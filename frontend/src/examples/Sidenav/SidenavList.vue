<template>
  <div class="pt-3 mx-3 mt-3 sidenav-footer">
    <div class="userInfoBox">
      <div class="userInfoFirstLine">
        <div class="userInfo_wrap">
          <img src="../../assets/img/myImage/profileImg.png" class="profile_img userInfo_left">
          <div>
            <!--            session에서 가져온 아이디 값 출력 -->
            <h6>{{ userInfo.user_id }}님 환영합니다.</h6>
            <a href="#">쪽지(3)</a>
            <button type="button" @click="logOut">logOut</button>
          </div>
        </div>
      </div>
      <div class="userInfo_wrap">
        <div class="userInfo_left user_Info_list">
          <span>지원완료</span><br>
          <span>10</span>
        </div>
        <div class="userInfo_left user_Info_list center">
          <span>열람</span><br>
          <span>10</span>
        </div>
        <div class="userInfo_left user_Info_list">
          <span>지원완료</span><br>
          <span>10</span>
        </div>
      </div>

      <!-- 왼쪽 사이드바 마이페이지 버튼 auth에 따라 다르게 나오게 만듦 -->
      <div v-if="userInfo.mg_auth === '1'">
        <div class="btnBox">
          <button type="button" class="btn" data-bs-toggle="modal" data-bs-target="#uInfoModi"
                  @click="getUserInfo()">
            개인정보 수정
          </button>
          <button type="button" class="btn" @click="this.$router.push('uMypageView') ">MyPage</button>
        </div>
      </div>
      <div v-if="userInfo.mg_auth === '2'">
        <div class="btnBox">
          <button type="button" class="btn" @click="this.$router.push('cQnAView')">
            QnA
          </button>
          <button type="button" class="btn" @click="this.$router.push('cMypageView') ">MyPage</button>
        </div>
      </div>
    </div>
  </div>


  <!-- Modal -->
  <div class="modal fade" id="uInfoModi" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
      <div class="modal-content">
        <div class="modal-header">
          <h1 class="modal-title fs-5" id="exampleModalLabel">개인정보수정</h1>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"
                  @click="toDefault(), toInfoType()"></button>
        </div>
        <!--        정보 수정 타입 section-->
        <div class="modiInfo_type_wrap">
          <ul class="changeType_btn_wrap">
            <li :class="[modi_type === 'info' ? 'selected_type' : 'unSelected_type']" @click="toInfoType(), toDefault(), getUserInfo()">회원정보
              수정
            </li>
            <li :class="[modi_type !== 'info' ? 'selected_type' : 'unSelected_type']" @click="toPwType(), toDefault()">비밀번호
              변경
            </li>
          </ul>
        </div>

        <div class="modal-body" style="padding-top: 8px; border-bottom: 1px solid #1E1E1E">
          <div class="content">
            <div>

              <div v-if="modi_type === 'info'">
                <div class="data_box">
                  <div class="data_title_wrap">
                    <span>아이디</span><span></span>
                  </div>
                  <input type="text" class="data_insert_box" ref="nameBox" placeholder="이름 (실명)"
                         v-model="userInfo.user_id" readonly/>
                </div>


                <div class="data_box">
                  <div class="data_title_wrap">
                    <span>이름</span><span :hidden="userName_errorMsg === ''"
                                         class="pass_error">{{ userName_errorMsg }}</span>
                  </div>
                  <input type="text" class="data_insert_box" ref="nameBox" placeholder="이름"
                         v-model="userInfo.user_name"
                         @keyup="nameCheck"/>
                </div>

                <div class="data_box">
                  <div class="data_title_wrap">
                    <span>성별:</span><span></span>
                  </div>
                  <div class="gender_type_wrap">
                    <div>
                      <input type="radio" id="man" name="gender" @click="genderType($event)" value="남자"
                             :checked="man">
                      <label for="man">남자</label>
                    </div>
                    <div>
                      <input type="radio" id="woman" name="gender" @click="genderType($event)" value="여자"
                             :checked="woman">
                      <label for="woman">여자</label>
                    </div>
                  </div>
                </div>

                <div class="data_box">
                  <div class="data_title_wrap">
                    <span>생년월일</span><span :hidden="userBirth_errorMsg === ''"
                                           class="pass_error">{{ userBirth_errorMsg }}</span>
                  </div>
                  <input type="date" class="data_insert_box" placeholder="Birth"
                         v-model="userInfo.user_rrn">
                </div>

                <div class="data_box">
                  <div class="data_title_wrap">
                    <span>핸드폰 번호</span><span :hidden="userPh_errorMsg === ''"
                                             class="pass_error">{{ userPh_errorMsg }}</span>
                  </div>
                  <input type="text" class="data_insert_box" placeholder='phoneNumber - 없이'
                         @keyup="noSpaceForm($event), phCheck()"
                         ref="phNumBox"
                         v-model="userInfo.user_phone" maxlength="11">
                </div>

                <div class="data_box">
                  <div class="data_title_wrap">
                    <span>이메일</span><span :hidden="userEmail_errorMsg === ''"
                                          class="pass_error">{{ userEmail_errorMsg }}</span>
                  </div>
                  <input type="email" class="data_insert_box" placeholder="Email"
                         ref="emailBox"
                         @keyup="emailCheck"
                         v-model="userInfo.user_email">
                </div>
              </div>

              <div v-if="modi_type === 'pw'">
                <div class="data_box">
                  <div class="data_title_wrap">
                    <span>기존 비밀번호</span><span :hidden="currentPw_errorMsg === ''"
                                              class="pass_error">{{ currentPw_errorMsg }}</span>
                  </div>
                  <input type="password" class="data_insert_box" ref="currentPwBox" placeholder="기존 비밀번호"
                         v-model="userInfo.currentPw"/>
                </div>

                <div class="data_box">
                  <div class="data_title_wrap">
                    <span>신규 비밀번호</span><span :hidden="newPw_errorMsg === ''"
                                              :class="[newPw_errorMsg === '사용가능한 패스워드입니다' ? 'pass_color' : 'pass_error']">{{ newPw_errorMsg }}</span>
                  </div>
                  <input type="password" class="data_insert_box" ref="newPwBox"
                         placeholder="비밀번호 (8~20자의 영문,숫자,특수기호 포함)"
                         @keyup="checkNewPw"
                         v-model="userInfo.newPw"/>
                </div>

                <div class="data_box">
                  <div class="data_title_wrap">
                    <span>신규 비밀번호 확인</span><span :hidden="newPwCheck_errorMsg === ''"
                                                 :class="[newPwCheck_errorMsg === '비밀번호 확인' ? 'pass_color' : 'pass_error']">{{ newPwCheck_errorMsg }}</span>
                  </div>
                  <input type="password" class="data_insert_box" ref="newPwCheckBox" placeholder="same password"
                         @keyup = "sameNewPwCheck"
                         v-model="sameNewPw"/>
                </div>
              </div>


            </div>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" ref="closeBtn" @click="toDefault, toInfoType()">
            Close
          </button>
          <button type="button" class="btn btn-primary" @click="requestModi">수정 완료</button>
        </div>
      </div>
    </div>
  </div>

  <hr>

  <!-- 아코디언 -->
    <div>
      <SideMenuList :mg_auth=userInfo.mg_auth menu_id="p1" menuTitle='홈'/>
    </div>
    <div>
      <SideMenuList :mg_auth=userInfo.mg_auth menu_id="p2" menuTitle='마이 페이지'/>
    </div>
    <div>
      <SideMenuList :mg_auth=userInfo.mg_auth menu_id="p3" menuTitle='채용 정보'/>
    </div>
    <div>
      <SideMenuList :mg_auth=userInfo.mg_auth menu_id="p4" menuTitle='QnA'/>
    </div>

</template>
<script>
import SidenavCollapse from "./SidenavCollapse.vue";
import SideMenuList from "@/components/myComponent/SideMenuList";
import router from "@/router";

export default {
  name: "SidenavList",
  components: {
    SidenavCollapse,
    SideMenuList
  },
  props: {
    cardBg: String,
  },
  data() {
    return {
      homeLink: '',
      myPageLink: '',
      //개인정보 수정 변수
      userInfo: {
        user_name: '',
        user_id: JSON.parse(sessionStorage.getItem('sessionId')),
        currentPw: '', //기존 비밀번호 확인 위한 변수
        newPw: '', //새비밀번호
        user_pw: '',
        user_phone: '',
        user_email: '',
        user_gender: '',
        user_rrn: '', //user 생년월일
        mg_auth: JSON.parse(sessionStorage.getItem('sessionAuth')) //회원정보 구분 아이디 1.유저 2.미승인기업 3.승인기업 4.관리자
      },

      sameNewPw: '', //새비밀번호 체크
      man: 'false',
      woman: 'false',
      gender: '',
      //정규식
      passwordRule: /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$/,  //비밀번호 유효성 검사 정규표현식
      nameRule: /^[가-힣]{2,4}$/, //한글만 2~4글자
      emailRule: /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/, //이메일 형식 유호성 검사 정규표현식
      phoneNumRule: /^[0-9]{8,13}$/, //휴대폰 번호 숫자만 가능
      //유효성검사 에러 메세지
      userName_errorMsg: '',
      currentPw_errorMsg: '', // pw파트
      newPw_errorMsg: '', //pw파트
      newPwCheck_errorMsg: '', //pw파트
      userGender_errorMsg: '',
      userBirth_errorMsg: '',
      userEmail_errorMsg: '',
      userPh_errorMsg: '',
      //유효성 검사 결과
      check_result: 'success',  // 유효성 검사 중 실패 사항 있을시 fail 들어감.
      //회원 정보 수정, 비밀번호 변경 타입인지 상태값 저장
      modi_type: 'info' // info = 회원정보수정, pw = 비밀번호 변경
    }
  },
  created () {
    //sesionStorage에서 값 가져오기
    let sessionAuth = sessionStorage.getItem('sessionAuth')
    if(sessionAuth && typeof sessionAuth === 'string' && sessionAuth !== '') {
      let SessionJsonAuth = JSON.parse(sessionAuth)
      if(SessionJsonAuth === '1') {
        this.homeLink = '/uMainView'
      }
      else if(SessionJsonAuth === '2' || SessionJsonAuth === '3') {
        this.homeLink = '/cMainView'
      }
      else if(SessionJsonAuth === '4') {
        this.homeLink = '/aMainView'
      }
    }
  },
  methods: {
    getRoute() {
      const routeArr = this.$route.path.split("/");
      return routeArr[1];
    },
    handleCollapse() {
      this.isOpen = !this.isOpen
    },
    // 개인정보 수정 모달 오픈시 로그인한 회원 데이터 가져와서 뿌려줌
    getUserInfo() {

      this.$axios.post('/jobfair/userInfoModi/getUserInfo', {user_id: this.userInfo.user_id})
          .then(response => {
            this.userInfo = response.data

            //받아온 성별데이터에 따라서 모달창 내에 라디오 타입 체크 되있도록 처리
            if (this.userInfo.user_gender === '남자') {
              this.man = true
            } else {
              this.woman = true
            }

          })
          .catch(error => {
            console.log(error)
          })

    },
    //남녀 선택 따라서 gender 변수에 값 담아주는 메서드
    genderType(e) {
      this.gender = e.target.value
      if (this.gender === '남자') {
        this.man = true
        this.woman = false
      } else {
        this.man = false
        this.woman = true
      }
    },

    //이름 유효성 검사 메서드
    nameCheck() {
      if (!this.nameRule.test(this.userInfo.user_name.trim())) {
        if (this.userInfo.user_name === '') {
          this.userName_errorMsg = '필수입력 정보 입니다'
          this.check_result = 'fail'
          return
        }
        this.userName_errorMsg = '이름을 확인해주세요'
        this.check_result = 'fail'
      } else {
        this.userName_errorMsg = ''
        this.check_result = 'success'
      }
    },

    //핸드폰 번호 유효성 검사 메서드
    phCheck() {
      if (this.phoneNumRule.test(this.userInfo.user_phone) === false) {
        if (this.userInfo.user_phone === '') {
          this.userPh_errorMsg = '필수 입력 정보입니다'
          this.check_result = 'fail'
          return
        }
        this.userPh_errorMsg = '휴대폰 번호를 확인해주세요'
        this.check_result = 'fail'
        return
      } else {
        this.userPh_errorMsg = ''
        this.check_result = 'success'
      }
    },
    //이메일 유효성 검사 메서드
    emailCheck() {
      if (this.emailRule.test(this.userInfo.user_email) === false) {
        if (this.userInfo.user_email === '') {
          this.userEmail_errorMsg = '필수 입력 정보입니다'
          this.check_result = 'fail'
          return
        }
        this.userEmail_errorMsg = '이메일을 확인해 주세요'
        this.check_result = 'fail'
        return
      } else {
        this.userEmail_errorMsg = ''
        this.check_result = 'success'
      }
    },
    //기존 비밀번호 검사 메서드
    checkCurrentPw () {
      if(this.userInfo.currentPw === ''){
        this.currentPw_errorMsg = '필수입력정보입니다'
      } else {
        this.currentPw_errorMsg = ''
      }
    },
    //신규 비밀번호 검사 메서드 -> 8~20자의 영문,숫자,특수기호 포함 체크
    checkNewPw() {
      if (this.passwordRule.test(this.userInfo.newPw.trim()) === false) {
        this.newPw_errorMsg = '비밀번호는 영문,숫자,특수기호 포함 8~20자 이내어야 합니다'
        this.check_result = 'fail'
      } else {
        this.newPw_errorMsg = '사용가능한 패스워드입니다'
      }
    },

    //신규 비밀번호확인 검사 메서드
    sameNewPwCheck () {
      if (this.sameNewPw !== this.userInfo.newPw) {
        this.newPwCheck_errorMsg = '비밀번호가 일치하지 않습니다'
        this.check_result = 'fail'
      } else {
        if(this.passwordRule.test(this.userInfo.newPw.trim()) === false){
          this.newPwCheck_errorMsg = '비밀번호가 옳바르지 않습니다'
          this.check_result = 'fail'
        } else {
          this.newPwCheck_errorMsg = '비밀번호 확인'
          this.check_result = 'success'
        }
      }
    },

    //유효성 검사 -> 1.유효성 검사 2.비밀번호변경 체크 3.수정요청
    dataCheck() {

      //이름 유효성 검사
      if (!this.nameRule.test(this.userInfo.user_name.trim())) {
        if (this.userInfo.user_name === '') {
          this.userName_errorMsg = '필수입력 정보 입니다'
          this.check_result = 'fail'
          return
        }
        this.userName_errorMsg = '이름을 확인해주세요'
        this.check_result = 'fail'
      } else {
        this.userName_errorMsg = ''
        this.check_result = 'success'
      }

      // user email 형식 유효성 검사
      if (this.emailRule.test(this.userInfo.user_email) === false) {
        if (this.userInfo.user_email === '') {
          this.userEmail_errorMsg = '필수 입력 정보입니다'
          this.$refs.emailBox.focus()
          return
        }
        this.userEmail_errorMsg = '이메일을 다시 확인해 주세요'
        this.$refs.emailBox.focus()
        return
      } else {
        this.userEmail_errorMsg = ''
      }

      //휴대폰 번호 유효성 검사 - 숫자만 입력.
      if (this.phoneNumRule.test(this.userInfo.user_phone) === false) {
        if (this.userInfo.user_phone === '') {
          this.userPh_errorMsg = '필수 입력 정보입니다'
          this.$refs.phNumBox.focus()
          return
        }
        this.userPh_errorMsg = '휴대폰 번호를 -없이 입력해주세요'
        this.$refs.phNumBox.focus()
        return
      } else {
        this.userPh_errorMsg = ''
      }

      //유효성 검사 통과 후 수정요청 날리기
      // this.requestModi()

    }
    ,
//비밀번호 검사
    checkPw() {

    }
    ,
//수정요청 날리기
    requestModi() {

      this.checkCurrentPw()

      if (this.check_result === 'success') {

        if (this.modi_type === 'info') { //회원 정보 수정 요청일 때
          this.$axios.post('/jobfair/userInfoModi/modifyInfo', this.userInfo)
              .then(response => {
                console.log(response)

                //수정이 완료된 후 모달창 닫기2
                alert('수정되었습니다 ^^!')
                this.$refs.closeBtn.click()

              })
              .catch(error => {
                console.log(error)
              })

        } else { //비밀번호 변경 요청일 때

          this.$axios.post('/jobfair/userInfoModi/modifyPw', this.userInfo)
              .then(response => {
                console.log(response)

                var msg = response.data

                if( msg !== '비밀번호가 변경되었습니다' ){
                  alert(msg)
                  if(msg === '기존 비밀번호가 틀렸습니다'){
                    this.currentPw_errorMsg = '비밀번호가 틀렸습니다'
                    this.check_result = 'fail'
                  } else if(msg === '현재 비밀번호를 신규 비밀번호로 사용할 수 없습니다'){
                    this.newPw_errorMsg = '현재 비밀번호를 신규 비밀번호로 사용할 수 없습니다'
                    this.newPwCheck_errorMsg = '비밀번호가 옳바르지 않습니다'
                    this.check_result = 'fail'
                  }
                } else {
                  alert(msg)
                //수정이 완료된 후 모달창 닫기
                this.$refs.closeBtn.click()
                }

              })
              .catch(error => {
                console.log(error)
              })

        }

      } else { // check_resutl 가 fail일 때
        alert('입력 정보를 확인해주세요')
      }


    }
    ,
// 공백 사용 못 하게 하는 메서드
    noSpaceForm(e) {
      var str_space = /\s/;               // 공백 체크
      if (str_space.exec(e.target.value)) {     // 공백 체크
        e.target.focus();
        e.target.value = e.target.value.replace(' ', ''); // 공백제거
        return false;
        console.log(this.gender)
      }
    },
    //회원정보 타입 선택시 기본값 변경
    toInfoType () {
      this.modi_type = 'info'
      this.check_result = 'success'
    },

    //비밀번호 변경 타입 선택시 기본값 변경
    toPwType () {
      this.modi_type = 'pw'
      this.check_result = 'fail'
    },

    // 모달창 닫힐 때, 에러메세지, modi_type을 info 로  즉, 기본값으로 지정해주기.
    toDefault() {

      //비밀번호 데이터들 리셋
      this.userInfo.currentPw = ''
      this.userInfo.newPw = ''
      this.sameNewPw = ''

      //에러메세지 리셋
      this.userEmail_errorMsg = ''
      this.userName_errorMsg = ''
      this.userPh_errorMsg = ''
      this.currentPw_errorMsg = ''
      this.newPw_errorMsg = ''
      this.newPwCheck_errorMsg = ''
    },

    //로그아웃 기능 (sessionStorage에 있는 세션값 삭제 후 로그인 페이지로 이동
    logOut(){
      sessionStorage.clear()
      this.$router.push('/sign-in')
    }
  }
}
</script>

<style scoped>

.sidenav-footer {
  text-align: center;
}

.profile_img {
  width: 70px;
}

.userInfo_wrap {
  margin-bottom: 20px;
  overflow: hidden;
}

.userInfo_left {
  float: left;
}

.user_Info_list {
  text-align: center;
  padding: 0 9px;
}

.center {
  border-left: 1px solid black;
  border-right: 1px solid black;
}

#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin-top: 60px;
}

/*------------- 개인정보 수정 모달 부분 css ------------------*/
/* 개인정보 수정 창에서 회원정보, 비밀번호 변경 선택 부분*/
.modal-body {
  height: 500px;
}

.modiInfo_type_wrap {
  border-top: 1px solid #1E1E1E;
}

.changeType_btn_wrap {
  width: 100%;
  padding: 0;
  margin: 0;
}

.changeType_btn_wrap li {
  text-align: center;
  font-size: 18px;
  list-style: none;
  display: inline-block;
  padding: 10px;
}

.changeType_btn_wrap li:first-child {
  border-right: 1px solid #1E1E1E;
}

.unSelected_type {
  background-color: #0d6efd;
  color: #FFFFFF;
  width: 40%;
  border-bottom: 1px solid #1E1E1E;
}

.unSelected_type:hover {
  background-image: linear-gradient(310deg, #1AB7EA 0%, #0d6efd 100%);
  cursor: pointer;
}

.selected_type {
  background-image: linear-gradient(310deg, #FFFFFF 0%, #FFFFFF 100%);
  color: #1E1E1E;
  font-weight: 1000;
  width: 60%;
}

/*각각 칼럼별 데이터 입력 파트 css*/
.data_box {
  margin-bottom: 10px;
}

.data_insert_box {
  /* data 입력되는 input 태그들*/
  display: block;
  width: 100%;
  padding: 0.375rem 0.75rem;
  font-size: 1rem;
  font-weight: 400;
  line-height: 1.5;
  color: #212529;
  background-color: #fff;
  background-clip: padding-box;
  border: 1px solid #ced4da;
  appearance: none;
  border-radius: 0.375rem;
  transition: border-color .15s ease-in-out, box-shadow .15s ease-in-out;
}

/* 입력된 데이터 에러메세지 띄우는 부분*/
.data_title_wrap span {
  display: inline-block;
  height: 100%;
}

.data_title_wrap span:first-child {
  margin-right: 10px;
}

.data_title_wrap span:last-child {
  font-size: 12px;
}

/*성별 타입 부분*/
.gender_type_wrap > div {
  display: inline-block;
  margin-right: 10px;
}

/*유효성 검사 에러메세지 css*/
.pass_error {
  font-size: 10px;
  color: red;
}

/*유효성 검사 통과 시 글자색 초록색*/
.pass_color {
  color: green;
}

/*------------- 개인정보 수정 모달 부분 end ------------------*/

.menu01 {
  border: 3px solid;
}

.userInfoBox {
  z-index: 500;
}
</style>
