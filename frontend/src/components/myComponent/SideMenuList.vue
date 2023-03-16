<template>
<!--  SidenavList.vue 에서 가져온 auth값을 이용해서 사용자마다 다른 메뉴 출력하는 화면 만듦 -->
  <div v-if="menuTitle === '1'">
    <div @click="visible">채용</div>
    <div v-if="isVisible">
      <ul>
        <li>
          <router-link to="uJobPostView">채용공고리스트</router-link>
        </li>
      </ul>
    </div>
    <div @click="visible">QnA</div>
    <div v-if="isVisible">
      <ul>
        <li>
          <router-link to="uQnaView">QnA리스트</router-link>
        </li>
      </ul>
    </div>
  </div>
  <div v-if="menuTitle === '2'">
    <div @click="visible">채용</div>
    <div v-if="isVisible">
      <ul>
        <li>
          <router-link to="cEmpRegView">채용공고등록</router-link>
        </li>
        <li>
          <router-link to="cEmpModiView">채용공고수정</router-link>
        </li>
        <li>
          <router-link to="cJobPostListView">나의 채용공고</router-link>
        </li>
      </ul>
    </div>
  </div>
  <div v-if="menuTitle === '4'">
    <div @click="visible">Menu</div>
    <div v-if="isVisible">
      <ul>
        <li>
          <router-link to="uApplyListView">유조지원관리</router-link>
        </li>
        <li>
          <router-link to="uJobPostView" class="routerLink">유조리스트</router-link>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: "SideMenuList",
  props: [
    'menuTitle'
  ],
  data () {
    return{
      isVisible: true
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
</style>