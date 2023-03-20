<template>

  <div class="wrapBox">
    <div class="container ">
      <div class="row ">
        <div class="col-sm-12">

          <div class="qnaBox">
            <h3>Q&A</h3>
            <button @click.stop="addQnA">+ 질의 등록</button>
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
        <a @click="goFirstPage(page - 1)">&lt;</a>
        <a @click="goPrevPage(page - 1)">prev</a>

        <a v-for="(paging, index) in pageList" :key="index" @click="onPageChange(paging - 1)" :class="paging - 1 === page ? 'page' : ''">{{paging}}</a>


        <a @click="goNextPage(page + 1)">next</a>
        <a @click="goLastPage(page + 1)">&gt;</a>


      </div>
    </div>

  </div>
</template>

<script>
export default {
  // name: "uQnAView",
  // user_id: 'user123',
  // qa_num: '',

  data() {
    return {
      QnAList: [],
      QnADetailList: [],
      list: "",
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
  created() {
    this.getQnAList();
    this.uQnAListAxios();
    this.uQnAGetTotal();
  },

  // computed: {
  //   pagess: function () {
  //     const list = [];
  //     for(let index = this.start; index <= this.end; index++) {
  //       list.push(index);
  //     }
  //     return list;
  //   }
  // },

  methods: {
    addQnA() {
      this.$router.push("/uQnAWriteView")

    },
    getQnAList() {
      this.$axios.post('/jobfair/getQnAList')
          .then((res) => this.QnAList = res.data)
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
            console.log(res)
            this.list = res.data.list;
            this.pages = res.data.pageVO;
            this.pageList = this.pages.pageList;

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
    }
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