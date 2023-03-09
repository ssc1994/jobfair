<template>


  <div class="wrapBox">
    <div class="centerBox">
      <div class="wrapBox2">
        <div class="qnaBox">
          <h3>Q&A</h3>
        </div>

        <div class=" wrapBox3">
          <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1">작성자</span>
            <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
          </div>

            <div class="input-group mb-3">
              <span class="input-group-text" id="basic-addon1">문의제목</span>
              <input type="text" class="form-control" placeholder="Title" aria-label="Username" aria-describedby="basic-addon1">
            </div>

            <div class="input-group">
              <span class="input-group-text">문의내용</span>
              <textarea class="form-control contentBox" aria-label="With textarea"></textarea>
            </div>

          <div class="btnBox">
            <button type="button" class="btn btn-outline-primary">문의하기</button>
            <button type="button" class="btn btn-outline-primary">목록으로</button>
          </div>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
import SoftInput from "@/components/SoftInput.vue";
import SoftButton from "@/components/SoftButton.vue";
export default { components: { SoftInput, SoftButton}, };

</script>

<style scoped>

.wrapBox {
  width: 100%;
  height: 800px;
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

.wrapBox2 .qnaBox h3 {
  font-size: 200%;
  position: relative;
  bottom: 60px;
  right: 150px;
}


.wrapBox3 .writer {
  font-size: 20px;
  height: 5%;
  line-height: 40px;

}

.wrapBox3 .contentBox {
  height: 500px;
  resize: none;
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

.btnBox {
  position: relative;
  left: 200px;
}

.btnBox button {
  background-color: darkblue;
  border: none;
  color: white;
}

</style>