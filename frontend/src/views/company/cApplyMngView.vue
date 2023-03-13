<template>
<div class="">
  <ApplicantList/>
</div>
</template>

<script>
import ApplicantList from "@/components/myComponent/ApplicantList";

export default {
  name: 'cApplyMngView',
  data () {
    return {

    }
  },
  components: {
    ApplicantList
  }
}
</script>

<style scoped>
* {margin: 0 auto; padding: 0;}
a {text-decoration: none; color: black}
a:hover {color: grey}

#dropdown-toggle {
  position: relative;
}

.dropdown-menu {
  position: absolute;
  text-align: center;
  width: auto;
  white-space: nowrap;
}
</style>
