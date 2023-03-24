<template>
  <div class="wrapBox" style="height: 2000px">
    <div class="wrapBox2">
    <div class="container empBoxWrap">
      <img src="@/assets/mainImg.png" style="width: 1500px">
        <div>
          <h3 style="margin-top: 20px">HOT 채용공고</h3>
        </div>


        <div>
          <div class="row" style="margin-top: 20px">
            <router-link to="" class="hotBoxWrap" v-for="(data, i) in mainJobInfo" :key="i">
              <div>
                <img :src="data.url" alt="이미지">
              </div>
              <div class="hotText">
                <div>{{ data.com_name }}</div>
                <p class="hotTitle">
                  {{ data.jpl_title }}
                </p>

<!--                <span class="hotDday">-->
<!--                  {{diffTime}}-->
<!--                </span>-->

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
                <td style="text-align: center">{{idx + 1}}</td>
                <td>{{ row.user_id }}</td>
                <td style="text-align: center">{{row.qa_title}}</td>
                <td style="text-align: center">{{ row.qa_regDate.substring(0,10) }}</td>
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
import moment from "moment/moment";

export default {
  name: 'uMainView',

  data() {
    return {
      QnAList: [],
      mainJobInfo: [],
      jpl_endDate : [],


      diffTime: '',
      diffDay: '',
      year: '',
      month: '',
      day: '',
      curTime: '',
      inputTime:'',
    }


  },
  mounted() {
    setInterval(this.getDate,86400);
    this.getDate();

  },

  beforeCreate() {




  },

  created() {
    this.getQnAList();

    this.$axios.post('/jobfair/getMainJobInfo')
        .then((res) => {
          this.mainJobInfo = res.data;
          console.log('데이터' + res)


          // this.jpl_endDate = res.data.jpl_endDate.substring(0, 10)
          //
          // for(var i = 0; i < this.mainJobInfo.length; i++) {
          //   console.log("하이")
          //   this.jpl_endDate = JSON.stringify(this.mainJobInfo[i].jpl_endDate);
          // }



          // this.jpl_endDate =  JSON.stringify(this.mainJobInfo[3].jpl_endDate);
          // console.log('엔드데이트: '+this.jpl_endDate);
          // console.log('데이터:' + JSON.stringify(this.mainJobInfo))
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

    // getMainJobInfo() {
    //
    //   this.$axios.post('/jobfair/getMainJobInfo')
    //       .then((res) => {
    //         this.mainJobInfo = res.data;
    //
    //         this.jpl_endDate = res.data.jpl_endDate;
    //
    //         console.log(res.data);
    //       })
    //       .catch((error) => {
    //         console.log(error)
    //       })
    // },

    // getDate() {
    //   const moment = require('moment')
    //   var today = moment();
    //   var etime = moment(this.jpl_endDate, 'YYYY-MM-DD');
    //   var inputT = moment(this.year + "-" + this.month + "-" + this.day)
    //
    //
    //   this.curTime = today.format('YYYY-MM-DD')
    //   this.inputTime = inputT.format('YYYY-MM-DD')
    //   this.diffTime = "D-" + moment.duration(today.diff(inputT)).days()
    //
    //   // if (moment(time).isBetween(stime, etime)) {
    //   //   //현재 시간이 접수 시작일과 마감일 사이일경우 동작
    //   //
    //   // } else {
    //   //   //현재 시간이 접수 시작일과 마감일 사이가 아닐경우 남은시간이 아닌 공고 마감 출력
    //   //   this.diffTime = "공고 마감"
    //   //   clearInterval(this.curcur)
    //   // }
    //
    // }

    getDate() {
      const moment = require('moment')

      var today = moment();
      var endTime = moment(this.jpl_endDate, 'YYYY-MM-DD');

      this.curTime = moment.duration(endTime.diff(today));

      this.diffDay = this.curTime.days()
      this.diffTime = "D-" + this.diffDay

      // console.log(this.jpl_endDate)
      // var TimeMinus = moment(this.jpl_endDate[1]).subtract(1, 'days').format('YYYY-MM-DD')
      // console.log('시간:' + TimeMinus)




    }


  }

}
</script>

<style scoped>


html, body {
  width:100%;
  height:100%;}

.left{float: left;}
.right {float:right;}

h3{
  font-weight: bold;
  font-size: 20px;
  padding:20px;
}

.wrapBox {
  height: 1300px;
}

.empBoxWrap {
  max-width:1560px;
  margin:0 auto;
  height: 100%;
}

/*hot 채용정보*/
.hotBoxWrap {
            border:1px solid #dedede;
            border-radius: 20px;
            width:23%;
            color:black;
            text-decoration: none;
            padding:20px;
            margin-left: 1%;
            margin-bottom: 1%;
}
.hotBoxWrap:hover {
            border:1px solid #0064ff;
  box-shadow: rgba(0, 0, 0, 0.16) 0px 10px 36px 0px, rgba(0, 0, 0, 0.06) 0px 0px 0px 1px;

}

.hotBoxWrap img {
            width:100%;
            padding:40px;
}

.hotTitle {font-size: 18px;
           font-weight: bold;

}

.hotText {border-top:1px solid #dedede;
          padding-top:10px;
}

.hotDday {font-weight: bold;
          padding:5px 15px;
          color:rgb(229, 75, 75);
          border:1px solid rgb(229, 75, 75);
          border-radius:20px;
}

.wrapBox2 {
  display: flex;
  justify-content: center;
  height: 500px;
}

/*큐앤에이*/

/*.qnaBox {*/
/*  font-family: 'MICEGothic Bold';*/
/*  display: flex;*/
/*  text-align: left;*/
/*  width: 80%;*/
/*  margin: 0 auto;*/
/*  margin-top: 300px;*/
/*  height: 60px;*/

/*}*/

.QnAWrap {
  display: flex;
  justify-content: space-between;
  margin-bottom: 30px;
  position: relative;
  top: 700px;
}

.qnaBox h3 {
  font-weight: bold;
  font-size: 23px;
  padding:20px;
  position: relative;
  right: 130px;
  color: #202632;
  margin-top: 50px;
}

#qnaTable {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  border: 1px solid #444444;
  width: 1500px;
  position: relative;
  right: 120px;
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
  color: white;
}

</style>
