<template>
  <nav
      class="shadow-none navbar navbar-main navbar-expand-lg border-radius-xl"
      v-bind="$attrs"
      id="navbarBlur"
      data-scroll="true"
  >
    <div class="px-3 py-1 container-fluid">
      <breadcrumbs :currentPage="currentRouteName" :textWhite="textWhite" />
      <div
          class="mt-2 collapse navbar-collapse mt-sm-0 me-md-0 me-sm-4"
          :class="this.$store.state.isRTL ? 'px-0' : 'me-sm-4'"
          id="navbar"
      >
        <div
            class="pe-md-3 d-flex align-items-center"
            :class="this.$store.state.isRTL ? 'me-md-auto' : 'ms-md-auto'"
        >
        </div>
      </div>
    </div>
  </nav>
</template>
<script>
import Breadcrumbs from "../Breadcrumbs.vue";
import { mapMutations, mapActions } from "vuex";

export default {
  name: "navbar",
  data() {
    return {
      showMenu: false,
    };
  },
  props: ["minNav", "textWhite"],
  created() {
    this.minNav;
  },
  methods: {
    ...mapMutations(["navbarMinimize", "toggleConfigurator"]),
    ...mapActions(["toggleSidebarColor"]),

    toggleSidebar() {
      this.toggleSidebarColor("bg-white");
      this.navbarMinimize();
    },
  },
  components: {
    Breadcrumbs,
  },
  computed: {
    currentRouteName() {
      return this.$route.name;
    },
  },
};
</script>
