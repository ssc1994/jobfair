<template>
  <div class="container" style="max-width:1560px;">

    <div>
      <div>
        <div class="aplBoxCon">
          <div>
            <h3>기업 정보</h3>
          </div>

          <div class="infoWrapBox">
            <div class="infoBox">
              <div class="logoBox">
                <img src="#">
                <h3>카카오</h3>
              </div>
              <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">기업번호</span>
                <input type="text" class="form-control" placeholder="Username" aria-label="Username"
                       aria-describedby="basic-addon1" disabled>
              </div>

              <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">사업자등록번호</span>
                <input type="text" class="form-control" placeholder="Title" aria-label="Username"
                       aria-describedby="basic-addon1" disabled>
              </div>

              <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">전화번호</span>
                <input type="text" class="form-control" placeholder="Username" aria-label="Username"
                       aria-describedby="basic-addon1" disabled>
              </div>

              <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">이메일</span>
                <input type="text" class="form-control" placeholder="Username" aria-label="Username"
                       aria-describedby="basic-addon1" disabled>
              </div>

              <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">업종</span>
                <input type="text" class="form-control" placeholder="Username" aria-label="Username"
                       aria-describedby="basic-addon1" disabled>
              </div>

              <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">대표자</span>
                <input type="text" class="form-control" placeholder="Username" aria-label="Username"
                       aria-describedby="basic-addon1" disabled>
              </div>

              <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">설립일</span>
                <input type="text" class="form-control" placeholder="Username" aria-label="Username"
                       aria-describedby="basic-addon1" disabled>
              </div>


            </div>
          </div>

        </div>


        <div class="btnBox">
          <button class="okBtn" @click="OkAlert">승인하기</button>
          <button class="noBtn" @click="NoAlert">
            반려하기
          </button>
        </div>
      </div>
    </div>


  </div>



</template>

<script>
export default {
  name: "aComDetailView",

  methods: {
    OkAlert() {
      alert("승인하시겠습니까?")
    },

    NoAlert() {
      alert("반려하시겠습니까?")
    }
  }
}
</script>

<style scoped>
.aplBoxCon h3{
  font-weight: bold;
  font-size: 20px;
  padding:20px;
}



.infoWrapBox {
  border: 1px solid grey;
  width: 100%;
  height: 600px;
  margin: 0 auto;
}

.infoBox {
  width: 80%;
  height: 500px;
  margin: 0 auto;
  margin-top: 50px;
}

.btnBox {
  text-align: center;
}

.okBtn {
  text-align: center;
  margin-top: 30px;
  height: 50px;
  line-height: 50px;
  width: 250px;
  border: 1px solid gray;
  margin-right: 15px;
}
.noBtn {
  text-align: center;
  margin-top: 30px;
  height: 50px;
  line-height: 50px;
  width: 250px;
  border: 1px solid gray;
}

.input-group textarea {
  height: 150px;
}

.btnModalBox button {
  float: right;
  margin-top: 25px;
}

</style>
