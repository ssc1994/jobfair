<template>
  <div>
  <div class="comBoxWrap">
<!--    <section class="comMiddle col-xl-12">-->
<!--      공고 등록하기 버튼 클릭시 페이지 이동하는 메서드 추가 + 스크립트 -->


      <div class="comList">
        <div class="comTopBox">

          <div>
            <h3>채용 현황</h3>
          </div>
          <div>
            <div class="aplBtnBoxWrap">
              <div class="aplBtnBox">
                <div @click="getApplyList"> <!---->
                  <p class="aplBtnNum">0</p>
                  <p>진행중 공고</p>
                </div>
                <div id="O" @click="getApplyList">
                  <p class="aplBtnNum">0</p>
                  <p>지원마감 공고</p>
                </div>
                <div id="X" @click="getApplyList">
                  <p class="aplBtnNum">0</p>
                  <p>열람 이력서</p>
                </div>
                <div id="X" @click="getApplyList">
                  <p class="aplBtnNum">0</p>
                  <p>미열람 이력서</p>
                </div>
              </div>
            </div>
          <div class="btnBox">
            <button type="button" class="comBtn1 btn btn-primary" v-on:click="goRegView()">  미답변 질문</button>

            <button type="button" class="comBtn1 btn btn-primary" v-on:click="goRegView()"> 공고 등록하기 </button>
          </div>
          </div>
          </div>
        <div class="comBottomBox">
          <div class="comRegList">
            <div>
                <h3>내가 등록한 최신공고</h3>
                <button class="comAllBtn">
                  <img src="@/assets/icon_arrow_right.svg"/>
                  공고 전체보기
                </button>
            </div>
            <div class="slider">
              <input type="radio" name="slide" id="slide1" checked>
              <input type="radio" name="slide" id="slide2">
              <input type="radio" name="slide" id="slide3">
              <ul id="listHolder" class="lists">
                <li>
                  <div class="empBoxConWrap col-6">

                    <div class="empBoxCon ">
                      <router-link to="" class="left empBoxCompany">
                        <p>(주)  jobpost.com_name </p>
                        <img src="@/assets/kakao.png" >
                      </router-link>
                      <div class="left empBoxText">
                        <router-link to="">
                          <p class="empTitle"> jobpost.jpl_title </p>

                          <p class="empBoxTag"> 서울시 어쩌고 저쩌고 </p>
                        </router-link>
                        <div style="padding-top:20px;">
                          <span class="left empBoxDday">D-27</span>
                          <span class="left empBoxDday">3월 17일 까지</span>
                          <button type="button" class="btn btn-primary aplBtn right applied">
                            지원자 <br/>40명 보기
                          </button>
                          <button type="button" class="btn btn-primary aplBtn right" style="background-color: #0064ff;">
                            수정하기
                          </button>
                        </div>

                      </div>

                    </div>
                  </div>

                </li>
                <li>공고2</li>
                <li>공고3</li>
              </ul>
              <div class="bullets">
                <label for="slide1">&nbsp;</label>
                <label for="slide2">&nbsp;</label>
                <label for="slide3">&nbsp;</label>
              </div>
            </div>
          </div>
          <div class="comNewComer">
              <div class="comTopBox">
                <h3>최근 지원자</h3>
              </div>
              <div class="ResentInfo">
                <div class="empBoxConWrap col-6">

                  <div class="empBoxCon ">
                    <router-link to="" class="left empBoxCompany">
                      <p>(주)  jobpost.com_name </p>
                      <img src="@/assets/kakao.png" >
                    </router-link>
                    <div class="left empBoxText">
                      <router-link to="">
                        <p class="empTitle"> jobpost.jpl_title </p>

                        <p class="empBoxTag"> 서울시 어쩌고 저쩌고 </p>
                      </router-link>
                      <div style="padding-top:20px;">
                        <span class="left empBoxDday">D-27</span>
                        <span class="left empBoxDday">3월 17일 까지</span>
                        <button type="button" class="btn btn-primary aplBtn right applied">
                          지원자 <br/>40명 보기
                        </button>
                        <button type="button" class="btn btn-primary aplBtn right" style="background-color: #0064ff;">
                          수정하기
                        </button>
                      </div>

                    </div>

                  </div>
                </div>
              </div>
          </div>
        </div>
      </div>

<!--    </section>-->
  </div>
  </div>
</template>

<script>
export default {
  name: 'cMainView',
  methods: {
    goRegView() {
      this.$router.push({path: "cEmpRegView"})
    }
  }
}
</script>

<style scoped>
/*글씨체*/
@font-face {
  font-family: 'MICEGothic Bold';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2206-01@1.0/MICEGothic Bold.woff2') format('woff2');
  font-weight: 700;
  font-style: normal;
}

/* 공통 부분 */
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

ul, ol {
  list-style: none;
}

a {
  text-decoration: none;
}

h3{font-weight: bold;
  font-size: 20px;
  padding:20px;
  color:#202632;
}

.aplBtnBoxWrap {  width: 60%;
                  display: inline-block;
                  border:1px solid red;
                }

/*지원현황*/
.aplBtnBox {
  border:1px solid #dedede;

  border-radius: 20px;
  box-shadow: rgba(0, 0, 0, 0.16) 0px 10px 36px 0px, rgba(0, 0, 0, 0.06) 0px 0px 0px 1px;
  background-color: #efefef;




}
.aplBtnBox div {
  text-align: center;
  display: inline-block;
  cursor: pointer;
  border:0;
  border-left:1px solid #dedede;
  background-color: transparent;
  width:25%;

  padding:10px;
}

.on {color:#0064ff;
  border-radius: 20px;
}

.aplBtnBox div:first-child {border:0;}

.aplBtnBox div:hover {color:#0064ff;}

.aplBtnBox p {padding:0;margin:0;}

.aplBtnNum {

  font-size: 25px;
  font-weight: bold;
  margin:0;
  padding:30px;

}



/* section 전체크기 */
.comBoxWrap {
  margin: 0 auto;
  width: 95%;
  height: 800px;
}
.comMiddle {
  display: flex;
  width: 100%;
  height: 100%;
}

.btnBox {display: inline-block;
         width:38%;
        margin-left: 20px;
  border: 1px solid red;
}

/* 오른쪽에 위치한 공고등록버튼 */
.comBtn1{
  background-image: url("@/assets/icon_regEmp.svg");
  background-position: 20px 25px;
  background-repeat: no-repeat;
  background-size: 35px;
  /*float: right;*/
  display: inline-block;
  width:47%;
  height: 100px;
  text-align: center;
  font-size: 18px;
  font-weight: bolder;
  color: white;
  background-color: #0064ff;
  border: none;
  border-radius: 15px;
  margin-right:10px;
}
.comBtn1:hover {
  background-color: #0d6efd;
  box-shadow: rgba(0, 0, 0, 0.14) 0px 9px 24px 0px, rgba(0, 0, 0, 0.08) 0px 0px 0px 1px;
}
/* div박스 모음 */
.comRightBox {
  display: flex;
  justify-content: space-between;
  float: left;
  width: 50%;
}

.comList span, .comTopBox p {
  font-weight: 600;
}


.comBottomBox {margin-top:20px;
               width:80%;
}

.comBottomBox h3{display: inline-block;}

.comBottomBox button{
  float: right;
  margin-top:10px;
  margin-right:10px;
  height:50px;
  border:0;
  padding:10px;
  border-radius: 10px;
  font-weight: bold;
  font-size: 16px;
}

.comAllBtn img {width:20px;}

/* 지원자 정보 */
.card img {
  width: 115px;
  height: 140px;
}
/* 최신공고와 지원자 정보란 */
.comBottomBox {
  align-items: center;
  height: 500px;
  width: 100%;
  border-radius: 5px;
}
/* 채용현황 박스 */
.comRecStatus, .comRecStatusList {
  width: 100%;
  height: 150px;
  text-align: center;
  padding: 15px;
}
.comRecStatus a {
  margin: 25px 20px 0px 10px;
  color: black;
  text-align: center;
}
.comRecStatus a:hover {
  color: grey;
}
.comRecStatus a p {
  color: #0064ff;
  font-size: 34px;
  font-weight: bold;
}
.comRecStatus {
  border-radius: 5px;
  background-color: #d2d6da;
  box-shadow: rgba(0, 0, 0, 0.16) 0px 10px 36px 0px, rgba(0, 0, 0, 0.06) 0px 0px 0px 1px;
}
.comRecStatusList {
  border-bottom: 2px solid #dedede;
}
.comRegList {
  width: 60%;
  float: left;
  /*border-right: 1px solid #dedede;*/
}

.comNewComer {
  width: 40%;
  height: 100%;
  float: left;
}

.comNewComer p {
  float: left;
}
/* 내가 등록한 최신공고를 보여주는 슬라이더 */
.slider li {
  position: relative;
}
.slider input[type=radio] {
  display: none;
}
/* 최신공고 슬라이더 안에 표시되는 내용 */
.lists, .ResentInfo {
  /*height: 400px;*/
  padding: 10px;
  align-items: center;
}
.lists li{
  display : block;
  opacity: 0;
  list-style: none;
  transition-delay: 0.9s;
  text-align: center;
}

.empBoxConWrap {
  width:100%;
  display: inline-block;

  text-align: left;

}

.empBoxCon {
  padding:25px;
  overflow: hidden;
  background-color: white;
  border-radius: 20px;
  border: 2px solid #dedede;
  display:inline-block;
  width:98%;
  height:200px;
}

.empTitle {font-size: 18px;font-weight: bold;}

.empBoxCon:hover { border: 2px solid #0064ff; }

.empBoxCompany p {color:black;}

.empBoxCompany {
  display: inline-block;
  /*cursor: pointer;*/
  float: left;
  margin-right:10px;
}
.empBoxCon img{
  float: left;
  width:80px;
  height:80px;
  display: inline;
  object-fit: contain;
}

.aplBtn {border:none;
  background-color: #0064ff;
  width:20%;
  height:40px;

}
.applied {background-color: #dedede;
  color:black;
}

.empBoxText {padding-left: 5px;color:black;display: inline-block;
  /*cursor: pointer;*/
  width:600px;
}


.empBoxText router-link {text-align: left;border:0;}

.empBoxText p {margin:0; padding:0;}

.empBoxDday {
  font-weight: bold;
  padding:5px 15px;
  color:rgb(229, 75, 75);
  border:1px solid rgb(229, 75, 75);
  border-radius:20px;
  margin-right: 5px;
}

.bullets{
  position: relative;
  left: 50%;
  text-align: center;
  transform: translateX(-50%);
  z-index: 2;
}
.bullets label{
  display: inline-block;
  border-radius: 50%;
  background-color: rgba(0,0,0,0.55);
  width: 20px;
  height: 20px;
  cursor: pointer;
}
.slider input[type=radio]:nth-child(1):checked~.bullets>label:nth-child(1){
  background-color: #0064ff;
}
.slider input[type=radio]:nth-child(2):checked~.bullets>label:nth-child(2){
  background-color: #0064ff;
}
.slider input[type=radio]:nth-child(3):checked~.bullets>label:nth-child(3){
  background-color: #0064ff;
}

.slider input[type=radio]:nth-child(1):checked~ul.lists>li:nth-child(1){
  opacity: 1;
  transition: 1s;
  z-index: 1;
}
.slider input[type=radio]:nth-child(2):checked~ul.lists>li:nth-child(2){
  opacity: 1;
  transition: 1s;
  z-index: 1;
}
.slider input[type=radio]:nth-child(3):checked~ul.lists>li:nth-child(3){
  opacity: 1;
  transition: 1s;
  z-index: 1;
}

</style>

