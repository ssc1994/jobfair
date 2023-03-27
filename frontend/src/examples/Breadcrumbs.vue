<template>
  <nav aria-label="breadcrumb">
<!-- 헤더부분에서 어떤 페이지인지 보여주는 곳 -->
    <!--  현재 위치한 페이지 표시    -->
<!--    <h6 class="mb-0 font-weight-bolder" :class="textWhite ? 'text-white' : ''">-->
<!--      {{ currentPage }}-->
<!--    </h6>-->
  </nav>
</template>

<script>
export default {
  name: "breadcrumbs",
  props: {
    currentPage: {
      required: true,
    },
    textWhite: {
      type: String,
    }
  }
}
</script>
