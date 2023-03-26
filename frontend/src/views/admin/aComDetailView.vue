<template>
  <div class="container" style="max-width:1560px;">

    <div>
      <div>
        <div class="aplBoxCon">
            <h3>기업 정보</h3>

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
          <button class="okBtn">승인하기</button>
          <button class="noBtn" data-bs-toggle="modal" data-bs-target="#exampleModal">
            반려하기
          </button>
        </div>
      </div>
    </div>


    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content ">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="exampleModalLabel">반려하기</h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body" style="height: 100%">
            <div class="infoModalBox">

              <div class=" wrapBox3">

                <div class="input-group">
                  <span class="input-group-text">반려사유</span>
                  <textarea class="form-control contentBox" aria-label="With textarea"></textarea>
                </div>

                <div class="btnModalBox">
                  <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" @click.prevent="uQnAModi">
                    반려하기
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
export default {
  name: "aComDetailView"
}
</script>

<style scoped>
.aplBoxCon h3{
  font-weight: bold;
  font-size: 20px;
  padding:20px;
  color: #202632;
}
.infoWrapBox {
  border: 1px solid #AAAAAA;
  border-radius: 15px;
  padding: 20px;
  width: 90%;
  margin: 0 auto;
}

.infoBox {
  width: 80%;
  height: 500px;
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
  background-color: #0064ff;
  color: white;
  font-weight: 800;
}
.okBtn:hover {
  background-color: rgb(0,100,255,0.8);
}
.noBtn {
  text-align: center;
  margin-top: 30px;
  height: 50px;
  line-height: 50px;
  width: 250px;
  border: 1px solid gray;
  background-color: #0064ff;
  color: white;
  font-weight: 800;
}
.noBtn:hover {
  background-color: rgb(0,100,255,0.8);
}

.input-group textarea {
  height: 150px;
}

.btnModalBox button {
  float: right;
  margin-top: 25px;
}

</style>
