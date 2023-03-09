<template>
  <div>

    <main class="resume">
      <section>
        <img class="headline-image" src="#" alt="프로필 사진">
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
            <p class="fs-medium fc-gray"></p>
            <select class="form-select" aria-label="Default select example">
              <option selected>성별선택</option>
              <option value="1">남자</option>
              <option value="2">여자</option>
            </select>
            <p class="headline-title">이름 :<input type="text" class="headline-input" placeholder="이름을 입력하세요."></p>
            <p class="headline-title">이메일 :<input type="email" class="headline-input"></p>
            <p class="headline-title">전화번호 :<input type="text" class="headline-input"></p>
            <p class="headline-title">주소 :<input type="text" class="headline-input"></p>
            <p class="headline-title">생년월일 :</p>
            <div class="join_row join_birthday">
              <h3 class="join_title">생년월일</h3>
              <div class="bir_wrap">
                <div class="bir_yy">
            <span class="ps_box">
              <select
                  id="mm"
                  class="sel"
                  v-model="signup.yyyy"
                  @focus="checkFlag = false"
              >
                <option value="">년</option>
                <option
                    v-for="(item, index) in yyyyList"
                    :key="index"
                    :value="item.value"
                >
                  {{ item.text }}
                </option>
              </select>
            </span>
                </div>
                <div class="bir_mm">
            <span class="ps_box">
              <select
                  id="mm"
                  class="sel"
                  v-model="signup.mm"
                  @focus="checkFlag = false"
              >
                <option value="">월</option>
                <option
                    v-for="(item, index) in mmlist"
                    :key="index"
                    :value="item.value"
                >
                  {{ item.text }}
                </option>
              </select>
            </span>
                </div>
                <div class=" bir_dd">
            <span class="ps_box">
              <input
                  v-model="signup.dd"
                  placeholder="일"
                  type="text"
                  class="int"
                  maxlength="2"
                  oninput="javascript: this.value = this.value.replace(/[^0-9]/g, '');"
                  @focus="checkFlag = false"
              />
            </span>
                </div>
              </div>
              <span
                  class="error_next_box"
                  v-if="checkFlag && (!signup.yyyy || !signup.mm || !signup.dd)"
              >생년월일을 입력하세요</span
              >
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
            <select class="form-select school" aria-label="Default select example">
              <option selected>선택</option>
              <option value="1">중학교 졸업</option>
              <option value="2">고등학교 졸업</option>
              <option value="3">대학교(2년제) 졸업</option>
              <option value="3">대학교(4년제) 졸업</option>
            </select>
            <p class="headline-title">학교명 :<input type="text" class="headline-input" placeholder="학교명을 입력하세요."></p>
            <p class="headline-title">입학년월/졸업년월</p>
            <select class="form-select finish" aria-label="Default select example">
              <option selected>졸업여부</option>
              <option value="1">졸업</option>
              <option value="2">재학중</option>
              <option value="3">자퇴</option>
            </select>
            <p class="headline-title">전공명 :<input type="text" class="headline-input" placeholder="전공을 입력하세요."></p>
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
            <p class="fs-medium fc-gray"></p>
            <p class="headline-title">업종 :<input type="text" class="headline-input"></p>
            <p class="headline-title">회사명 :<input type="text" class="headline-input"></p>
            <p class="headline-title">부서명 :<input type="text" class="headline-input"></p>
            <p class="headline-title">입사일/퇴사일 :<input type="text" class="headline-input"></p>
            <p>
              <button class="btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                +
              </button>
            </p>
            <div class="collapse" id="collapseExample">
              <div class="card card-body">
                Some placeholder content for the collapse component. This panel is hidden by default but revealed when the user activates the relevant trigger.
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
                  <h4 class="fs-medium">자격증</h4>
                </div>
              </li>
            </ul>
          </div>
          <div class="profile">
            <p class="fs-medium fc-gray"></p>
            <p class="headline-title">자격증명 :<input type="text" class="headline-input"></p>
            <p class="headline-title">발행일 :<input type="text" class="headline-input"></p>
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
              <textarea class="form-control col-sm-5" rows="5"></textarea>
            </div>
            <div class="input-group mb-3">
              <input type="file" class="form-control" id="inputGroupFile02">
              <label class="input-group-text" for="inputGroupFile02">Upload</label>
            </div>
          </div>
        </div>
      </section>
      <button>이력서 저장</button>

    </main>

  </div>
</template>

<script>
export default {
  name: 'uResumeView',
  data () {
    return {
      days: [],
      checkFlag: false,
      signup: {
        // id: this.propSignup.id,
        // password: this.propSignup.password,
        // pwhint: this.propSignup.pwhint,
        // pwhintans: this.propSignup.pwhintans,
        name: "",
        yyyy: "2000",
        mm: "",
        dd: "",
        gender: "",
        email: "",
        address: "",
        phoneNum: "",
      }
    }
  },
  created () {
    const nowYear = new Date().getFullYear()
    for (let i = 0; i < 100; i++) {
      const date = nowYear - i
      this.yyyyList.push({ value: date, text: date })
    }

    for (let i = 1; i < 13; i++) {
      this.mmlist.push({
        value: i,
        text: i
      })
    }
  },
  computed: {
    dates () {
      return this.days.map(day => day.date)
    },
    attributes () {
      return this.dates.map(date => ({
        highlight: true,
        dates: date
      }))
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

/* 이력서 양식 제일 바깥 css*/
.resume {
  width: 800px;
  margin: 60px auto;
  padding: 20px;
  color: #1E1E1E;
  background-color: #FFF;
  box-shadow: rgba(0, 0, 0, 0.16) 0px 10px 36px 0px, rgba(0, 0, 0, 0.06) 0px 0px 0px 1px;
}

.resume section {
  display: flex;
  position: relative;
  margin-left: 135px;
  margin-bottom: 70px;
}

.resume section:first-child {
  margin-left: 0px;
}
.form-floating {
  margin-left: 30px;
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
  left: -11px;
  top: 205px;
}

.headline-image {
  margin-top: 70px;
  width: 150px;
  height: 200px;
  border: 1px solid #A4A4A4;
}

.introduce {
  left: 800px;
  width: 320px;
}

.introduce-contact {
  margin-bottom: 20px;
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

/* 버튼 */
.btn {
  width: 50px;
  height: 30px;

}
/* 자기소개서 박스 크기 */
textarea.form-control {
  min-height: calc(1.5em + 0.75rem + 2px);
  width: 600px;
  height: 250px;
}

</style>

