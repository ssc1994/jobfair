<template>
  <div class="container" style="max-width:1560px;">

  <div class="aplBoxCon" style="margin-top: 50px">
    <div style="margin-left: 50px">
      <h3>참여기업 등록</h3>
    </div>

    <div class="infoWrapBox">
      <div class="infoBox" >

        <div class="input-group mb-3">
          <span class="input-group-text" id="basic-addon1">기업명</span>
          <input type="text" class="form-control" placeholder="Username" aria-label="Username"
                 aria-describedby="basic-addon1" disabled>
        </div>

        <div class="input-group mb-3">
          <span class="input-group-text" id="basic-addon1">기업주소</span>
          <input type="text" class="form-control" placeholder="Username" aria-label="Username"
                 aria-describedby="basic-addon1" disabled>
        </div>

        <div class="input-group mb-3">
          <span class="input-group-text" id="basic-addon1">기업 전화번호</span>
          <input type="text" class="form-control" placeholder="Title" aria-label="Username"
                 aria-describedby="basic-addon1" disabled>
        </div>

        <div class="input-group mb-3">
          <span class="input-group-text" id="basic-addon1">기업 이메일</span>
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
          <span class="input-group-text" id="basic-addon1">사업자 등록번호</span>
          <input type="text" class="form-control" placeholder="Username" aria-label="Username"
                 aria-describedby="basic-addon1" disabled>
        </div>

        <div class="input-group mb-3">
          <span class="input-group-text" id="basic-addon1">참여기간</span>
          <input type="text" class="form-control" placeholder="Username" aria-label="Username"
                 aria-describedby="basic-addon1" disabled>
        </div>

        <div class="btnBox">
          <input type="button" value="등록하기" class="regBtn">
          <input type="button" value="목록" class="listBtn" @click.prevent="BackToList">
        </div>

      </div>
    </div>

  </div>




</div>
</template>

<script>
export default {
  name: "aComRegView",


  methods: {
    BackToList() {
      this.$router.push('/aComListView')
    }
  }

}
</script>

<style scoped>
.infoWrapBox {
  border: 1px solid grey;
  width: 100%;
  height: 600px;
  margin: 0 auto;
  margin-bottom: 100px;
}

.infoBox {
  width: 80%;
  height: 500px;
  margin: 0 auto;
  margin-top: 70px;
}

.btnBox {
  text-align: center;
  height: 50px;
  line-height: 50px;

}

.regBtn {
  text-align: center;
  margin-top: 30px;
  height: 50px;
  line-height: 50px;
  width: 250px;
  border: 1px solid gray;
  margin-right: 15px;
}

.listBtn {
  text-align: center;
  margin-top: 30px;
  height: 50px;
  line-height: 50px;
  width: 250px;
  border: 1px solid gray;
}

</style>
