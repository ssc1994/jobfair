<template>
  <li>
    <div class="empBoxConWrap col-6">

      <div class="empBoxCon ">
        <router-link to="" class="left empBoxCompany">
          <p>{{ jplInfo.jpl_companyName }} </p>
          <img :src="this.imgUrl" >
        </router-link>
        <div class="left empBoxText">
          <router-link to="">
            <p class="empTitle"> {{ jplInfo.jpl_title }} </p>

            <p class="empBoxTag"> {{ jplInfo.jpl_locationSi + ' ' + jplInfo.jpl_locationGu }} </p>
          </router-link>
          <div style="padding-top:50px;">
            <span class="left empBoxDday">{{d_day}}</span>
            <span class="left empBoxDday">{{endDate}}</span>
          </div>



        </div>
        <div class="empBoxBtn right">
          <button type="button" class="btn btn-primary aplBtn applied" style="height:50%;">
            현재까지 <br/> {{totalAppArr}}명 지원
          </button>
          <button type="button" class="btn btn-primary aplBtn" style="background-color: #0064ff;" @click="modi()">
            수정하기
          </button>
        </div>

      </div>
    </div>
  </li>
</template>

<script>
export default {
  name: "RecentJobPostingComp",
  props: [
    'jplInfo',
    'imgUrl',
    'totalAppArr'
  ],
  created() {
    let sysDate = new Date();
    let endDate = new Date(this.jplInfo.jpl_endDate);

    let calDate = Math.trunc(((endDate - sysDate) / (1000 * 60 * 60 * 24)));

    if(calDate > 0) this.d_day = 'D - ' + calDate;
    else if(calDate === 0) this.d_day = "금일 마감";
    else if(calDate < 0) this.d_day = "모집종료"

    this.endDate = (endDate.getMonth() + 1) + '월 ' + endDate.getDate() + '일 마감'
  },
  data() {
    return{
      d_day: '',
      endDate: '',
    }
  },
  methods: {
    modi(){
      this.$router.push({
        //params를 넘겨줄 때엔 push할 때 path보단 name을 사용함
        name: 'cEmpModiView',
        params: {
          jpl_num: this.jplInfo.jpl_num
        }
      })

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