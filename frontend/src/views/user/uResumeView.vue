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
            <p class="headline-title">성별 :
              <select
                  class="sel"
                  v-model="signup.gender"
                  @focus="checkFlag = false"
              >
                <option
                    v-for="(item, index) in genderList"
                    :key="index"
                    :value="item.value"
                >
                  {{ item.text }}
                </option>
              </select>
            </p>

            <p class="headline-title">이름 :<input type="text" class="headline-input" placeholder="이름을 입력하세요."></p>
            <p class="headline-title">이메일 :<input type="email" class="headline-input"></p>
            <p class="headline-title">전화번호 :<input type="text" class="headline-input"></p>
            <p class="headline-title">주소 :<input type="text" class="headline-input"></p>
            <div class="headline-title">
              <p>생년월일 :</p>
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
            <div class="headline-title start">
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
              />~
            </span>
              </div>
            </div>
            <div class="headline-title end">
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
            <p class="headline-title">입사일/퇴사일 :</p>
            <div class="headline-title start">
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
              />~
            </span>
              </div>
            </div>
            <div class="headline-title end">
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
            <p>
              <button class="btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#collapseExample"
                      aria-expanded="false" aria-controls="collapseExample">
                +
              </button>
            </p>
            <div class="collapse" id="collapseExample">
              <div class="card">
                <p class="headline-title">업종 :<input type="text" class="headline-input"></p>
                <p class="headline-title">회사명 :<input type="text" class="headline-input"></p>
                <p class="headline-title">부서명 :<input type="text" class="headline-input"></p>
                <p class="headline-title">입사일/퇴사일 :</p>
                <div class="headline-title start">
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
              />~
            </span>
                  </div>
                </div>
                <div class="headline-title end">
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
  filters: {
    comma(val) {
      return String(val).replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
  },
  props: {
    propSignup: {
      type: Object,
      default: null,
    },
  },
  data() {
    return {
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
      },
      genderList: [
        {
          value: "M",
          text: "남성",
        },
        {
          value: "F",
          text: "여성",
        },
      ],
      yyyyList: [],
      mmlist: []
    }
  },
  computed: {
    idValid() {
      return /^[A-Za-z0-9]+$/.test(this.email)
    },
    computeOnlyNum() {
      if (this.person.age > 18) {
        return "Adult"
      } else {
        return "Minor"
      }
    },
    nextPageDisabledFlag() {
      let flag = true
      if (this.email !== '') {
        flag = false
      }
      return flag
    }
  },
  watch: {
    onlyNum() {
      this.onlyNum = this.onlyNum.replace(/[^0-9]/g, "")
    }
  },
  created() {
    // console.log(this.$store.state.todos.list[0]);
    const nowYear = new Date().getFullYear()
    for (let i = 0; i < 100; i++) {
      const date = nowYear - i
      this.yyyyList.push({value: date, text: date})
    }
    for (let i = 1; i < 13; i++) {
      this.mmlist.push({
        value: i,
        text: i
      })
    }
  },
  mounted() {
    // this.test = this.$store.state.todos.list[0].text
  },
  methods: {
    // 데이터 empty 체크
    isEmpty(data) {
      if (data === '' || data === null || data === undefined) {
        return true
      } else {
        return false
      }
    },
    goNextPage() {
      this.checkFlag = true
      if (
          !this.isEmpty(this.signup.name) &&
          !this.isEmpty(this.signup.yyyy) &&
          !this.isEmpty(this.signup.mm) &&
          !this.isEmpty(this.signup.dd) &&
          !this.isEmpty(this.signup.gender) &&
          !this.isEmpty(this.signup.email) &&
          !this.isEmpty(this.signup.address) &&
          !this.isEmpty(this.signup.phoneNum)
      ) {
        this.$router.push({name: "signup3", params: {signup: this.signup}})
      }
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
  margin-left: 135px;
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
  left: 90px;
  top: 70px;
}

/* 입학여부 select*/
.finish {
  position: absolute;
  left: 290px;
  top: 251px;
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

/* 버튼, 경력추가시 누르면 나오는 박스 */
.btn {
  width: 50px;
  height: 30px;
}
.card {
  width: 600px;
}

/* 자기소개서 박스 크기 */
textarea.form-control {
  min-height: calc(1.5em + 0.75rem + 2px);
  width: 600px;
  height: 250px;
}

/* 생년월일 */
.bir_yy,.bir_mm,.bir_dd {
  display: inline;
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

