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
        <button type="button" class="btn">이력서 관리</button>
        <button type="button" class="btn">mypage</button>
      </div>

    </div>
  </div>
  <hr>

  <!-- 아코디언 -->
  <div id="app">

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
      title: "Soft UI Dashboard PRO",
      controls: "dashboardsExamples",
      isActive: "active",
      isOpen: false
    };
  },
  components: {
    SidenavCollapse,
    SidenavCard,
    Shop,
    Box3d,
    Document,
    Spaceship,
    Settings,
  },
  methods: {
    getRoute() {
      const routeArr = this.$route.path.split("/");
      return routeArr[1];
    },
    handleCollapse () {
      this.isOpen = !this.isOpen
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
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin-top: 60px;
}
</style>