<template>
  <div class="profile introduce-contact">
    <p class="fs-medium fc-gray"></p>
    <div class="empReg">
      <section>
        <div class="mb-3 mt-3">
          <label for="">학교구분 :</label>
          <select class="form-select" v-model="eduInfo.edu_degree" @change="inputEduData">
            <option selected value="none">선택</option>
            <option value="high">고등학교</option>
            <option value="college">대학교(2, 3년)</option>
            <option value="university">대학교(4년)</option>
            <option value="graduate">대학원</option>
          </select>
          <label for="">학교명 :</label>
          <input type="text" class="form-control" placeholder="학교명을 입력하세요." v-model="eduInfo.edu_schoolName" @change="inputEduData>
        </div>
        <div class="mb-3 mt-3">
          <label for="">입학년월 :</label>
          <input type="date" class="form-control" v-model="eduInfo.edu_entranceDate" @change="inputEduData">
          <label for="">졸업년월 :</label>
          <input type="date" class="form-control" v-model="eduInfo.edu_graduationDate" @change="inputEduData">
          <label for="">졸업상태 :</label>
          <select class="form-select" v-model="eduInfo.edu_state" @change="inputEduData">
            <option selected value="none">졸업상태 선택</option>
            <option value="1">졸업</option>
            <option value="2">졸업예정</option>
            <option value="3">재학중</option>
            <option value="4">휴학</option>
            <option value="5">자퇴</option>
          </select>
        </div>
        <div class="mb-3 mt-3">
          <label for="">전공명 :</label>
          <input type="text" class="form-control" placeholder="전공을 입력하세요." v-model="eduInfo.edu_major" @change="inputEduData">
        </div>
      </section>
    </div>
  </div>
</template>

<script>
export default {
  name: "Education",
  props: [
    'eduCount'
  ],
  data () {
    return {
      eduInfo: {
        user_id: '',
        edu_degree: 'none',
        edu_schoolName: '',
        edu_major: '',
        edu_entranceDate: '',
        edu_graduationDate: '',
        edu_state: 'none',
        edu_grades: '',
        edu_totalGrades: '',
      },
    }
  },
  methods: {
    inputEduData () {
      let eduData= {
        eduInfo: this.eduInfo,
        eduCount: this.eduCount
      };
      this.$emit("inputEdu", eduData);
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

</style>
