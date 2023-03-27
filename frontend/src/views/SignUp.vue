<template>
  <!--  <navbar btn-background="bg-gradient-primary"/>-->
  <div
      class="pt-5 m-3 page-header bg-gradient-dark align-items-start min-vh-50 pb-11 border-radius-lg"
      :style="{
      backgroundImage:
        'url(' + require('@/assets/img/curved-images/sign-up-bg1.jpg') + ')',
    }"
  >
    <span class="mask opacity-6"></span>
    <div class="container">
      <div class="row justify-content-center">
        <div class="mx-auto text-center col-lg-5">
          <h1 class="mt-5 mb-2 text-white">회원가입</h1>
          <p class="text-white text-lead">
            회원가입하고 다양한 혜택을 누리세요!
          </p>
        </div>
      </div>
    </div>
  </div>
  <div class="container">
    <div class="row mt-lg-n10 mt-md-n11 mt-n10 justify-content-center">
      <div class="mx-auto col-xl-4 col-lg-5 col-md-7" style="width: 40%">
        <div class="card z-index-0" style="border-width: 0; border-radius: 0.5rem ">
          <div class="choice_joinTypeWrap">
            <li>
              <input type="radio" name="selectType" id="userType" style="display: none" @change="changeJoinType($event)"
                     :checked="userRadio"/>
              <label for="userType" class="btn mb-0 btn-md w-100"
                     :class="[ mg_auth === '1' ? 'selected_joinType' : 'bg-gradient-dark' ]"
                     style="color: #FFFFFF">개인회원</label>
              <!--              <label class="btn mb-0 bg-gradient-dark btn-md w-100" for="userType">개인회원</label>-->
            </li>
            <li>
              <input type="radio" name="selectType" style="display: none" id="companyType"
                     @change="changeJoinType($event)" :checked="comRadio">
              <label for="companyType" class="btn mb-0 btn-md w-100"
                     :class="[ mg_auth === '2' ? 'selected_joinType' : 'bg-gradient-dark' ]"
                     style="color: #FFFFFF">기업회원</label>
              <!--              <label class="btn mb-0 bg-gradient-dark btn-md w-100" for="companyType">기업회원</label>-->
            </li>
          </div>


          <div class="card-body">
            <div :class="{ 'CompanyForm' : hasError, active : isActive }">
              <div>
                <form class="MemberInfo">

                  <div class="userBox">

                    <div>
                      <div class="data_title_wrap">
                        <span>이름</span><span :hidden="userName_errorMsg === ''"
                                             class="pass_error">{{ userName_errorMsg }}</span>
                      </div>
                      <input type="text" class="data_insert_box" ref="nameBox" name="user_name" placeholder="이름 (실명)"
                             v-model="user_name" id="name"/>
                    </div>

                    <div>
                      <div class="data_title_wrap">
                        <span>아이디</span>
                        <span :hidden="id_errorMsg === 'id 중복확인을 먼저 해주세요'"
                              :class="[id_errorMsg === '사용가능한 id 입니다' ? 'pass_color':'pass_error']">
                          {{ id_errorMsg }}</span>
                      </div>
                      <div class="id_input_wrap">
                        <input type="text" ref="idBox" name="user_id" placeholder="아이디 (길이4~14 영어 소문자,숫자만)"
                               @keydown.enter="sameIdCheck" v-model="user_id" class="PersonUnder data_insert_box"/>
                        <button type="button" @click="sameIdCheck($event)" class="btn bg-gradient-dark">
                          중복확인
                        </button>
                      </div>

                    </div>
                    <div>
                      <div class="data_title_wrap">
                        <span>비밀번호</span><span :hidden="userPw_errorMsg === ''"
                                               :class="[userPw_errorMsg === '사용가능한 패스워드입니다' ? 'pass_color':'pass_error']">
                          {{ userPw_errorMsg }}
                        </span>
                      </div>
                      <input type="password" class="data_insert_box" ref="pwBox" name="user_pw" autoComplete="off"
                             placeholder="비밀번호 (8~20자의 영문,숫자,특수기호 포함)" v-model="user_pw"/>
                    </div>
                    <div>
                      <div class="data_title_wrap">
                        <span>비밀번호 확인</span><span :hidden="userPwCheck_errorMsg === ''"
                                                  :class="[userPwCheck_errorMsg === '확인' ? 'pass_color':'pass_error']">
                          {{ userPwCheck_errorMsg }}
                        </span>
                      </div>
                      <input type="password" class="data_insert_box" ref="pwCheckBox" autoComplete="off"
                             placeholder="비밀번호 재입력" v-model="user_pwCheck"/>
                    </div>

<!--                성별 위치    -->
                    <div>
                      <div class="data_title_wrap">
                        <span>성별</span>
                        <span :hidden="userGender_errorMsg === ''"
                                             class="pass_error">
                          {{ userGender_errorMsg }}
                        </span>
                      </div>
                      <div class="gender_type_wrap">
                        <div>
                          <input type="radio" id="man" name="gender" @click="user_gender = '남자'" value="남자"
                                 :checked="gender === '남자'">
                          <label for="man">남자</label>
                        </div>
                        <div>
                          <input type="radio" id="woman" name="gender" @click="user_gender = '여자'" value="여자"
                                 :checked="gender === '여자'">
                          <label for="woman">여자</label>
                        </div>
                      </div>

                    </div>

<!--                    생년월일 위치-->
                    <div>
                      <div class="data_title_wrap">
                        <span>생년월일</span><span :hidden="userBirth_errorMsg === ''"
                                                  class="pass_error">
                          {{ userBirth_errorMsg }}
                        </span>
                      </div>
                      <div class="birth_select_wrap">
                        <select  v-model="birth_yyyy">
                          <option value="">년</option>
                          <option v-for="(item, key) in yyyyList" :key="key" :value="item.value">{{item.value}}</option>
                        </select>
                        <select  v-model="birth_MM">
                          <option value="">월</option>
                          <option v-for="(item, key) in mmlist" :key="key" :value="item.value">{{item.value}}</option>
                        </select>
                        <select  v-model="birth_dd">
                          <option value="">일</option>
                          <option v-for="(item, key) in ddlist" :key="key" :value="item.value">{{item.value}}</option>
                        </select>
                      </div>
                    </div>

                    <div>
                      <div class="data_title_wrap">
                        <span>이메일</span><span :hidden="userEmail_errorMsg === ''"
                                              class="pass_error">{{ userEmail_errorMsg }}</span>
                      </div>
                      <input type="email" class="data_insert_box" ref="emailBox" name="user_email" placeholder="이메일"
                             v-model="user_email"/>
                    </div>
                    <div style="padding-bottom: 0px">
                      <div class="data_title_wrap">
                        <span>핸드폰번호</span><span :hidden="userPh_errorMsg === ''"
                                               class="pass_error">{{ userPh_errorMsg }}</span>
                      </div>
                      <div class="userPh_input_wrap">
                        <input type="text" ref="phNumBox" name="user_phone" placeholder="숫자만 입력 자동 - 추가"
                               v-model="user_phone"
                               @keyup="userAutoHyphen($event)"
                               class="PersonUnder data_insert_box" maxlength="13"/>
                        <button type="button" class="btn bg-gradient-dark" style="margin: 0">인증번호 전송</button>
                      </div>
                    </div>
                    <div style="padding:5px">
                      <div class="data_title_wrap">
                        <span>인증번호</span><span></span>
                      </div>
                      <div class=" certif_input_wrap">
                        <input type="text" ref="certifNumBox" name="" placeholder="인증번호 입력" v-model="certification_num"
                               class="PersonUnder data_insert_box">
                        <button type="button" class="btn bg-gradient-dark" id="leftBtn" style="margin: 0">확인</button>
                        <button type="button" class="btn bg-gradient-dark" id="rightBtn" style="margin: 0">재전송</button>
                      </div>
                    </div>
                  </div>

                  <div class="CompanyBox" :class="{ 'PeopleForm' : hasError, active : isActive }">
                    <div>
                      <div class="MemberInfo companyContent" :class="class2" v-if="show">
                        <div>
                          <div class="data_title_wrap">
                            <span>기업명</span><span :hidden="comName_errorMsg === ''"
                                                  class="pass_error">{{ comName_errorMsg }}</span>
                          </div>
                          <input type="text" class="data_insert_box" ref="com_nameBox" placeholder="기업명"
                                 v-model="com_name"/>
                        </div>
                        <div>
                          <div class="data_title_wrap">
                            <span>기업 전화번호</span>
                            <span :hidden="comPh_errorMsg === ''"
                                                  class="pass_error">{{ comPh_errorMsg }}</span>
                          </div>
                          <input type="tel" class="data_insert_box" ref="com_phBox" placeholder="숫자만 입력 자동 - 추가"
                                 maxlength="13" v-model="com_phone" @keyup="comAutoHyphen($event)"/>
                        </div>
                        <div>
                          <div class="data_title_wrap">
                            <span>기업 이메일</span>
                            <span :hidden="comEmail_errorMsg === ''"
                                  class="pass_error">{{ comEmail_errorMsg }}</span>
                          </div>
                          <input type="email" class="data_insert_box" ref="com_emailBox" placeholder="기업 이메일"
                                 v-model="com_email"/>
                        </div>
                        <div>
                          <div class="data_title_wrap">
                            <span>기업 주소</span>
                            <span :hidden="comAddress_errorMsg === ''"
                                  class="pass_error">{{ comAddress_errorMsg }}</span>
                          </div>
                          <div class="address_btn_wrap">
                            <input type="text" id="address" class="data_insert_box" ref="com_addressBox"
                                   placeholder="주소검색을 눌러주세요"
                                   v-model="com_address" readonly @keydown="execDaumPostcode"/>
                            <button type="button"  class="btn bg-gradient-dark" @click="execDaumPostcode">
                              주소검색
                            </button>
                          </div>
                        </div>
                        <div>
                          <div class="data_title_wrap">
                            <span>기업 상세주소</span>
                            <span :hidden="comDeAddress_errorMsg=== ''"
                                  class="pass_error">{{ comDeAddress_errorMsg }}</span>
                          </div>
                          <input type="text" id="address" class="data_insert_box"
                                 placeholder="기업 상세주소"
                                 ref="com_deAddressBox"
                                 v-model="com_detail_address"/>
                        </div>
                        <div>
                          <div class="data_title_wrap">
                            <span>업종</span>
                            <span :hidden="comCategory_errorMsg === ''"
                                  class="pass_error">{{ comCategory_errorMsg }}</span>
                          </div>
                          <input type="text" class="data_insert_box" ref="com_categoryBox" placeholder="업종"
                                 v-model="com_category"/>
                        </div>
                        <div>
                          <div class="data_title_wrap">
                            <span>대표자</span>
                            <span :hidden="comCeo_errorMsg === ''"
                                  class="pass_error">{{ comCeo_errorMsg }}</span>
                          </div>
                          <input type="text" class="data_insert_box" ref="com_ceoBox" placeholder="대표자"
                                 v-model="com_ceo"/>
                        </div>
                        <div>
                          <div class="data_title_wrap">
                            <span>사업자 등록번호</span>
                            <span :hidden="comBizReg_errorMsg === ''"
                                  class="pass_error">{{ comBizReg_errorMsg }}</span>
                          </div>
                          <input type="text" class="data_insert_box" ref="com_regBox" placeholder="사업자 등록번호 3글자-2글자-5글자 형식으로 입력"
                                 v-model="com_businessRegistration" maxlength="12"/>
                        </div>
                        <div class="esDateWrap">
                          <div class="data_title_wrap">
                            <span>설립일</span>
                            <span :hidden="comEsDate_errorMsg === ''"
                                  class="pass_error">{{ comEsDate_errorMsg }}</span>
                          </div>
                          <input type="date" class="data_insert_box" ref="com_esDateBox" placeholder="설립일"
                                 @change="comEsDate_errorMsg = ''" v-model="com_establishmentDate">
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

                        <input type="submit" @click.prevent="checkSubmit($event)" class="btn bg-gradient-dark"
                               value="가입하기"
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
</template>


<script>
import Navbar from "@/examples/PageLayout/Navbar.vue";
import AppFooter from "@/examples/PageLayout/Footer.vue";
import SoftInput from "@/components/SoftInput.vue";
import SoftCheckbox from "@/components/SoftCheckbox.vue";
import SoftButton from "@/components/SoftButton.vue";

import {mapMutations, mg_auth} from "vuex";
import axios from "axios";


export default {
  name: "SignupBasic",
  data: function () {
    return {
      user_name: '',
      user_id: '',
      user_pw: '',
      user_pwCheck: '', // 비밀번호 확인 (비밀번호 동일한지 체크할 변수)
      user_gender: '',
      user_rrn: this.birth_yyyy + '-' + this.birth_MM + '-' + this.birth_dd, //생년월일
      birth_yyyy: '',
      birth_MM: '',
      birth_dd: '',
      yyyyList: [],
      mmlist: [],
      ddlist: [],
      user_email: '',
      user_phone: '',
      certification_num: '',
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
      nameRule:  /^[가-힣]{2,4}$/, //한글만 2~4글자
      idRule: /^[a-z0-9]{4,12}$/, // 영문 소문자, 숫자만 사용가능 길이는 4~12 글자
      passwordRule: /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$/,  //비밀번호 유효성 검사 정규표현식 -> (8~20자의 영문,숫자,특수기호 포함)
      emailRule: /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/, //이메일 형식 유호성 검사 정규표현식
      phoneNumRule: /^\d{2,3}-\d{3,4}-\d{4}$/, //전화번호, 핸드폰 번호 형식인지 검사
      businessRegisRule: /^[0-9]{3}-[0-9]{2}-[0-9]{5}$/, //사업자 등록번호 정규식 3글자-2글자-5글자
      //유효성 검사 후 에러 메세지
      //유저 쪽
      userName_errorMsg: '',
      id_errorMsg: '', // id 중복확인 하고나서 화면에 뿌려줄 것.
      userPw_errorMsg: '',
      userPwCheck_errorMsg: '',
      userGender_errorMsg: '',
      userBirth_errorMsg: '',
      userEmail_errorMsg: '',
      userPh_errorMsg: '',
      //기업 쪽
      comName_errorMsg: '',
      comPh_errorMsg: '',
      comEmail_errorMsg: '',
      comAddress_errorMsg: '',
      comDeAddress_errorMsg: '', //기업 상세주소 에러메세지
      comCategory_errorMsg: '',
      comCeo_errorMsg: '',
      comBizReg_errorMsg: '', //사업자등록번호 입력 오류 메시지
      comEsDate_errorMsg: '', //회사 설립일 지정 오류 메시지
      //여기서부턴 기업가입 정보 입력 부분
      com_name: '',
      com_phone: '',
      com_email: '',
      com_address: '',
      com_detail_address: '',
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
    if(this.mg_auth === ''){
      this.mg_auth = '1'
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

    const nowYear = new Date().getFullYear();
    for(let i = 0; i <100; i++) {
      let date = nowYear - i
      this.yyyyList.push({value: date})
    }
    for (let i = 1; i < 13; i++) {
      if (i < 10) {
        this.mmlist.push({
          value: "0" + i,
          text: "0" + i,
        });
      } else {

        this.mmlist.push({
          value: i,
          text: i,
        });
      }
    }
    for (let i = 1; i <= 31; i++) {
      if (i < 10) {
        this.ddlist.push({
          value: "0" + i,
          text: "0" + i,
        });
      } else {

        this.ddlist.push({
          value: i,
          text: i,
        });
      }
    }
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
          this.id_errorMsg = '아이디는 4~12글자 이내로 영어 소문자,숫자만 가능합니다'
        } else {

          //id 중복확인 요청 보내기
          this.$axios.post('/jobfair/checkSameId', {user_id: this.user_id})
              .then(response => {
                console.log(response)
                self.idPassCheck = response.data
                if (self.idPassCheck === true) {
                  self.id_errorMsg = '사용가능한 id 입니다'
                } else {
                  self.id_errorMsg = '이미 사용하고 있는 id 입니다'
                }
                this.id_errorMsg = self.id_errorMsg
              })
              .catch(error => {
                console.log(error)
              })

        }
      } else {
        this.id_errorMsg = "Id를 입력해주세요"
      }
    },
    // 가입하기 등록 전 유효성 검사 ( + 필수항목 체크했는지 확인) , 검사 통과 후 가입 메서드 호출.
    checkSubmit(e) {
      //이름 유효성 검사
      if (!this.nameRule.test(this.user_name.trim())) {
        this.userName_errorMsg = '이름을 확인해주세요'
        this.$refs.nameBox.focus()
        return
      } else{
        this.userName_errorMsg = ''
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
        this.id_errorMsg = 'id를 입력해주세요.'
        this.$refs.idBox.focus()
        return
      }
      // password 유효성 검사 -> 8~20자의 영문,숫자,특수기호 포함 체크
      if (this.passwordRule.test(this.user_pw.trim()) === false) {
        this.$refs.pwBox.focus()
        this.userPw_errorMsg = '비밀번호는 영문,숫자,특수기호 포함 8~20자 이내어야 합니다.'
        return
      } else {
        this.userPw_errorMsg = '사용가능한 패스워드입니다'
      }
      // 비밀번호 확인 검사
      if (this.user_pw !== this.user_pwCheck) {
        if(this.user_pwCheck === ''){
          this.$refs.pwCheckBox.focus()
          return
        }
        this.$refs.pwCheckBox.focus()
        this.userPwCheck_errorMsg = '비밀번호가 일치하지 않습니다'
        return
      } else {
        this.userPwCheck_errorMsg = '확인'
      }
      // 회원 성별 검사
      if (this.user_gender === '') {
        this.userGender_errorMsg = '성별을 지정해주세요'
        return
      } else {
        this.userGender_errorMsg = ''
      }
      //생년월일 체크
      if(this.birth_yyyy === ''){
        this.userBirth_errorMsg = '생년월일을 입력해주세요'
        return
      } else if(this.birth_MM === ''){
        this.userBirth_errorMsg = '생년월일을 입력해주세요'
        return
      } else if(this.birth_dd === ''){
        this.userBirth_errorMsg = '생년월일을 입력해주세요'
        return
      } else {
        this.userBirth_errorMsg = ''
      }

      // user email 형식 유효성 검사
      if (this.emailRule.test(this.user_email.trim()) === false) {
        if(this.user_email === ''){
          this.userEmail_errorMsg = '필수 입력 정보 입니다'
          this.$refs.emailBox.focus()
          return
        }
        this.userEmail_errorMsg = '이메일을 다시 확인해 주세요.'
        this.$refs.emailBox.focus()
        return
      } else {
        this.userEmail_errorMsg = ''
      }
      //휴대폰 번호 유효성 검사 - 숫자만 입력.
      if (this.phoneNumRule.test(this.user_phone.trim()) === false) {
        if(this.user_phone === ''){
          this.userPh_errorMsg = '필수 입력 정보입니다'
          this.$refs.phNumBox.focus()
          return
        }
        this.userPh_errorMsg = '휴대폰 번호를 -없이 다시 입력해주세요'
        this.$refs.phNumBox.focus()
        return
      } else {
        this.userPh_errorMsg = ''
      }

      // // 휴대폰 인증 통과여부 확인
      // if(this.phCertifPassCheck === false){
      //   this.$refs.certifNumBox.focus()
      //   alert('휴대폰 인증을 해주세요')
      //   e.preventDefault()
      //   return
      // }

      //기업가입시 기업가입정보 유효성 검사
      if (this.mg_auth === '2') {
        //기업명 체크
        if (this.com_name === '') {
          this.$refs.com_nameBox.focus()
          this.comName_errorMsg = '필수 입력 정보입니다'
          return
        } else {
          this.comName_errorMsg = ''
        }
        //기업 전화번호 체크
        if (this.phoneNumRule.test(this.com_phone.trim()) === false) {
          if(this.com_phone === ''){
            this.comPh_errorMsg = '필수 입력 정보입니다'
            this.$refs.com_phBox.focus()
            return
          }
          this.comPh_errorMsg = '번호를 -없이 다시 입력해주세요'
          this.$refs.com_phBox.focus()
          return
        } else {
          this.comPh_errorMsg = ''
        }
        //기업 이메일 체크
        if (this.emailRule.test(this.com_email.trim()) === false) {
          if(this.com_email === ''){
            this.comEmail_errorMsg = '필수 입력 정보입니다'
            this.$refs.com_emailBox.focus()
            return
          }
          this.comEmail_errorMsg = '기업 이메일을 다시 확인해주세요'
          this.$refs.com_emailBox.focus()
          return
        } else {
          this.comEmail_errorMsg = ''
        }
        //기업 주소 체크
        if (this.com_address === '') {
          this.$refs.com_addressBox.focus()
          this.comAddress_errorMsg = '필수 입력 정보입니다'
          return
        } else {
          this.comAddress_errorMsg = ''
        }
        //기업 상세주소 체크
        if (this.com_detail_address === '') {
          this.$refs.com_deAddressBox.focus()
          this.comDeAddress_errorMsg = '필수 입력 정보입니다'
          return
        } else {
          this.comDeAddress_errorMsg = ''
        }

        // 업종 체크
        if (this.com_category === '') {
          this.$refs.com_categoryBox.focus()
          this.comCategory_errorMsg = '필수 입력 정보입니다'
          return
        } else {
          this.comCategory_errorMsg = ''
        }
        // 기업 대표 체크
        // 한글, 영문만 입력가능
        if (this.nameRule.test(this.com_ceo.trim()) === false) {
          if(this.com_ceo === ''){
            this.comCeo_errorMsg = '필수 입력 정보입니다'
            this.$refs.com_ceoBox.focus()
            return
          }
          this.comCeo_errorMsg = '대표자 이름을 확인해주세요'
          this.$refs.com_ceoBox.focus()
          return
        } else {
          this.comCeo_errorMsg = ''
        }
        //사업자 등록번호 체크
        //사업자 등록번호 정규식 3글자-2글자-5글자
        if (this.businessRegisRule.test(this.com_businessRegistration.trim()) === false) {
          if(this.com_businessRegistration === ''){
            this.comBizReg_errorMsg = '필수 입력 정보입니다'
            this.$refs.com_regBox.focus()
            return
          }
          this.comBizReg_errorMsg = '사업자 등록 번호가 잘못 되었습니다'
          this.$refs.com_regBox.focus()
          return
        } else {
          this.comBizReg_errorMsg = ''
        }
        //회사 설립일 체크
        if (this.com_establishmentDate === '') {
          this.comEsDate_errorMsg = '필수 입력 정보입니다'
          this.$refs.com_esDateBox.focus()
          return
        } else {
          this.comEsDate_errorMsg = ''
        }
      }

      //필수동의 체크여부 확인
      if (document.getElementById('agree1').checked === false) {
        alert("필수동의 항목을 확인해 주세요.")
        this.errorMsg.push({msg: '필수 항목입니다.'}) //에러메시지 담기
        console.log(this.errorMsg)
        return
      }
      if (document.getElementById('agree2').checked === false) {
        alert("개인정보 동의 항목을 확인해 주세요.")
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
          user_gender: this.user_gender,
          user_rrn: this.birth_yyyy + '-' + this.birth_MM + '-' + this.birth_dd, //생년월일
          user_email: this.user_email,
          user_phone: this.user_phone,
          mg_auth: this.mg_auth
        },
        comData: {
          com_name: this.com_name,
          com_phone: this.com_phone,
          com_email: this.com_email,
          com_address: this.com_address,
          com_detail_address: this.com_detail_address,
          com_category: this.com_category,
          com_ceo: this.com_ceo,
          com_businessRegistration: this.com_businessRegistration,
          com_establishmentDate: this.com_establishmentDate
        }
      }
      this.$axios.post(url, data)
          .then(response => {
            if (response.status === 200) {
              this.$router.push('/sign-in')
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
    },
    testBirth () {
      console.log('testBirth 실행')
      console.log('yyyy:', this.birth_yyyy)
      console.log('MM:', this.birth_MM)
      console.log('dd:', this.birth_dd)
      console.log('user_rrn:', this.user_rrn)
    },
    // 전화,핸드폰번호 자동 하이푼 추가
    userAutoHyphen(e) {
      let value = e.target.value
      this.user_phone = value.replace(/[^0-9]/g, "").replace(
          /(^02.{0}|^01.{1}|[0-9]{3})([0-9]+)([0-9]{4})/,
          "$1-$2-$3")
    },
    comAutoHyphen(e) {
      let value = e.target.value
      this.com_phone = value.replace(/[^0-9]/g, "").replace(
          /(^02.{0}|^01.{1}|[0-9]{3})([0-9]+)([0-9]{4})/,
          "$1-$2-$3")
    },

  }

}
</script>

<style scoped>
@import "./SignUp.css";
</style>
