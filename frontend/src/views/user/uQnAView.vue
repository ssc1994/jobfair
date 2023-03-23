<template>

  <div class="wrapBox">
    <div class="container ">
      <div class="row ">
        <div class="col-sm-12">

          <div class="qnaBox">
            <h3>Q&A</h3>
          </div>

          <table class="table table-bordered">
            <thead>
            <tr>
              <td>No</td>
              <td>작성자</td>
              <td>질문제목</td>
              <td>등록시간</td>
            </tr>
            </thead>
            <tbody>
            <tr v-for="(row, idx) in QnAList" :key=idx @click="detail(row.qa_num)">
              <td>{{idx + 1}}</td>
              <td>{{ row.user_id }}</td>
              <td>{{row.qa_title}}</td>
              <td>{{ row.qa_regDate.substring(0,10) }}</td>
            </tr>
            </tbody>
          </table>

        </div>

        <!--페이지네이션 부분-->
        <!--        <a @click="goFirstPage(page - 1)">&lt;</a>-->
        <!--        <a @click="goPrevPage(page - 1)">prev</a>-->

        <!--                <a v-for="(paging, index) in pageList" :key="index" @click="onPageChange(paging - 1)" :class="paging - 1 === page ? 'page' : ''">{{paging}}</a>-->

        <!--        <div v-for="(paging, index) in pageList" :key="index">-->
        <!--          <router-link to="{ path: '/uQnAView'+index }">{{ paging }}</router-link>-->
        <!--        </div>-->

        <!--        <a v-for="n in pageList" :key="n" :class="[n === ]"></a>-->

        <!--        <a v-for="(paging, index) in pageList" :key="index">{{ paging }}</a>-->

        <!--        <a v-for="(paging, index) in pageList" :key="index" @click="uQnAListAxios">{{paging}}</a>-->



        <!--        <a @click="goNextPage(page + 1)">next</a>-->
        <!--        <a @click="goLastPage(page + 1)">&gt;</a>      -->

        <ul class="pagination">
          <li class="page-item"><a class="page-link" href="#" @click="goFirstPage(page - 1)">First</a></li>
          <li class="page-item"><a class="page-link" href="#" @click="goPrevPage(page - 1)">Previous</a></li>
          <template v-for="(item, index) in pageList" :key="index">
            <li class="page-item" :class="{'active' : item == currentPage}"><span class="page-link" href="#" @click.prevent="ClickPage()" id="index">{{item}}</span></li>
          </template>
          <li class="page-item"><a class="page-link" href="#" @click="goNextPage(page + 1)">Next</a></li>
          <li class="page-item"><a class="page-link" href="#" @click="goLastPage(page + 1)">Last</a></li>
        </ul>




      </div>
    </div>

  </div>
</template>

<script>
import {ref} from "vue";

export default {
  // name: "uQnAView",
  // user_id: 'user123',
  // qa_num: '',

  data() {
    return {
      QnAList: [],
      QnADetailList: [],

      list: ref([]),
      cache: ref([]),

      currentPage: ref(0),

      isBtnFirst : ref(true),
      isBtnPrev : ref(true),
      isBtnNext : ref(true),
      isBtnLast : ref(true),

      // list: "",
      pages: "", // pageVO
      pageList: "", //pageVO.pageList 배열값
      detailNum: "",

      //페이지 이동에 필요한 초기값
      page: 1,
      amount: 10,
      prev: "",
      start: "",
      end: "",
      realEnd: "",


    };
  },

  props: {
    listArray: {
      type: Array,
      required: true
    }
  },

  watch() {
    this.uQnAListAxios();
  },

  created() {
    this.getQnAList();
    this.uQnAListAxios();
    this.uQnAGetTotal();
  },

  computed: {
    paginatedData() {
      return this.listArray.slice(this.pages.start, this.pages.end);
    }
  },

  methods: {
    addQnA() {
      this.$router.push("/uQnAWriteView")

    },
    getQnAList() {
      this.$axios.post('/jobfair/getQnAList')
          .then((res) => {
            this.QnAList = res.data
          })

          .catch((error) => console.log(error))

    },
    // getQnADetailList() {
    //   this.$axios.get('/jobfair/getQnADetailList?qa_num=' + this.qa_num)
    //       .then((res) => {
    //
    //         self.$router.push("/uQnADetailView")
    //       })
    //       .catch((error) => this.QnADetailList = error.date)
    // }
    detail(idx) {
      this.$router.push({
        //params를 넘겨줄 때엔 push할 때 path보단 name을 사용함
        name: 'uQnADetailView',
        params: {
          qa_num: idx
        }
      })
    },

    uQnAListAxios() {
      this.$axios.get("/jobfair/uQnAListAxios/?amount=" +
          this.amount +
          "&page=" +
          this.page)
          .then((res) => {
            console.log(11111111);
            console.log(res.data)
            console.log(222222222);

            this.list = res.data.list;
            this.pages = res.data.pageVO;
            this.pageList = this.pages.pageList;

            // console.log(this.pages.page)
            // console.log(this.pages.prev)
            // console.log(this.pages.start)
            // console.log(this.pages.end)
            // console.log(this.pages.realEnd)

            //페이지 이동에 필요한 데이터 담기
            this.page = this.pages.page;
            this.prev = this.pages.prev;
            this.start = this.pages.start;
            this.end = this.pages.end;
            this.realEnd = this.pages.realEnd;

          })
          .catch((error) => console.log(error))

    },
    uQnAGetTotal() {
      this.$axios.post("/jobfair/uQnAGetTotal")
          .then((res) => {
            console.log(res)
          })
          .catch((error) => console.log(error))
    },
    goFirstPage() {
      this.page = 1;
      this.uQnAListAxios();
    },
    goPrevPage() {
      if(this.page > 1) {
        this.page = this.page - 1;
      } else {
        alert("첫 페이지입니다.");
      }
    },
    goNextPage() {
      if(this.page < this.realEnd) {
        this.page = this.page + 1;
        this.uQnAListAxios();
      } else {
        alert("마지막 페이지입니다.")
      }
    },
    goLastPage() {
      this.page = this.realEnd;
      this.uQnAListAxios();
    },
    onPageChange(e) {
      this.$axios.post('/jobfair/uQnAListAxios', {
        amount: this.amount,
        page: this.e.target
      })
    },
    // pageArrow(e) {
    //   let movePage = parseInt(this.pages.page.value)
    //   if(e == 'first') {
    //     movePage = this.pages.start.value
    //   } else if(e == 'last') {
    //     movePage = this.pages.end.value
    //   } else if(e == 'prev') {
    //     movePage = this.pages.prev
    //   } else if(e == 'next') {
    //     movePage = this.pages.next
    //   }
    // },
    page(item) {
      console.log(item.currentTarget.id)

    },
    ClickPage() {
      var clicked = event.target.innerHTML;
      console.log(clicked)
    },






    // paging() {
    //   this.pageList.value = [];
    //
    //
    //
    // }
  }
}

</script>

<style scoped>

body, html {
  padding: 0;
  margin: 0;
}

.wrapBox {
  margin-top: 5%;
  margin-right: 10%;
}

.qnaBox {
  display: flex;
  justify-content: space-between;
  margin-bottom: 30px;
}

.qnaBox h3 {
  font-size: 350%;
}

.qnaBox button {
  border: none;
}

table {
  width: 100%;
  border: 1px solid #444444;
  border-collapse: collapse;
}

.table thead {
  background-color: grey;
  color: white;
}

.table tbody tr:last-child td {
  border-width: 1px;
}


</style>