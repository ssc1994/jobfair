<template>
  <div class="ListBg">
    <div class="list_titleWrap">
      <h1>참여 업체 목록</h1>
      <select class="choiceSort" v-model="dateOption" @change="getComList">
        <option>최신 날짜순</option>
        <option>오래된 날짜순</option>
      </select>
    </div>

    <div class="companyTable_wrap">
      <table>
          <tr class="tableMenu">
            <td>기업로고</td>
            <td>기업명</td>
            <td>신청날짜</td>
            <td>
              관리
              <select class="choiceSort" v-model="manageState" @change="getComList">
                <option>모두</option>
                <option>신청</option>
                <option>승인</option>
                <option>반려</option>
              </select>
            </td>
          </tr>
        <tr class="tableList" v-for="(com, index) in comList" :key="index" @click="goDetail" >
          <td><img src="" alt="이미지"></td>
          <td>{{com.com_name}}</td>
          <td>{{com.user_regDate}}</td>
          <td>{{com.mg_auth }}</td>
        </tr>
      </table>
    </div>

    <!--페이지네이션 부분-->
    <div class="paginationWrap">
      <ul class="pagination">
        <li class="page-item"><a class="page-link"  @click="goFirstPage(page - 1)" style="margin-right: 10px">First</a></li>
        <li class="page-item"><a class="page-link"  @click="goPrevPage(page - 1)" style="margin-right: 10px">Previous</a></li>
        <template v-for="(item, index) in pageList" :key="index">
          <li class="page-item" :class="{'active' : item == this.page}"><span class="page-link"  @click.prevent="ClickPage($event)" id="index">{{item}}</span></li>
        </template>
        <li class="page-item"><a class="page-link"  @click="goNextPage(page + 1)" style="margin-right: 10px">Next</a></li>
        <li class="page-item"><a class="page-link"  @click="goLastPage(page + 1)" style="margin-right: 10px">Last</a></li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: 'aComListView',
  data() {
    return {

      //기업의 데이터 담을 변수
      com_name: '',
      com_fileName: '',
      com_filePath: '',
      com_fileUuid: '',
      user_regDate: '',
      mg_auth: '',

      //페이지네이션 관련
      comList: '', //받아온 기업리스트 담을 변수
      pages: "", //pageVO
      pageList: "", //pageVO.pageList 배열값
      detailNum: "",
      //페이지 이동에 필요한 초기값
      page: 1,
      amount: 10,
      prev: '',
      start: '',
      end: '',
      realEnd: '',
      dateOption: '최신 날짜순', //기업 리스트 정렬 옵션
      manageState: '모두',      //기업 리스트 정렬 옵션
    }
  },
  created() {
    this.getComList()
  },
  methods: {

    //참여 업체 목록 가져오기
     async getComList () {

       let {data} = await this.$axios.get('/jobfair/aComList/getComList',
           { params: {page : this.page,
                            amount : this.amount,
                            dateOption : this.dateOption,
                            manageState : this.manageState}
                  }).catch( err => console.log(err))

       console.log(data)

       // //데이터 다시 돌아오는거 보고 변수 매칭되는거 다시한번씩 확인해야됨 아래로 다.
       // this.comList = data.list
       // this.pages = data.pageVO;
       // this.pageList = this.pages.pageList;
       //
       // //페이지이동에 필요한 데이터 담기
       // this.page = this.pages.page;
       // this.prev = this.pages.prev;
       // this.pageStart = this.pages.pageStart;
       // this.pageEnd = this.pages.pageEnd;
       // this.realEnd = this.pages.realEnd;
       //
       // //mg_auth에 따라서 관리상태 값 매칭해주기
       // for(let i =0; i<this.comList.length; i++){
       //    if(this.comList[i].mg_auth === '2'){
       //      this.comList[i].mg_auth = '신청'
       //    } else if(this.comList[i].mg_auth === '3'){
       //      this.comList[i].mg_auth = '승인'
       //    } else {
       //      // mg_auth 가 5일 경우
       //      this.comList[i].mg_auth = '반려'
       //    }
       // }




     },
    //기업리스트 누르면 기업의 상세페이지로 넘어가기
    goDetail () {
      this.$router.push('/aComDetailView')
    },

    //페이지 네이션 부분
    goFirstPage() {
      this.page = 1;
      this.getComList();
    },
    goPrevPage() {
      if(this.page > 1) {
        this.page = this.page - 1;
        this.getComList();
      } else {
        alert("첫 페이지입니다.");
      }
    },
    goNextPage() {
      if(this.page < this.realEnd) {
        this.page = this.page + 1;
        this.getComList();
      } else {
        alert("마지막 페이지입니다.")
      }
    },
    goLastPage() {
      this.page = this.realEnd;
      this.getComList();
    },
    ClickPage(e) {
      var clicked = e.target.innerHTML;
      this.page = clicked
    },
  }
}
</script>

<style scoped>
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

ul, ol, li {
  list-style: none;
}

a {
  text-decoration: none;
}
/* 전체 틀 */
.ListBg {
  border: 1px solid #AAAAAA;
  border-radius: 15px;
  padding: 20px;
  width: 90%;
  margin: 0 auto;
}

/* title */
.list_titleWrap{
  overflow: hidden;
  margin-bottom: 10px;
}
.list_titleWrap h1 {
  font-weight: bold;
  font-size: 20px;
  padding:20px;
  color: #202632;
}
/* select Sort */
.list_titleWrap .choiceSort {
  float: right;
}
/* select design */
select {
  padding: 5px;
  border-radius: 5px;
  border: 1px solid #ccc;
  font-size: 16px;
}
/* company list(회사목록) */
.companyTable_wrap {
  width: 100%;
  list-style: none;
  margin: 0;
  padding: 0;
}
.companyTable_wrap table{
  width: 100%;
}
/* 테이블 컬럼명 리스트 */
.tableMenu {
  color: white;
  font-size: 18px;
  font-weight: bolder;
  justify-content: space-around;
  text-align: center;
}

/*테이블의 각 행에 대한 css*/
.companyTable_wrap tr {
  text-align: center;
  display: flex;
  align-items: center;
  justify-content: space-around;
  padding: 10px;
  margin-bottom: 5px;
  background-color: #0064ff;
}
/*각 열 크기(줄) 맞추기*/
.companyTable_wrap table tr td{
  width: 25%;
}
.companyTable_wrap tr:nth-child(even) {
  background-color: #f2f2f2;
}

.companyTable_wrap img {
  width: 50px;
  height: 50px;
}

.companyTable_wrap td:nth-child(2) {
  font-weight: bold;
}

.companyTable_wrap td:nth-child(3) {
  padding: 5px 10px;
  border-radius: 5px;
  text-align: center;
}

.tableList{
  cursor: pointer;
}

.tableList td select{
  margin: 0;
}

/* 페이지네이션 부분 */
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

</style>
