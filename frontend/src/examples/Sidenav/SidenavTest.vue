<template>
  <div class="pt-3 mx-3 mt-3 sidenav-footer">
    <div>
      <input type="radio" id="userType" style="display: none" name="selectType" class="leftBox" :checked="this.mg_auth">
      <label for="userType" :class="{ btn: true, 'btn-outline-dark': isClickedFirst }" @click="clickType">개인회원</label>
      <input type="radio" id="companyType" style="display: none" name="selectType" class="rightBox" :checked="!this.mg_auth">
      <label for="companyType" :class="{ btn: true, 'btn-outline-dark': isClickedSecond }" @click="clickType">기업회원</label>
    </div>
    <form>
      <input type="checkbox" name="" id="maintainCheck" value="maintainLogin">
      <label for="maintainCheck">로그인 유지</label>
      <input type="text" class="form-control" id="" placeholder="아이디">
      <input type="password" class="form-control" id="" placeholder="패스워드">
      <button type="submit" class="btn btn-primary">Sign in</button>
    </form>
    <router-link to="JoinView">회원가입</router-link>
  </div>
  <hr>
  <!-- https://getbootstrap.kr/docs/5.0/components/collapse/#accessibility -->
  <div class="accordion" id="accordionExample">
    <div class="accordion-item">
      <h2 class="accordion-he ader" id="headingOne">
        <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
          채용
        </button>
      </h2>
      <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
        <div class="accordion-body">
          <router-link to="uJobPostView">채용공고 리스트</router-link> <br/>
          <router-link to="uApplyListView">지원 목록</router-link>
        </div>
      </div>
    </div>
    <div class="accordion-item">
      <h2 class="accordion-header" id="headingTwo">
        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
          QnA
        </button>
      </h2>
      <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
        <div class="accordion-body">
          <router-link to="uJobPostView">채용공고 리스트</router-link> <br/>
          <router-link to="uApplyListView">지원 목록</router-link>
        </div>
      </div>
    </div>
    <div class="accordion-item">
      <h2 class="accordion-header" id="headingThree">
        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
          쪽지
        </button>
      </h2>
      <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree" data-bs-parent="#accordionExample">
        <div class="accordion-body">
          <router-link to="uJobPostView">채용공고 리스트</router-link> <br/>
          <router-link to="uApplyListView">지원 목록</router-link>
        </div>
      </div>
    </div>    <div class="accordion-item">
    <h2 class="accordion-header" id="headingFour">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
        마이페이지
      </button>
    </h2>
    <div id="collapseFour" class="accordion-collapse collapse" aria-labelledby="headingFour" data-bs-parent="#accordionExample">
      <div class="accordion-body">
        <router-link to="uJobPostView">채용공고 리스트</router-link> <br/>
        <router-link to="uApplyListView">지원 목록</router-link>
      </div>
    </div>
  </div>
  </div>
</template>
<script>
import SidenavCollapse from "./SidenavCollapse.vue";
import SidenavCard from "./SidenavCard.vue";
import Shop from "../../components/Icon/Shop.vue";
import Office from "../../components/Icon/Office.vue";
import CreditCard from "../../components/Icon/CreditCard.vue";
import Box3d from "../../components/Icon/Box3d.vue";
import CustomerSupport from "../../components/Icon/CustomerSupport.vue";
import Document from "../../components/Icon/Document.vue";
import Spaceship from "../../components/Icon/Spaceship.vue";
import Settings from "../../components/Icon/Settings.vue";

export default {
  name: "SidenavList",
  props: {
    cardBg: String,
  },
  data() {
    return {
      isClickedFirst: true,
      isClickedSecond: false,
      title: "Soft UI Dashboard PRO",
      controls: "dashboardsExamples",
      isActive: "active",
      mg_auth: ''
    };
  },
  components: {
    SidenavCollapse,
    SidenavCard,
    Shop,
    Office,
    CreditCard,
    Box3d,
    CustomerSupport,
    Document,
    Spaceship,
    Settings,
  },
  methods: {
    getRoute() {
      const routeArr = this.$route.path.split("/");
      return routeArr[1];
    },
    clickType (e) {
      if(e.target.htmlFor === 'userType') {
        this.isClickedFirst = true
        this.isClickedSecond = false
        this.$store.commit("setMg_auth", 1)
        this.mg_auth = 1
      }else{
        this.isClickedFirst = false
        this.isClickedSecond = true
        this.$store.commit("setMg_auth", 2)
        this.mg_auth = 2
      }
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
.userInfo_left{
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
.accordion-body a{
  list-style: none;
}
</style>
