<template>
  <div>
    <img src="@/assets/mainImg.png" style="width: 1500px; margin-left: 50px;">
    <div class="comBoxWrap">
      <!--    <section class="comMiddle col-xl-12">-->
      <!--      공고 등록하기 버튼 클릭시 페이지 이동하는 메서드 추가 + 스크립트 -->
      <div class="comList">
        <div class="comTopBox">
          <div class="aplBtnBoxWrap">
            <h3>채용 현황</h3>
            <div class="aplBtnBox">
              <div @click="getApplyList">
                <p class="aplBtnNum">{{ingPosting}}</p>
                <p>진행중 공고</p>
              </div>
              <div id="O" @click="getApplyList">
                <p class="aplBtnNum">{{totalPosting - ingPosting}}</p>
                <p>지원마감 공고</p>
              </div>
              <div id="X" @click="getApplyList">
                <p class="aplBtnNum">{{seeRes}}</p>
                <p>열람 이력서</p>
              </div>
              <div id="X" @click="getApplyList">
                <p class="aplBtnNum">{{totalRes - seeRes}}</p>
                <p>미열람 이력서</p>
              </div>
            </div>
          </div>
<!--          승인된 기업만 큐엔에이와 공고를 등록할 수 있게 버튼생성하기, 박희진-->
          <div class="btnBox" v-if="this.auth === '3'">
            <button type="button" class="comBtn1 " v-on:click="goQnaView()">  QnA 목록</button>
            <button type="button" class="comBtn2" v-on:click="goRegView()"> 공고 등록하기 </button>
          </div>
        </div>

        <div class="comBottomBox">
          <div class="comRegList">
            <div>
              <h3>내가 등록한 최신공고</h3>
              <button class="comAllBtn" @click="this.$router.push({path: 'cApplyMngView'})">
                <img src="@/assets/icon_arrow_right.svg"/>
                공고 전체보기
              </button>
            </div>
            <div>
              <ul id="listHolder" class="lists" v-for="(jpl, index) in jplArr" :key="jpl.jpl_num">
                <RecentJobPostingComp :jplInfo="jpl" :imgUrl="this.urlArr[index]" :totalAppArr="totalAppArr[index]" />
              </ul>
            </div>
          </div>
          <div class="comNewComer">
            <div class="comTopBox">
              <h3>최근 지원자</h3>
<!--              <button class="comAllBtn">-->
<!--                <img src="@/assets/icon_arrow_right.svg"/>-->
<!--                지원자 전체보기-->
<!--              </button>-->
            </div>
            <div class="ResentInfo">
              <div>
                <ul id="listHolder" class="lists" v-for="(app, index) in appArr" :key="app.al_num">
                  <RecentApplicantComp :appInfo="app"/>
                </ul>
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
import RecentJobPostingComp from "@/components/myComponent/RecentJobPostingComp";
import RecentApplicantComp from "@/components/myComponent/RecentApplicantComp";

export default {
  name: 'cMainView',
  components: {
    RecentJobPostingComp,
    RecentApplicantComp
  },
  data () {
    return {
      totalPosting: 0,
      ingPosting : 0,
      donPosting: 0,
      totalRes: 0,
      seeRes: 0,
      notSeeRes: 0,
      com_num: '',
      jplArr: [],
      appArr: [],
      urlArr: [],
      totalAppArr: [],
      auth: JSON.parse(sessionStorage.getItem('sessionAuth'))
    }
  },
  methods: {
    goRegView() {
      this.$router.push({path: "cEmpRegView"})
    },
    goQnaView() {
      this.$router.push({path: "cQnAView"})
    },
    getApplyList(e) {
      this.$router.push({path:""})
    },
    async mainFunction () {
      let sessionComp = sessionStorage.getItem('sessionComp')
      if(sessionComp && typeof sessionComp === 'string' && sessionComp !== '') {
        let SessionJsonComp = JSON.parse(sessionComp)
        this.com_num = SessionJsonComp;
      }

      let res = await this.$axios.get("/jobfair/getStatusData", {
        params: {
          com_num: this.com_num
        }}) .catch (arr => console.log(err))

      this.totalPosting = res.data.postingArr[0].totalPosting
      this.ingPosting = res.data.postingArr[0].ing
      this.totalRes = res.data.resArr[0].totalRes
      this.seeRes = res.data.resArr[0].seeRes
      this.jplArr = res.data.jplArr
      this.appArr = res.data.appArr
      this.urlArr = res.data.urlArr
      this.totalAppArr = res.data.totalAppArr
    }
  },
  created() {
    this.mainFunction()
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

.left {float: left;}
.right {float: right;}

h3{font-weight: bold;
  font-size: 20px;
  padding:20px;
  color:#202632;
}

.comTopBox {overflow: hidden;}

.topWrap {width:100%;}

.aplBtnBoxWrap {  width: 60%;
  display: inline-block;
  height:200px;
}

.btnBox {display: inline-block;
  width:40%;
  height:200px;
  float: right;
  padding-top:62px;
  padding-left:15px;
}

/*채용현황*/
.aplBtnBox {
  border:1px solid #dedede;
  border-radius: 20px;
  box-shadow: rgba(0, 0, 0, 0.16) 0px 10px 36px 0px, rgba(0, 0, 0, 0.06) 0px 0px 0px 1px;
  background-color: #efefef;
  float: left;
  width:100%;
  left: 15px;
  position: relative;
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



/* 오른쪽에 위치한 공고등록버튼 */

.comBtn1, .comBtn2 {display: inline-block;
  width:45%;
  height: 88px;
  text-align: center;
  font-size: 18px;
  font-weight: bolder;
  color: white;
  background-color: #202632;
  border: none;
  border-radius: 15px;
  margin:0 5px;}

.comBtn1:hover, .comBtn2:hover {
  background-color: #0d6efd;
  box-shadow: rgba(0, 0, 0, 0.14) 0px 9px 24px 0px, rgba(0, 0, 0, 0.08) 0px 0px 0px 1px;
}

.comBtn1{
  background-image: url("@/assets/icon_question.svg");
  background-position: 20px 25px;
  background-repeat: no-repeat;
  background-size: 35px;
}

.comBtn2{
  background-image: url("@/assets/icon_regEmp.svg");
  background-position: 20px 25px;
  background-repeat: no-repeat;
  background-size: 35px;
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

.comAllBtn {background-color:transparent;}
.comAllBtn:hover {box-shadow: rgba(0, 0, 0, 0.14) 0px 9px 24px 0px, rgba(0, 0, 0, 0.08) 0px 0px 0px 1px;
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


/* 최신공고 슬라이더 안에 표시되는 내용 */
.lists {
  /*height: 400px;*/
  padding: 10px;
  align-items: center;
}
.lists li{
  display : block;
  list-style: none;
  text-align: center;
}

.empBoxConWrap {
  width:100%;
  display: inline-block;

  text-align: left;

}

.aplBoxTag {color:black;}

.empBoxCon {
  padding:25px;
  overflow: hidden;
  background-color: white;
  border-radius: 20px;
  border: 2px solid #dedede;
  display:inline-block;
  width:100%;
  overflow: hidden;
  height:200px;
}

.aplBoxCon {
  padding:25px;
  overflow: hidden;
  background-color: white;
  border-radius: 20px;
  border: 2px solid #dedede;
  display:inline-block;
  width:100%;
  overflow: hidden;
  height:200px;
}

.aplBoxText p {width:70%;}

.empTitle {font-size: 18px;font-weight: bold;}

.aplTitle {padding-bottom:20px;font-size: 18px;font-weight: bold;color:black;}

.empBoxCon:hover { border: 2px solid #0064ff; }

.aplBoxCompany p {color:black;font-size: 18px;}

.empBoxCompany p {color:black;}

.aplBoxCompany {
  display: inline-block;
  /*cursor: pointer;*/
  float: left;
  margin-right:10px;
  height:100%;
  width:20%;
}

.empBoxCompany {
  display: inline-block;
  /*cursor: pointer;*/
  float: left;
  margin-right:10px;
  height:100%;
}
.empBoxCon img{
  float: left;
  width:80px;
  height:80px;
  display: inline;
  object-fit: contain;
}

.aplBoxCon img{
  height:80px;
  width:80%;
  object-fit: contain;
}


.empBoxBtn {
  width:18%;
  height:100%;
}

.aplBtn {border:none;
  background-color: #0064ff;
  width:100%;
  height:100%;

}
.applied {background-color: #dedede;
  color:black;
  height:200px;
}

.empBoxText {padding-left: 5px;color:black;display: inline-block;
  /*cursor: pointer;*/
  width:60%;
  height:100%;
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
</style>
