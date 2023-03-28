<template>
  <div>
    <form>
      <main class="resume">
        <!--이력서 제목 -->
        <div class="">
          <h3 class="fs-medium resumeTitle">이력서제목 :
            <input type="text">
          </h3>
        </div>

        <!-- 프로필 사진 등록 -->
        <section>
          <img class="headline-image" :src="viewImg" alt="프로필 사진" ref="previewImg">
          <div class="input-group mb-3 profileSubmit">
            <input type="file" style="display: none" class="form-control" id="inputGroupFile02" @change="previewImg" accept="image/*" ref="inputImg">
            <input type="button" value="사진 선택" @click="clickFile">
          </div>
          <div class="introduce">
            <div class="introduce-contact">
              <ul>
                <li class="introduce-cotact_list">
                  <div>
                    <h4 class="fs-medium">인적사항</h4>
                  </div>
                </li>
              </ul>

              <!-- 인적사항 작성 -->
              <div class="profile">
                <p class="fs-medium fc-gray"></p>
                <p class="headline-title">이름 :<input type="text" class="headline-input" placeholder="이름을 입력하세요."
                                                     v-model="resInfo.res_name"></p>
                <p class="headline-title">이메일 :<input type="email" class="headline-input" v-model="resInfo.res_email">
                </p>
                <p class="headline-title">전화번호 :<input type="text" class="headline-input" v-model="resInfo.res_phone">
                </p>
                <p class="headline-title">주소 :<input type="text" class="headline-input" v-model="resInfo.res_address">
                </p>
                <p class="headline-title">생년월일 :<input type="date" class="headline-input" v-model="resInfo.res_birth">
                </p>
              </div>

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
                    <input type="button" value="추가" id="btnAddWe" @click="addWE">
                  </div>
                </li>
              </ul>
            </div>
            <div  v-for="we in weCount">
              <WE :weCount="weCount" v-model="prop_weInfo" @inputWE="changeWeInfo"/>
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
              <p class="headline-title">자격증명 :<input type="text" class="headline-input" v-model="certInfo.cert_name">
              </p>
              <p class="headline-title">발행일 :<input type="date" class="headline-input" v-model="certInfo.cert_gainDate">
              </p>
              <p class="headline-title">발행처 :<input type="text" class="headline-input"
                                                    v-model="certInfo.cert_issueInstitute"></p>
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
        <input type="submit" value="이력서 저장" @click.prevent="doAction">
      </main>
    </form>
  </div>
</template>

<script>
import axios from "axios";
import WE from "@/components/myComponent/WorkExperiences";

export default {
  name: 'uResumeView',
  components: {
    WE
  },
  data() {
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
        we_company: [
          {we_company: 1}
        ],
        we_department: [],
        we_position: '',
        we_job: '',
        we_emplDate: '',
        we_departureDate: '',
        we_salary: ''
      },
      weCount: 0,
      res_img: '',
      viewImg: ''
    }
  },
  methods: {
    doAction() {  //form 데이터 서버로 전송
      let tmpData = {
        resInfo: this.resInfo,
        certInfo: this.certInfo,
        weInfo: this.weInfo,
      }
      let formData = new FormData();
      let resData = new Blob([JSON.stringify(tmpData)], {type: "application/json"});
      formData.append("resData", resData);
      formData.append("res_img", this.res_img);

      this.$axios.post("/jobfair/regResume", formData)
          .then( response => {
            if(response.status === 200) alert("성공")
          })
          .catch( error => {
            console.log(error)
          })
    },
    clickFile () {  //버튼 클릭 시 input:file 클릭으로 연동하는 함수
      this.$refs.inputImg.click();
    },
    previewImg(e) {  //이미지 미리보기
      this.res_img = e.target.files[0]
      //이미지 업로드 시 화면에서 미리보기 기능
      let reader = new FileReader();
      reader.onload = (event) => {
        this.viewImg = event.target.result;
      }
      reader.readAsDataURL(this.res_img);
    },
    changeWeInfo (weInfo) {
      this.weInfo = weInfo
    },
    addWE () {
      this.weCount++;
    },
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
  width: 98%;
  margin: 10px;
}

.resumeTitle::before {
  content: "";
  display: block;
  width: 800px;
  height: 3px;
  background-color: #A4A4A4;
  margin-left: 10px;
}

.resumeTitle::after {
  content: "";
  display: block;
  width: 800px;
  height: 1px;
  background-color: #A4A4A4;
  margin-left: 10px;
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

.headline-image {
  margin-top: 60px;
  width: 150px;
  height: 200px;
  border: 1px solid #A4A4A4;
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

/* 프로필사진 파일 선택하는 인풋태그 스타일 */
.profileSubmit {
  width: 130px;
  height: 30px;
  position: absolute;
  top: 270px;
  text-align: center;
}

</style>
