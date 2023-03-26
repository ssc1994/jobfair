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
                <h3>{{comInfo.com_name}}</h3>
              </div>
              <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">기업번호</span>
                <input type="text" class="form-control" placeholder="comNum" aria-label="Username"
                       aria-describedby="basic-addon1" disabled :value="comInfo.com_num">
              </div>

              <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">사업자등록번호</span>
                <input type="text" class="form-control" placeholder="BusinessRegistrationNum" aria-label="Username"
                       aria-describedby="basic-addon1" disabled :value="comInfo.com_businessRegistration">
              </div>

              <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">전화번호</span>
                <input type="text" class="form-control" placeholder="Phone" aria-label="Username"
                       aria-describedby="basic-addon1" disabled :value="comInfo.com_phone">
              </div>

              <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">이메일</span>
                <input type="text" class="form-control" placeholder="Email" aria-label="Username"
                       aria-describedby="basic-addon1" disabled :value="comInfo.com_email">
              </div>

              <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">업종</span>
                <input type="text" class="form-control" placeholder="Category" aria-label="Username"
                       aria-describedby="basic-addon1" disabled :value="comInfo.com_category">
              </div>

              <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">대표자</span>
                <input type="text" class="form-control" placeholder="CEO" aria-label="Username"
                       aria-describedby="basic-addon1" disabled :value="comInfo.com_ceo">
              </div>

              <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">설립일</span>
                <input type="text" class="form-control" placeholder="RegDate" aria-label="Username"
                       aria-describedby="basic-addon1" disabled :value="comInfo.com_establishmentDate">
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
  data(){
    return{
      comInfo:{
        com_name: '',
        com_num: this.$route.params.com_num  ,
        com_phone: '',
        com_email: '',
        com_address: '',
        com_detail_address: '',
        com_category: '',
        com_ceo: '',
        com_businessRegistration: '',
        com_establishmentDate: '',
        com_fileName: '',
        com_filePath: '',
        com_fileUuid: ''
      },
    }
  },
  created() {
    //aComdetailView에 들어오면 바로 실행되는 메서드
    this.getComInfo()
  },
  methods:{
    //회사 정보 불러오기
    async getComInfo () {
      const {data} = await this.$axios.post('/jobfair/companyMypage/getComInfo',
          {com_num: this.comInfo.com_num})
          .catch( err => console.log(err))
      this.comInfo = data;
    },
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
