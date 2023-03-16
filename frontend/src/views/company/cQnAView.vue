<template>

  <div className="wrapBox">
    <div className="container ">
      <div className="row ">
        <div className="col-sm-12">

          <div className="qnaBox">
            <h3>Q&A</h3>
          </div>

          <table className="table table-bordered">
            <thead>
            <tr>
              <td>No</td>
              <td>작성자</td>
              <td>질문제목</td>
              <td>등록시간</td>
            </tr>
            </thead>
            <tbody>
            <tr v-for="(row, idx) in QnAList" :key=idx @click.prevent="detail(row.qa_num)">
              <td>{{idx + 1}}</td>
              <td>{{ row.user_id }}</td>
              <td>{{row.qa_title}}</td>
              <td>{{ row.qa_regDate.substring(0,10) }}</td>
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
  com_num: 'com456',

  data() {
    return {
      QnAList: []
    };
  },
  created() {
    this.cgetQnAList();
  },
  methods: {
    cgetQnAList() {
      this.$axios.post('/jobfair/cgetQnAList')
          .then((res) => {this.QnAList = res.data
          }
          )
          .catch((error) => this.QnAList = error.data)

    },
    detail(idx) {
      this.$router.push({
        //params를 넘겨줄 때엔 push할 때 path보단 name을 사용함
        name: 'cQnADetailView',
        params: {
          qa_num: idx
        }
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
