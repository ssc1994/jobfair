<template>
  <div class="mainBox">
    <div class="UserBox">
      <div class="select">
        <div class="leftBox">
          <input type="radio" id="userType" name="selectType" @change="radioChange($event)" :checked="userRadio">
          <label for="userType">개인회원</label>
        </div>
        <div class="rightBox">
          <input type="radio" id="companyType" name="selectType" @change="radioChange($event)" :checked="comRadio">
          <label for="companyType">기업회원</label>
        </div>

        <p>
          <strong :style="{color:'red'}">*</strong>는 필수입력 정보란입니다.
        </p>

        <div :class="{ 'CompanyForm' : hasError, active : isActive }">
          <div>
            <form @submit="checkSubmit($event)" action="/jobfair/uJoin" method="post" class="MemberInfo">
              <input type="text" ref="nameBox" name="user_name" placeholder="이름(실명)" v-model = "username" id="name"/>

              <div>
                <input type="text" ref="idBox" name="user_id" placeholder="아이디" @keyup="idBoxNullCheck" @keydown.enter="sameIdCheck" v-model = "id" class="PersonUnder"/>
                <button type="button" @click="sameIdCheck" :disabled="idBoxCheck" class="PersonTop">중복확인</button>
                <span :hidden="msg === 'id 중복확인을 먼저 해주세요'">{{msg}}</span>
              </div>
              <div>
                <input type="password" ref="pwBox" name="user_pw" autoComplete="off" placeholder="비밀번호(8~20자의 영문,숫자,특수기호)" v-model = "password"/>
              </div>
              <div>
                <input type="email" ref="emailBox" name="user_email" placeholder="이메일" v-model="email"/>
              </div>
              <div>
                <input type="text" ref="phNumBox" name="user_phone" placeholder="휴대폰번호 -없이" v-model="phoneNum" class="PersonUnder"/>
                <button type="button" class="PersonTop">인증번호 전송</button>
              </div>
              <div>
                <input type="text" ref="certifNumBox" name="" placeholder="인증번호 입력" v-model ="certification_num" class="PersonUnder">
                <button type="button" id="leftBtn">확인</button>
                <button type="button" id="rightBtn">재전송</button>
              </div>

              <div class="CompanyBox" :class="{ 'PeopleForm' : hasError, active : isActive }">
                <div>
                  <div class="MemberInfo companyContent" :class="class2" v-if="show">
                    <div>
                      <input type="text" placeholder="기업명"/>
                    </div>
                    <div>
                      <input type="tel" placeholder="기업 전화번호"/>
                    </div>
                    <div>
                      <input type="email" placeholder="기업 이메일"/>
                    </div>
                    <div>
                      <input type="text" placeholder="기업 주소"/>
                    </div>
                    <div>
                      <input type="text" placeholder="업종"/>
                    </div>
                    <div>
                      <input type="text" placeholder="대표자"/>
                    </div>
                    <div>
                      <input type="text" placeholder="사업자등록번호"/>
                    </div>
                    <div>
                      <input type="date" placeholder="설립일">
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

                  <input type="submit" value="가입하기">

                </div>
              </div>
            </form>
          </div>
        </div>
        <br>
        <hr>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import router from '@/router'
export default {
  name: 'uJoinView',
  data: function () {
    return {
      username: '',
      id: '',
      password: '',
      email: '',
      phoneNum: '',
      certification_num: '',
      msg: 'id 중복확인을 먼저 해주세요', // id 중복확인 하고나서 화면에 뿌려줄 것.
      checkedBox : [],
      errorMsg : [],
      sampleData: '',
      isActive: false,
      hasError: false,
      class2: ['active', 'hasError'],
      show: false,
      mg_auth: this.$store.getters.getMg_auth,
      userRadio: true,
      comRadio: false,
      idBoxCheck : true, //id 값이 있는지 여부에 따라 id 중복확인 버튼 활성화 조절하기 위한 변수
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
  created () {
    if(this.$store.getters.getMg_auth === '1') {
      this.userRadio = true
      this.comRadio = false
    }else{
      this.userRadio = false
      this.comRadio = true
      this.show = true
    }
  },
  methods: {
    // id값이 공백이 아닐때 중복확인 버튼 활성화 , 공백이면 다시 비활성화
    idBoxNullCheck () {
      if(this.id !== ''){this.idBoxCheck = false}
      else if(this.id === ''){ this.idBoxCheck = true}
    },
    // 아이디 중복확인 메서드
    sameIdCheck () {
      var self = this // axios 안에서 this 키워드 동작 제대로 안되서 여기서 변수로 선언해줌
      this.$axios.post('/jobfair/checkSameId', { user_id: this.id })
          .then(function (response) {
            console.log(response)
          })
          .catch(function (error) {
            console.log(error)
          })
    },
    // 회원가입 처리 메서드 (필수 체크 항목 체크했는지 확인)
    checkSubmit(e) {
      //이름 입력했는지 체크
      if(this.username === ''){
        this.$refs.nameBox.focus()
        e.preventDefault()
        return
      }
      //아이디 중복확인 통과했는지 체크
      if(this.idPassCheck === false){
        alert(this.msg)
        this.$refs.idBox.focus()
        e.preventDefault()
        return
      }
      //password 입력여부 체크
      if(this.password === ''){
        this.$refs.pwBox.focus()
        e.preventDefault()
        return
      }
      // password 유효성 검사 -> 8~20자의 영문,숫자,특수기호 포함 체크
      if( !this.passwordRule.test(this.password.trim()) ){
        this.$refs.pwBox.focus()
        alert('비밀번호는 영문,숫자,특수기호 포함 8~20자 이내어야 합니다.')
        e.preventDefault()
        return
      }
      //email 입력여부 체크
      if(this.email === ''){
        this.$refs.emailBox.focus()
        e.preventDefault()
        return
      }
      // email 형식 유효성 검사
      if( !this.emailRule.test(this.email.trim()) ){
        this.$refs.emailBox.focus()
        alert('이메일을 다시 확인해 주세요.')
        e.preventDefault()
        return
      }
      //휴대폰 번호 입력 체크
      if(this.phoneNum === ''){
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
        this.errorMsg.push({ msg : '필수 항목입니다.' }) //에러메시지 담기
        console.log(this.errorMsg)
        e.preventDefault()
        return
      }
      if (document.getElementById('agree2').checked === false) {
        alert("필수 항목을 확인해 주세요.")
        this.errorMsg.push({ msg : '필수 항목입니다.' }) //에러메시지 담기
        console.log(this.errorMsg)
        e.preventDefault()
      }
    },
    //개인회원,기업회원 버튼 클릭 시 맞는 폼태그 화면보이기 이벤트
    radioChange (e) {
      if(e.target.id === 'userType') this.show = false
      else this.show = true
    }
  }
}
</script>

<style scoped>
* {margin: 0; padding: 0}
a {text-decoration: none}
button {cursor: pointer}
/* 선택한 버튼 색깔변경 */
.select {
  margin-top: 50px;
  border: none;
}
.select input[type=radio]{
  display: none;
}
.select input[type=radio]+label{
  display: inline-block;
  cursor: pointer;
  height: 24px;
  width: 100px;
  line-height: 24px;
  text-align: center;
  font-weight:bold;
  font-size:23px;
}
.select input[type=radio]+label{
  background-color: rgb(95,75,229);
  color: #333;
}
.select input[type=radio]:checked+label{
  background-color: rgb(95,75,229,0.5);
  color: #fff;
}
.mainBox {
  width: 100%;
}
/* 개인회원 버튼 */
.leftBox a {
  font-size: large;
  color: black;
  text-align: center;
}
.leftBox {
  width: 50%;
  height: 50px;
  float: left;
  box-sizing: border-box;
  background-color: rgb(95,75,229);
  color: red;
  padding: 10px 10px;
}
/* 기업회원 버튼 */
.rightBox {
  width: 50%;
  height: 50px;
  float: right;
  box-sizing: border-box;
  background-color: rgb(95,75,229);
  padding: 10px 10px;
}
.rightBox a {
  font-size: large;
  color: black;
  text-align: center;
}
.UserBox {
  position: relative;
}
.CompanyBox {
  width: 100%;
  position: absolute;
  top: 500px;
  margin: 0 auto;
}
/* 정보입력란 */
.MemberInfo {
  display: flex;
  flex-direction: column;
}
.MemberInfo div {
  margin-top: 10px;
  margin-bottom: 10px;
}
.MemberInfo input {
  display: block;
  width: 90%;
  height: 50px;
}
/* 개인회원 인풋태그 위에 버튼 올리기 작업*/
.PersonUnder {
  position: absolute;
  width: 100%;
}
.PersonTop {
  position: relative;
  top: 12px;
  left: 450px;
  border: 2px solid #ddd;
  box-sizing: border-box;
  text-align: center;
  width: 100px;
}
/* 인증번호입력 확인/재전송버튼 위치설정 */
#leftBtn {
  position: relative;
  top: 12px;
  left: 450px;
  border: 2px solid #ddd;
  box-sizing: border-box;
  text-align: center;
  width: 50px;
}
#rightBtn {
  position: relative;
  top: 12px;
  left: 450px;
  border: 2px solid #ddd;
  box-sizing: border-box;
  text-align: center;
  width: 53px;
}
</style>