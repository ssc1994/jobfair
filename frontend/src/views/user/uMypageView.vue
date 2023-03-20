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

        <div class="resumeBoxWrap" v-for="(resumeAll,i) in resumeArray" :key="i">
          <div class="resumeBox">
            <div class="left">
              <ul>
                <li>
                  <p class="resumeTitle">{{ resumeAll.res_title }}</p>
                  <p>{{ resumeAll.res_regDate}}</p>
                </li>
              </ul>
            </div>
            <div class="right">
              <button id="" type="button" class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" style="border-color: #0064ff;color:#0064ff;">
                수정
              </button>
              <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#DeleteModal" style="border-color: rgb(229, 75, 75);color:rgb(229, 75, 75);" @click="deleteResume" :value="resumeAll.res_num">
                삭제
              </button>
            </div>
          </div>
        </div>


<!--         수정버튼 클릭시 나오는 모달창 -->
<!--        res_num에 따른 데이터를 가져오게끔 만들어야함, 수정을 눌렀을 때 그 이력서 번호에 맞는 데이터만 출력되게끔 (아직 미구현, 박희진)-->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content"  v-for="(resumeAll,i) in resumeArray" :key="i">
<!--              모달창 최상단 section -->
              <div class="modal-header">
<!--                res_title값 가져오기-->
                <h1 class="modal-title fs-5" id="exampleModalLabel" value="res_title">{{ resumeAll.res_title }}</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>

              <div class="modal-body" style="height: 100%">
                <div class="infoModalBox">
                  <div class="wrapBox3">
                    <div class="input-group mb-3">
<!--                      res_name 값 가져오기-->
                      <span class="input-group-text" id="basic-addon1">작성자</span>
                      <p class="form-control"  aria-label="Username" aria-describedby="basic-addon1">{{resumeAll.user_id}}</p>
                    </div>

                    <div class="input-group mb-3">
<!--                      res_regDate 값 가져오기-->
                      <span class="input-group-text" id="basic-addon1">작성일</span>
                      <p class="form-control"  aria-label="Username" aria-describedby="basic-addon1">{{resumeAll.res_regDate}}</p>
                    </div>

                    <div class="input-group">
<!--                       res_content 값 가져오기-->
                      <span class="input-group-text">자기소개서 내용</span>
                      <textarea class="form-control contentBox" aria-label="With textarea"></textarea>
                    </div>
                    <div>
                      <button type="button" class="btn btn-primary" data-bs-target="#exampleModal">
                        수정하기
                      </button>
                      <button type="button" class="btn btn-primary">
                        이력서 상세보기
                      </button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <hr>

    <div class="aplBoxCon">
      <div>
        <h3>지원 현황</h3>
      </div>
      <div class="aplBtnBox">
        <button style="border:0;">
          <p class="aplBtnNum">30</p>
          <p>전체</p>
        </button>
        <button>
          <p class="aplBtnNum">30</p>
          <p>지원완료</p>
        </button>
        <button>
          <p class="aplBtnNum">30</p>
          <p>열람</p>
        </button>
        <button>
          <p class="aplBtnNum">30</p>
          <p>미열람</p>
        </button>
      </div>

      <div class="aplBoxConWrap">
        <div>
          <div>
            <div>
              <table class="aplTable">
                <thead>
                <tr class="aplTableTitle">
                  <td>지원 회사</td>
                  <td>공고명</td>
                  <td>지원 포지션</td>
                  <td>진행상태</td>
                </tr>
                </thead>

                <tbody>

                  <tr>
                    <td ><router-link to="" style="color:black;text-decoration: none;">(주)카카오</router-link></td>
                    <td><router-link to="" style="color:black;text-decoration: none;">카카오와 함께할 UI/UX 디자이너 인재를 채용합니다.</router-link></td>
                    <td>UI/UX 디자이너</td>
                    <td class="allPass">열람</td>
                  </tr>
                  <tr>
                    <td><router-link to="" style="color:black;text-decoration: none;">(주)카카오</router-link></td>
                    <td><router-link to="" style="color:black;text-decoration: none;">카카오와 함께할 UI/UX 디자이너 인재를 채용합니다.</router-link></td>
                    <td>UI/UX 디자이너</td>
                    <td class="noPass">미열람</td>
                  </tr>
                  <tr>
                    <td><router-link to="" style="color:black;text-decoration: none;">(주)카카오</router-link></td>
                    <td><router-link to="" style="color:black;text-decoration: none;">카카오와 함께할 UI/UX 디자이너 인재를 채용합니다.</router-link></td>
                    <td>UI/UX 디자이너</td>
                    <td class="pass">서류통과</td>
                  </tr>
                  <tr>
                    <td><router-link to="" style="color:black;text-decoration: none;">(주)카카오</router-link></td>
                    <td><router-link to="" style="color:black;text-decoration: none;">카카오와 함께할 UI/UX 디자이너 인재를 채용합니다.</router-link></td>
                    <td>UI/UX 디자이너</td>
                    <td class="applied">지원완료</td>
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
export default {
  name: 'uMypageView',
  data() {
    return {
      resumeArray: [],
      fold: true,
      arrSrc: 'up',
      res_num: '',
      res_title: '',
      res_regDate: '',
      user_id: JSON.parse(sessionStorage.getItem('sessionId')),
      resumeNumber: ''
    }
  },
  created() {
  this.resumeinfo();
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
    // 삭제버튼 클릭 시 데이터베이스에 있는 데이터 삭제 ( 이력서 삭제 )
    deleteResume(e) {
      alert("삭제하시겠습니까?")
      console.log(e.target.value)
      this.$axios.get('/jobfair/deleteResume',{params:{res_num: e.target.value}})
          .then((res) => {
            this.$router.go('/uMypageView')
            this.res_num = res.data
          })
          .catch((error) => { console.log(error) })
    },
    // 로그인 한 유저의 이력서만 보여주
    resumeinfo() {
      this.$axios.post("/jobfair/resumeInfo" , {user_id: this.user_id})
          .then((res) => {
            this.resumeArray = res.data
            // console.log(res.data)

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
  width: 100%;
}
.aplBtnBox button {
  border:0;
  border-left:1px solid #dedede;
  background-color: transparent;
  width:25%;
  background-color: #efefef;
  padding:10px;
}

.aplBtnBox button:hover {color:#0064ff;}

.aplBtnBox button:first-child {border:0;}

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