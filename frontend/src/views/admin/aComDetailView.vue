<template>
  <div class="container" style="max-width:1560px;">

    <div>
      <div>
        <div class="aplBoxCon">
          <div>
            <h3 class="title">기업 정보</h3>
          </div>

          <div class="infoBoxWrap">
            <div class="infoBox">

              <div class="info_head">
                <div class="comLogoWrap">
                  <img :src="comInfo.img_url" class="comLogo">
                </div>
                <div class="com_name_wrap">
                  <div class="com_name">{{ comInfo.com_name }}</div>
                </div>
              </div>

              <div class="info_body">
                <div class="input-group mb-3">
                  <span class="input-group-text" id="basic-addon1">사업자등록번호</span>
                  <input type="text" class="form-control" placeholder="Title" aria-label="Username"
                         aria-describedby="basic-addon1" disabled :value="comInfo.com_businessRegistration">
                </div>

                <div class="input-group mb-3">
                  <span class="input-group-text" id="basic-addon1">설립일</span>
                  <input type="text" class="form-control" placeholder="Username" aria-label="Username"
                         aria-describedby="basic-addon1" disabled :value="comInfo.com_establishmentDate">
                </div>

                <div class="input-group mb-3">
                  <span class="input-group-text" id="basic-addon1">업종</span>
                  <input type="text" class="form-control" placeholder="Username" aria-label="Username"
                         aria-describedby="basic-addon1" disabled :value="comInfo.com_category">
                </div>

                <div class="input-group mb-3">
                  <span class="input-group-text" id="basic-addon1">대표자</span>
                  <input type="text" class="form-control" placeholder="대표자" aria-label="Username"
                         aria-describedby="basic-addon1" disabled :value="comInfo.com_ceo">
                </div>

                <div class="input-group mb-3">
                  <span class="input-group-text" id="basic-addon1">전화번호</span>
                  <input type="text" class="form-control" placeholder="Username" aria-label="Username"
                         aria-describedby="basic-addon1" disabled :value="comInfo.com_phone">
                </div>

                <div class="input-group mb-3">
                  <span class="input-group-text" id="basic-addon1">이메일</span>
                  <input type="text" class="form-control" placeholder="Username" aria-label="Username"
                         aria-describedby="basic-addon1" disabled :value="comInfo.com_email">
                </div>


                <div class="input-group mb-3">
                  <span class="input-group-text" id="basic-addon1">주소</span>
                  <input type="text" class="form-control" placeholder="Username" aria-label="Username"
                         aria-describedby="basic-addon1" disabled :value="comInfo.com_address">
                </div>

                <div class="input-group mb-3">
                  <span class="input-group-text" id="basic-addon1">상세주소</span>
                  <input type="text" class="form-control" placeholder="" aria-label="Username"
                         aria-describedby="basic-addon1" disabled :value="comInfo.com_detail_address">
                </div>
              </div>

              <div class="btnBox">
                <button class="okBtn btn btn-primary" @click="OkHandle">승인하기</button>
                <button class="noBtn btn btn-primary" @click="NoHandle">반려하기</button>
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
        com_fileUuid: '',
        img_url: ''
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
    async OkHandle() {
      alert("승인하시겠습니까?")
      let data = {
        com_num : this.comInfo.com_num,
        mg_auth : '3'
      }
      let res = await this.$axios.post('/jobfair/aComList/handleApplication', data).catch(err => console(err))
      console.log(res)
      this.$router.go(-1)
    },
    async NoHandle() {
      alert("반려하시겠습니까?")
      let data = {
        com_num : this.comInfo.com_num,
        mg_auth : '5'
      }
      let res = await this.$axios.post('/jobfair/aComList/handleApplication', data).catch(err => console(err))
      console.log(res)
      this.$router.go(-1)
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

/* title  공용 css */
.title{
  font-weight: bold;
  color: #202632;
}

/*----------  기업 정보 부분 ----------*/

.infoBoxWrap {
  border: 1px solid #AAAAAA;
  border-radius: 15px;
  padding: 10px;
  width: 100%;
  height: 800px;
}

.infoBox {
  width: 80%;
  height: 500px;
  margin: 0 auto;
  margin-top: 50px;
}

/*--------- 정보 머리부분 : 기업 로고, 기업 이름 -------------------------*/
.info_head {
  display: block;
  margin-bottom: 40px;
  overflow: hidden;
}

/* 로고 부분*/
.info_head .comLogoWrap {
  overflow: hidden;
  display: inline-block;
  width: 150px;
  height: 150px;
  float: left;
}
.comLogo {
  width: 150px;
  height: 150px;
  object-fit:cover;
}

/*기업 이름 부분*/
.info_head .com_name_wrap{
  margin-left: 10px;
  display: inline-block;
  float: left;
}
.info_head .com_name_wrap .com_name{
  color: #202632;
  font-weight: bold;
  font-size: 40px;
  padding:20px;
}


/*-------------- 기업 데이터 부분 --------------------*/
.info_body{
  display: block;
}

.input-group-text{
  font-weight: bold;
  color: #202632;
  font-size: 15px;
}



.infoBox {
  width: 80%;
  height: 500px;
  margin: 0 auto;
  margin-top: 50px;
}
/*----------------------------------*/
.btnBox {
  text-align: center;
}

.btnBox button {
  text-align: center;
  width: 10%;
  margin-top: 25px;
  margin-right: 35px;
}

.input-group textarea {
  height: 150px;
}

.btnModalBox button {
  float: right;
  margin-top: 25px;
}

</style>
