<template>
  <header>
    <div class="header_size">
      <div class="header_wrap">
        <div class="logo">
          <a href="#">logo</a>
        </div>
        <div class="header_form">

        </div>
        <ul class="menu dropdown">
          <li>
            <form class="searchForm">
              <input type="text" class="search"/>
              <input type="button" class="searchIcon" />
              <button class="detailSearch">상세검색</button>
            </form>

          </li>
          <li><a class="dropbtn">채용공고</a>
            <div class="dropdown-content">
              <a href="#">Link 1</a>
              <a href="#">Link 2</a>
              <a href="#">Link 3</a>
            </div>
          </li>
          <li><a>Q&A</a></li>
        </ul>
      </div>

    </div>
  </header>
  <div>
  <div class="comBoxWrap">
    <section class="comMiddle col-xl-12">
      <div class="comLeftBox">
        <button type="button" class="comBtn1">공고등록하기</button>
        <div class="comTip">인재채용 잘하는 꿀팁</div>
      </div>

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
              <select>
                <option value="1">최신순</option>
                <option value="2">조회순</option>
              </select>
              <p>지원자 목록</p>
            </div>
            <div class="comNewInfo clearfix">
              <b-img thumbnail src="#" alt="image"></b-img>
              <p>지원자 정보</p>
              <b-button type="button">이전</b-button>
              <b-button type="button">다음</b-button>
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
*{
  padding: 0;
  margin: 0;
  font-family: 'MICEGothic Bold';
}
a {text-decoration: none; color: black}
li {list-style: none;}

/*Header Test*/
header{
  background-color: rgb(95, 75, 229);
  width:100%;
  color:white;

}
.header_size {width:1200px;
  margin:0 auto;
  height:120px;
  line-height: 50px;
  display: flex;
  justify-content: space-between;
}
.header_wrap {padding:30px 20px 20px;}
.logo {display: inline-block;
  width:10%;
}
.logo a{color:white;font-size: 30px;font-weight: bold;}
.header_wrap {width:1200px;}
.header_form {display: inline-block;}

.searchForm {position: relative;
}

.searchIcon {
  background-size:contain;
  width:35px;
  height:28px;
  background-color: transparent;
  border: none;
  position: absolute;
  top:13px;
  right:120px;
  cursor: pointer;
}
.search {width:380px;
  height:40px;
  border-radius: 10px;
  border: 3px solid #90aee8;
}

.detailSearch {width:100px;
  height:40px;
  background-color:transparent;
  border:0px;
  color:white;
  background-color: #90aee8;
  border-radius: 10px;
  font-size: 14px;
  cursor: pointer;
  font-weight: bold;
}

.menu{display: flex;
  justify-content: space-between;
  width:85%;
  text-align: center;

}
.menu li{display:inline-block;margin:0 auto;font-weight: bold;}
.menu li a {display:inline-block;
  width:100px;
  cursor: pointer;}
.menu li a:hover {border-bottom:3px solid white;}

/* w3c - CSS */
/* Style The Dropdown Button */
.dropbtn {
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
  cursor: pointer;
}

/* The container <div> - needed to position the dropdown content */
.dropdown {
  position: relative;
  display: inline-block;
}

/* Dropdown Content (Hidden by Default) */
.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

/* Links inside the dropdown */
.dropdown-content a {
  color: black;
  /* padding: 12px 16px; */
  text-decoration: none;
  display: block;
}

/* Change color of dropdown links on hover */
.dropdown-content a:hover {background-color: #f1f1f1}

/* Show the dropdown menu on hover */
.dropdown:hover .dropdown-content {
  display: block;
}

/* Change the background color of the dropdown button when the dropdown content is shown */
.dropdown:hover .dropbtn {

}

@media (max-width: 1200px) {

  .header_size {width:100%;}
  .headerMenu {
    /* width:1200px; */
    display: flex;
    justify-content: space-around;
  }
  .headerMenu li{
    float: left;
  }
  .logo {
    float: left;
    width:10%;
  }
}
@media (max-width: 990px) {

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
/* 왼쪽에 위치한 공고등록버튼 및 인재채용정보 */
.comLeftBox{
  width: 30%;
  height: 100%;
}
.comBtn1{
  width: 230px;
  height: 50px;
  text-align: center;
  margin: 30px;
  font-size: medium;
  color: white;
  background-color: rgb(95,75,229);
  border-radius: 15px;
}
.comTip{
  height: 70%;
  border: 3px solid;
  text-align: center;
}

/* 오른쪽에 위치한 div박스 모음 */
.comRightBox {
  display: flex;
  justify-content: space-between;
  float: left;
  width: 50%;
}
.comRightBox span {
  text-align: center;
  font-weight: bold;
}
.comNewComer p {
  font-weight: bold;
}

.comList {
  display: inline-block;
  width: 100%;
  height: 100%;
}
.comList span {
  font-weight: 900;
  font-size: x-large;
}
.comTopBox {
  /*display: inline-flex;*/
  height: 20%;
}
.comBottomBox {
  display: inline-flex;
  align-items: center;
  height: 80%;
  width: 100%;
  background-color: #efefef;
  border-radius: 5px;
}

.comRecStatus {
  width: 100%;
  height: 110px;
  text-align: center;
  margin-top: 30px;
  background-color: #efefef;
  border-radius: 5px;
}
.comRecStatus a {
  margin: 30px 20px 10px 10px;
  text-align: center;
}
.comRecStatus a:hover {
  color: grey;
}
.comRecStatus a p {
  color: rgb(95,75,229);
  font-size: large;
  font-weight: bold;
  margin-top: 10px;
}
.comRecStatusList {
  width: 100%;
  height: 110px;
  text-align: center;
}
.comRecList {
  text-align: center;
  width: 50%;
}
.comNewComer {
  width: 600px;
  height: 600px;
}
.comNewComer select {
  width: 100px;
  height: 30px;
  float: right;
  margin-right: 30px;
}
.comNewComer p {
  float: left;
}
.comNewInfo{
  height: 480px;
}
.slider{
  height: 600px;
  width: 600px;
}
.slider li {
  position: relative;
}
.slider input[type=radio]{
  display: none;
}
ul.lists{
  padding: 0;
  margin: 0;
}
ul.lists li{
  position: absolute;
  opacity: 0;
  list-style: none;
  padding: 0;
  margin: 0;
  transition-delay: 0.9s;
}
.bullets{
  position: relative;
  top: 93%;
  left: 50%;
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
  background-color: rgb(95,75,229);
}
.slider input[type=radio]:nth-child(2):checked~.bullets>label:nth-child(2){
  background-color: rgb(95,75,229);
}
.slider input[type=radio]:nth-child(3):checked~.bullets>label:nth-child(3){
  background-color: rgb(95,75,229);
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

