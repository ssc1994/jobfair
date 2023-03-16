<template>
  <div class="profile">
    <p class="fs-medium fc-gray"></p>
    <p class="headline-title">자격증명 :<input type="text" class="headline-input" v-model="certInfo.cert_name" @change="inputCertData">
    </p>
    <p class="headline-title">발행일 :<input type="date" class="headline-input" v-model="certInfo.cert_gainDate" @change="inputCertData">
    </p>
    <p class="headline-title">발행처 :<input type="text" class="headline-input"
                                          v-model="certInfo.cert_issueInstitute" @change="inputCertData"></p>
  </div>
</template>

<script>
export default {
  name: "Certificate",
  props: [
      'certCount'
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

</style>
