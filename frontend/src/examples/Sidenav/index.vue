<template>
  <aside
    class="my-3 overflow-auto border-0 sidenav navbar navbar-vertical navbar-expand-xs border-radius-xl"
    :class="isRTL ? 'me-3 rotate-caret' : 'ms-3'"
    id="sidenav-main"
  >
    <div class="sidenav-header">
      <router-link class="navbar-brand" to="/">
        <img :src="logo" class="navbar-brand-img" alt="main_logo" />
      </router-link>
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
      logo
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
.sidenav .navbar-brand {
  padding: 0px;
  margin: 0px;
}
.navbar-brand-img {
  max-width: 200px;
  max-height: 30px;
}
</style>
