<template>
  <div class="profile introduce-contact">
    <div class="empReg">
      <section>
        <div class="mb-3 mt-3">
          <label for="">회사명 :</label>
          <input type="text" class="form-control" :name="props_name" placeholder="회사명을 입력하세요."
                 :disabled="isAble" v-model="weInfo.we_company" @change="inputWeData">
        </div>
        <div class="mb-3 mt-3">
          <label for="">부서명 :</label>
          <input type="text" class="form-control" :name="props_name" placeholder="부서명을 입력하세요."
                 :disabled="isAble" v-model="weInfo.we_department" @change="inputWeData">
          <label for="">직급/직책 :</label>
          <input type="text" class="form-control" :name="props_name"
                 :disabled="isAble" v-model="weInfo.we_position" @change="inputWeData">
          <label for="">담당직무 :</label>
          <input type="text" class="form-control" :name="props_name"
                 :disabled="isAble" v-model="weInfo.we_job" @change="inputWeData">
          <label for="">연봉 :</label>
          <input type="text" class="form-control" :name="props_name"
                 :disabled="isAble" v-model="weInfo.we_salary" @change="inputWeData">
        </div>
        <div class="mb-3 mt-3">
          <label for="">입사일 :</label>
          <input type="date" class="form-control" :name="props_name"
                 :disabled="isAble" v-model="weInfo.we_emplDate" @change="inputWeData">
          <label for="">퇴사일 :</label>
          <input type="date" class="form-control" :name="props_name"
                 :disabled="isAble" v-model="weInfo.we_departureDate" @change="inputWeData">
        </div>
      </section>
    </div>
  </div>
</template>

<script>

export default {
  name: "WorkExperiences",
  props: [
      'weCount',
      'value',
      'isAble'
  ],
  data () {
    return {
      weInfo: {
        we_company: '',
        we_department: '',
        we_position: '',
        we_job: '',
        we_emplDate: '',
        we_departureDate: '',
        we_salary: '',
      },
      props_name: 'weInfo' + this.$props.weCount
    }
  },
  created() {
    if(this.$props.value != undefined){
      this.weInfo = this.$props.value;
    }
  },
  methods: {
    inputWeData (e) {
      let weData = {
        weCount: this.weCount,
        weInfo: this.weInfo
      }
      this.$emit('inputWE', weData)
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

.form-select {
  width: 200px;
  height: 45px;
  margin: 0px 0px 16px 30px;
}

/* 졸업상태 select */
.school {
  float: right;
  position: absolute;
  left: 150px;
  top: 70px;
}

/* 입학여부 select*/
.finish {
  position: absolute;
  left: 150px;
  top: 345px;
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
