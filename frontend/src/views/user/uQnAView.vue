<template>

  <div class="wrapBox">
    <div class="container ">
      <div class="row ">
        <div class="col-sm-12">

          <div class="qnaBox">
            <h3>Q&A</h3>
            <button @click.stop="addQnA">+ 질의 등록</button>
          </div>

          <table id="qnaTable">
            <thead>
            <tr style="background-color: #0064ff; color: antiquewhite; height: 60px; font-size: 20px">
              <td style="text-align: center; width: 100px; ">No</td>
              <td style="text-align: center; width: 200px">작성자</td>
              <td style="text-align: center; width: 500px">질문제목</td>
              <td style="text-align: center; width: 200px">등록시간</td>
            </tr>
            </thead>
            <tbody>
            <tr v-for="(row, idx) in QnAList" :key=idx @click="detail(row.qa_num)">
              <td style="text-align: center">{{idx + 1}}</td>
              <td style="text-align: center">{{ row.user_id }}</td>
              <td>{{row.qa_title}}</td>
              <td style="text-align: center">{{ row.qa_regDate.substring(0,10) }}</td>
            </tr>
            </tbody>
          </table>

        </div>
        <div class="paginationWrap">
          <ul class="pagination">
            <li class="page-item"><a class="page-link" href="#" @click="goFirstPage(page - 1)" style="margin-right: 10px">First</a></li>
            <li class="page-item"><a class="page-link" href="#" @click="goPrevPage(page - 1)" style="margin-right: 10px">Previous</a></li>
            <template v-for="(item, index) in pageList" :key="index">
              <li class="page-item" :class="{'active' : item == this.page}"><span class="page-link" href="#" @click.prevent="ClickPage" id="index">{{item}}</span></li>
            </template>
            <li class="page-item"><a class="page-link" href="#" @click="goNextPage(page + 1)" style="margin-right: 10px">Next</a></li>
            <li class="page-item"><a class="page-link" href="#" @click="goLastPage(page + 1)" style="margin-right: 10px">Last</a></li>
          </ul>
        </div>


      </div>
    </div>

  </div>
</template>

<script>

export default {

  data() {
    return {
      QnAList: [],
      QnADetailList: [],
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

  watch: {
    page: function () {
      this.uQnAListAxios();
    },
  },

  created() {
    this.getQnAList();
    this.uQnAListAxios();
  },

  methods: {
    addQnA() {
      this.$router.push({name: "uQnAWriteView", params: {com_num: -1}});

    },
    getQnAList() {
      this.$axios.post('/jobfair/getQnAList')
          .then((res) => {
            this.QnAList = res.data
          })

          .catch((error) => console.log(error))

    },

    detail(idx) {
      this.$router.push({
        //params를 넘겨줄 때엔 push할 때 path보단 name을 사용함
        name: 'uQnADetailView',
        params: {
          qa_num: idx
        }
      })
    },

    async uQnAListAxios() {

      let res =  await this.$axios.get("/jobfair/uQnAListAxios/?amount=" +
          this.amount +
          "&page=" +
          this.page);
      this.list = res.data.list;

            this.list = res.data.list;
            this.pages = res.data.pageVO;
            this.pageList = this.pages.pageList;
            this.QnAList = res.data.list;


            //페이지 이동에 필요한 데이터 담기
            this.page = this.pages.page;
            this.prev = this.pages.prev;
            this.start = this.pages.start;
            this.end = this.pages.end;
            this.realEnd = this.pages.realEnd;

    },

    goFirstPage() {
      this.page = 1;
      this.uQnAListAxios();
    },
    goPrevPage() {
      if(this.page > 1) {
        this.page = this.page - 1;
        this.uQnAListAxios();
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

    ClickPage() {
      var clicked = event.target.innerHTML;
      this.page = clicked;
    },

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
}

.qnaBox h3 {
  font-weight: bold;
  font-size: 20px;
  padding:20px;
  color: #202632;
}

.qnaBox button {
  border: none;
}

.paginationWrap ul {
  margin-top: 50px;
  padding-left: 470px;
}

.paginationWrap .page-link {
  background-color: #0064ff;
}

.paginationWrap li.active span {
  background-color: #202632;
  border: none;
}

#qnaTable {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
  border: 1px solid #444444;
  border-collapse: collapse;
}

#qnaTable td, #qnaTable th {
  border: 1px solid #ddd;
  padding: 8px;
}

#qnaTable tr:nth-child(even){background-color: #f2f2f2;}

#qnaTable tr:hover {background-color: #ddd;}

#qnaTable th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}


</style>