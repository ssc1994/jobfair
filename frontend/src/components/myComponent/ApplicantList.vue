<template>
  <div class="card mb-4">
    <div class="card-header pb-0">
      <h6 @click="test">우리 회사가 등록한 채용공고</h6>
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
                둥록일
              </th>
              <th class="text-center text-uppercase text-secondary text-s font-weight-bolder">
                종료일
              </th>
              <th class="text-center text-uppercase text-secondary text-s font-weight-bolder">
                상태
              </th>
            </tr>
          </thead>
          <tbody :key="index" v-for="(jpl, index) in jplList">
            <TableAccordian :jpl_title=jpl.jpl_title count-cdd="99" :jpl_reg-date=jpl.jpl_regDate :jpl_end-date=jpl.jpl_endDate />
<!--            <TableAccordian jpl_title="2023 상반기 삼성그룹 신입사원 채용" count-cdd="544" jpl_reg-date="23-03-01" jpl_end-date="23-03-31"/>-->
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
import TableAccordian from "@/components/myComponent/TableAccordian";
import {user_id, mg_auth, com_num} from 'vuex';

export default {
  name: "authors-table",
  data() {
    return {
      user_id: '',
      mg_auth: '',
      com_num: '',
      jplList: [],
    };
  },
  methods: {
    test () {
      console.log("test")
      console.log(this.user_id);
      console.log(this.mg_auth);
      console.log(this.com_num);
    }
  },
  components: {
    TableAccordian
  },
  created () {
        // this.user_id = this.$store.getters.getUser_id,
        // this.mg_auth = this.$store.getters.getMg_auth;
        // this.com_num = this.$store.getters.getCom_num;
    let sessionId = sessionStorage.getItem('sessionId')
    let sessionAuth = sessionStorage.getItem('sessionAuth')
    let sessionComNum = sessionStorage.getItem('sessionComp')
    if(sessionId && typeof sessionId === 'string' && sessionId !== '') {
      this.user_id = JSON.parse(sessionId)
    }
    if(sessionAuth && typeof sessionAuth === 'string' && sessionAuth !== '') {
      this.mg_auth = JSON.parse(sessionAuth)
    }
    if(sessionComNum && typeof sessionComNum === 'string' && sessionAuth !== '') {
      this.com_num = JSON.parse(sessionComNum)
    }

    let data = {
      com_num: this.com_num
    }
    this.$axios.post("/jobfair/getComJobPosingList", data)
        .then(res => {
          this.jplList = res.data;
        })
        .catch(error => {
          console.log(error)
        })
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