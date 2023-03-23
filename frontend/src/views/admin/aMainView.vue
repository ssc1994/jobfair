<template>

  <div class="adminBg" >
    <div class="container empBoxWrap">
      <h3>참여 기업 상태</h3>
      <div class="row">
        <div class="col-lg-4 col-sm-4 aBox" >
          <router-link to="aComListView" style="background-color:rgb(95, 75, 229)">
            <div class="companyNumImg">
            </div>
            <div class="companyNum_text">
              <span>참여 기업 수</span>
              <p>{{number}}</p>
            </div>
          </router-link>
        </div>
        <div class="col-lg-4 col-sm-4  aBox" >
          <router-link to="" style="background-color:rgb(229, 75, 75)">
            <div class="companyNumImg">
            </div>
            <div class="companyNum_text">

              <span>미승인 기업 수</span>
              <p>{{nosuccess}}</p>
            </div>
          </router-link>
        </div>
        <div class="col-lg-4 col-sm-4  aBox">
          <router-link to="" style="background-color:rgb(62, 162, 72)">
            <div class="companyNumImg">
            </div>
            <div class="companyNum_text">

              <span>승인 기업 수</span>
              <p>{{ysuccess}}</p>
            </div>
          </router-link>
        </div>
      </div>
    </div>
  </div>
  <div class="userInfoBox">
    <h3>채용공고 목록</h3>
    <router-link to="/aComListView" style="float: right">더보기</router-link>
    <div class="userInfoFirstLine">
      <div>
<!--        기업이 등록한 전체 채용공고를 가져오려하는중, 근데 작성한 채용공고테이블과 기업테이블을 join해서 채용공고를 작성한 기업정보도 가져올 생-->
        <table class="tableDesign">
          <thead>
            <th v-for="tableTitle in items">{{tableTitle}}</th>
          </thead>
                    <tbody>
                      <tr v-for="(line,i) in jobPostList">
                        <td>{{i+1}}</td>
                        <td>{{line.jpl_title}}</td>
                        <td>{{line.jpl_regDate}}</td>
                        <td>{{line.jpl_name}}</td>
                        <td>{{line.com_name}}</td>
                      </tr>
                    </tbody>
        </table>
      </div>
    </div>
  </div>
</template>
<script>
import {mg_auth} from "vuex";

export default {
  name: 'aMainView',
  data() {
    return {
      items: ['No.','채용공고제목','작성일','등록자명','회사명'],
      jobPostList: [],
      com_num: '',
      com_name: [],
      number: 1,
      auth: [],
      nosuccess: 0,
      ysuccess: 0
      // auth: JSON.parse(sessionStorage.getItem('sessionAuth'))
    }
  },
  created() {
    this.allinfo()
    this.getauth()
  },
  methods: {
    getauth(){
      this.$axios.post('/jobfair/getAuth')
          .then(res => {
            this.auth = res.data
            console.log(this.auth)
            for (let i = 0; i < res.data.length; i++) {
              console.log('실행됨')
              if(this.auth[i].mg_auth === '2') {
                this.nosuccess++
              } else if(this.auth[i].mg_auth === '3') {
                this.ysuccess++
              }
            }
          })
          .catch(error => { console.log(error)})
    },
    allinfo() {
      this.$axios.post('/jobfair/getAllData', {com_num: this.com_num})
          .then(res => {
            this.com_name = res.data.com_num
            this.jobPostList = res.data
            var set = new Set()
            for(let i=0; i<res.data.length; i++){
              set.add(res.data[i].com_num)
            }
            this.number=set.size
          }).catch(error => {
        console.log(error)
      })
    }
  }
}
</script>

<style scoped>
*{
  padding: 0;
  margin: 0;
  list-style: none;
  font-size:15px;
}

a {text-decoration: none;}

html, body {width:100%;
  height:100%;}

/* 참여기업상태 div */
.row {
  padding: 30px;
}

/* 테이블 css */
.userInfoBox {
  padding: 20px;
  border: 1px solid #ccc;
}

.userInfoBox h3 {
  font-size: 24px;
  font-weight: bold;
  margin-bottom: 20px;
}

.tableDesign {
  width: 100%;
  border-collapse: collapse;
  margin-top: 20px;
}

.tableDesign th,
.tableDesign td {
  border: 1px solid #ccc;
  padding: 10px;
  text-align: center;
}

.tableDesign th {
  background-color: #f2f2f2;
  font-weight: bold;
}

.tableDesign tr:nth-child(even) {
  background-color: #f2f2f2;
}

/* */

.adminBg {
  background-color: #f7f7f7;
  padding: 20px 0;
}

.empBoxWrap {
  margin: 0 auto;
  max-width: 900px;
}

.empBoxWrap h3 {
  font-size: 24px;
  font-weight: bold;
  margin-bottom: 20px;
}

.aBox {
  margin-bottom: 20px;
}

.aBox a {
  display: block;
  height: 150px;
  position: relative;
  border-radius: 5px;
  overflow: hidden;
  color: #fff;
  text-decoration: none;
  transition: all 0.3s ease;
}

.aBox a:hover {
  transform: translateY(-5px);
  box-shadow: rgba(0, 0, 0, 0.16) 0px 10px 36px 0px, rgba(0, 0, 0, 0.06) 0px 0px 0px 1px;
}

.companyNumImg {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  /*background-image: url("path/to/image");*/
  background-position: center;
  background-size: cover;
  opacity: 0.5;
}

.companyNum_text {
  position: absolute;
  bottom: 0;
  left: 0;
  width: 100%;
  padding: 20px;
  box-sizing: border-box;
  text-align: center;
}

.companyNum_text span {
  display: block;
  font-size: 16px;
  font-weight: bold;
  margin-bottom: 10px;
  text-transform: uppercase;
}

.companyNum_text p {
  font-size: 48px;
  font-weight: bold;
  margin: 0;
}
</style>
