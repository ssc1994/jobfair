<template>
  <div class="container top-0 position-sticky z-index-sticky">
    <div class="row">
      <div class="col-12">
        <navbar
          is-blur="blur blur-rounded my-3 py-2 start-0 end-0 mx-4 shadow"
          btn-background="bg-gradient-success"
          :dark-mode="true"
        />
      </div>
    </div>
  </div>
  <main class="mt-0 main-content main-content-bg">
    <section>
      <div class="page-header min-vh-75">
        <div class="container">
          <div class="row">
            <div class="mx-auto col-xl-4 col-lg-5 col-md-6 d-flex flex-column">
              <div class="mt-8 card card-plain">
                <div class="pb-0 card-header text-start">
                  <h3 class="font-weight-bolder text-success text-gradient">
                    Welcome back
                  </h3>
                  <p class="mb-0">Enter your id and password to sign in</p>
                  <br>
                  <div class="radioBox">
                    <input type="radio" name="radioBtn" value="1" v-model="mg_auth"><span>개인회원</span>
                    <input type="radio" name="radioBtn" value="2" v-model="mg_auth"><span>기업회원</span>
                  </div>
                </div>
                <div class="card-body">
                  <div class="text-start loginBox">
                    <label>id</label><br>
                    <soft-input
                      id="user_id"
                      type="text"
                      placeholder="username"
                      name="user_id"
                      v-model:model="user_id"
                    />
                    <label>Password</label><br>
                    <soft-input
                      id="password"
                      type="password"
                      placeholder="Password"
                      name="password"
                      v-model:model="user_pw"
                    />
                    <soft-switch id="rememberMe" name="rememberMe" checked>
                      Remember me
                    </soft-switch>
<!--                    <div class="text-center">-->
<!--                      <soft-button-->
<!--                        class="my-4 mb-2"-->
<!--                        variant="gradient"-->
<!--                        color="success"-->
<!--                        full-width-->
<!--                        @click="logInBtn"-->
<!--                        >Sign in-->
<!--                      </soft-button>-->
<!--                    </div>-->
                  </div>
                </div>
                <button type="submit" id="loginBtn" @click="logInBtn"
                class="btn mb-0 bg-gradient-success w-80"
                >로그인</button>

                <div class="px-1 pt-0 text-center card-footer px-lg-2">
                  <p>좋은 직업을 찾고싶으신가요? <br>가입하시고 다양한 정보를 얻어가세요!<br>
                    <router-link to="/Sign-Up"  class="text-success text-gradient font-weight-bold">회원가입</router-link>
                  </p>
                </div>
              </div>
            </div>
            <div class="col-md-6">
              <div
                class="top-0 oblique position-absolute h-100 d-md-block d-none me-n8"
              >
                <div
                  class="bg-cover oblique-image position-absolute fixed-top ms-auto h-100 z-index-0 ms-n6"
                  :style="{
                    backgroundImage:
                      'url(' +
                      require('@/assets/img/curved-images/curved9.jpg') +
                      ')',
                  }"
                ></div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </main>
  <app-footer />
</template>

<script>
import Navbar from "@/examples/PageLayout/Navbar.vue";
import AppFooter from "@/examples/PageLayout/Footer.vue";
import SoftInput from "@/components/SoftInput.vue";
import SoftSwitch from "@/components/SoftSwitch.vue";
import SoftButton from "@/components/SoftButton.vue";
const body = document.getElementsByTagName("body")[0];
import { mapMutations } from "vuex";

export default {
  name: "SignIn",
  data () {
    return {
      mg_auth: this.$store.getters.getMg_auth,
      user_id: '',
      user_pw: '',


    }
  },
  updated() {
    this.$store.commit("setMg_auth", this.mg_auth)
    // console.log(this.mg_auth)
    // console.log(this.user_id)
    // console.log(this.user_pw)
  },
  components: {
    Navbar,
    AppFooter,
    SoftInput,
    SoftSwitch,
    SoftButton
  },
  created() {
    this.toggleEveryDisplay();
    this.toggleHideConfig();
    body.classList.remove("bg-gray-100");
  },
  beforeUnmount() {
    this.toggleEveryDisplay();
    this.toggleHideConfig();
    body.classList.add("bg-gray-100");
  },
  methods: {
    ...mapMutations(["toggleEveryDisplay", "toggleHideConfig"]),

    logInBtn () {
      console.log(this.mg_auth)
      console.log(this.user_id)
      console.log(this.user_pw)
      let self = this;

      this.$axios
          .post('/jobfair/login', {
            mg_auth: this.mg_auth,
            user_id: this.user_id,
            user_pw: this.user_pw
          })
          .then((res) => {
            //sessionStorage에 id / auth 추가
            sessionStorage.setItem('sessionId',JSON.stringify(res.data.user_id))
            sessionStorage.setItem('sessionAuth',JSON.stringify(res.data.mg_auth))
            if(res.data.com_num != null){
              sessionStorage.setItem('sessionComp',JSON.stringify(res.data.com_num))
            }
            console.log(res.data)
            this.$store.commit('setUser_id', sessionStorage.getItem('sessionId'));
            this.$store.commit('setMg_auth', sessionStorage.getItem('sessionAuth'));
            this.$store.commit('setCom_num', sessionStorage.getItem('sessionComp'));

            if(res.data.mg_auth == '1'){
              //sesionStorage에서 값 가져오는법
              // let sessionId = sessionStorage.getItem('sessionId')
              // let sessionAuth = sessionStorage.getItem('sessionAuth')
              // if(sessionId && typeof sessionId === 'string' && sessionId !== '') {
              //   let SessionJsonId = JSON.parse(sessionId)
              //   console.log(SessionJsonId)
              // }
              // if(sessionAuth && typeof sessionAuth === 'string' && sessionAuth !== '') {
              //   let SessionJsonAuth = JSON.parse(sessionAuth)
              //   console.log(SessionJsonAuth)
              // }

              // //페이지 이동전에 세션에 값을 넣어야함
              this.$router.push("/uMainView")

            }else if(res.data.mg_auth == '2' || res.data.mg_auth == '3' ){
              //페이지 이동전에 세션에 값을 넣어야함
              this.$router.push("/cMainView")

            }else if(res.data.mg_auth == '4' ){
              //페이지 이동전에 세션에 값을 넣어야함
              this.$router.push("/aMainView")

            }else{
              var msg='로그인 실패 / 비밀번호를 확인하세요'
              alert(msg)
            }
          })
          .catch((error) => {
            alert('에러내용 : ' + error)

          })
          .finally(() => {
            console.log('로그인시도')
          })
    },
  },
};
</script>

<style scoped>

.loginBox input {
  height: 40px;
  width: 250px;
  margin-bottom: 10px;
  border-radius: 5px;
  border: 1px solid black;
}
.loginBtn{
  justify-content: center;
  position: relative;
  left: 25px;
}

</style>