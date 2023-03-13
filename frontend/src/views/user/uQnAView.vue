<template>

  <div class="wrapBox">
    <div class="container ">
      <div class="row ">
        <div class="col-sm-12">

          <div class="qnaBox">
            <h3>Q&A</h3>
            <button @click.stop="addQnA">+ 질의 등록</button>
          </div>

          <table class="table table-bordered" @click.stop="clickQnA">
            <thead>
            <tr>
              <td>No</td>
              <td>작성자</td>
              <td>질문제목</td>
              <td>등록시간</td>
            </tr>
            </thead>
            <tbody>
            <tr v-for="(row, idx) in list" :key="idx">
              <td>{{row.idx}}</td>
              <td>{{ row.user_id }}</td>
              <td><a v-on:click="clickQnA('${row.idx}')">{{row.title}}</a></td>
              <td>{{ row.qa_regdate }}</td>
            </tr>
            </tbody>
          </table>


        </div>
      </div>
    </div>

  </div>
</template>

<script>
export default {
  name: "uQnAView",

  data() {
    return {
      list: {
        qa_num: 'list[]',
        user_id: '',
        qa_title: '',
        qa_regdate: ''
      },
      items: [],
    }
  },
  created() {
    this.$axios
        .post("/jobfair/getQnAList")
        .then((res) => {

        })
        .catch((error) => {

    })

  },
  methods: {
    addQnA() {
      this.$router.push("/uQnAWriteView")

    },
    getQnAList() {
      this.axios.get('/getQnAList',
          {
            params: {}
          })
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
