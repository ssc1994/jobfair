<template>
  <div class="wrapBox" style="height: 2000px">
    <div class="wrapBox2">
      <div class="container empBoxWrap">
        <img src="@/assets/mainImg.png" style="width: 1500px">
        <div>
          <h3 style="margin-top: 20px">채용공고</h3>
        </div>


        <div>
          <div class="row" style="margin-top: 20px">
            <router-link to="" class="hotBoxWrap" v-for="(data, i) in mainJobInfo" :key="i"
                         @click.prevent="jobPostDetail(data.jpl_num)">
              <div>
                <img :src="data.url" alt="이미지" style="height: 250px">
              </div>
              <div class="hotText">
                <div>{{ data.com_name }}</div>
                <p class="hotTitle">
                  {{ data.jpl_title }}
                </p>

                <span class="hotDday">
                  마감일 {{ data.jpl_endDate }}
                </span>

              </div>
            </router-link>
          </div>
        </div>
      </div>
    </div>

    <div class="QnAWrap">
      <div className="container ">
        <div className="row ">
          <div className="col-sm-12">

            <div className="qnaBox">
              <h3 @click.prevent="goToQnAList">Q&A</h3>
            </div>

            <table id="qnaTable">
              <thead>
              <tr style="background-color: #0064ff; color: antiquewhite; height: 60px; font-size: 20px">
                <td style="text-align: center; width: 200px; ">No</td>
                <td style="text-align: center; width: 400px">작성자</td>
                <td style="text-align: center; width: 700px">질문제목</td>
                <td style="text-align: center; width: 400px">등록시간</td>
              </tr>
              </thead>
              <tbody>
              <tr v-for="(row, idx) in QnAList" :key=idx @click.prevent="detail(row.qa_num)">
                <td style="text-align: center">{{ idx + 1 }}</td>
                <td>{{ row.user_id }}</td>
                <td style="text-align: center">{{ row.qa_title }}</td>
                <td style="text-align: center">{{ row.qa_regDate.substring(0, 10) }}</td>
              </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>


</template>

<script>

export default {
  name: 'uMainView',

  data() {
    return {
      QnAList: [],
      mainJobInfo: {
        jpl_num: '',
        jpl_title: '',
        jpl_endDate: '',
        jpl_fileName: '',
        jpl_filePath: '',
        jpl_fileUuid: '',
        com_num: '',
      },

      dDay: '',
      sysDate: '',
      endDate: '',
      diffTime: '',
    }

  },

  beforeCreate() {

  },

  created() {
    this.getQnAList();
    this.$axios.post('/jobfair/getMainJobInfo')
        .then((res) => {
          this.mainJobInfo = res.data;

          for (var i = 0; i < res.data.length; i++) {
            this.jpl_title = JSON.stringify(res.data[i].jpl_title),
                this.jpl_endDate = JSON.stringify(res.data[i].jpl_endDate),
                this.jpl_fileName = JSON.stringify(res.data[i].jpl_fileName),
                this.jpl_fileUuid = JSON.stringify(res.data[i].jpl_fileUuid),
                this.jpl_filePath = JSON.stringify(res.data[i].jpl_filePath)

          }


          console.log("ddd" + JSON.stringify(res.data[1].jpl_endDate))
          console.log("kk" + JSON.stringify(this.jpl_title))

        })
        .catch((error) => {
          console.log(error)
        })

  },

  methods: {
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
    goToQnAList() {
      this.$router.push('/uQnAView')
    },

    jobPostDetail(jobpost) {
      this.$router.push({
        name: 'uJobPostDetailView',
        params: {
          jpl_num: jobpost
        }
      })
    },
    getMainJobInfo() {
      this.$axios.post('/jobfair/getMainJobInfo')
          .then((res) => {
            this.mainJobInfo = res.data;
          })
          .catch((error) => {
            console.log(error)
          })
    },

  }

}
</script>

<style scoped>


html, body {
  width: 100%;
  height: 100%;
}

.left {
  float: left;
}

.right {
  float: right;
}

h3 {
  font-weight: bold;
  font-size: 20px;
  padding: 20px;
}

.wrapBox {
  height: 1300px;
}

.empBoxWrap {
  max-width: 1560px;
  margin: 0 auto;
  height: 100%;
}

/*hot 채용정보*/
.hotBoxWrap {
  border: 1px solid #dedede;
  border-radius: 20px;
  width: 23%;
  color: black;
  text-decoration: none;
  padding: 20px;
  margin-left: 1%;
  margin-bottom: 1%;
}

.hotBoxWrap:hover {
  border: 1px solid #0064ff;
  box-shadow: rgba(0, 0, 0, 0.16) 0px 10px 36px 0px, rgba(0, 0, 0, 0.06) 0px 0px 0px 1px;

}

.hotBoxWrap img {
  width: 100%;
  padding: 40px;
}

.hotTitle {
  font-size: 18px;
  font-weight: bold;

}

.hotText {
  border-top: 1px solid #dedede;
  padding-top: 10px;
}

.hotDday {
  font-weight: bold;
  padding: 5px 15px;
  color: rgb(229, 75, 75);
  border: 1px solid rgb(229, 75, 75);
  border-radius: 20px;
}

.wrapBox2 {
  display: flex;
  justify-content: center;
  height: 500px;
}

.QnAWrap {
  display: flex;
  justify-content: space-between;
  margin-bottom: 30px;
  position: relative;
  top: 900px;
}

.qnaBox h3 {
  font-weight: bold;
  font-size: 23px;
  padding: 20px;
  position: relative;
  right: 130px;
  color: #202632;
  margin-top: 50px;
  cursor: pointer;
}

#qnaTable {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  border: 1px solid #444444;
  width: 1500px;
  position: relative;
  right: 120px;

}

#qnaTable tbody {
  cursor: pointer;
}

#qnaTable td, #qnaTable th {
  border: 1px solid #ddd;
  padding: 8px;
}

#qnaTable tr:nth-child(even) {
  background-color: #f2f2f2;
}

#qnaTable tr:hover {
  background-color: #ddd;
}

#qnaTable th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  color: white;
}

</style>
