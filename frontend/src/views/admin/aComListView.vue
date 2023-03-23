<template>
<div class="ListBg">

  <h1>참여 업체 목록</h1>
  <select class="choiceSort">
    <option>최신 날짜순</option>
  </select>

  <div class="companyList">
    <table>
      <tr class="tableMenu">
        <td>기업로고</td>
        <td>기업명</td>
        <td>신청날짜</td>
        <td>관리</td>
      </tr>
      <tr>
        <td><img src="" alt="이미지"></td>
        <td>(주)네이버</td>
        <td>2023.03.20</td>
        <td>
          <select>
            <option>신청</option>
            <option>승인</option>
            <option>반려</option>
          </select>
        </td>
      </tr>
      <tr>
        <td><img src="" alt="이미지"></td>
        <td>(주)네이버</td>
        <td>2023.03.20</td>
        <td>
        <select>
          <option>신청</option>
          <option>승인</option>
          <option>반려</option>
        </select>
        </td>
      </tr>
      <tr>
        <td><img src="" alt="이미지"></td>
        <td>(주)네이버</td>
        <td>2023.03.20</td>
        <td>
        <select>
          <option>신청</option>
          <option>승인</option>
          <option>반려</option>
        </select>
        </td>
      </tr>
    </table>
  </div>

  <div class="page">
    <!--페이지네이션 부분-->
<!--    <a @click="goFirstPage(page - 1)">&lt;</a>-->
    <a @click="goPrevPage(page - 1)">prev</a>

    <a v-for="(paging, index) in pageList" :key="index" @click="onPageChange(paging - 1)" :class="paging - 1 === page ? 'page' : ''">{{paging}}</a>


    <a @click="goNextPage(page + 1)">next</a>
<!--    <a @click="goLastPage(page + 1)">&gt;</a>-->
  </div>

</div>
</template>

<script>

export default {
  name: 'aComListView',
  data () {
    return {
      ApplyArray: ['신청','반려','승인완료'],
      // currentPage: ref(0),
      // isBtnFirst: ref(true),
      // isBtnPrev: ref(true),
      // isBtnNext: ref(true),
      // isBtnLast: ref(true),
      EmpList: [],
      EmpDetailList: [],
      list: '',
      pages: '', // pageVO
      pageList: '', //pageVO.pageList 배열값
      detailNum: '',

      page: 1,
      amount: 10,
      prev: '',
      start: '',
      end: '',
      realEnd: ''
    }
  },
  created() {
    // 채용공고리스트 가져오는 메서드 만들기 (지금은 은영쓰꺼 예시)
    this.getEmpList()
    this.EmpListAxios()
  },
  methods: {
    // 채용공고 리스트 가져오는 메서드 만들기
    getEmpList() {
      this.$axios.post('/jobfair/getEmpList')
          .then((res) => this.EmpList = res.data)
          .catch((error) => console.log(error))
    },
    EmpListAxios() {
      this.$axios.get("/jobfair/EmpListAxios/?amount=" +
          this.amount +
          "&page=" +
          this.page)
          .then((res) => {
            console.log(res)
            this.list = res.data.list
            this.pages = res.data.pageVO
            this.pageList = this.pages.pageList

            //페이지 이동에 필요한 데이터 담기
            this.page = this.pages.page
            this.prev = this.pages.prev
            this.start = this.pages.start
            this.end = this.pages.end
            this.realEnd = this.pages.realEnd

          })
          .catch((error) => console.log(error))

    },
    goPrevPage() {
      if(this.page > 1) {
        this.page = this.page - 1;
      } else {
        alert("첫 페이지입니다.");
      }
    },
    goNextPage() {
      if(this.page < this.realEnd) {
        this.page = this.page + 1;
        this.EmpListAxios();
      } else {
        alert("마지막 페이지입니다.")
      }
    },
    onPageChange(e) {
      this.$axios.post('/jobfair/EmpListAxios', {
        amount: this.amount,
        page: this.e.target
      })
    }
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
}

/* title */
h1 {
  font-size: 30px;
  margin-bottom: 20px;
  padding: 10px;
}
/* select Sort */
.choiceSort {
  float: right;
}

/* select design */
select {
  margin-bottom: 20px;
  padding: 5px;
  border-radius: 5px;
  border: 1px solid #ccc;
  font-size: 16px;
}
/* 테이블 컬럼명 리스트 */
.tableMenu {
  color: black;
  font-size: 18px;
  font-weight: bolder;
  justify-content: space-around;
  text-align: center;
  width: 900px;
}
/* company list(회사목록) */
.companyList {
  list-style: none;
  margin: 0;
  padding: 0;
}

.companyList tr {
  display: flex;
  align-items: center;
  justify-content: space-around;
  padding: 10px;
  margin-bottom: 5px;
  background-color: #A4A4A4;
}
.companyList tr:nth-child(even) {
  background-color: #f2f2f2;
}

.companyList img {
  width: 50px;
  height: 50px;
  margin-right: 10px;
}

.companyList td:nth-child(2) {
  margin-right: 20px;
  font-weight: bold;
}

.companyList td:nth-child(3) {
  padding: 5px 10px;
  border-radius: 5px;
  text-align: center;
}

/* 페이지네이션 기능넣어야함 */
.page {
  display: flex;
  justify-content: center;
  margin-top: 20px;
}

.page a {
  margin: 0 10px;
  color: #000;
  font-size: 18px;
  font-weight: bold;
}

.page a:hover {
  text-decoration: underline;
}

</style>
