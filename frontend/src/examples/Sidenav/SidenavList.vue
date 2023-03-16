<template>
  <div class="pt-3 mx-3 mt-3 sidenav-footer">
    <div class="userInfoBox">
      <div class="userInfoFirstLine">
        <div class="userInfo_wrap">
          <img src="../../assets/img/myImage/profileImg.png" class="profile_img userInfo_left">
          <div>
            <h6>OOO님 환영합니다.</h6>
            <a href="#">쪽지(3)</a>
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

      <div class="btnBox">
        <button type="button" class="btn" data-bs-toggle="modal" data-bs-target="#uInfoModi"
                @click="getUserInfo()">
          개인정보 수정
        </button>
        <button type="button" class="btn" @click="this.$router.push('uMypageView') ">mypage</button>

      </div>
    </div>
  </div>


    <!-- Modal -->
    <div class="modal fade" id="uInfoModi" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
        <div class="modal-content">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="exampleModalLabel">개인정보수정</h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <div class="content">
              <div>

                <div class="input-group mb-3">
                  <span class="input-group-text" id="basic-addon1">아이디:</span>
                  <input type="text" readonly class="form-control" placeholder="UserId" aria-label="Username"
                         aria-describedby="basic-addon1"
                         v-model="userInfo.user_id">
                </div>

                <div>- 비밀번호 변경시 비밀번호 칸들을 채워주세요 -</div>

                <div class="input-group mb-3">
                  <span class="input-group-text" id="basic-addon1">기존 비밀번호:</span>
                  <input type="password" class="form-control" placeholder="Password" aria-label="Username"
                         aria-describedby="basic-addon1"
                         v-model="currentPw">
                </div>

                <div class="input-group mb-3">
                  <span class="input-group-text" id="basic-addon1">신규 비밀번호:</span>
                  <input type="password" class="form-control" placeholder="Password" aria-label="Username"
                         aria-describedby="basic-addon1"
                         v-model="newPw">
                </div>

                <div class="input-group mb-3">
                  <span class="input-group-text" id="basic-addon1">신규 비밀번호 확인:</span>
                  <input type="password" class="form-control" placeholder="Password" aria-label="Username"
                         aria-describedby="basic-addon1"
                         v-model="checkNewPw">
                </div>

                <span class="error_msg">{{ userName_errorMsg }}</span>
                <div class="input-group mb-3">
                  <span class="input-group-text" id="basic-addon1">이름:</span>
                  <input type="text" class="form-control" placeholder="Name" aria-label="Username"
                         aria-describedby="basic-addon1"
                         v-model="userInfo.user_name">
                </div>



                <div class="input-group mb-3">
                  <span class="input-group-text" id="basic-addon1">성별:</span>
                  <input type="radio" id="man" name="gender" @click="genderType($event)" value="남자"
                         :checked="man">
                  <label for="man">남자</label>
                  <input type="radio" id="woman" name="gender" @click="genderType($event)" value="여자"
                         :checked="woman">
                  <label for="woman">여자</label>
                </div>

                <div class="input-group mb-3">
                  <span class="input-group-text" id="basic-addon1">생년월일:</span>
                  <input type="date" class="form-control" placeholder="Birth" aria-label="Username"
                         aria-describedby="basic-addon1"
                         v-model="userInfo.user_rrn">
                </div>

                <div class="input-group mb-3">
                  <span class="input-group-text" id="basic-addon1">핸드폰 번호:</span>
                  <input type="text" class="form-control" placeholder='phoneNumber - 없이' aria-label="Username"
                         aria-describedby="basic-addon1"
                         @keyup="noSpaceForm($event)"
                         required
                         ref="phNumBox"
                         v-model="userInfo.user_phone" maxlength="11">
                </div>
                <span class="error_msg">{{ userPh_errorMsg }}</span>

                <div class="input-group mb-3">
                  <span class="input-group-text" id="basic-addon1">이메일:</span>
                  <input type="email" class="form-control" placeholder="Email" aria-label="Username"
                         aria-describedby="basic-addon1"
                         ref="emailBox"
                         v-model="userInfo.user_email">
                </div>
                <span class="error_msg">{{ userEmail_errorMsg }}</span>

              </div>
            </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" ref="closeBtn">Close</button>
            <button type="button" class="btn btn-primary" @click="dataCheck">수정 완료</button>
          </div>
        </div>
      </div>
    </div>


  <hr>

  <!-- 아코디언 -->
  <Test menuTitle='메뉴 1'/>
  <Test menuTitle='메뉴 2'/>
  <Test menuTitle='메뉴 3'/>

</template>
<script>
import SidenavCollapse from "./SidenavCollapse.vue";
import SidenavCard from "./SidenavCard.vue";
import Shop from "../../components/Icon/Shop.vue";
import Box3d from "../../components/Icon/Box3d.vue";
import Document from "../../components/Icon/Document.vue";
import Spaceship from "../../components/Icon/Spaceship.vue";
import Settings from "../../components/Icon/Settings.vue";
import Test from "@/components/myComponent/SideMenuList";

export default {
  name: "SidenavList",
  props: {
    cardBg: String,
  },
  data() {
    return {
      title: "Soft UI Dashboard PRO",
      controls: "dashboardsExamples",
      isActive: "active",
      isOpen: false,
      //개인정보 수정 변수
      userInfo: {
        user_name: '',
        user_id: '',
        user_pw: '',
        user_phone: '',
        user_email: '',
        user_gender: '',
        user_rrn: '' //user 생년월일
      },
      currentPw: '',
      newPw: '',
      checkNewPw: '',
      man: 'false',
      woman: 'false',
      gender: '',
      //정규식
      nameRule: /^[가-힣a-zA-Z]+$/, //한글,영문만 입력가능
      emailRule: /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/, //이메일 형식 유호성 검사 정규표현식
      phoneNumRule: /^[0-9]{8,13}$/, //휴대폰 번호 숫자만 가능
      //유효성검사 에러 메세지
      userName_errorMsg: '',
      userEmail_errorMsg: '',
      userPh_errorMsg: '',
      //유효성 검사 결과
      check_result : 'success'  // 유효성 검사 중 실패 사항 있을시 fail 들어감.

    }
  },
  components: {
    SidenavCollapse,
    SidenavCard,
    Shop,
    Box3d,
    Document,
    Spaceship,
    Settings,
    Test
  },
  methods: {
    getRoute() {
      const routeArr = this.$route.path.split("/");
      return routeArr[1];
    },
    handleCollapse() {
      this.isOpen = !this.isOpen
    },
    getUserInfo() {
      //세션에서 user의 id 값을 가져와서 넘기는 데이터의 user_id 에 넣어줘야함.
      this.$axios.post('/jobfair/userInfoModi/getUserInfo', {user_id: 'taemin'})
          .then(response => {
            console.log(response)
            console.log(response.data.user_gender)
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
    //유효성 검사 -> 1.유효성 검사 2.비밀번호변경 체크 3.수정요청
    dataCheck() {

      //이름 유효성 검사
      if (!this.nameRule.test(this.userInfo.user_name.trim())) {
        this.userName_errorMsg = '이름을 확인해주세요'
        this.$refs.nameBox.focus()
        return
      } else {
        this.userName_errorMsg = ''
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

    },
    //비밀번호 검사
    checkPw() {

    },
    //수정요청 날리기
    requestModi() {

      this.$axios.post('/jobfair/userInfoModi/modifyInfo', this.userInfo)
          .then(response => {
            console.log(response)

            //수정이 완료된 후 모달창 닫기
            this.$refs.closeBtn.click()

          })
          .catch(error => {
            console.log(error)
          })
    },
    // 공백 사용 못 하게 하는 메서드
    noSpaceForm(e) {
      var str_space = /\s/;               // 공백 체크
      if (str_space.exec(e.target.value)) {     // 공백 체크
        e.target.focus();
        e.target.value = e.target.value.replace(' ', ''); // 공백제거
        return false;
      }
    }

  }
};
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

/*유효성 검사 에러메세지 css*/
.error_msg {
  font-size: 10px;
  color: red;
}

/*모달 전체 wrap*/
#modal_back {
  position: fixed;
  background: #1E1E1E;
  opacity: 0.6;
  z-index: 1;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}

#modi_modal {
  background: white;
  z-index: 13;
  position: fixed;
  top: 200px;
  left: 200px;
  width: 40%;
  height: 40%;
}

</style>