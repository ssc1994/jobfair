<template>
  <!--  SidenavList.vue 에서 가져온 auth값을 이용해서 사용자마다 다른 메뉴 출력하는 화면 만듦 -->
  <!--  <div v-if="menuTitle === '홈' || menuTitle === '마이 페이지' || (menuTitle === '채용 정보' && this.mg_auth === '1')">-->
  <div v-if="menuTitle != '채용 정보' || this.mg_auth != 3" class="menu_link">
    <div><router-link :to="link">{{ menuTitle }}</router-link></div>
  </div>

  <!--  <div v-if="menuTitle !='홈' && menuTitle != '마이 페이지' && (menuTitle != '채용 정보' || this.mg_auth != '1')">-->
  <div class="menu_dropdown" @mouseenter="visible" @mouseleave="visible" v-if="menuTitle === '채용 정보' && this.mg_auth === '3'">
    <div>{{ menuTitle }}</div>
    <div v-if="isVisible" style="border: 1px solid #AAAAAA; border-radius: 6px;">
      <ul v-for="menu in menuGroup">
        <li class="menu_child">
          <router-link :to="menu.menu_URL">{{ menu.menu_name }}</router-link>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "SideMenuList",
  props: [
    'menuTitle',
    'menu_id',
    'mg_auth'
  ],
  data () {
    return{
      isVisible: false,
      link: '',
      menuGroup: []
    }
  },
  created () {
    console.log(this.menuTitle)
    console.log(this.mg_auth)
    if(this.mg_auth === '1') {
      if (this.menuTitle === '홈') this.link = '/uMainView'
      else if (this.menuTitle === '마이 페이지') this.link = '/uMypageView'
      else if (this.menuTitle === '채용 정보') this.link = '/uJobPostView'
      else if (this.menuTitle === 'QnA') this.link = '/uQnAView'

    }
    else if(this.mg_auth  === '2' || this.mg_auth  === '3') {
      if(this.menuTitle === '홈') this.link = '/cMainView'
      else if(this.menuTitle ==='마이 페이지') this.link = '/cMypageView'
      else if (this.menuTitle === 'QnA') this.link = '/cQnAView'
    }
    else if(this.mg_auth  === '4') {
      if(this.menuTitle === '홈') this.link = '/aMainView'
      else if(this.menuTitle ==='채용 정보') this.link = '/aJobPostMngView'
      else if (this.menuTitle === 'QnA') this.link = '/aQnAView'
    }

    if(this.menu_id === 'p3') {
      //하위 메뉴 DB에서 가져오기
      this.$axios.post("/jobfair/sidebar/getMenu", {
        menu_id: this.menu_id,
        menu_auth: sessionStorage.getItem('sessionAuth')
      })
          .then(response => {
            this.menuGroup = response.data
          })
          .catch(error => {
            console.log(error)
          })
    }
  },
  methods: {
    visible () {
      this.isVisible = !this.isVisible
    }
  }
}
</script>

<style scoped>
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

ul, ol {
  list-style: none;
}

a {
  text-decoration: none;
  color: black;
}

.menu_link {
  color: #202632;
  height: 30px;
  font-size: 18px;
  font-weight: 700;
}
.menu_link:hover {
  color: #0064ff;
}

/* 드롭다운 메뉴 */
.menu_dropdown {
  color: #202632;
  font-size: 18px;
  font-weight: 700;
}
/* 드롭다운 자식메뉴 */
.menu_child {
  font-size: 15px;
  font-weight: 600;
}




</style>