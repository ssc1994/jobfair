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
          <routerLink to="">
            <div class="resumeBox">
              <div class="left">
              <span class="newResumeIcon" style="font-size: 40px;">
                +
              </span>
                <p class="newResume" style="display: inline-block;font-size: 19px;margin-left:10px;">이력서 작성하기</p>
              </div>
              <div class="right">

              </div>
            </div>
          </routerLink>
        </div>

        <div class="resumeBoxWrap" >
          <div class="resumeBox">
            <div class="left">
              <p class="resumeTitle">창의적인 개발자가 되겠습니다.</p>
              <p>2023.03.09</p>
            </div>
            <div class="right">
              <button type="button" class="btn btn-outline-primary" style="border-color: #0064ff;color:#0064ff;">수정</button>
              <button type="button" class="btn btn-outline-primary" style="border-color: rgb(229, 75, 75);color:rgb(229, 75, 75);">삭제</button>
            </div>
          </div>
        </div>

        <div class="resumeBoxWrap">
          <div class="resumeBox">
            <div class="left">
              <p class="resumeTitle">창의적인 개발자가 되겠습니다.</p>
              <p>2023.03.09</p>
            </div>
            <div class="right">
              <button type="button" class="btn btn-outline-primary" style="border-color: #0064ff;color:#0064ff;">수정</button>
              <button type="button" class="btn btn-outline-primary" style="border-color: rgb(229, 75, 75);color:rgb(229, 75, 75);">삭제</button>
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
          <p>서류통과</p>
        </button>
        <button>
          <p class="aplBtnNum">30</p>
          <p>최종합격</p>
        </button>
        <button>
          <p class="aplBtnNum">30</p>
          <p>불합격</p>
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
                  <td class="allPass">최종합격</td>
                </tr>
                <tr>
                  <td><router-link to="" style="color:black;text-decoration: none;">(주)카카오</router-link></td>
                  <td><router-link to="" style="color:black;text-decoration: none;">카카오와 함께할 UI/UX 디자이너 인재를 채용합니다.</router-link></td>
                  <td>UI/UX 디자이너</td>
                  <td class="noPass">불합격</td>
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
  name: "uMypageView",
  data() {
    return {
      fold : true,
      arrSrc : "up"
    }
  },
  methods : {
    upDown : function (){
      this.fold = !this.fold;

      if(this.arrSrc!="up"){
        this.arrSrc = "up";
      } else {
        this.arrSrc = "down";
      }

    }
  }
}
</script>

<style scoped>

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
  width: 1560px;
}
.aplBtnBox button {
  border:0;
  border-left:1px solid #dedede;
  background-color: transparent;
  width:20%;
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

.aplTable {width:1560px;
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


</style>