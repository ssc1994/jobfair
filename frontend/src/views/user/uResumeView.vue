<template>

  <div>
    <form>
      <main class="resume">
        <!--이력서 제목 -->
        <div class="">
          <h3 class="fs-medium resumeTitle">이력서제목 : <input type="text" v-model="resInfo.res_title"></h3>
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
              <p class="headline-title">이름 :<input type="text" class="headline-input" placeholder="이름을 입력하세요."
                                                   v-model="resInfo.res_name"></p>
              <p class="headline-title">이메일 :<input type="email" class="headline-input" v-model="resInfo.res_email"></p>
              <p class="headline-title">전화번호 :<input type="text" class="headline-input" v-model="resInfo.res_phone"></p>
              <p class="headline-title">주소 :<input type="text" class="headline-input" v-model="resInfo.res_address"></p>
              <p class="headline-title">생년월일 :<input type="date" class="headline-input" v-model="resInfo.res_birth"></p>
            </div>
            <!-- 프로필 사진 등록 -->
            <img class="headline-image" :src="viewImg" alt="프로필 사진" ref="previewImg">
            <div class="input-group mb-3 profileSubmit">
              <input type="file" style="display: none" class="form-control" id="inputGroupFile02" @change="previewImg" accept="image/*" ref="inputImg">
              <input class="ImgChoice" type="button" value="사진 선택" @click="clickFile">
              <div class="box">
                <h3>이미지 첨부시 유의사항</h3>
                <div class="info">
                  <p>사진 용량은 50MB가 최대입니다.</p>
                </div>
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
                    <input type="button" value="추가" id="btnAddWe" @click="addComp">
                  </div>
                </li>
              </ul>
            </div>

            <EDU :eduCount=0 v-model="eduInfo[0]" @inputEdu="getEduData"/>
            <div v-for="edu in eduCount">
              <EDU :eduCount="edu" v-model="eduInfo[edu]" @inputEdu="getEduData"/>
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
                    <input type="button" value="추가" id="btnAddWe" @click="addComp">
                  </div>
                </li>
              </ul>
            </div>
            <WE :weCount=0 v-model="weInfo[0]" @inputWE="getWeData"/>
            <div v-for="we in weCount">
              <WE :weCount="we" v-model="weInfo[we]" @inputWE="getWeData"/>
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
                    <input type="button" value="추가" id="btnAddWe" @click="addComp">
                  </div>
                </li>
              </ul>
            </div>

            <CERT :certCount="0" v-model="certInfo[0]" @inputCert="getCertData"/>
            <div v-for="cert in certCount">
              <CERT :certCount="cert" v-model="certInfo[cert]" @inputCert="getCertData"/>
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
import EDU from "@/components/myComponent/Education";
import CERT from "@/components/myComponent/Certificate";

export default {
  name: 'uResumeView',
  components: {
    WE, //경력 컴포넌트
    EDU, //학력 컴포넌트
    CERT //자격증 컴포넌트
  },
  created() {
    //sesionStorage에서 값 가져오는법
    let sessionId = sessionStorage.getItem('sessionId')
    let sessionAuth = sessionStorage.getItem('sessionAuth')
    let sessionComp = sessionStorage.getItem('sessionAuth')
    if(sessionId && typeof sessionId === 'string' && sessionId !== '') {
      let SessionJsonId = JSON.parse(sessionId)
      this.resInfo.user_id = SessionJsonId
    }
    if(sessionAuth && typeof sessionAuth === 'string' && sessionAuth !== '') {
      let SessionJsonAuth = JSON.parse(sessionAuth)
    }
  },
  data() {
    return {
      //이력서 Table 변수
      resInfo: {
        user_id: '',
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
      eduInfo: [],
      eduCount: 0,
      //자격증 Table 변수
      certInfo: [],
      certCount: 0,
      //경력 Table 변수
      weInfo: [],
      weCount: 0,
      //이력서 사진 관련 변수
      res_img: '',
      viewImg: ''
    }
  },
  methods: {
    //*********데이터와 파일을 서버로 전송
    doAction() {
      let tmpData = {
        resInfo: this.resInfo,
        eduInfo: this.eduInfo,
        weInfo: this.weInfo,
        certInfo: this.certInfo
      }

      let formData = new FormData();
      let resData = new Blob([JSON.stringify(tmpData)], {type: "application/json"});
      formData.append("resData", resData);
      formData.append("res_img", this.res_img);

      this.$axios.post("/jobfair/regResume", formData)
          .then(response => {
            if (response.status === 200) alert("작성한 이력서가 등록되었습니다.")
            this.$router.push('/uMypageView')
          })
          .catch(error => {
            if(error.response.data.message === "Required request part 'res_img' is not present"){
              alert("사진을 등록해주세요.")
            }else{
              alert("이력서 등록에 실패하였습니다.")
            }
          })
    },
    //*********버튼 클릭 시 input:file 클릭으로 연동시키는 함수
    clickFile() {
      this.$refs.inputImg.click();
    },
    //*********업로드시킬 사진 미리보기 함수
    previewImg(e) {
      console.log(e.target.files)
      this.res_img = e.target.files[0]
      let reader = new FileReader();
      reader.onload = (event) => {
        this.viewImg = event.target.result;
      }
      reader.readAsDataURL(this.res_img);
    },
    //*********자식 컴포넌트(학력, 경력, 자격증)에서 입력된 데이터 받아오는 함수
    //splice: 첫 번째 인자: 변경시킬 인덱스,  두 번째 인자 : 삭제시킬 개수, 세 번째 인자: 인덱스에 들어갈 값
    //변경 시 기존 인덱스에 들어있는 값을 삭제 후 변경된 데이터를 집어넣는다.
    getEduData(eduData) {
      this.eduInfo.splice(eduData.eduCount, 1, eduData.eduInfo);
    },
    getWeData(weData) {
      this.weInfo.splice(weData.weCount, 1, weData.weInfo);
    },
    getCertData(certData) {
      this.certInfo.splice(certData.certCount, 1, certData.certInfo);
    },
    //*********자식 컴포넌트 추가 함수
    addComp(e) {
      let checkType = e.target.previousSibling.innerHTML;
      if( checkType === '학력') this.eduCount++;
      else if( checkType === '경력') this.weCount++;
      else if( checkType === '자격증') this.certCount++;
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
/* 추가버튼 */
#btnAddWe {
  border: none;
  border-radius: 10px;
  background-color: #0064ff;
  color: white;
  width: 90px;
  height: 30px;
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
  width: 150px;
  height: 200px;
  border: 1px solid #A4A4A4;
  position: absolute;
  margin-left: 100px;
}

.introduce {
  left: 800px;
  width: 320px;
  margin-left: 10px;
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
.ImgChoice {
  position: relative;
  bottom: 30px;
  border: 1px solid #AAAAAA;
  background-color: #A4A4A4;
}

.box {
  position: relative;
  bottom: 28px;
}

.box .info {
  color: #fff;
  position: absolute;
  background: rgba(0,0,0,0.5);
  width: 200px;
  padding: 10px;
  box-sizing: border-box;
  opacity: 0;
  transition: opacity 0.35s ease-in-out;
}
.box:hover .info {
  opacity: 1;
}
.box h3 {
  font-size: 12px;
  padding-bottom: 0.4em;
  overflow:hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  text-transform: uppercase;
}
.box .info p {
  font-size: 12px;
  text-overflow: ellipsis;
  white-space: nowrap;
  text-transform: uppercase;
}

</style>
