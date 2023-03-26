<template>
  <div>
    <form>
      <main class="resume">
        <!--이력서 제목 -->
        <div class="">
          <h2>{{resInfo.res_title}}</h2>
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
              <p class="headline-title">이름 :<input type="text" class="headline-input" :disabled="isAble" placeholder="이름을 입력하세요."
                                                   v-model="resInfo.res_name"></p>
              <p class="headline-title">이메일 :<input type="email" class="headline-input" :disabled="isAble" v-model="resInfo.res_email"></p>
              <p class="headline-title">전화번호 :<input type="text" class="headline-input" :disabled="isAble" v-model="resInfo.res_phone"></p>
              <p class="headline-title">주소 :<input type="text" class="headline-input" :disabled="isAble" v-model="resInfo.res_address"></p>
              <p class="headline-title">생년월일 :<input type="date" class="headline-input" :disabled="isAble" v-model="resInfo.res_birth"></p>
            </div>
            <!-- 프로필 사진 등록 -->
            <img class="headline-image" :src="imageUrl" alt="프로필 사진" ref="previewImg">
            <div class="input-group mb-3 profileSubmit">
              <input type="file" style="display: none" class="form-control" id="inputGroupFile02" @change="previewImg" accept="image/*" ref="inputImg">
              <input class="ImgChoice" :class="isAble" type="button" value="사진 선택" @click="clickFile">
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
                  </div>
                </li>
              </ul>
            </div>

            <div v-for="edu in eduCount">
              <EDU :isAble="isAble" :eduCount="edu" :value="eduInfo[edu-1]"/>
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

            <div v-for="we in weCount">
              <WE :isAble="isAble" :weCount="we" :value="weInfo[we-1]"/>
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

            <div v-for="cert in certCount">
              <CERT :isAble="isAble" :certCount="cert" :value="certInfo[cert-1]" />
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
                <textarea class="form-control col-sm-5" rows="5" :disabled="isAble" v-model="resInfo.res_content"></textarea>
              </div>
            </div>
          </div>
        </section>

        <div v-if="isAble">
          <input type="button" value="이력서 수정" @click="modiBtn">
          <input type="button" value="삭제" @click="delBtn">
        </div>
        <div v-if="!isAble">
          <input type="button" value="돌아가기" @click="goBack">
        </div>

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
  props: [
    'resDetail'
  ],
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
      eduCount: '',
      //자격증 Table 변수
      certInfo: [],
      certCount: '',
      //경력 Table 변수
      weInfo: [],
      weCount: '',
      //이력서 사진 관련 변수
      res_img: '',
      viewImg: '',
      res_num: '',
      isAble: false,
      imageUrl: ''
    }
  },
  created() {
    this.res_num = this.$route.query.res_num
    this.isAble = this.$route.query.isAble === 'true' ? true : false;

    this.$axios.get('/jobfair/getResumeDetail?res_num=' + this.res_num)
        .then(response => {
          this.resInfo = response.data.resVO;
          this.eduInfo = response.data.eduList;
          this.eduCount = this.eduInfo.length;
          this.weInfo = response.data.weList;
          this.weCount = this.weInfo.length;
          this.certInfo = response.data.certList;
          this.certCount = this.certInfo.length;
          this.imageUrl = response.data.imageUrl;
        })
        .catch(err => {
          console.log(err)
        })
  },
  methods: {
    delBtn() {
      if (confirm('정말로 삭제하시겠습니까?')) {
        this.$axios.post('/jobfair/deleteResume', this.resInfo)
            .then((res) => {
              this.$router.push("/uMypageView");
              this.res_num = res.data
            })
            .catch((error) => {
              console.log(error)
            })
      }
    },
    modiBtn() {
      this.$router.push({
        name: 'uModiResumeView',
        query: {
          res_num: this.resInfo.res_num
        }}
      )
      window.scrollTo(0, 0);

    },
    goBack() {
      this.$router.go(-1)
    }
  },
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

input:disabled {
  border: none;
  background-color: white;
}
</style>