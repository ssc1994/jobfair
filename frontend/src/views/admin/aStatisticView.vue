<template>

  <div>
    <div>
      <form>
        <h3>기간별 지원자 통계</h3>
        <input type="text"/>
        <button>기간조회</button>
      </form>
      <div>
        성비 통계
      </div>
      <div>
        많이 찾는 비율
      </div>
    </div>

    <div>
      <form>
        <h3>업체별 모집공고 관련통계</h3>
        <input type="text"/>
        <button>기간조회</button>
      </form>

      <div>
        <p>가장 많이 찾은 공고</p>
        <table>
          <tr>
            <td>1</td>
            <td>기술영업 및 해외설치 시운전요원 모집</td>
          </tr>
          <tr>
            <td>2</td>
            <td>기술영업 및 해외설치 시운전요원 모집</td>
          </tr>
          <tr>
            <td>3</td>
            <td>기술영업 및 해외설치 시운전요원 모집</td>
          </tr>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "aStatisticView"
}
</script>

<style scoped>

</style>
