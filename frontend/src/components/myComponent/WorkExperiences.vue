<template>
  <div class="profile">
    <p class="headline-title">업종 :
      <input type="text" class="headline-input">
    </p>
    <p class="headline-title">회사명 :
      <input type="text" class="headline-input" :name="props_name" v-model="weInfo.we_company" @change="dataChanged">
    </p>
    <p class="headline-title">부서명 :
      <input type="text" class="headline-input" :name="props_name" v-model="weInfo.we_department" @change="dataChanged">
    </p>
    <p class="headline-title">직급/직책 :
      <input type="text" class="headline-input" :name="props_name" v-model="weInfo.we_position" @change="dataChanged">
    </p>
    <p class="headline-title">담당직무 :
      <input type="text" class="headline-input" :name="props_name" v-model="weInfo.we_job" @change="dataChanged">
    </p>
    <p class="headline-title">입사일 :
      <input type="date" class="headline-input" :name="props_name" v-model="weInfo.we_emplDate" @change="dataChanged">
    </p>
    <p class="headline-title">퇴사일 :
      <input type="date" class="headline-input" :name="props_name" v-model="weInfo.we_departureDate" @change="dataChanged">
    </p>
    <p class="headline-title">연봉 :
      <input type="text" class="headline-input" :name="props_name" v-model="weInfo.we_salary" @change="dataChanged">
    </p>
  </div>
</template>

<script>

export default {
  name: "WorkExperiences",
  props: [
      'prop_weInfo',
      'weCount'
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
  methods: {
    dataChanged (e) {
      console.log(this.weCount)
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
  width: 98%;
  margin: 10px;
}

.resume section {
  display: flex;
  position: relative;
  margin-bottom: 70px;
}

.resume section:first-child {
  margin-left: 0px;
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

.introduce {
  left: 800px;
  width: 320px;
  margin-left: 60px;
}

.introduce-contact {
  margin-bottom: 22px;
}

.introduce-contact::before {
  content: "";
  display: block;
  width: 600px;
  height: 3px;
  background-color: #A4A4A4;
  margin-left: 10px;
}

.introduce-contact::after {
  content: "";
  display: block;
  width: 600px;
  height: 1px;
  background-color: #A4A4A4;
  margin-left: 10px;
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

.introduce-cotact_list {
  display: flex;
}

.introduce-cotact_list::before {
  content: "";
  display: block;
  width: 25px;
  height: 25px;
  margin: 5px 10px 0 0;
  background-repeat: no-repeat;
  background-position: center center;
  background-size: contain;
}

.profile h2 {
  margin-bottom: 10px;
}

.part-content_list--title .date,
.part-content_list--content .title {
  margin-bottom: 5px;
}

/* 자기소개서 박스 크기 */
textarea.form-control {
  min-height: calc(1.5em + 0.75rem + 2px);
  width: 600px;
  height: 250px;
}

select#mm.sel {
  margin-left: 0px;
}

input.int {
  width: 50px;
}

/* 성별 */
select.sel {
  margin-left: 55px;
}

</style>
