<template>

  <div class="adminBg" >
    <div class="container empBoxWrap">
      <h3>참여 기업 상태</h3>
      <div class="row">
        <div class="col-lg-4 col-sm-4  aBox" >
          <a href="#" style="background-color:rgb(95, 75, 229)">
            <div class="companyNumImg">
            </div>
            <div class="companyNum_text">

              <span>참여 기업 수</span>
              <p>{{jobPostList.length}}</p>
            </div>
          </a>
        </div>
        <div class="col-lg-4 col-sm-4  aBox" >
          <a href="#" style="background-color:rgb(229, 75, 75)">
            <div class="companyNumImg">
            </div>
            <div class="companyNum_text">

              <span>반려</span>
              <p>{{}}</p>
            </div>
          </a>
        </div>
        <div class="col-lg-4 col-sm-4  aBox">
          <a href="#" style="background-color:rgb(62, 162, 72)">
            <div class="companyNumImg">
            </div>
            <div class="companyNum_text">

              <span>승인완료</span>
              <p>{{}}</p>
            </div>
          </a>
        </div>
      </div>
    </div>
  </div>
  <div class="userInfoBox">
    <h3>채용공고 목록</h3>
    <div class="userInfoFirstLine">
      <div>
<!--        기업이 등록한 전체 채용공고를 가져오려하는중, 근데 작성한 채용공고테이블과 기업테이블을 join해서 채용공고를 작성한 기업정보도 가져올 생각-->
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
                      <tr v-for="(line,i) in CompanyInfo">
                        <td>{{i+1}}</td>
                        <td>{{line.jpl_title}}</td>
                        <td>{{line.jpl_regDate}}</td>
                        <td>{{line.jpl_name}}</td>
                        <td>{{line.com_name}}</td>
                      </tr>
                    </tbody>
        </table>
<!--        <b-table striped hover>-->
<!--          <b-thead>-->
<!--            <b-th v-for="tableTitle in items">{{tableTitle}}</b-th>-->
<!--          </b-thead>-->
<!--          <b-tbody>-->
<!--            <b-tr v-for="line in jobPostList">-->
<!--              <b-td>{{line.jpl_title}}</b-td>-->
<!--            </b-tr>-->
<!--          </b-tbody>-->
<!--        </b-table>-->
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: 'aMainView',
  data() {
    return {
      items: ['No.','채용공고제목','작성일','등록자명','회사명'],
      jobPostList: [],
      CompanyInfo: [],
      com_num: JSON.parse(sessionStorage.getItem('sessionComp'))
    }
  },
  beforeCreate () {
    this.$axios.post('/jobfair/getEmpData')
      .then(res => {
        this.jobPostList = res.data
      }).catch(error => {
        console.log(error)
      })
  },
  created() {
    this.companyinfo()
  },
  methods: {
    companyinfo(){
      this.$axios.post('/jobfair/getComData', {com_num: this.com_num})
          .then(res => {
            this.CompanyInfo = res.data
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

.adminBg{
  width:100%;
  height:100%;
  background-color: #efefef;
}

.empBoxWrap {
  max-width:1200px;
  margin:0 auto;
}
.aBox {padding:5px;}
.aBox a, .aBox > div{
  /*padding: 5px;*/
  width:100%;
  height:150px;
  border-radius: 20px;
  display: block;
  padding:2%;
}

.aBox > div {background-color: white;}

.aBox a:first-child {background-color:rgb(95, 75, 229); }
.aBox a:nth-child(2) {background-color:rgb(229, 75, 75);}

.companyNum_text {color:white;}
.companyNum_text p {font-size: 40px;

}

.aBoxBtn button{width:50%;
  display: inline-block;
  height:20px;
  border:0;
  background-color: #efefef;
}

/* 채용공고 목록 css */
.userInfoBox {
  margin-top: 40px;
  border-top: 1px solid #AAAAAA;
}
/* 테이블 디자인 */
.tableDesign tr:hover {
  background-color: #d2d6da;
}
.tableDesign {
  width: 100%;
}
</style>
