<template>
  <nav aria-label="breadcrumb">
    <ol
      class="px-0 pt-1 pb-0 mb-0 bg-transparent breadcrumb"
      :class="this.$store.state.isRTL ? '' : ' me-sm-6'"
    >

      <!--  상단에 현재 페이지 표시 ex) Pages/Dashboard    -->
      <li class="text-sm breadcrumb-item" :class="textWhite">
        <a :class="textWhite" class="opacity-8" href="#">메인페이지</a>
      </li>

      <!--  현재 위치한 페이지 표시    -->
      <li
        class="text-sm breadcrumb-item active"
        :class="textWhite ? 'text-white' : 'text-dark'"
        aria-current="page"
      >
        {{ currentPage }}
      </li>
    </ol>

    <!--  현재 위치한 페이지 표시    -->
    <h6 class="mb-0 font-weight-bolder" :class="textWhite ? 'text-white' : ''">
      {{ currentPage }}
    </h6>
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
    },
  },
};
</script>
