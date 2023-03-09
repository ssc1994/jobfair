<template>


  <div class="wrapBox">
    <div class="centerBox">
      <div class=" wrapBox2">
        <div class=" qnaBox">
          <h3>Q&A</h3>
        </div>

        <div class=" wrapBox3">
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

          <div>
            <button class="askBtn">문의하기</button>
            <button class="askBtn">목록으로</button>
          </div>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
export default {
  name: "uQnAWriteView"
}
</script>

<style scoped>


.wrapBox {
  width: 100%;
  height: 800px;
}

.centerBox {
  border: 1px solid red;
}

.wrapBox2 {
  width: 50%;
  height: 700px;
  margin: 0 auto;
  margin-top: 5%;
}

.wrapBox2 .qnaBox {
  text-align: left;
  font-size: 30px;
  height: 80px;
  position: relative;

}

.wrapBox2 h3 {
  font-size: 50px;
}


.wrapBox3 .writer {
  font-size: 20px;
  height: 50px;
  line-height: 40px;
  text-align: left;
}

.wrapBox3 .writer input {
  height: 30px;
  font-size: 15px;
  position: relative;
  left: 50px;
}

.wrapBox3 .title {
  font-size: 20px;
  height: 50px;
  line-height: 40px;
  text-align: left;
}

.wrapBox3 .title input {
  height: 30px;
  font-size: 15px;
  position: relative;
  left: 25px;
}

.wrapBox3 .content {
  font-size: 20px;
  text-align: left;
}

.wrapBox3 .content .contentInput {
  height: 350px;
  width: 550px;
  resize: none;
  font-size: 15px;
  position: relative;
  top: 10px;
  left: 120px;
}
.askBtn {
  width: 150px;
  height: 40px;
  background-color: rgb(95, 75, 229);
  border: none;
  border-radius: 5px;
  color: white;
  margin-top: 30px;
}


</style>