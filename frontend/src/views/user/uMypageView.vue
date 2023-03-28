<template>

  <div class="container" style="max-width:1560px;">
    <!--이력서 관리-->
    <div class="resumeBoxCon">
      <div>
        <h3>이력서 관리</h3>
        <button class="arrDown">
          <img :src="require(`@/assets/icon_arr_${arrSrc}.png`)" @click="upDown"/>
        </button>
      </div>

      <div v-if="fold!=false">
        <div class="resumeBoxWrap" >
          <routerLink to="/uResumeView">
            <div class="resumeBox">
              <div class="left">
              <span class="newResumeIcon" style="font-size: 40px;">
                +
              </span>
                <p class="newResume" style="display: inline-block;font-size: 19px;margin-left:10px;">이력서 작성하기</p>
              </div>

            </div>
          </routerLink>
        </div>

        <div class="resumeBoxWrap" key="i" v-for="(resDetail, i) in resumeArray" :key="i">
          <ResComp :index='i' :resDetail='resDetail' />
        </div>

      </div>
    </div>
    <hr>

    <div class="aplBoxCon">
      <div>
        <h3>지원 현황</h3>
      </div>
      <div class="aplBtnBox">
        <div @click="getApplyList" id="all" v-bind:class="{on : One}"> <!---->
          <p class="aplBtnNum">{{ this.applyCnt.all }}</p>
          <p>지원완료</p>
        </div>
        <div id="O" @click="getApplyList" v-bind:class="{on : Two}">
          <p class="aplBtnNum">{{ this.applyCnt.O }}</p>
          <p>열람</p>
        </div>
        <div id="X" @click="getApplyList" v-bind:class="{on : Thr}">
          <p class="aplBtnNum" style="color: red">{{ this.applyCnt.X }}</p>
          <p>미열람</p>
        </div>
      </div>

      <div class="aplBoxConWrap">
        <div>
          <div>
            <div>
              <table class="aplTable">

                <div v-if="applylist.length == 0" style="margin:0 auto; width:100%;height:500px;font-size: 20px;">
                  내용이 없습니다.
                </div>

                <thead v-if="applylist.length != 0">
                <tr class="aplTableTitle">
                  <td>지원 회사</td>
                  <td>공고명</td>
                  <td>지원 포지션</td>
                  <td>진행상태</td>
                </tr>
                </thead>

                <tbody>


                  <tr v-for="(applyList,i) in applylist" :key=i > <!--@click.prevent="detail(jobpost.com_num)"-->
                    <td ><router-link to="" style="color:black;text-decoration: none;">{{ applyList.com_name }}</router-link></td>
                    <td><router-link to="" style="color:black;text-decoration: none;">{{ applyList.jpl_title }}</router-link></td>
                    <td>{{ applyList.jpl_workPosition }}</td>
                    <td class="allPass" v-if = "applyList.al_state === 'O'" >열람</td>
                    <td class="noPass" v-if = "applyList.al_state === 'X'" >미열람</td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>

      </div>

    </div>

  </div>

</template>

<script>
import ResComp from "@/components/myComponent/ResumeComp";

export default {
  name: 'uMypageView',
  components: {
    ResComp
  },
  data() {
    return {
      resumeArray: [],
      fold: true,
      arrSrc: 'up',
      res_num: '',
      res_title: '',
      res_regDate: '',
      user_id: JSON.parse(sessionStorage.getItem('sessionId')),
      resumeNumber: '',
      //applylist배열
      applylist: [],
      //applylist분류
      applySel: 'all',
      //applylist 버튼 스타일
      One : true,
      Two : false,
      Thr : false,
      //applylist 갯수
      applyCnt : []

    }
  },
  created() {
    //이력서
   this.resumeinfo();
    //지원현황 리스트
    this.$axios.post("/jobfair/getApplyList" , {user_id: this.user_id, applySel : this.applySel})
        .then((res) => {

          this.applylist = res.data;

        }).catch((error) => {
      console.log(error)
    }),
        //지원현황 리스트
        this.$axios.post("/jobfair/getApplyListCnt" , {user_id: this.user_id})
            .then((res) => {
              this.applyCnt = res.data;
            }).catch((error) => {
          console.log(error)
        })
  },
  methods : {
    upDown : function (){
      this.fold = !this.fold;

      if(this.arrSrc!="up"){
        this.arrSrc = "up";
      } else {
        this.arrSrc = "down";
      }
    },
    // 로그인 한 유저의 이력서만 보여주
    resumeinfo() {
      this.$axios.post("/jobfair/resumeInfo" , {user_id: this.user_id})
          .then((res) => {
            this.resumeArray = res.data
          }).catch((error) => {
        console.log(error)
      })
    },
    getApplyList(e){
      this.applySel = e.currentTarget.id;
      if(e.currentTarget.id == "all"){
        this.One = true;
        this.Two = false;
        this.Thr = false;
      } else if(e.currentTarget.id == "O"){
        this.One = false;
        this.Two = true;
        this.Thr = false;
      } else if(e.currentTarget.id == "X"){
        this.One = false;
        this.Two = false;
        this.Thr = true;
      }

      this.$axios.post("/jobfair/getApplyList" , {user_id: this.user_id, applySel : this.applySel})
          .then((res) => {
            this.applylist = res.data
          }).catch((error) => {
        console.log(error)
      })
    }
  }
}
</script>

<style scoped>

ul, ol {
  list-style: none;
}

a {
  text-decoration: none;
}

.left{float: left;}
.right {float:right;}

h3{font-weight: bold;
  font-size: 20px;
  padding:20px;
}

/*이력서*/
.resumeBoxCon h3 {display: inline-block;}

.resumeBoxWrap { display: inline-block;width:50%;}

.arrDown{border:0;
  margin-left:10px;
  background: transparent;
}
.arrDown img{border:0;
  width:20px;
  height:30px;
  object-fit: contain;
}

.resumeBox {border: 1px solid #dedede;
  border-radius: 20px;
  overflow: hidden;
  padding:20px;
  width:98%;
  margin-bottom:10px;
  display:inline-block;
  margin-left:5px;
  height:100px;
  line-height: 50px;
 }

.resumeBox p {margin:0;padding: 0;}
.resumeBox button {margin:5px;}

.resumeBox:hover {border:1px solid #0064ff;}
.resumeTitle {font-weight: bold;
  font-size: 18px;
}



/*지원현황*/
.aplBtnBox {margin-top:20px;
  border:1px solid #dedede;
  display: inline-block;
  border-radius: 20px;
  box-shadow: rgba(0, 0, 0, 0.16) 0px 10px 36px 0px, rgba(0, 0, 0, 0.06) 0px 0px 0px 1px;
  background-color: #efefef;
  width: 100%;
}
.aplBtnBox div {
  text-align: center;
  display: inline-block;
  cursor: pointer;
  border:0;
  border-left:1px solid #dedede;
  background-color: transparent;
  width:33.33%;

  padding:10px;
}

.on {color:#0064ff;
  border-radius: 20px;
}

.aplBtnBox div:first-child {border:0;}

.aplBtnBox p {padding:0;margin:0;}

.aplBtnNum {

  font-size: 25px;
  font-weight: bold;
  margin:0;
  padding:30px;
}


.aplTable {width:100%;
           padding:20px;

  text-align: center;
  margin-top:30px;
}

tr td:nth-child(4){border-right:0;
  height:80px;
}

tr {border-radius: 20px;
  margin: 10px 0;
}

tr td:hover {border-bottom: 2px solid #0064ff;}

tr td {
  padding:10px;
  border-left: 0;
  border-bottom: 2px solid #dedede;
}

.aplTableTitle td{border:0;
  padding:10px;
  font-weight: bold;
  font-size: 20px;
}

.pass {color:#202632;
  font-weight: bold;

}
.noPass {color:rgb(229, 75, 75);
  font-weight: bold;
}
.allPass {color:#0064ff;
  font-weight: bold;
  border-radius: 20px;
  margin:10px;
}
.applied {color:#757575;
  font-weight: bold;
}

/* 이력서 수정 모달창 관련 css */
.contentBox {
  height: 300px;
}

</style>