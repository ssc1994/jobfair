<template>
  <aside
    class="my-3 sidenav navbar navbar-vertical navbar-expand-xs box"
    :class="isRTL ? 'me-3 rotate-caret' : 'ms-3'"
    id="sidenav-main"
  >
    <div class="side-header" @click="clickHome">
        <img :src="logo" class="HomeLogo" alt="main_logo"/>
    </div>
    <hr class="mt-0 horizontal dark" />
    <sidenav-list :cardBg="customClass" />
  </aside>
</template>
<script>
// logo가 로고이미지를 변경해주는곳임 이미지 변경은 여기서 임포트해서 변경하면됨
import SidenavList from "./SidenavList.vue";
import logo from "@/assets/img/homeLogo.png";
import { mapState } from "vuex";

export default {
  name: "index",
  components: {
    SidenavList
  },
  data() {
    return {
      mg_auth: JSON.parse(sessionStorage.getItem('sessionAuth')),
      logo
    }
  },
  methods: {
    clickHome(){
      // console.log(this.mg_auth)
      if(this.mg_auth === '1'){
        this.$router.push('/uMainView')
      }else if(this.mg_auth === '2' || this.mg_auth === '3'){
        this.$router.push('/cMainView')
      }else if(this.mg_auth === '4'){
        this.$router.push('/aMainView')
      }
    }

  },
  props: {
    customClass: {
      type: String,
      default: "",
    },
  },
  computed: {
    ...mapState(["isRTL"])
  },
}
</script>
<style>
.side-header {
  display: flex;
  justify-content: center;
  cursor: pointer;
}
.HomeLogo {
  width: 200px;
  height: 85px;
  margin-bottom: 20px;
  display: block;
}
</style>
