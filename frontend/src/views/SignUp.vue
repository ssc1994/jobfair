<template>
<!--  <navbar btn-background="bg-gradient-primary"/>-->
  <div
      class="pt-5 m-3 page-header align-items-start min-vh-50 pb-11 border-radius-lg"
      :style="{
      backgroundImage:
        'url(' + require('@/assets/img/curved-images/sign-up-bg1.jpg') + ')',
    }"
  >
    <span class="mask bg-gradient-dark opacity-6"></span>
    <div class="container">
      <div class="row justify-content-center">
        <div class="mx-auto text-center col-lg-5">
          <h1 class="mt-5 mb-2 text-white">Welcome!</h1>
          <p class="text-white text-lead">
            Use these awesome forms to login or create new account in your
            project for free.
          </p>
        </div>
      </div>
    </div>
  </div>
  <div class="container">
    <div class="row mt-lg-n10 mt-md-n11 mt-n10 justify-content-center">
      <div class="mx-auto col-xl-4 col-lg-5 col-md-7">
        <div class="card z-index-0">
          <div class="choice_joinTypeWrap">
            <li>
              <input type="radio" name="selectType" id="userType" style="display: none" @change="radioChange($event)"
                     :checked="userRadio"/>
              <label class="btn mb-0 bg-gradient-dark btn-md w-100" for="userType">개인회원</label>
            </li>
            <li>
              <input type="radio" name="selectType" style="display: none" id="companyType" @change="radioChange($event)"
                     :checked="comRadio">
              <label class="btn mb-0 bg-gradient-dark btn-md w-100" for="companyType">기업회원</label>
            </li>
          </div>


          <div class="card-body">
            <div :class="{ 'CompanyForm' : hasError, active : isActive }">
              <div>
                <form @submit="checkSubmit($event)" action="/jobfair/uJoin" method="post" class="MemberInfo">

                  <div class="userBox">

                    <div>
                    <input type="text" class="data_insert_box" ref="nameBox" name="user_name" placeholder="이름(실명)"
                           v-model="username" id="name"/>
                    </div>

                    <div style="padding-bottom: 0px">
                      <input type="text" ref="idBox" name="user_id" placeholder="아이디" @keyup="idBoxNullCheck"
                             @keydown.enter="sameIdCheck" v-model="id" class="PersonUnder data_insert_box"/>
                      <button type="button" @click="sameIdCheck" :disabled="idBoxCheck" class="btn bg-gradient-dark" style="margin-top: 5px">중복확인</button>
                      <span :hidden="msg === 'id 중복확인을 먼저 해주세요'" style="margin-left: 10px">{{ msg }}</span>
                    </div>
                    <div style="padding-top: 0px">
                      <input type="password" class="data_insert_box" ref="pwBox" name="user_pw" autoComplete="off"
                             placeholder="비밀번호(8~20자의 영문,숫자,특수기호)" v-model="password"/>
                    </div>
                    <div>
                      <input type="email" class="data_insert_box" ref="emailBox" name="user_email" placeholder="이메일"
                             v-model="email"/>
                    </div>
                    <div style="padding-bottom: 0px">
                      <input type="text" ref="phNumBox" name="user_phone" placeholder="휴대폰번호 -없이" v-model="phoneNum"
                             class="PersonUnder data_insert_box"/>
                      <button type="button" class="btn bg-gradient-dark" style="margin-top: 5px">인증번호 전송</button>
                    </div>
                    <div style="padding: 0px 5px">
                      <input type="text" ref="certifNumBox" name="" placeholder="인증번호 입력" v-model="certification_num"
                             class="PersonUnder data_insert_box">
                      <button type="button" class="btn bg-gradient-dark" id="leftBtn" style="margin-top: 5px">확인</button>
                      <button type="button" class="btn bg-gradient-dark" id="rightBtn" style="margin-top: 5px; margin-left: 5px">재전송</button>
                    </div>
                  </div>

                  <div class="CompanyBox" :class="{ 'PeopleForm' : hasError, active : isActive }">
                    <div>
                      <div class="MemberInfo companyContent" :class="class2" v-if="show">
                        <div style="padding-bottom: 0px">
                          <input type="text" class="data_insert_box" placeholder="기업명"/>
                        </div>
                        <div>
                          <input type="tel" class="data_insert_box" placeholder="기업 전화번호"/>
                        </div>
                        <div>
                          <input type="email" class="data_insert_box" placeholder="기업 이메일"/>
                        </div>
                        <div>
                          <input type="text" class="data_insert_box" placeholder="기업 주소"/>
                        </div>
                        <div>
                          <input type="text" class="data_insert_box" placeholder="업종"/>
                        </div>
                        <div>
                          <input type="text" class="data_insert_box" placeholder="대표자"/>
                        </div>
                        <div>
                          <input type="text" class="data_insert_box" placeholder="사업자등록번호"/>
                        </div>
                        <div>
                          <input type="date" class="data_insert_box" placeholder="설립일">
                        </div>
                      </div>

                      <div>
                        필수동의 항목 및 개인정보 수집 및 이용동의
                        <input type="checkbox" id="agree1" value="checkedBox" v-model="checkbox">
                      </div>
                      <div>
                        개인정보 동의항목란
                        <input type="checkbox" id="agree2" value="checkedBox" v-model="checkbox">
                      </div>

                      <input type="submit" class="btn bg-gradient-dark" value="가입하기" style="margin-top: 5px">

                    </div>
                  </div>
                </form>
              </div>
            </div>
            <!--            <form role="form" action="/jobfair/uJoin" method="post">-->
            <!--              <div class="mb-3">-->
            <!--                <soft-input-->
            <!--                    id="name"-->
            <!--                    type="text"-->
            <!--                    placeholder="이름"-->
            <!--                    aria-label="Name"-->
            <!--                    ref="nameBox"-->
            <!--                    name="user_name"-->
            <!--                    v-model="username"-->
            <!--                />-->
            <!--              </div>-->
            <!--              <div class="mb-3 id_part">-->
            <!--                <input-->
            <!--                    type="text"-->
            <!--                    placeholder="ID"-->
            <!--                    ref="idBox" name="user_id"-->
            <!--                    @keyup="idBoxNullCheck"-->
            <!--                    @keydown.enter="sameIdCheck"-->
            <!--                    v-model = "id"-->
            <!--                    class="PersonUnder"-->
            <!--                />-->
            <!--                <button type="button" @click="sameIdCheck" :disabled="idBoxCheck" class="btn bg-gradient-dark">중복확인</button>-->
            <!--                <span :hidden="msg === 'id 중복확인을 먼저 해주세요'">{{msg}}</span>-->
            <!--              </div>-->
            <!--              <div class="mb-3">-->
            <!--                <soft-input-->
            <!--                    type="password"-->
            <!--                    placeholder="비밀번호 (8~20의 영문, 숫자, 특수 기호 포함)"-->
            <!--                />-->
            <!--              </div>-->
            <!--              <div class="mb-3">-->
            <!--                <soft-input-->
            <!--                    type="email"-->
            <!--                    placeholder="Email"-->
            <!--                />-->
            <!--              </div>-->
            <!--              <div class="mb-3 phoneWrap">-->
            <!--                <soft-input-->
            <!--                    type="text"-->
            <!--                    placeholder="핸드폰 번호 -없이"-->
            <!--                />-->
            <!--                <button type="button" class="btn bg-gradient-dark">인증번호 전송</button>-->
            <!--              </div>-->
            <!--              <div class="mb-3 certifWrap">-->
            <!--                <soft-input-->
            <!--                    type="text"-->
            <!--                    placeholder="인증번호"-->
            <!--                />-->
            <!--                <button type="button" class="btn bg-gradient-dark certif_btn">확인</button>-->
            <!--                <button type="button" class="btn bg-gradient-dark">재전송</button>-->
            <!--              </div>-->
            <!--              <soft-checkbox-->
            <!--                  id="flexCheckDefault"-->
            <!--                  name="flexCheckDefault"-->
            <!--                  class="font-weight-light"-->
            <!--                  checked-->
            <!--              >-->
            <!--                <a href="javascript:;" class="text-dark font-weight-bolder">-->
            <!--                  필수동의 항목 및 개인정보 수집 및 이용동의-->
            <!--                </a>-->
            <!--              </soft-checkbox>-->
            <!--              <soft-checkbox-->
            <!--                  id="flexCheckDefault"-->
            <!--                  name="flexCheckDefault"-->
            <!--                  class="font-weight-light"-->
            <!--                  checked-->
            <!--              >-->
            <!--                <a href="javascript:;" class="text-dark font-weight-bolder">-->
            <!--                  개인정보 동의-->
            <!--                </a>-->
            <!--              </soft-checkbox>-->

            <!--              &lt;!&ndash; 회원가입 버튼 form submit&ndash;&gt;-->
            <!--              <div class="text-center">-->
            <!--                <soft-button-->
            <!--                    color="dark"-->
            <!--                    full-width-->
            <!--                    variant="gradient"-->
            <!--                    class="my-4 mb-2"-->
            <!--                >Sign up-->
            <!--                </soft-button-->
            <!--                >-->
            <!--              </div>-->
            <!--            </form>-->

            <p class="text-sm mt-3 mb-0">
              Already have an account?
              <router-link
                  :to="{ name: 'Sign In' }"
                  class="text-dark font-weight-bolder"
              >
                Sign in
              </router-link>
            </p>

          </div>
        </div>
      </div>
    </div>
  </div>
  <app-footer/>
</template>

<script>
import Navbar from "@/examples/PageLayout/Navbar.vue";
import AppFooter from "@/examples/PageLayout/Footer.vue";
import SoftInput from "@/components/SoftInput.vue";
import SoftCheckbox from "@/components/SoftCheckbox.vue";
import SoftButton from "@/components/SoftButton.vue";

import {mapMutations} from "vuex";

export default {
  name: "SignupBasic",
  data: function () {
    return {
      username: '',
      id: '',
      password: '',
      email: '',
      phoneNum: '',
      certification_num: '',
      msg: 'id 중복확인을 먼저 해주세요', // id 중복확인 하고나서 화면에 뿌려줄 것.
      checkedBox: [],
      errorMsg: [],
      sampleData: '',
      isActive: false,
      hasError: false,
      class2: ['active', 'hasError'],
      show: false,
      mg_auth: this.$store.getters.getMg_auth,
      userRadio: true,
      comRadio: false,
      idBoxCheck: true, //id 값이 있는지 여부에 따라 id 중복확인 버튼 활성화 조절하기 위한 변수
      idPassCheck: false, //id 중복확인 통과했는지 여부 체크 , 통과하면 true 로 바꿔줌.
      phCertifPassCheck: false, //핸드폰인증 확인했는지 여부 체크, 통과했으면 true
      passwordRule: /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$/,  //비밀번호 유효성 검사 정규표현식
      emailRule: /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/, //이메일 형식 유호성 검사 정규표현식
      //여기서부턴 기업가입 정보 입력 부분
      com_name: '',
      com_phone: '',
      com_email: '',
      com_address: '',
      com_category: '',
      com_ced: '',
      com_businessRegistration: '',
      com_establishmentDate: ''
    }
  },
  components: {
    Navbar,
    AppFooter,
    SoftInput,
    SoftCheckbox,
    SoftButton,
  },
  created() {
    this.toggleEveryDisplay();
    this.toggleHideConfig();
  },
  beforeUnmount() {
    this.toggleEveryDisplay();
    this.toggleHideConfig();
  },
  methods: {
    ...mapMutations(["toggleEveryDisplay", "toggleHideConfig"]),
    // id값이 공백이 아닐때 중복확인 버튼 활성화 , 공백이면 다시 비활성화
    idBoxNullCheck() {
      if (this.id !== '') {
        this.idBoxCheck = false
      } else if (this.id === '') {
        this.idBoxCheck = true
      }
    },
    // 아이디 중복확인 메서드
    sameIdCheck() {
      var self = this // axios 안에서 this 키워드 동작 제대로 안되서 여기서 변수로 선언해줌
      this.$axios.post('/jobfair/checkSameId', {user_id: this.id})
          .then(function (response) {
            console.log(response)
            self.idPassCheck = response.data
            if (self.idPassCheck === true) {
              self.msg = '사용가능한 id 입니다'
            } else {
              self.msg = '이미 사용하고 있는 id 입니다'
            }
            alert(self.msg)
          })
          .catch(function (error) {
            console.log(error)
          })
    },
    // 회원가입 처리 메서드 (필수 체크 항목 체크했는지 확인)
    checkSubmit(e) {
      //이름 입력했는지 체크
      if (this.username === '') {
        this.$refs.nameBox.focus()
        e.preventDefault()
        return
      }
      //아이디 중복확인 통과했는지 체크
      if (this.idPassCheck === false) {
        alert(this.msg)
        this.$refs.idBox.focus()
        e.preventDefault()
        return
      }
      //password 입력여부 체크
      if (this.password === '') {
        this.$refs.pwBox.focus()
        e.preventDefault()
        return
      }
      // password 유효성 검사 -> 8~20자의 영문,숫자,특수기호 포함 체크
      if (!this.passwordRule.test(this.password.trim())) {
        this.$refs.pwBox.focus()
        alert('비밀번호는 영문,숫자,특수기호 포함 8~20자 이내어야 합니다.')
        e.preventDefault()
        return
      }
      //email 입력여부 체크
      if (this.email === '') {
        this.$refs.emailBox.focus()
        e.preventDefault()
        return
      }
      // email 형식 유효성 검사
      if (!this.emailRule.test(this.email.trim())) {
        this.$refs.emailBox.focus()
        alert('이메일을 다시 확인해 주세요.')
        e.preventDefault()
        return
      }
      //휴대폰 번호 입력 체크
      if (this.phoneNum === '') {
        this.$refs.phNumBox.focus()
        e.preventDefault()
        return
      }
      //휴대폰 인증 통과여부 확인
      // if(this.phCertifPassCheck === false){
      //   this.$refs.certifNumBox.focus()
      //   alert('휴대폰 인증을 해주세요')
      //   e.preventDefault()
      //   return
      // }
      //필수동의 체크여부 확인
      if (document.getElementById('agree1').checked === false) {
        alert("필수 항목을 확인해 주세요.")
        this.errorMsg.push({msg: '필수 항목입니다.'}) //에러메시지 담기
        console.log(this.errorMsg)
        e.preventDefault()
        return
      }
      if (document.getElementById('agree2').checked === false) {
        alert("필수 항목을 확인해 주세요.")
        this.errorMsg.push({msg: '필수 항목입니다.'}) //에러메시지 담기
        console.log(this.errorMsg)
        e.preventDefault()
      }
    },
    radioChange(e) {
      if (e.target.id === 'userType') this.show = false
      else this.show = true
    }
  }
};
</script>

<style scoped>
@import "./SignUp.css";
</style>
