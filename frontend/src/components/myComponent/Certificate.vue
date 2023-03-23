<template>
  <div class="profile introduce-contact">
    <p class="fs-medium fc-gray"></p>
    <div class="empReg">
      <section>
        <div class="mb-3 mt-3">
          <label for="">자격증명 :</label>
          <input type="text" class="form-control" placeholder="자격증을 입력하세요." v-model="certInfo.cert_name"
                 :disabled="isAble" @change="inputCertData">
        </div>
        <div class="mb-3 mt-3">
          <label for="">발행일 :</label>
          <input type="date" class="form-control" v-model="certInfo.cert_gainDate" :disabled="isAble" @change="inputCertData">
        </div>
        <div class="mb-3 mt-3">
          <label for="">발행처 :</label>
          <input type="text" class="form-control" placeholder="발행처를 입력하세요."
                 v-model="certInfo.cert_issueInstitute" :disabled="isAble" @change="inputCertData">
        </div>
      </section>
    </div>
  </div>
</template>

<script>
export default {
  name: "Certificate",
  props: [
      'certCount',
      'value',
      'isAble'
  ],
  data () {
    return {
      certInfo: {
        user_id: '',
        cert_name: '',
        cert_gainDate: '',
        cert_issueInstitute: '',
      }
    }
  },
  created() {
    if(this.$props.value != undefined){
      this.certInfo = this.$props.value;
    }
  },
  methods: {
    inputCertData() {
      let certData = {
        certInfo: this.certInfo,
        certCount: this.certCount
      };
      this.$emit("inputCert", certData);
    }
  }
}
</script>

<style scoped>
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

ul, ol {
  list-style: none;
}

a {
  text-decoration: none;
}

body {
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
  background-color: #fbfbfb;
  word-break: keep-all;
}

.resumeTitle input {
  width: 650px;
  margin: 10px;
}

.resume section {
  display: flex;
  position: relative;
  margin-bottom: 70px;
}

.headline-title {
  margin: 0px 10px 10px 20px;
  font-size: 18px;
  text-align: left;
  width: 500px;
  float: left;
}

.headline-input {
  width: 400px;
  height: 45px;
  margin-left: 10px;
  font-size: small;
  float: right;
}

.introduce-contact ul {
  display: flex;
  justify-content: space-between;
  align-content: center;
  margin: 15px 0;
}

.introduce-contact-sec ul {
  display: flex;
  justify-content: space-between;
  align-content: center;
  margin: 15px 0;
}

.empReg {
  width: 860px;
}

.empReg section {
  display: flex;
  position: relative;
  justify-content: space-around;
}

.empReg section .form-select {
  width: 130px;
  height: 30px;
}

input:disabled {
  border: none;
  background-color: white;
}

</style>
