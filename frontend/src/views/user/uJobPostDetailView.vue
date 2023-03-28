<template>

  <div style="overflow: hidden">
    <main class="resume left">
      <div class="TopBox">
        <div class="left PostImg tbList">
          <img class="tbLogo" :src="com_logo" alt="">
          <p>{{ com_name }}</p>
        </div>
        <div class="left PostText">
          <span style="font-size: 35px; font-weight: bolder;">{{ jpl_title }}</span> <br/>
          <span style="color: #999; font-weight: bold">{{ jpl_workForm }}</span>
          <div class="tdCol">
            <dl class="tbList left">
              <dt>직무</dt>
              <dd>
                <strong>{{ jpl_duty }}</strong>
              </dd>
              <dt>경력</dt>
              <dd>
                <strong>{{ jpl_workHistory }}</strong>
              </dd>
              <dt>학력</dt>
              <dd>
                <strong>{{ jpl_education }}</strong>
              </dd>
              <dt>연봉</dt>
              <dd>
                <strong>{{ jpl_salary }}</strong>
              </dd>
              <dt>위치</dt>
              <dd>
                <strong>{{ jpl_address }}</strong>
              </dd>
            </dl>
          </div>
        </div>
      </div>
      <div class="contents">
        <div class="recruitment">
          <b>업무소개</b> <br/>
          <p>
            {{ jpl_content }}
            <br>
            <!--            aws에서 가져오는 이미지를 집어넣을예정-->
          </p>

          <br/>
        </div>
        <p><br></p>
        <p>&nbsp;</p>
        <div class="recruitment pic">
          <b>공고내용</b><br/>
          <p><img :src="viewImg" alt="No Img"></p><br/>
        </div>
        <p><br></p>
        <p>&nbsp;</p>
        <div class="recruitment pro">
          <b>전형절차</b><br/>
          <p>서류 지원 - 1차 면접 - 2차 면접 - 합격</p><br/>
        </div>
        <p><br></p>
        <p>&nbsp;</p>
        <div class="recruitment">
          <b>기업정보</b><br/>
          <img :src="com_logo">
          <span>기업명 : {{ com_name }}</span><br/>
          <span>기업전화번호 : {{ com_phone }}</span><br/>
          <span>기업이메일 : {{ com_email }}</span><br/>
          <span>기업주소 : {{ com_address }}</span><br/>
          <span>업종 : {{ com_category }}</span><br/>
          <span>대표자 : {{ com_ceo }}</span><br/>
          <span>사업자등록번호 : {{ com_businessRegistration }}</span><br/>
        </div>
        <p><br></p>
        <p>&nbsp;</p>
        <p><br></p>
        <p>&nbsp;</p>
      </div>
    </main>

    <div style="position: fixed; right: 50px">
      <div>
        <div class="marginTime">
          <span style="color: #0064ff; font-weight: bolder">남은 시간</span>
          <div class="Time">
            <!--            <p>5일 12:59</p>-->
            <input type="text" disabled v-model="diffTime">
            <!--            <button type="button" @click="curcur"></button>-->
            <span>접수 시작 : {{ jpl_startDate }}</span><br/>
            <span>접수 마감 : {{ jpl_endDate }}</span>
          </div>

          <button type="button" class="btn btn-primary endBtn" data-bs-toggle="modal" data-bs-target="#exampleModal"
                  v-bind:disabled="AppliedResult == 1"
                  v-if="this.mg_auth < 3">
            {{ applyBtnText }}
          </button>


          <button type="button" class="btn btn-primary endBtn" data-bs-toggle="modal" data-bs-target="#exampleModal" style="background-color: #dedede;color:black;" v-if="this.mg_auth == 3 && com_num == this.loginComNum">
           지원자 보기
          </button>

          <button type="button" class="btn btn-primary endBtn" v-if="this.mg_auth == 3 && com_num == this.loginComNum" @click="modi(jpl_num)">
            수정하기
          </button>

          <button type="button" class="btn btn-primary" @click.prevent="uQnABtnClick" v-if="this.mg_auth < 3">
            Q&A 질문하기
          </button>

        </div>

        <div class="marginTime">
          <span>지원자 현황 통계</span>
          <div class="applicant">
            <div class="personCount">
              <p>지원자 수</p>
              <span>{{peopleNumber}}</span>
            </div>
          </div>

          <div>
            <br>
            <ul>
              <li>성별</li>
              <div class="genderGroup">
                <canvas
                    ref="genderGroup"
                />
              </div>
            </ul>
          </div>
        </div>
      </div>
    </div>

    <!--지원하기 모달창 설정-->
    <!--state 적용해서 데이터 넣어야해유-->
<!--    유저가 채용공고에 본인의 이력서를 선택해서 지원할 때 모달창 -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true"
         style="z-index: 10000;" v-if="this.mg_auth < 3">
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content ">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="exampleModalLabel">이력서 선택하기</h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body" style="height: 100%">
            <div class="contentModalBox">

              <div class="miniContentModalBox" v-for="(resumeAll,i) in resumeArray" :key="i">
                <input type="radio" :id="resumeAll.res_num" name="resumeRadio" :value="i" v-model="resNum">
                <label :for="resumeAll.res_num">
                  <h4>{{ resumeAll.res_title }} </h4>
                  <h5>{{ resumeAll.res_regDate }} </h5>
                </label>
              </div>

            </div>
            <div class="modal-footer">
              <!-- @click="supportResume" 넣기 -->
              <button type="button" class="btn btn-primary" @click.prevent="postRes" data-bs-dismiss="modal">지원하기
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>

<!--    기업이 본인의 채용공고에 지원한 사람들의 목록을 모달에서 확인할 때 -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true"
         style="z-index: 10000;" v-if="this.mg_auth == 3">
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content ">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="exampleModalLabel">지원자 목록</h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body" style="height: 100%">
            <div class="contentModalBox">

              <div class="miniContentModalBox" v-for="(personAll,j) in lookPerson" :key="j">
                <label :for="personAll.res_num">
                  <h4>{{ personAll.res_title }} </h4>
                  <h5>{{ personAll.res_regDate }} </h5>
                </label>
              </div>

            </div>
            <div class="modal-footer">
              <!-- @click="supportResume" 넣기 -->
              <button type="button" class="btn btn-primary" data-bs-dismiss="modal">확인
              </button>
            </div>
          </div>
        </div>
      </div>


    </div>

  </div>
</template>

<script>
import router from "@/router";
import moment from "moment/moment";
import { Chart, registerables } from 'chart.js'
Chart.register(...registerables)
let chart
export default {
  name: "uJobPostDetailView",
  data() {
    return {
      peopleNumber: 0,
      woman: 0,
      man: 0,
      page_jpl_num: [],
      data1: {
        labels: [
          '여성',
          '남성'
        ],
        datasets: [{
          label: 'Login Gender Total',
          data: [],
          backgroundColor: [
            'rgb(255, 99, 132)',
            'rgb(54, 162, 235)'
          ],
          hoverOffset: 4
        }]
      },
      // 데이터 정의
      jpl_num: this.$route.params.jpl_num,
      com_num: '',
      jpl_title: '',
      jpl_content: '',
      jpl_startDate: '',
      jpl_endDate: '',
      jpl_regDate: '',
      jpl_workPosition: '',
      jpl_duty: '',
      jpl_workHistory: '',
      jpl_workForm: '',
      jpl_education: '',
      jpl_conditions: '',
      jpl_certificate: '',
      jpl_gender: '',
      jpl_salary: '',
      jpl_locationSi: '',
      jpl_locationGu: '',
      jpl_address: '',
      jpl_workDay: '',
      jpl_workTimeS: '',
      jpl_workTimeE: '',
      jpl_name: '',
      jpl_companyName: '',
      jpl_contact: '',
      jpl_phoneNum: '',
      jpl_email: '',
      jpl_fileName: '',
      jpl_filePath: '',
      jpl_fileUuid: '',
      salaryType: '',
      viewImg: '',
      com_name: '',
      com_phone: '',
      com_email: '',
      com_address: '',
      com_category: '',
      com_ceo: '',
      com_businessRegistration: '',
      com_establishmentDate: '',
      curTime: '',
      diffDay:'',
      diffHour:'',
      diffMin:'',
      diffSec:'',
      diffTime:'',
      QnAComInfo: {
        user_id: JSON.parse(sessionStorage.getItem('sessionId')),
        com_num: ''
      },
      user_id: JSON.parse(sessionStorage.getItem('sessionId')),
      mg_auth : JSON.parse(sessionStorage.getItem('sessionAuth')),
      res_num: '1',
      lookPerson: [],
      //지원한 이력서
      resNum: 0,
      // apply 성공
      apply: '',
      applyBtnText: '지원하기',
      // 지원했던 공고면 1 , 아니면 0
      AppliedResult: 0,
      resumeArray: [],
      loginComNum : '',
      com_logo:''
    }
  },
  watch: {
    woman () { this.genderChart() },
    man () { this.genderChart() }
  },
  created() {
    this.$axios.post("/jobfair/getComNum", {user_id: this.user_id})
        .then((res) => {
          this.loginComNum = res.data;
        }).catch((error) => {
      console.log(error);
    }),

    this.getGendertotal(),
    this.getlookPerson(),
        this.$axios.get('/jobfair/empData', {
      params: {jpl_num: this.jpl_num}
    }).then(res => {
      this.com_num = res.data.com_num,
          this.jpl_title = res.data.jpl_title,
          this.jpl_content = res.data.jpl_content,
          this.jpl_startDate = res.data.jpl_startDate.substring(0, 10),
          this.jpl_endDate = res.data.jpl_endDate.substring(0, 10),
          this.jpl_regDate = res.data.jpl_regDate.substring(0, 10),
          this.jpl_workPosition = res.data.jpl_workPosition,
          this.jpl_duty = res.data.jpl_duty,
          this.jpl_workHistory = res.data.jpl_workHistory,
          this.jpl_workForm = res.data.jpl_workForm,
          this.jpl_education = res.data.jpl_education,
          this.jpl_conditions = res.data.jpl_conditions,
          this.jpl_certificate = res.data.jpl_certificate,
          this.jpl_gender = res.data.jpl_gender,
          this.jpl_salary = res.data.jpl_salary,
          this.jpl_locationSi = res.data.jpl_locationSi,
          this.jpl_locationGu = res.data.jpl_locationGu,
          this.jpl_address = res.data.jpl_address,
          this.jpl_workDay = res.data.jpl_workDay,
          this.jpl_workTimeS = res.data.jpl_workTimeS,
          this.jpl_workTimeE = res.data.jpl_workTimeE,

          this.jpl_name = res.data.jpl_name,
          this.jpl_phoneNum = res.data.jpl_phoneNum,
          this.jpl_email = res.data.jpl_email,
          this.jpl_companyName = res.data.jpl_comPanyName,
          this.jpl_contact = res.data.jpl_contact,
          this.jpl_fileName = res.data.jpl_fileName,
          this.jpl_filePath = res.data.jpl_filePath,
          this.jpl_fileUuid = res.data.jpl_fileUuid
          if(res.data.url!=null){
            this.viewImg=res.data.url
          }
          this.$axios
              .post('/jobfair/compInfo', {
                com_num: this.com_num
              })
              .then(res => {
                this.jpl_comPanyName = res.data.com_name
                this.jpl_contact = res.data.com_phone

                this.com_name = res.data.com_name
                this.com_phone = res.data.com_phone
                this.com_email = res.data.com_email
                this.com_address = res.data.com_address
                this.com_category = res.data.com_category
                this.com_ceo = res.data.com_ceo
                this.com_establishmentDate = res.data.com_establishmentDate
                this.com_businessRegistration = res.data.com_businessRegistration
                this.com_logo=res.data.com_logo
              }).catch(err => {
            console.log(err)
          })

    }).catch(err => {
      console.log(err)
    }),
        this.resumeinfo();



    this.$axios.post("/jobfair/EmpApplied", {user_id: this.user_id, jpl_num: this.jpl_num})
        .then((res) => {
          this.AppliedResult = res.data;
          if (this.AppliedResult == 1) {
            this.applyBtnText = '지원완료';
          }
        }).catch((error) => {
      console.log(error);
    })


  },
  mounted() {
    setInterval(this.curcur,1000);
    this.genderChart()
  },
  methods: {
    curcur(){
      const moment = require('moment')
      var time = moment();
      var etime = moment(this.jpl_endDate, 'YYYY-MM-DD');
      var stime = moment(this.jpl_startDate, 'YYYY-MM-DD');

      if(moment(time).isBetween(stime,etime)){
        //현재 시간이 접수 시작일과 마감일 사이일경우 동작
        this.curTime=moment.duration(etime.diff(time))
        this.diffDay=this.curTime.days()
        this.diffHour=this.curTime.hours()
        this.diffMin=this.curTime.minutes()
        this.diffSec=this.curTime.seconds()
        this.diffTime= this.diffDay+"일 "+this.diffHour+"시간"+this.diffMin+"분"+this.diffSec+"초"
      }else {
        //현재 시간이 접수 시작일과 마감일 사이가 아닐경우 남은시간이 아닌 공고 마감 출력
        this.diffTime= "공고 마감"
        clearInterval(this.curcur)
      }
    },
    resumeinfo() {
      this.$axios.post("/jobfair/resumeInfo", {user_id: this.user_id})
          .then((res) => {
            this.resumeArray = res.data
          }).catch((error) => {
        console.log(error)
      })
    },
    Applied() {

    },
    postRes() {
      this.resNum = this.resNum + 1;
      this.$axios.post("/jobfair/EmpApply", {
        user_id: this.user_id,
        jpl_num: this.jpl_num,
        res_num: this.resNum
      })
          .then((res) => {
            this.apply = res.data;
          }).catch((error) => {
        console.log(error)
      })
    },

    uQnABtnClick() { // 채용상세공고 페이지에서 해당 기업 번호 넘기기 위한 메서드

      this.$router.push({name: "uQnAWriteView", params: {com_num: this.com_num}});

    },
    getlookPerson() {
      this.$axios.post('/jobfair/getlookPerson', {jpl_num: this.jpl_num})
          .then((res) => {
            this.lookPerson = res.data
            console.log(this.lookPerson)
            this.peopleNumber = res.data.length
            for(var i = 0; i < this.lookPerson.length; i++){
              if (res.data[i].user_gender === 'F' || res.data[i].user_gender === '여자') {
                this.woman++
              } else if (res.data[i].user_gender === 'M' || res.data[i].user_gender === '남자') {
                this.man++
              }
            }
            chart.data.datasets[0].data[0] = this.woman
            chart.data.datasets[0].data[1] = this.man
            chart.update()
            chart.destroy()
          })
          .catch((error) => console.log(error))
    },
    getGendertotal () {
      this.$axios.post('/jobfair/getGendertotal')
          .then((res) => {
            // console.log(res.data)
            // for(var b = 0; b < res.data.length; b++) {
            //       if (res.data[b].jpl_num === this.jpl_num) {
            //         // console.log('지금페이지' + res.data[b].jpl_num)
            //       if (res.data[b].user_gender === 'F' || res.data[b].user_gender === '여자') {
            //         this.woman++
            //       } else if (res.data[b].user_gender === 'M' || res.data[b].user_gender === '남자') {
            //         this.man++
            //       }
            //     }
            //   }
          })
          .catch((error) => console.log(error))
    },
    //남녀성비구하는 차트함수
    genderChart() {
      chart = new Chart(this.$refs.genderGroup, {
        type: 'doughnut',
        data: this.data1
      })
    },
    modi(e){
      console.log(e);
      this.$router.push({
        //params를 넘겨줄 때엔 push할 때 path보단 name을 사용함
        name: 'cEmpModiView',
        params: {
          jpl_num: e
        }
      })

    }
  }
}
</script>

<style scoped>

.miniContentModalBox {
  height: 100px;
}

* {
  box-sizing: border-box;
}

ul, ol {
  list-style: none;
}

a {
  text-decoration: none;
}

dl {
  display: block;
  margin-block-start: 1em;
  margin-block-end: 1em;
  margin-inline-start: 0px;
  margin-inline-end: 0px;
}

/* 왼쪽 상단에 기업로고 */
.tbLogo {
  width: 228px;
  height: 160px;
  text-align: center;
  margin: auto;
}

.tdCol {
  width: 326px;
  margin: 0 20px 0 0;
}

.tbList > dt {
  color: #0064ff;
  width: 70px;
}

.tbList > dd {
  color: #333;
  width: 250px;
}

.tbList > dd, .tbList > dt {
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 20px;
  margin: 2px 0 3px;
}

/* 채용공고 상세내역 정보 */
.resume {
  width: 70%;
  height: 2000px;
  color: #1E1E1E;
  padding: 50px 30px;
  border: 1px solid #AAAAAA;
  border-radius: 15px;
  padding: 20px;
}

.left {
  float: left;
}

/* 지원자 수 */
.personCount p {
  font-size: 20px;
  font-weight: 700;
}
.personCount span {
  font-size: 28px;
  font-weight: 900;
  color: #0064ff;
}
/* 남은시간 */
.marginTime {
  width: 280px;
  border: 1px solid #d2d6da;
  padding: 30px;
}

.Time {
  text-align: center;
}

.Time p {
  font-size: 30px;
  font-weight: bolder;
}
.Time input {
  font-size: 24px;
  font-weight: bolder;
  border:none;
  border-right:0px;
  border-top:0px;
  boder-left:0px;
  boder-bottom:0px;
  width: 220px;
  background-color: #FFFFFF;
}

.marginTime button {
  width: 200px;
  height: 50px;
  border: none;
  border-radius: 25px;
  margin: 10px;
  background-color: #0064ff;
  color: white;

}

/* 지원자 현황 통계 */
.applicant {
  width: 100%;
  height: 90px;
  padding: 10px;
  text-align: center;
}

.applicant .left {
  padding-right: 40px;
  border-right: 2px solid #d2d6da;
}

.applicant .left span,
.applicant .right span {
  font-size: 28px;
  font-weight: bolder;
  color: #0064ff;
}

/* post 전체 틀 */
.TopBox {
  height: 15%;
}

/* post 왼쪽 창 */
.PostImg {
  width: 30%;
  margin: 20px;
  text-align: center;
}

.PostImg p {
  font-size: 20px;
  font-weight: 600;
  margin-top: 8px;
}

/* post 오른쪽 창*/
.PostText {
  width: 60%;
}

.PostText span {
  width: 100px;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}

/* 채용공고 상세내역 정보 */
.contents {
  width: 100%;
  height: 60%;
}

/* 채용공고 업무소개, 전형절차, 혜택 및 복지란 */
.recruitment {
  border: 1px solid rgb(181, 183, 186, 0.5);
  width: 100%;
  height: 20%;
  padding: 10px;
}
.pic{
  border: 1px solid rgb(181, 183, 186, 0.5);
  width: 100%;
  height: 55%;
  padding: 10px;
}
.pro{
  border: 1px solid rgb(181, 183, 186, 0.5);
  width: 100%;
  height: 15%;
  padding: 10px;
}

.recruitment b {
  font-size: 20px;
}

.recruitment p {
  line-height: 1.3;
  white-space: pre-line;
  word-wrap: break-word;
}

.recruitment img {
  float: left;
  width: 30%;
  height: 160px;
  margin-right: 30px;
}
.pic img {
  float: left;
  width: 85%;
  height: 80%;
  margin-right: 30px;
}

.endBtn:disabled {
  background-color: #dedede;
  color: black;
}
</style>