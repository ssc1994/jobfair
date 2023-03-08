/* eslint-disable */
<template>
  <div class="wrapBox">
    <div class="miniWrapBox">
      <div class="logoBox">
        <img src="#" alt="HomePage Logo">
      </div>
      <div class="radioBox">
        <input type="radio" name="radioBtn" value="1" v-model="auth" @change="changeJoinType"><span>개인회원</span>
        <input type="radio" name="radioBtn" value="2" v-model="auth" @change="changeJoinType"><span>기업회원</span>
      </div>
      <div class="loginBox">
        <input type="text" name="" id="idInput" placeholder="username" v-model="id"><br/>
        <input type="password" placeholder="password" v-model="pw"><br/>
        <button type="submit" id="loginBtn" @click="logInBtn">로그인</button>
      </div>
      <div class="checkBoxWrap">
        <input type="checkbox">
        <span>로그인상태 유지하기</span><br/>
        <a href="#">아이디찾기</a> /
        <a href="#">비밀번호찾기</a>
        <p>좋은 직업을 찾고싶으신가요? 가입하시고 다양한 정보를 얻어가세요!<a href="/JoinView">회원가입</a></p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'MainView',
  data () {
    return {
      auth: '1',
      id: '',
      pw: ''
    }
  },
  methods: {
    logInBtn () {
      this.$axios
        .post('/login', {
          auth: this.auth,
          id: this.id,
          pw: this.pw
        })
        .then((res) => {
          console.log(res.data)
        })
        .catch((error) => {
          console.log(error)
        })
        .finally(() => {
          console.log('로그인실행')
        })
    },
    changeJoinType () {
      this.$store.commit("setMg_auth", this.auth)
      console.log(this.$store.getters.getMg_auth)
    }
  }
}
</script>


<style scoped>
.wrapBox {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
}
.miniWrapBox {
  height: 500px;
  width: 500px;
}

/*라디오 박스 크기 수정 및 글씨 정렬 설정*/
.radioBox input {
  font-size: 1em;
  width: 1.25em; /* 너비 설정 */
  height: 1.25em; /* 높이 설정 */
  vertical-align: middle;
}
.radioBox input + span{ /* 라벨 텍스트 크기와 수직 정렬 맞춤 */
  font-size: 1.125em;
  vertical-align: middle;
  padding-left: 10px;
  padding-right: 25px;
}
.radioBox {
  height: 50px;
  line-height: 50px;
}

/*회사 로고 넣는 곳 높이 넓힘*/
.logoBox {
  height: 100px;
}

.miniWrapBox {
  height: 500px;
  width: 500px;
}

/*라디오 박스 크기 수정 및 글씨 정렬 설정*/
.radioBox input {
  font-size: 1em;
  width: 1.25em; /* 너비 설정 */
  height: 1.25em; /* 높이 설정 */
  vertical-align: middle;
}
.radioBox input + span{ /* 라벨 텍스트 크기와 수직 정렬 맞춤 */
  font-size: 1.125em;
  vertical-align: middle;
  padding-left: 10px;
  padding-right: 25px;
}
.radioBox {
  height: 50px;
  line-height: 50px;
}

/*회사 로고 넣는 곳 높이 넓힘*/
.logoBox {
  height: 100px;
}

/*로그인창, 로그인 버튼 설정*/
.loginBox {
  height: 200px;
  padding-top: 20px;
}
.loginBox input {
  height: 40px;
  width: 250px;
  margin-bottom: 10px;
  border-radius: 5px;
  border: 1px solid black;
}
.loginBox #loginBtn {
  height: 50px;
  width: 100px;
  background-color: #42b983;
  border: none;
  border-radius: 5px;
}
.checkBoxWrap {
  height: 150px;
}
</style>
