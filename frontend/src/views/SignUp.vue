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
            할 수 있다 할 수 있다 할 수 있따!!
          </p>
        </div>
      </div>
    </div>
  </div>
  <div class="container">
    <div class="row mt-lg-n10 mt-md-n11 mt-n10 justify-content-center">
      <div class="mx-auto col-xl-4 col-lg-5 col-md-7">
        <div class="card z-index-0" style="border-width: 0; border-radius: 0.5rem ">
          <div class="choice_joinTypeWrap">
            <li>
              <input type="radio" name="selectType" id="userType" style="display: none" @change="changeJoinType($event)"
                     :checked="userRadio"/>
              <label for="userType" class="btn mb-0 btn-md w-100" :class="[ mg_auth === '1' ? 'selected_joinType' : 'bg-gradient-dark' ]" style="color: #FFFFFF">개인회원</label>
              <!--              <label class="btn mb-0 bg-gradient-dark btn-md w-100" for="userType">개인회원</label>-->
            </li>
            <li>
              <input type="radio" name="selectType" style="display: none" id="companyType"
                     @change="changeJoinType($event)" :checked="comRadio">
              <label for="companyType" class="btn mb-0 btn-md w-100" :class="[ mg_auth === '2' ? 'selected_joinType' : 'bg-gradient-dark' ]" style="color: #FFFFFF">기업회원</label>
              <!--              <label class="btn mb-0 bg-gradient-dark btn-md w-100" for="companyType">기업회원</label>-->
            </li>
          </div>


          <div class="card-body">
            <div :class="{ 'CompanyForm' : hasError, active : isActive }">
              <div>
                <form class="MemberInfo">

                  <div class="userBox">

                    <div>
                      <input type="text" class="data_insert_box" ref="nameBox" name="user_name" placeholder="이름 (실명)"
                             v-model="user_name" id="name"/>
                    </div>

                    <div style="padding-bottom: 0px">
                      <input type="text" ref="idBox" name="user_id" placeholder="아이디 (길이4~14 영어 대소문자,숫자만)"
                             @keydown.enter="sameIdCheck" v-model="user_id" class="PersonUnder data_insert_box"/>
                      <button type="button" @click="sameIdCheck($event)" class="btn bg-gradient-dark"
                              style="margin-top: 5px">중복확인
                      </button>
                      <span :hidden="msg === 'id 중복확인을 먼저 해주세요'" style="margin-left: 10px">{{ msg }}</span>
                    </div>
                    <div style="padding-top: 0px">
                      <input type="password" class="data_insert_box" ref="pwBox" name="user_pw" autoComplete="off"
                             placeholder="비밀번호 (8~20자의 영문,숫자,특수기호 포함)" v-model="user_pw"/>
                    </div>
                    <div>
                      <input type="email" class="data_insert_box" ref="emailBox" name="user_email" placeholder="이메일"
                             v-model="user_email"/>
                    </div>
                    <div style="padding-bottom: 0px">
                      <input type="text" ref="phNumBox" name="user_phone" placeholder="휴대폰번호 -없이" v-model="user_phone"
                             class="PersonUnder data_insert_box" maxlength="11"/>
                      <button type="button" class="btn bg-gradient-dark" style="margin-top: 5px">인증번호 전송</button>
                    </div>
                    <div style="padding: 0px 5px">
                      <input type="text" ref="certifNumBox" name="" placeholder="인증번호 입력" v-model="certification_num"
                             class="PersonUnder data_insert_box">
                      <button type="button" class="btn bg-gradient-dark" id="leftBtn" style="margin-top: 5px">확인
                      </button>
                      <button type="button" class="btn bg-gradient-dark" id="rightBtn"
                              style="margin-top: 5px; margin-left: 5px">재전송
                      </button>
                    </div>
                  </div>

                  <div class="CompanyBox" :class="{ 'PeopleForm' : hasError, active : isActive }">
                    <div>
                      <div class="MemberInfo companyContent" :class="class2" v-if="show">
                        <div style="padding-bottom: 0px">
                          <input type="text" class="data_insert_box" ref="com_nameBox" placeholder="기업명"
                                 v-model="com_name"/>
                        </div>
                        <div>
                          <input type="tel" class="data_insert_box" ref="com_phBox" placeholder="기업 전화번호 -없이"
                                 maxlength="11" v-model="com_phone"/>
                        </div>
                        <div>
                          <input type="email" class="data_insert_box" ref="com_emailBox" placeholder="기업 이메일"
                                 v-model="com_email"/>
                        </div>
                        <div>
                          <input type="text" id="address" class="data_insert_box" ref="com_addressBox" placeholder="기업 주소"
                                 v-model="com_address" @click="execDaumPostcode" @keydown="execDaumPostcode"/>
                        </div>
                        <div>
                          <input type="text" class="data_insert_box" ref="com_categoryBox" placeholder="업종"
                                 v-model="com_category"/>
                        </div>
                        <div>
                          <input type="text" class="data_insert_box" ref="com_ceoBox" placeholder="대표자"
                                 v-model="com_ceo"/>
                        </div>
                        <div>
                          <input type="text" class="data_insert_box" ref="com_regBox" placeholder="사업자등록번호 - 포함"
                                 v-model="com_businessRegistration" maxlength="12"/>
                        </div>
                        <div class="esDateWrap">
                          <div>설립일: </div>
                          <input type="date" class="data_insert_box" ref="com_esDateBox" placeholder="설립일"
                                 v-model="com_establishmentDate">
                        </div>
                      </div>

                      <div class="form-bottom">
                        <div>
                          필수동의 항목 및 개인정보 수집 및 이용동의
                          <input type="checkbox" id="agree1" value="checkedBox" v-model="checkbox">
                        </div>
                        <div>
                          개인정보 동의항목란
                          <input type="checkbox" id="agree2" value="checkedBox" v-model="checkbox">
                        </div>

                        <input type="submit" @click.prevent="checkSubmit($event)" class="btn bg-gradient-dark" value="가입하기"
                               style="margin-top: 5px">
                      </div>

                    </div>
                  </div>
                </form>
              </div>
            </div>

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
import axios from "axios";


export default {
  name: "SignupBasic",
  data: function () {
    return {
      user_name: '',
      user_id: '',
      user_pw: '',
      user_email: '',
      user_phone: '',
      certification_num: '',
      msg: '', // id 중복확인 하고나서 화면에 뿌려줄 것.
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
      idPassCheck: false, //id 중복확인 통과했는지 여부 체크 , 통과하면 true 로 바꿔줌.
      phCertifPassCheck: false, //핸드폰인증 확인했는지 여부 체크, 통과했으면 true
      //유효성 검사 정규식
      nameRule: /^[가-힣a-zA-Z]+$/, //한글,영문만 입력가능
      idRule: /^[a-z0-9]{4,12}$/, // 영문 대소문자, 숫자만 사용가능 길이는 4~12 글자
      passwordRule: /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$/,  //비밀번호 유효성 검사 정규표현식
      emailRule: /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/, //이메일 형식 유호성 검사 정규표현식
      phoneNumRule: /^[0-9]{8,13}$/, //휴대폰 번호 숫자만 가능
      businessRegisRule: /^[0-9]{3}-[0-9]{2}-[0-9]{5}$/, //사업자 등록번호 정규식 3글자-2글자-5글자
      //여기서부턴 기업가입 정보 입력 부분
      com_name: '',
      com_phone: '',
      com_email: '',
      com_address: '',
      com_category: '',
      com_ceo: '',
      com_businessRegistration: '',
      com_establishmentDate: '',
      //주소 api 관련
      postcode: "",
      address: "",
      //css 관련
      userTypeOn: this.mg_auth === '1' ? true : false,
      comTypeOn: this.mg_auth === '2' ? true : false
    }
  },
  mounted() {

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
    // 아이디 중복확인 메서드
    sameIdCheck(e) {
      e.preventDefault()
      var self = this // axios 안에서 this 키워드 동작 제대로 안되서 여기서 변수로 선언해줌
      if (this.user_id !== '') {

        //아이디 중복확인 전 id 유효성 검사
        if (this.idRule.test(this.user_id.trim()) === false) {
          alert('아이디는 4~12글자 이내로 영어 대소문자,숫자만 가능합니다')
        } else {

          //id 중복확인 요청 보내기
          this.$axios.post('/jobfair/checkSameId', {user_id: this.user_id})
              .then(response => {
                console.log(response)
                self.idPassCheck = response.data
                if (self.idPassCheck === true) {
                  self.msg = '사용가능한 id 입니다'
                } else {
                  self.msg = '이미 사용하고 있는 id 입니다'
                }
                alert(self.msg)
              })
              .catch(error => {
                console.log(error)
              })

        }
      } else {
        this.msg = "Id를 입력해주세요"
      }
    },
    // 가입하기 등록 전 유효성 검사 ( + 필수항목 체크했는지 확인) , 검사 통과 후 가입 메서드 호출.
    checkSubmit(e) {
      //이름 유효성 검사
      if (!this.nameRule.test(this.user_name.trim())) {
        alert('이름을 다시 입력해주세요')
        this.$refs.nameBox.focus()
        return
      }
      //아이디 중복확인 통과했는지 체크
      if (this.idPassCheck === false) {
        alert('아이디 중복확인을 해주세요')
        this.$refs.idBox.focus()
        return
      }
      // 아이디 중복확인 후 id 값 null값 되면 다시 중복확인 하게끔 처리
      if (this.user_id === '') {
        this.idPassCheck = false
        this.msg = 'id를 입력해주세요.'
        this.$refs.idBox.focus()
        return
      }
      // password 유효성 검사 -> 8~20자의 영문,숫자,특수기호 포함 체크
      if (this.passwordRule.test(this.user_pw.trim()) === false) {
        this.$refs.pwBox.focus()
        alert('비밀번호는 영문,숫자,특수기호 포함 8~20자 이내어야 합니다.')
        return
      }
      // email 형식 유효성 검사
      if (this.emailRule.test(this.user_email.trim()) === false) {
        this.$refs.emailBox.focus()
        alert('이메일을 다시 확인해 주세요.')
        return
      }
      //휴대폰 번호 유효성 검사 - 숫자만 입력.
      if (this.phoneNumRule.test(this.user_phone.trim()) === false) {
        alert('휴대폰 번호를 다시 입력해주세요')
        this.$refs.phNumBox.focus()
        return
      }
      // // 휴대폰 인증 통과여부 확인
      // if(this.phCertifPassCheck === false){
      //   this.$refs.certifNumBox.focus()
      //   alert('휴대폰 인증을 해주세요')
      //   e.preventDefault()
      //   return
      // }

      //기업가입시 기업가입정보 유효성 검사
      //기업명 체크
      if (this.mg_auth === '2') {
        if (this.com_name === '') {
          this.$refs.com_nameBox.focus()
          return
        }
        //기업 전화번호 체크
        if (this.phoneNumRule.test(this.com_phone.trim()) === false) {
          alert('기업 전화번호를 다시 확인해주세요')
          this.$refs.com_phBox.focus()
          return
        }
        //기업 이메일 체크
        if (this.emailRule.test(this.com_email.trim()) === false) {
          alert('기업 이메일을 다시 확인해주세요')
          this.$refs.com_emailBox.focus()
          return
        }
        //기업 주소 체크
        if (this.com_address === '') {
          this.$refs.com_addressBox.focus()
          return
        }
        // 업종 체크
        if (this.com_category === '') {
          this.$refs.com_categoryBox.focus()
          return
        }
        // 기업 대표 체크
        // 한글, 영문만 입력가능
        if (this.nameRule.test(this.com_ceo.trim()) === false) {
          this.$refs.com_ceoBox.focus()
          return
        }
        //사업자 등록번호 체크
        //사업자 등록번호 정규식 3글자-2글자-5글자
        if (this.businessRegisRule.test(this.com_businessRegistration.trim()) === false) {
          alert('사업자 등록 번호가 잘못 되었습니다')
          this.$refs.com_regBox.focus()
          return
        }
        //회사 설립일 체크
        if (this.com_establishmentDate === '') {
          alert('회사 설립일을 지정해주세요')
          this.$refs.com_esDateBox.focus()
          return
        }
      }
      //필수동의 체크여부 확인
      if (document.getElementById('agree1').checked === false) {
        alert("필수 항목을 확인해 주세요.")
        this.errorMsg.push({msg: '필수 항목입니다.'}) //에러메시지 담기
        console.log(this.errorMsg)
        return
      }
      if (document.getElementById('agree2').checked === false) {
        alert("필수 항목을 확인해 주세요.")
        this.errorMsg.push({msg: '필수 항목입니다.'}) //에러메시지 담기
        console.log(this.errorMsg)
        return
      }
      this.signUp()
    },

    //회원가입 요청
    signUp(e) {
      console.log('signup 실행')
      // e.preventDefault()
      let url = '/jobfair/uJoin';
      let data = {
        userData: {
          user_name: this.user_name,
          user_id: this.user_id,
          user_pw: this.user_pw,
          user_email: this.user_email,
          user_phone: this.user_phone,
          mg_auth: this.mg_auth
        },
        comData: {
          com_name: this.com_name,
          com_phone: this.com_phone,
          com_email: this.com_email,
          com_address: this.com_address,
          com_category: this.com_category,
          com_ceo: this.com_ceo,
          com_businessRegistration: this.com_businessRegistration,
          com_establishmentDate: this.com_establishmentDate
        }
      }
      this.$axios.post(url, data)
          .then(response => {
            if (response.status === 200) {
              this.$router.push('/uMainView')
            }
          })
          .catch(error => {
            console.log(error)
          })
    },
    // 개인, 기업 회원가입 구분 메서드
    changeJoinType(e) {
      if (e.target.id === 'userType') {
        this.show = false
        this.mg_auth = '1';
        this.$store.commit("setMg_auth", "1")
      } else {
        this.show = true
        this.mg_auth = '2';
        this.$store.commit("setMg_auth", "2")
      }
      console.log(this.mg_auth)
    },
    //화면 로드시 권한에 따라 회원가입인지 기업가입인지 버튼 색 활성화 메서드
    joinTypeView(){
      if(this.mg_auth === '1'){
        this.userTypeOn = true
      } else if (this.mg_auth === '2'){
        this.comTypeOn === true
      }
    },
    execDaumPostcode() {
      new window.daum.Postcode({
        oncomplete: (data) => {
          if (this.extraAddress !== "") {
            this.extraAddress = "";
          }
          if (data.userSelectedType === "R") {
            // 사용자가 도로명 주소를 선택했을 경우
            this.com_address = data.roadAddress;
          } else {
            // 사용자가 지번 주소를 선택했을 경우(J)
            this.com_address = data.jibunAddress;
          }

          // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
          if (data.userSelectedType === "R") {
            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if (data.bname !== "" && /[동|로|가]$/g.test(data.bname)) {
              this.extraAddress += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if (data.buildingName !== "" && data.apartment === "Y") {
              this.extraAddress +=
                  this.extraAddress !== ""
                      ? `, ${data.buildingName}`
                      : data.buildingName;
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if (this.extraAddress !== "") {
              this.extraAddress = `(${this.extraAddress})`;
            }
          } else {
            this.extraAddress = "";
          }
          // 우편번호를 입력한다.
          this.postcode = data.zonecode;
        },
      }).open();
    }

  }

}
</script>

<style scoped>
@import "./SignUp.css";
</style>
