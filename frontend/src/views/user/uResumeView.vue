<template>
  <div>
    <form :action.stop="doAction">
      <main class="resume">
        <!--이력서 제목 -->
        <div class="">
          <h3 class="fs-medium resumeTitle">이력서제목 : <input type="text"></h3>
        </div>
        <!-- 인적사항 작성 -->
        <section>

  <div class="introduce">
    <div class="introduce-contact">
      <ul>
        <li class="introduce-cotact_list">
          <div>
            <h4 class="fs-medium">인적사항</h4>
          </div>
        </li>
      </ul>
    </div>
              <div class="profile">
                <p class="headline-title">이름 :<input type="text" class="headline-input" placeholder="이름을 입력하세요." v-model="resInfo.res_name"></p>
                <p class="headline-title">이메일 :<input type="email" class="headline-input" v-model="resInfo.res_email"></p>
                <p class="headline-title">전화번호 :<input type="text" class="headline-input" v-model="resInfo.res_phone"></p>
                <p class="headline-title">주소 :<input type="text" class="headline-input" v-model="resInfo.res_address"></p>
                <p class="headline-title">생년월일 :<input type="date" class="headline-input" v-model="resInfo.res_birth"></p>
              </div>
              <!-- 프로필 사진 등록 -->
              <img class="headline-image" src="#" alt="프로필 사진">
              <div class="input-group mb-3 profileSubmit">
                <input type="file" class="form-control" id="inputGroupFile02">
                <button class="input-group-text" for="inputGroupFile02">사진등록</button>
              </div>
  </div>
        </section>

        <section>
          <div class="introduce">
            <div class="introduce-contact">
              <ul>
                <li class="introduce-cotact_list">
                  <div>
                    <h4 class="fs-medium">학력</h4>
                  </div>
                </li>
              </ul>
            </div>

            <div class="profile">
              <p class="fs-medium fc-gray"></p>
              <p class="headline-title">학교구분 :</p>
              <select class="form-select school" v-model="eduInfo.edu_degree">
                <option selected value="none">선택</option>
                <option value="high">고등학교</option>
                <option value="college">대학교(2, 3년)</option>
                <option value="university">대학교(4년)</option>
                <option value="graduate">대학원</option>
              </select>
              <p class="headline-title">학교명 :
                <input type="text" class="headline-input" placeholder="학교명을 입력하세요." v-model="eduInfo.edu_schoolName">
              </p>
              <p class="headline-title">입학년월 :
                <input type="date" class="headline-input" v-model="eduInfo.edu_entranceDate">
              </p>
              <p class="headline-title">졸업년월 :
                <input type="date" class="headline-input" v-model="eduInfo.edu_graduationDate">
              </p>
              <select class="form-select finish" v-model="eduInfo.edu_state">
                <option selected value="none">졸업상태 선택</option>
                <option value="1">졸업</option>
                <option value="2">졸업예정</option>
                <option value="3">재학중</option>
                <option value="4">휴학</option>
                <option value="5">자퇴</option>
              </select>
              <p class="headline-title">전공명 :
                <input type="text" class="headline-input" placeholder="전공을 입력하세요." v-model="eduInfo.edu_major">
              </p>
            </div>
          </div>
        </section>

        <section>
          <div class="introduce">
            <div class="introduce-contact">
              <ul>
                <li class="introduce-cotact_list">
                  <div>
                    <h4 class="fs-medium">경력</h4>
                  </div>
                </li>
              </ul>
            </div>

            <div class="profile">
              <p class="headline-title">업종 :
                <input type="text" class="headline-input">
              </p>
              <p class="headline-title">회사명 :
                <input type="text" class="headline-input" v-model="weInfo.we_company">
              </p>
              <p class="headline-title">부서명 :
                <input type="text" class="headline-input" v-model="weInfo.we_department">
              </p>
              <p class="headline-title">직급/직책 :
                <input type="text" class="headline-input"  v-model="weInfo.we_position">
              </p>
              <p class="headline-title">담당직무 :
                <input type="text" class="headline-input" v-model="weInfo.we_job">
              </p>
              <p class="headline-title">입사일 :
                <input type="date" class="headline-input" v-model="weInfo.we_emplDate">
              </p>
              <p class="headline-title">퇴사일 :
                <input type="date" class="headline-input" v-model="weInfo.we_departureDate">
              </p>
              <p class="headline-title">연봉 :
                <input type="text" class="headline-input" v-model="weInfo.we_salary">
              </p>
            </div>
          </div>
        </section>

        <section>
          <div class="introduce">
            <div class="introduce-contact">
              <ul>
                <li class="introduce-cotact_list">
                  <div>
                    <h4 class="fs-medium">자격증</h4>
                  </div>
                </li>
              </ul>
            </div>

            <div class="profile">
              <p class="fs-medium fc-gray"></p>
              <p class="headline-title">자격증명 :<input type="text" class="headline-input" v-model="certInfo.cert_name"></p>
              <p class="headline-title">발행일 :<input type="date" class="headline-input" v-model="certInfo.cert_gainDate"></p>
              <p class="headline-title">발행처 :<input type="text" class="headline-input" v-model="certInfo.cert_issueInstitute"></p>
            </div>
          </div>
        </section>

        <section>
          <div class="introduce">
            <div class="introduce-contact">
              <ul>
                <li class="introduce-cotact_list">
                  <div>
                    <h4 class="fs-medium">자기소개서</h4>
                  </div>
                </li>
              </ul>
            </div>

            <div class="profile">
              <p class="fs-medium fc-gray"></p>
              <div class="container">
                <textarea class="form-control col-sm-5" rows="5" v-model="resInfo.res_content"></textarea>
              </div>
            </div>
          </div>
        </section>
        <input type="button" value="이력서 저장">
      </main>
    </form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: 'uResumeView',
  data () {
    return {
      //이력서 Table 변수
      resInfo: {
        res_title: '',
        res_content: '',
        res_regDate: '',
        res_picName: '',
        res_picPath: '',
        res_picUuid: '',
        res_name: '',
        res_email: '',
        res_phone: '',
        res_address: '',
        res_birth: '',
      },
      //학력 Table 변수
      eduInfo: {
        edu_degree: 'none',
        edu_schoolName: '',
        edu_major: '',
        edu_entranceDate: '',
        edu_graduationDate: '',
        edu_state: 'none',
        edu_grades: '',
        edu_totalGrades: '',
      },
      //자격증 Table 변수
      certInfo: {
        cert_name: '',
        cert_gainDate: '',
        cert_issueInstitute: '',
      },
      //경력 Table 변수
      weInfo: {
        we_company: '',
        we_department: '',
        we_position: '',
        we_job: '',
        we_emplDate: '',
        we_departureDate: '',
        we_salary: ''
      }
    }
  },
  methods: {
    doAction () {
      this.$axios.post("")
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
/* 이력서 제목 입력 css */
.resumeTitle {
  padding: 20px;
}
.resumeTitle input {
  width: 650px;
  margin: 10px;
}
.resumeTitle::before {
  content: "";
  display: block;
  width: 800px;
  height: 3px;
  background-color: #A4A4A4;
}
.resumeTitle::after {
  content: "";
  display: block;
  width: 800px;
  height: 1px;
  background-color: #A4A4A4;
}
/* 이력서 양식 제일 바깥 css*/
.resume {
  width: 900px;
  margin: 60px auto;
  padding: 20px;
  color: #1E1E1E;
  background-color: #FFF;
  box-shadow: rgba(0, 0, 0, 0.16) 0px 10px 36px 0px, rgba(0, 0, 0, 0.06) 0px 0px 0px 1px;
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
  left: 90px;
  top: 70px;
}

/* 입학여부 select*/
.finish {
  position: absolute;
  left: 90px;
  top: 345px;
}

.headline-image {
  width: 150px;
  height: 200px;
  border: 1px solid #A4A4A4;
  position: absolute;
  margin-left: 100px;
}

.introduce {
  left: 800px;
  width: 320px;
}

.introduce-contact {
  margin-bottom: 22px;
}

.introduce-contact::before {
  content: "";
  display: block;
  width: 800px;
  height: 3px;
  background-color: #A4A4A4;
  margin-left: 10px;
}

.introduce-contact::after {
  content: "";
  display: block;
  width: 800px;
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


.part-content_list--title .date,
.part-content_list--content .title {
  margin-bottom: 5px;
}

/* 자기소개서 박스 크기 */
textarea.form-control {
  min-height: calc(1.5em + 0.75rem + 2px);
  width: 800px;
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
/* 프로필사진 파일 선택하는 인풋태그 스타일 */
.profileSubmit {
  width: 130px;
  height: 30px;
  position: absolute;
  top: 320px;
  left: 640px;
}

</style>