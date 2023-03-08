<template>



  <div class="wrapBox container-fluid mt-3">
    <div class="wrapBox2">
      <div class="postingBox">
        <h2>최근 인기 있는 공고</h2>
        <div class="postingBox2">
          <div class="postingBox3">
            <div class="miniPostingBox">
              <img src="#">
              <div>
                <h3>(주)카카오</h3>
                <a href="#">2023년도 각 부문별 채용모집</a>
              </div>
            </div>

            <div class="miniPostingBox">
              <img src="#">
              <div>
                <h3>(주)카카오</h3>
                <a href="#">2023년도 각 부문별 채용모집</a>
              </div>
            </div>

            <div class="miniPostingBox">
              <img src="#">
              <div>
                <h3>(주)카카오</h3>
                <a href="#">2023년도 각 부문별 채용모집</a>
              </div>
            </div>
          </div>
          <div class="postingBox4">
            <div class="miniPostingBox">
              <img src="#">
              <div>
                <h3>(주)카카오</h3>
                <a href="#">2023년도 각 부문별 채용모집</a>
              </div>
            </div>

            <div class="miniPostingBox">
              <img src="#">
              <div>
                <h3>(주)카카오</h3>
                <a href="#">2023년도 각 부문별 채용모집</a>
              </div>
            </div>

            <div class="miniPostingBox">
              <img src="#">
              <div>
                <h3>(주)카카오</h3>
                <a href="#">2023년도 각 부문별 채용모집</a>
              </div>
            </div>
          </div>
        </div>

      </div>

      <!--우측 회원정보 확인하는 곳-->
      <div class="userInfoBox">
        <div class="userInfoFirstLine">
          <div>
            <img src="#">
            <h3>OOO님의 <br/>입사 지원 현황</h3>
            <a href="#">쪽지(3)</a>
          </div>
        </div>
        <div class="userInfoSecondLine">
          <ul class="userInfoSecondLine1">
            <li>10</li>
            <li>지원완료</li>
          </ul>

          <ul class="userInfoSecondLine2">
            <li>10</li>
            <li>열람</li>
          </ul>

          <ul class="userInfoSecondLine3">
            <li>10</li>
            <li>미열람</li>
          </ul>

        </div>

        <div class="btnBox">
          <button type="button" class="btn btn-outline-primary btn1">이력서 관리</button>
          <button type="button" class="btn btn-outline-primary btn2">mypage</button>
        </div>

      </div>
    </div>

    <div class="qnaBox">
      <h3>Q&A</h3>
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

</template>

<script>
export default {
  name: 'uMainView'
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
.wrapBox {
  min-height: 100vh;
  overflow: hidden;
}
.wrapBox2 {
  display: flex;
  justify-content: center;
  height: 500px;
}
.postingBox {
  margin-left: 100px;
}
.postingBox h2 {
  display: block;
  height: 50px;
  text-align: left;
  font-size: 20px;
  padding-left: 130px;
  margin-top: 25px;
  font-family: 'MICEGothic Bold';
}
.postingBox2 {
  display: flex;
  justify-content: space-between;
  margin-right: 250px;
}
.postingBox2 .miniPostingBox {
  display: flex;
  justify-content: center;
  height: 150px;
}
.postingBox2 .miniPostingBox img {
  border: 1px solid grey;
  height: 70px;
  width: 70px;
}
.postingBox2 .miniPostingBox div a {
  margin-top: 0px;
  margin-bottom: 0;
  font-size: 15px;
  text-decoration-line: none;
  font-family: 'MICEGothic Bold';
}
.postingBox2 .miniPostingBox div h3 {
  margin-top: 0px;
  margin-bottom: 0;
  font-family: 'MICEGothic Bold';
}
.postingBox2 .miniPostingBox div {
  display: inline-block;
  text-align: left;
  width: 200px;
  height: 70px;
  padding-top: 10px;
  margin-left: 10px;
}
.postingBox2 .postingBox3 {
  float: left;
  padding-left: 130px;
}
.postingBox2 .postingBox4 {
  padding-left: 150px;
}
.userInfoBox {
  margin-top: 50px;
  margin-right: 200px;
}
.userInfoFirstLine {
  overflow: hidden;
}
.userInfoFirstLine img {
  float: left;
  height: 40px;
  width: 40px;
  margin-left: 15px;
}
.userInfoFirstLine h3 {
  font-size: 14px;
  float: left;
  padding-left: 20px;
  height: 50%;
  font-family: 'MICEGothic Bold';
}
.userInfoFirstLine a {
  float: left;
  margin-left: 15px;
  margin-top: 15px;
  text-decoration-line: none;
  color: grey;
  font-family: 'MICEGothic Bold';
}
.userInfoSecondLine li {
  list-style: none;
}
.userInfoSecondLine {
  overflow: hidden;
  margin-bottom: 20px;
  margin-top: 20px;
  margin-left: 10px;
}
.userInfoSecondLine .userInfoSecondLine1 {
  float: left;
  text-align: center;
  font-family: 'MICEGothic Bold';
}
.userInfoSecondLine .userInfoSecondLine2 {
  float: left;
  text-align: center;
  padding-left: 40px;
  font-family: 'MICEGothic Bold';
}
.userInfoSecondLine .userInfoSecondLine3 {
  float: left;
  text-align: center;
  padding-left: 40px;
  font-family: 'MICEGothic Bold';
}
.btnBox .btn1 {
  width: 230px;
  height: 40px;
  margin-bottom: 15px;
  font-family: 'MICEGothic Bold';
  font-size: 15px;
}
.btnBox .btn2 {
  width: 230px;
  height: 40px;
  font-family: 'MICEGothic Bold';
  font-size: 15px;
}
.qnaBox {
  display: block;
  float: left;
  font-family: 'MICEGothic Bold';
  position: relative;
  left: 250px;
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
  font-size:  20px;
  margin-bottom: 20px;
}
</style>
