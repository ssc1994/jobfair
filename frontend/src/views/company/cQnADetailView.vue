<template>
  <div class="wrapBox">
    <div class="centerBox">
      <div class="wrapBox2">
        <div class="qnaBox">
          <h3>Q.</h3>
        </div>

        <div class=" wrapBox3">
          <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1">작성자</span>
            <input type="text" class="form-control" placeholder="Username" aria-label="Username"
                   aria-describedby="basic-addon1" disabled>
          </div>

          <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1">문의제목</span>
            <input type="text" class="form-control" placeholder="Title" aria-label="Username"
                   aria-describedby="basic-addon1" disabled>
          </div>

          <div class="input-group">
            <span class="input-group-text">문의내용</span>
            <textarea class="form-control contentBox" aria-label="With textarea" disabled></textarea>
          </div>


        </div>
      </div>

      <div class="wrapBox4">
        <div class="qnaBox">
          <h3>A.</h3>
        </div>

        <div class=" wrapBox5">
          <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1">담당자</span>
            <input type="text" class="form-control" placeholder="Username" aria-label="Username"
                   aria-describedby="basic-addon1" disabled>
          </div>


          <div class="input-group">
            <span class="input-group-text">답변</span>
            <textarea class="form-control contentBox" aria-label="With textarea" disabled></textarea>
          </div>


        </div>
      </div>
    </div>

    <div class="btnBox">
      <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
        수정하기
      </button>
      <button type="button" class="btn btn-outline-primary">목록으로</button>
    </div>

    <!--지원하기 모달창 설정-->
    <!--state 적용해서 데이터 넣어야해유-->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content ">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="exampleModalLabel">답변수정</h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body" style="height: 100%">
            <div class="infoModalBox">

              <div class=" wrapBox3">
                <div class="input-group mb-3">
                  <span class="input-group-text" id="basic-addon1">담당자</span>
                  <input type="text" class="form-control" placeholder="Username" aria-label="Username"
                         aria-describedby="basic-addon1" disabled>
                </div>

                <div class="input-group">
                  <span class="input-group-text">답변</span>
                  <textarea class="form-control contentBox" aria-label="With textarea"></textarea>
                </div>
                <div class="btnModalBox">
                  <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    수정하기
                  </button>

                </div>
              </div>

            </div>


          </div>
        </div>
      </div>


    </div>

  </div>
</template>

<script>
import SoftInput from "@/components/SoftInput.vue";
import SoftButton from "@/components/SoftButton.vue";

export default {components: {SoftInput, SoftButton},};
</script>

<style scoped>
.wrapBox {
  width: 100%;
  height: 100%;
}


.wrapBox2 {
  width: 80%;
  height: 50%;
  margin: 0 auto;
}

.wrapBox2 .qnaBox {
  text-align: left;
  font-size: 30px;
  height: 80px;
  position: relative;

}

.qnaBox h3 {
  font-size: 70px;
  position: relative;
  right: 100px;
  top: 60px;
}


.wrapBox3 .writer {
  font-size: 20px;
  height: 5%;
  line-height: 40px;

}

.contentBox {
  height: 300px;
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

.wrapBox4 {
  width: 80%;
  height: 50%;
  margin: 0 auto;
}

.btnBox {
  text-align: center;
  height: 50px;
  line-height: 50px;
}

.btnModalBox {
  text-align: center;
  margin-top: 30px;
  height: 50px;
  line-height: 50px;
}

.modal {
  --bs-modal-width: 800px
}

</style>
