<template>
  <div class="mainBox">
    <div class="UserBox">
      <div>
        <input type="radio" id="userType" name="selectType" class="leftBox" @change="changeJoinType($event)" :checked="this.mg_auth">
        <label for="userType">개인회원</label>
        <input type="radio" id="companyType" name="selectType" class="rightBox" @change="changeJoinType($event)" :checked="!this.mg_auth">
        <label for="companyType">기업회원</label>
      </div>
      <p>
        <strong :style="{color:'red'}">*</strong>는 필수입력 정보란입니다.
      </p>
      <div>
        <form @submit="checkSubmit($event)" action="/jobfair/uJoin" method="post">
          <p>*는 필수입력 정보란입니다.</p>
          <div>
            <input type="text" name="user_name" placeholder="이름(실명)" v-model = "username"/>
          </div>
          <div>
            <input type="text" name="user_id" placeholder="아이디" v-model = "id"/>
            <button @click="sameIdCheck">중복확인</button>
            <span>{{msg}}</span>
          </div>
          <div>
            <input type="password" name="user_pw" autoComplete="off" placeholder="비밀번호(8~16자의 영문,숫자,특수기호)" v-model = "password"/>
          </div>
          <div>
            <input type="text" name="user_email" placeholder="이메일" v-model = "email"/>
          </div>
          <div>
            <input type="text" name="user_phone" placeholder="휴대폰번호" v-model ="phone"/>
            <button>인증번호 전송</button>
          </div>
          <div>
            <input type="text" name="" placeholder="인증번호 입력" v-model ="certification_num">
            <button>확인</button>
            <button>재전송</button>
          </div>
          <div>
            <div>
              필수동의 항목 및 개인정보 수집 및 이용동의
              <input type="checkbox" id="agree1">
            </div>
            <div>
              개인정보 동의항목란
              <input type="checkbox" id="agree2">
            </div>

            <input type="submit" value="가입하기">
          </div>
        </form>
      </div>
    </div>

    <div :class="{ CompanyBox: true ,'display_hidden': this.mg_auth === '1' ? true : false }">
      <div>
        <div class="leftBox" @click="OpenForm($event)">
          <a href="#">개인회원</a>
        </div>
        <div class="rightBox">
          <a href="#">기업회원</a>
        </div>
        <p>
          <strong v-bind:style="{color:'red'}">*</strong>는 필수입력 정보란입니다.
        </p>
        <form class="MemberInfo">
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
          <div>
            <div>
              필수동의 항목 및 개인정보 수집 및 이용동의
              <input type="checkbox" value="checkedBox" v-model="checkbox">
            </div>
            <div>
              개인정보 동의항목란
              <input type="checkbox" value="checkedBox" v-model="checkbox">
            </div>

            <input type="submit" value="가입하기" @click="joinHandler(e)">
          </div>
        </form>
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
      mg_auth : this.$store.getters.getMg_auth,
      username: this.username,
      id: this.id,
      password: this.password,
      email: this.email,
      phone: this.phone,
      certification_num: this.certification_num,
      msg: '',
      checkedBox : [],
      errorMsg : [],
      sampleData: '',
      isActive: false,
      hasError: false,
      class2: ['active', 'hasError'],
      show: false
    }
  },
  mounted () {
    console.log(this.radioCheck)
  },
  methods: {
    // 아이디 중복확인 메서드
    sameIdCheck (e) {
      var self = this // axios 안에서 this 키워드 동작 제대로 안되서 여기서 변수로 선언해줌
      this.$axios.post('/jobfair/checkSameId', { user_id: this.id })
        .then(function (response) {
          console.log(response)
          self.msg = response.data
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    // 회원가입 처리 메서드
    checkSubmit(e) {
      if (document.getElementById('agree1').checked === false) {
        alert("필수 항목을 확인해 주세요.")
        this.errorMsg.push({ msg : '필수 항목입니다.' }) //에러메시지 담기
        console.log(this.errorMsg)
        e.preventDefault()
      }
    },
    clickHandler () {
      this.hasError = !this.hasError
      this.isActive = !this.isActive
    },
    ComclickHandler () {
      this.hasError = !this.hasError
      this.isActive = !this.isActive
      this.show = !this.show
    },
    // 개인, 기업 회원가입 구분 메서드
    changeJoinType(e) {
      if(e.target.id === 'userType') {
        this.mg_auth = '1';
        this.$store.commit("setMg_auth", "1")
      }
      else {
        this.mg_auth = '2';
        this.$store.commit("setMg_auth", "2")
      }
      console.log(this.mg_auth)
    }
  }
}
</script>

<style scoped>
* {margin: 0; padding: 0}
a {text-decoration: none}
button {cursor: pointer}

.mainBox {
  width: 100%;
  border: 3px solid;
}
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
  padding: 10px 10px;
}
.leftBox:hover{
  background-color: rgb(95,75,229,0.5);
}

.rightBox {
  width: 50%;
  height: 50px;
  float: right;
  box-sizing: border-box;
  background-color: rgb(95,75,229);
  padding: 10px 10px;
}
.rightBox:hover{
  background-color: rgb(95,75,229,0.5);
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
  top: 344px;
  margin: 0 auto;
}

.MemberInfo {
  display: flex;
  flex-direction: column;
}
.MemberInfo div {
  margin-top: 8px;
  margin-bottom: 8px;
}
.MemberInfo input {
  display: block;
  width: 90%;
  height: 60px;
}
.PhoneRegist {
  position: relative;
}
.PhoneYN {
  position: relative;
}
#leftBtn {
  position: absolute;
  float: left;
  top: 0;
  right: 130px;
  width: 150px;
  height: 64px;
  border: 2px solid #ddd;
  box-sizing: border-box;
  text-align: center;
}
#rightBtn {
  position: absolute;
  float: right;
  top: 0;
  right: 290px;
  width: 150px;
  height: 64px;
  border: 2px solid #ddd;
  box-sizing: border-box;
  text-align: center;
}
#PhoneBtn {
  display: block;
  position: absolute;
  top: 0;
  right: 130px;
  width: 150px;
  height: 64px;
  border: 2px solid #ddd;
  box-sizing: border-box;
  text-align: center;
}
  .mainBox {
    width: 100%;
    border: 3px solid;
  }
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
    padding: 10px 10px;
  }
  .leftBox:hover{
    background-color: rgb(95,75,229,0.5);
  }

  .rightBox {
    width: 50%;
    height: 50px;
    float: right;
    box-sizing: border-box;
    background-color: rgb(95,75,229);
    padding: 10px 10px;
  }
  .rightBox:hover{
    background-color: rgb(95,75,229,0.5);
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
    top: 120px;
    border: 3px solid skyblue;
    margin: 0 auto;
  }

  .MemberInfo {
    display: flex;
    flex-direction: column;
  }
  .MemberInfo div {
    margin-top: 8px;
    margin-bottom: 8px;
  }
  .MemberInfo input {
    display: block;
    width: 90%;
    height: 60px;
  }
  .PhoneRegist {
    position: relative;
  }
  .PhoneYN {
    position: relative;
  }
  #leftBtn {
    position: absolute;
    float: left;
    top: 0;
    right: 130px;
    width: 150px;
    height: 64px;
    border: 2px solid #ddd;
    box-sizing: border-box;
    text-align: center;
  }
  #rightBtn {
    position: absolute;
    float: right;
    top: 0;
    right: 290px;
    width: 150px;
    height: 64px;
    border: 2px solid #ddd;
    box-sizing: border-box;
    text-align: center;
  }
  #PhoneBtn {
    display: block;
    position: absolute;
    top: 0;
    right: 130px;
    width: 150px;
    height: 64px;
    border: 2px solid #ddd;
    box-sizing: border-box;
    text-align: center;
  }

  .display_hidden{
    display: none;
  }
</style>
