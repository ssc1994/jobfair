<template>
  <div class="wrapBox">



    <div class="wrapBox2">
      <div class="modiBox">

        <div>
        <h2>기업정보 수정 </h2>
        </div>

        <div class="modiBox2">
          <ul>
            <li>기업명 </li>
            <li>기업주소</li>
            <li>기업 전화번호</li>
            <li>기업 이메일</li>
            <li>업종</li>
            <li>대표자</li>
            <li>사업자 등록번호</li>
            <li>참여기간</li>
          </ul>
        </div>

        <div class="modiBox3">
          <input type="text">
          <input type="text">
          <input type="text">
          <input type="text">
          <input type="text">
          <input type="text">
          <input type="text">
          <input type="text">
        </div>


      </div>

      <div class="btnBox">
        <button class="modiBtn">수정하기</button>
        <button class="listBtn">목록</button>
      </div>
    </div>

    <!--우측 회원정보 확인하는 곳-->
    <div class="userInfoBox">
      <div class="userInfoFirstLine">
        <div>
          <img src="#">
          <h3>OOO님</h3>
          <a href="#">쪽지(3)</a>
        </div>
      </div>
      <div class="userInfoSecondLine">
        <ul class="userInfoSecondLine1">
          <li>10</li>
          <li>담당자 <br/> 신청목록</li>
        </ul>

        <ul class="userInfoSecondLine2">
          <li>10</li>
          <li>참여업체 <br/>신청목록</li>
        </ul>


      </div>

      <div class="btnBox2">
        <button type="button" class="btn btn-outline-primary btn1">채용담당자 신청목록조회</button><br/>
        <button type="button" class="btn btn-outline-primary btn2">참여업체 목록조회</button>
      </div>

    </div>



  </div>
</template>

<script>
export default {
  name: "aComModiView"
}
</script>

<style scoped>
.wrapBox {

  display: flex;
  justify-content: center;
}

.wrapBox2 {
  margin-left: 100px;
  margin-top: 100px;
  width: 700px;
  height: 500px;
  background-color: #90aee8;
}

.wrapBox2 h2 {
  position: relative;
  bottom: 70px;
  right: 180px;
}

.wrapBox2 .modiBox li{
  list-style: none;
}

.wrapBox2 .modiBox .modiBox2 {
  width: 50%;
  display: inline-block;
  float: left;
  margin-top: 50px;
}

.wrapBox2 .modiBox .modiBox2 li {
  font-size: 20px;
  margin-top: 5px;
}

.wrapBox2 .modiBox .modiBox3 input {
  margin-top: 5px;
}

.wrapBox2 .modiBox .modiBox3 {
  width: 50%;
  display: block;
  float: right;
  margin-top: 50px;

}

.wrapBox2 .btnBox {
  position: relative;
  top: 50px;
  right: 50px;
  height: 10px;
  margin-right: 120px;
}

.wrapBox2 .btnBox button {
  border: 1px solid black;
}

.wrapBox2 .btnBox .modiBtn {

}


.userInfoBox {
  margin-top: 50px;
  margin-left: 200px;
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
}
.userInfoFirstLine a {
  float: left;
  margin-left: 15px;
  margin-top: 15px;
  text-decoration-line: none;
  color: grey;
}
.userInfoSecondLine li {
  list-style: none;
}
.userInfoSecondLine {
  overflow: hidden;
  margin-bottom: 20px;
  margin-top: 20px;
}
.userInfoSecondLine .userInfoSecondLine1 {
  float: left;
  text-align: center;
}
.userInfoSecondLine .userInfoSecondLine2 {
  float: left;
  text-align: center;
  padding-left: 40px;
}

.btnBox2 .btn1 {
  width: 230px;
  height: 40px;
  margin-bottom: 15px;
  font-size: 15px;
}
.btnBox2 .btn2 {
  width: 230px;
  height: 40px;
  font-size: 15px;
}
</style>
