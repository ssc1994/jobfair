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


    <div class="qnaBox">
      <div class="qnaBox2">
        <div>
          <h3>Q&A</h3>
          <button>+ 질의 등록</button>
        </div>

        <table>
          <thead>
          <tr class="firstLine">
            <td class="writer">작성자</td>
            <td class="bigTitle">질문제목</td>
            <td class="bigRegdate">등록시간</td>
          </tr>
          </thead>

          <tbody>
          <tr>
            <td class="id">Id</td>
            <td class="title">Title</td>
            <td class="regdate">Regdate</td>
          </tr>
          <tr>
            <td class="id">Id</td>
            <td class="title">Title</td>
            <td class="regdate">Regdate</td>
          </tr>
          <tr>
            <td class="id">Id</td>
            <td class="title">Title</td>
            <td class="regdate">Regdate</td>
          </tr>
          <tr>
            <td class="id">Id</td>
            <td class="title">Title</td>
            <td class="regdate">Regdate</td>
          </tr>
          <tr>
            <td class="id">Id</td>
            <td class="title">Title</td>
            <td class="regdate">Regdate</td>
          </tr>
          </tbody>
        </table>
      </div>
    </div>

  </div>
</template>

<script>
export default {
  name: "uQnAView"
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
  display: flex;
  align-items: center;

}

.qnaBox {
  border: 1px solid red;
  width: 1200px;
  height: 500px;
  margin: 0 auto;
  margin-top: 100px;
  font-family: 'MICEGothic Bold';
}



.qnaBox table {
  border-collapse: collapse;

}

.qnaBox tr {
  text-align: center;
}

.qnaBox td {
  border: 1px solid grey;
}

.qnaBox .firstLine {
  background-color: rgb(227, 227, 227);
}

.qnaBox .writer {
  width: 200px;
  padding: 5px;
  text-align: center;
}



.qnaBox .title {
  width: 500px;
  height: 40px;
  padding: 5px;
  text-align: left;

}

.qnaBox .regdate {
  width: 200px;
  text-align: center;

}

.qnaBox h3 {
  font-size: 20px;
  font-family: 'MICEGothic Bold';
  margin-bottom: 20px;
}

.qnaBox2 h3 {
  font-size: 25px;
}

.qnaBox2 button {
  font-size: 18px;
  border: none;
  position: relative;
  left: 830px;
  bottom: 40px;
}
</style>
