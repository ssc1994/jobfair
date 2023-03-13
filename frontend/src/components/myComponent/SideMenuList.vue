<template>
  <div>
    <div @click="visible">{{ menuTitle }}</div>
    <div v-if="isVisible">
      <ul>
        <li>
          <router-link to="uApplyListView">지원관리</router-link>
        </li>
        <li>
          <router-link to="uJobPostView" class="routerLink">리스트</router-link>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: "Test",
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

</style>