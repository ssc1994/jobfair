<template>
  <div class="card mb-4">
    <div class="card-header pb-0">
      <h6>우리 회사가 등록한 채용공고</h6>
    </div>
    <div class="card-body px-0 pt-0 pb-2">
      <div class="table-responsive p-0">
        <table class="table align-items-center mb-0">
          <thead>
            <tr>
              <th  class="text-uppercase text-secondary text-s font-weight-bolder">
                채용공고 목록
              </th>
              <th class="text-uppercase text-secondary text-s font-weight-bolder opacity-7 ps-2">
                지원자 수
              </th>
              <th class="text-center text-uppercase text-secondary text-s font-weight-bolder">
                등록일
              </th>
              <th class="text-center text-uppercase text-secondary text-s font-weight-bolder">
                종료일
              </th>
              <th class="text-center text-uppercase text-secondary text-s font-weight-bolder">
                상태
              </th>
            </tr>
          </thead>
          <tbody>
            <TableAccordian jpl_title="한솔테크닉스 2023년 신입/경력 채용" count-cdd="99" jpl_reg-date="23-03-01" jpl_end-date="23-03-31"/>
            <TableAccordian jpl_title="2023 상반기 삼성그룹 신입사원 채용" count-cdd="544" jpl_reg-date="23-03-01" jpl_end-date="23-03-31"/>
            <TableAccordian jpl_title="2023년 신입사원 인재 영입" count-cdd="222" jpl_reg-date="23-03-01" jpl_end-date="23-03-31"/>
            <TableAccordian jpl_title="2023년 상반기 포스코그룹 신입/경력 채용" count-cdd="894" jpl_reg-date="23-03-01" jpl_end-date="23-03-31"/>
            <TableAccordian jpl_title="한솔테크닉스 2023년 신입/경력 채용" count-cdd="80" jpl_reg-date="23-03-01" jpl_end-date="23-03-31"/>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
import TableAccordian from "@/components/myComponent/TableAccordian";

export default {
  name: "authors-table",
  data() {
    return {

    };
  },
  methods: {
    test () {
      console.log("test")
    }
  },
  components: {
    TableAccordian
  }
};
</script>

<style scoped>
.align-middle label {
  font-size: 15px;
}
.card {
  width:95%;
  margin-top: 50px;
}

</style>