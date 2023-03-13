<template>
  <div>
  <div class="comBoxWrap">
    <section class="comMiddle col-xl-12">
        <button type="button" class="comBtn1 btn btn-primary">공고등록하기</button>

      <div class="comList">
        <div class="comTopBox">
          <div class="comRightBox comRecStatus">
            <span>채용현황</span>
            <a href="#">진행중 공고 <p>0</p></a>
            <a href="#">서류/면접중 공고 <p>0</p></a>
            <a href="#">신규지원자 <p>0</p></a>
            <a href="#">미열람이력서 <p>0</p></a>
          </div>

          <div class="comRightBox comRecStatusList">
            <span>인재관리 현황</span>
          </div>
        </div>
        <div class="comBottomBox">
          <div class="comRecList">
            <div class="comTopBox">
                <p>내가 등록한 최신공고</p>
            </div>
            <div class="slider">
              <input type="radio" name="slide" id="slide1" checked>
              <input type="radio" name="slide" id="slide2">
              <input type="radio" name="slide" id="slide3">
              <ul id="listHolder" class="lists">
                <li>공고1</li>
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
                <p>최근 지원자</p>
              </div>
              <div class="ResentInfo">
              <!-- 이력서 사진 넣기 -->
                <div class="card" style="width: 400px; border: none">
                  <img src="@/assets/img/myImage/profileImg.png" class="card-img-top" alt="지원자 사진 넣기">
                  <div class="card-body" style="height: auto">
                    <h5 class="card-title">이름</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                    <router-link to="#">이력서 보러가기</router-link>
                  </div>
                  <b-button type="button">▵</b-button>
                  <b-button type="button">▿</b-button>
                </div>
              </div>
          </div>
        </div>
      </div>

    </section>

    <footer>
      <p>@copyRight sungzzin</p>
    </footer>
  </div>
  </div>
</template>

<script>
export default {
  name: 'cMainView'
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

/* section 전체크기 */
.comBoxWrap {
  width: 1200px;
  height: 800px;
}
.comMiddle {
  display: flex;
  width: 100%;
  height: 100%;
}
/* 오른쪽에 위치한 공고등록버튼 */
.comBtn1{
  position: fixed;
  right: 30px;
  width: 200px;
  height: 50px;
  margin-bottom: 20px;
  text-align: center;
  font-size: 18px;
  font-weight: bolder;
  color: white;
  background-color: #0064ff;
  border: none;
  border-radius: 15px;
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
.comList {
  width: 80%;
  height: 100%;
}
.comList span, .comTopBox p {
  font-weight: 600;
  font-size: 20px;
}
.comTopBox {
  padding: 10px;
}
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
  padding: 10px;
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
.comRecList,.comNewComer {
  width: 50%;
  height: 100%;
  float: left;
  border-bottom: 2px solid #dedede;
}
.comRecList {
  border-right: 2px solid #dedede;
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
  width: 420px;
  height: 400px;
  padding: 20px;
  align-items: center;
}
.lists li{
  position: absolute;
  opacity: 0;
  list-style: none;
  padding: 0;
  margin: 0;
  transition-delay: 0.9s;
  text-align: center;
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

