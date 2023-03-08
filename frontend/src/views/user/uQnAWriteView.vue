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
              <img src="@/assets/1.png">
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

  <div class="wrapBox">
    <div class="wrapBox2">
      <div class="qnaBox">
        <h3>Q&A</h3>
        <button class="xBtn">x</button>
      </div>

      <div class="wrapBox3">
        <div class="writer">
          작성자  <input type="text" placeholder="내용을 입력해주세요"> <br />
        </div>

        <div class="title">
          문의 제목  <input type="text" placeholder="내용을 입력해주세요"> <br />
        </div>

        <div class="content">
          문의 내용 <br/>
          <textarea class="contentInput" placeholder="내용을 입력해주세요"></textarea>  <br />
        </div>

      </div>
      <button class="askBtn">문의하기</button>
    </div>


  </div>
</template>

<script>
export default {
  name: "uQnAWriteView"
}
</script>

<style scoped>
/*폰트설정*/
@font-face {
  font-family: 'Happiness-Sans-Title';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2205@1.0/Happiness-Sans-Title.woff2') format('woff2');
  font-weight: normal;
  font-style: normal;
}
/* 공통 부분 */
*{
  padding: 0;
  margin: 0;
}
a {text-decoration: none;}
li {list-style: none;}
/* 공통 부분--end */


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

.searchIcon {background-image: url("@/assets/1.png")  ;
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

.wrapBox {
  border: 1px solid grey;
  width: 800px;
  height: 800px;
  margin: 0 auto;
  margin-top: 100px;
  margin-bottom: 100px;
  display: flex;
  align-items: center;
}

.wrapBox2 {
  width: 670px;
  height: 670px;
  margin: auto;
  overflow: hidden;

}

.wrapBox2 .qnaBox {
  text-align: left;
  font-size: 30px;
  height: 80px;
}

.wrapBox2 .qnaBox .xBtn {
  position: relative;
  width: 40px;
  left: 600px;
  font-size: 30px;
  bottom: 30px;
}

.wrapBox3 .writer {
  height: 50px;
  line-height: 50px;
  position: relative;
  left: 50px;
  font-size: 20px;
}

.wrapBox3 .writer input {
  position: relative;
  left: 100px;
  width: 300px;
  height: 30px;
}

.wrapBox3 .title {
  height: 50px;
  line-height: 50px;
  position: relative;
  left: 50px;
  margin-bottom: 20px;
  font-size: 20px;
}

.wrapBox3 .title input {
  position: relative;
  left: 80px;
  width: 300px;
  height: 30px;
}

.wrapBox3 .content {
  height: 50px;
  position: relative;
  left: 50px;
  font-size: 20px;

}

.wrapBox3 .content .contentInput {
  height: 350px;
  width: 550px;
  margin-top: 15px;
  resize: none;
}


.askBtn {
  position: relative;
  left: 250px;
  top: 370px;
  width: 150px;
  height: 40px;
  font-family: 'Happiness-Sans-Title';
  background-color: rgb(95, 75, 229);
  border: none;
  border-radius: 5px;
  color: white;
}

body {
  font-family: 'Happiness-Sans-Title';
}
</style>
