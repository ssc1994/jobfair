<template>



  <div class="wrapBox">
    <div class="wrapBox2">



      <div class="container empBoxWrap">
        <div>
          <h3>HOT 채용공고</h3>
        </div>
        <div class="row" style="margin-top: 20px">
          <router-link to="" class="hotBoxWrap">
            <div>
              <img src="@/assets/kakao.png"/>
            </div>
            <div class="hotText">
              <div>(주)카카오</div>
              <p class="hotTitle">
                채용전환형 인턴 공개채용
              </p>

                <span class="hotDday">D-9</span>
            </div>
          </router-link>

          <router-link to="" class="hotBoxWrap">
            <div>
              <img src="@/assets/kakao.png"/>
            </div>
            <div class="hotText">
              <div>(주)카카오</div>
              <p class="hotTitle">
                채용전환형 인턴 공개채용
              </p>

              <span class="hotDday">D-9</span>
            </div>
          </router-link>
          <router-link to="" class="hotBoxWrap">
            <div>
              <img src="@/assets/kakao.png"/>
            </div>
            <div class="hotText">
              <div>(주)카카오</div>
              <p class="hotTitle">
                채용전환형 인턴 공개채용
              </p>

              <span class="hotDday">D-9</span>
            </div>
          </router-link>
          <router-link to="" class="hotBoxWrap">
            <div>
              <img src="@/assets/kakao.png"/>
            </div>
            <div class="hotText">
              <div>(주)카카오</div>
              <p class="hotTitle">
                채용전환형 인턴 공개채용
              </p>

              <span class="hotDday">D-9</span>
            </div>
          </router-link>

          <router-link to="" class="hotBoxWrap">
            <div>
              <img src="@/assets/kakao.png"/>
            </div>
            <div class="hotText">
              <div>(주)카카오</div>
              <p class="hotTitle">
                채용전환형 인턴 공개채용
              </p>

              <span class="hotDday">D-9</span>
            </div>
          </router-link>

          <router-link to="" class="hotBoxWrap">
            <div>
              <img src="@/assets/kakao.png"/>
            </div>
            <div class="hotText">
              <div>(주)카카오</div>
              <p class="hotTitle">
                채용전환형 인턴 공개채용
              </p>

              <span class="hotDday">D-9</span>
            </div>
          </router-link>
          <router-link to="" class="hotBoxWrap">
            <div>
              <img src="@/assets/kakao.png"/>
            </div>
            <div class="hotText">
              <div>(주)카카오</div>
              <p class="hotTitle">
                채용전환형 인턴 공개채용
              </p>

              <span class="hotDday">D-9</span>
            </div>
          </router-link>
          <router-link to="" class="hotBoxWrap">
            <div>
              <img src="@/assets/kakao.png"/>
            </div>
            <div class="hotText">
              <div>(주)카카오</div>
              <p class="hotTitle">
                채용전환형 인턴 공개채용
              </p>

              <span class="hotDday">D-9</span>
            </div>
          </router-link>



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
export default {
  name: 'uMainView',

  data() {
    return {
      QnAList: [],
    }
  },

  created() {
    this.getMainQnAList();
  },

  methods: {
    getMainQnAList() {
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
    }
  }

}
</script>

<style scoped>


html, body {width:100%;
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
  top: 200px;
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
