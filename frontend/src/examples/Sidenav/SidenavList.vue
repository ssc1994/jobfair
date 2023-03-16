<template>
  <div class="pt-3 mx-3 mt-3 sidenav-footer">
    <div class="userInfoBox">
      <div class="userInfoFirstLine">
        <div class="userInfo_wrap">
          <img src="../../assets/img/myImage/profileImg.png" class="profile_img userInfo_left">
          <div>
<!--            session에서 가져온 아이디 값 출력 -->
            <h6>{{userInfo.user_id}}님 환영합니다.</h6>
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

<!--      왼쪽 사이드바 마이페이지 버튼 auth에 따라 다르게 나오게 만듦 -->
      <div v-if="userInfo.mg_auth === '1'">
      <div class="btnBox">
        <button type="button" class="btn" data-bs-toggle="modal" data-bs-target="#uInfoModi" @click="getUserInfo">
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
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <div class="content">
            <div>
              <div class="modalImg">
                <img src="" alt="프로필사진">
              </div>


              <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">아이디:</span>
                <input type="text" readonly class="form-control" placeholder="UserId" aria-label="Username"
                       aria-describedby="basic-addon1"
                       v-model="userInfo.user_id">
              </div>

              <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">이름:</span>
                <input type="text" class="form-control" placeholder="Name" aria-label="Username"
                       aria-describedby="basic-addon1"
                       v-model="userInfo.user_name">
              </div>

              <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">현재 비밀번호:</span>
                <input type="text" class="form-control" placeholder="Password" aria-label="Username"
                       aria-describedby="basic-addon1"
                       v-model="currentPw">
              </div>

              <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">새로운 비밀번호:</span>
                <input type="text" class="form-control" placeholder="Password" aria-label="Username"
                       aria-describedby="basic-addon1"
                       v-model="newPw">
              </div>

              <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">새로운 비밀번호 확인:</span>
                <input type="text" class="form-control" placeholder="Password" aria-label="Username"
                       aria-describedby="basic-addon1"
                       v-model="checkNewPw">
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
                       v-model="userInfo.user_phone" maxlength="11">
              </div>

              <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">이메일:</span>
                <input type="email" class="form-control" placeholder="Email" aria-label="Username"
                       aria-describedby="basic-addon1"
                       v-model="userInfo.user_email">
              </div>

            </div>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
          <button type="button" class="btn btn-primary" data-bs-dismiss="modal">수정 완료</button>
        </div>
      </div>
    </div>
  </div>


  <hr>

  <!-- 아코디언 -->
  <div v-if="userInfo.mg_auth === '1'">
    <SideMenuList class="menu01" menuTitle='1'/>
  </div>
  <div v-if="userInfo.mg_auth === '2'">
    <SideMenuList menuTitle='2'/>
  </div>
  <div v-if="userInfo.mg_auth === '4'">
    <SideMenuList menuTitle='4'/>
  </div>


</template>
<script>
import SidenavCollapse from "./SidenavCollapse.vue";
import SidenavCard from "./SidenavCard.vue";
import Shop from "../../components/Icon/Shop.vue";
import Box3d from "../../components/Icon/Box3d.vue";
import Document from "../../components/Icon/Document.vue";
import Spaceship from "../../components/Icon/Spaceship.vue";
import Settings from "../../components/Icon/Settings.vue";
import SideMenuList from "@/components/myComponent/SideMenuList";

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
        user_id: JSON.parse(sessionStorage.getItem('sessionId')),
        user_pw: '',
        user_phone: '',
        user_email: '',
        user_gender: '',
        user_rrn: '', //user 생년월일
        mg_auth: JSON.parse(sessionStorage.getItem('sessionAuth')) //회원정보 구분 아이디 1.유저 2.미승인기업 3.승인기업 4.관리자
      },
      currentPw: '',
      newPw: '',
      checkNewPw: '',
      man: 'false',
      woman: 'false',
      gender: ''
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
    SideMenuList
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
      console.log('getUserInfo 실행')
      //세션에서 user의 id 값을 가져와서 넘기는 데이터의 user_id 에 넣어줘야함.
      this.$axios.post('/jobfair/userInfoModi/getUserInfo', {user_id: 'taemin'})
          .then(response => {
            console.log(response)
            console.log(response.data.user_gender)
            this.userInfo = response.data

            //받아온 성별데이터에 따라서 모달창 내에 라디오 타입 체크 되있도록 처리
            if(this.userInfo.user_gender === '남자'){
              this.man = true
            } else {
              this.woman = true
            }

          })
          .catch(error => {
            console.log(error)
          })
    },
    // 정규표현식 만족시 하이푼 추가, 전화번호 형식도 가능
    autoHyphen(e) {
      e.target.value = e.target.value
          .replace(/[^0-9]/g, '')
          .replace(/^(\d{2,3})(\d{3,4})(\d{4})$/, `$1-$2-$3`);
    },
    //핸드폰 번호 입력과 동시에 자동 하이픈 추가
    autoHyphen2(e) {
      e.target.value = e.target.value
          .replace(/[^0-9]/g, '')
          .replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");
    },
    //남녀 선택 따라서 gender 변수에 값 담아주는 메서드
    genderType(e) {
      this.gender = e.target.value
      // 밑에꺼 굳이 필요없나 ? 확신들면 지우기
      if(this.gender === '남자'){
       this.man = true
       this.woman = false
      } else {
        this.man = false
        this.woman = true
      }
      console.log(this.gender)
    }
  },
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

.menu01 {
  border: 3px solid;
}

</style>