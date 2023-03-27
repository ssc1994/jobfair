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
          <tbody :key="index" v-for="(jpl, index) in jplList">
            <TableAccordian :jplInfo="jpl" :countCdd="countAppList[index]"/>
          </tbody>
          <div class="paginationWrap">
            <ul class="pagination">
              <li class="page-item"><a class="page-link"  @click="goFirstPage(page - 1)" style="margin-right: 10px">First</a></li>
              <li class="page-item"><a class="page-link"  @click="goPrevPage(page - 1)" style="margin-right: 10px" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
              <template v-for="(item, index) in pageVO.pageList" :key="index">
                <li class="page-item" :class="{'active' : item == this.page}"><span class="page-link"  @click.prevent="ClickPage($event), getJplList()" id="index">{{item}}</span></li>
              </template>
              <li class="page-item"><a class="page-link"  @click="goNextPage(page + 1)" style="margin-right: 10px" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
              <li class="page-item"><a class="page-link"  @click="goLastPage(page + 1)" style="margin-right: 10px">Last</a></li>
            </ul>
          </div>

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
      //페이지네이션 관련
      jplList: [], //받아온 기업 공고리스트 담을 변수
      pageVO: "", //pageVO
      pageList: [], //pageVO.pageList 배열값
      detailNum: "",
      //페이지 이동에 필요한 초기값
      page: 1,
      amount: 10,
      prev: '',
      start: '',
      end: '',
      realEnd: '',
      countAppList: []
    };
  },
  methods: {
    //페이지 네이션 부분
    goFirstPage() {
      this.page = 1;
      this.getComList();
    },
    goPrevPage() {
      if(this.page > 1) {
        this.page = this.page - 1;
        this.getComList();
      } else {
        alert("첫 페이지입니다.");
      }
    },
    goNextPage() {
      if(this.page < this.realEnd) {
        this.page = this.page + 1;
        this.getComList();
      } else {
        alert("마지막 페이지입니다.")
      }
    },
    goLastPage() {
      this.page = this.realEnd;
      this.getComList();
    },
    ClickPage(e) {
      var clicked = e.target.innerHTML;
      this.page = clicked
    },
    async getJplList () {
      let jplData = {
        com_num: this.com_num,
            page: this.page,
          amount: this.amount,
      }

      let res = await this.$axios.post("/jobfair/getComJobPosingList",
          jplData) .catch( err => console.log(err))
      this.pageVO = res.data.pageVO;
      this.jplList = res.data.jplList;
      this.countAppList = res.data.countAppList;
    }

  },
  components: {
    TableAccordian
  },
  created () {
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

    this.getJplList ()
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

/* 페이지네이션 부분 */

.paginationWrap .page-link {
  background-color: white;
}

.paginationWrap li.active span {
  background-color: #202632;
  border: none;
}

.pagination {
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 20px 0;
}

.page-item {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-right: 10px;
}

.page-link {
  color: #333;
  border: none;
  background: none;
  cursor: pointer;
}

.page-link:hover {
  color: #0064ff;
}

.active .page-link {
  color: #fff;
  background-color: #007bff;
  border-color: #007bff;
}

</style>
