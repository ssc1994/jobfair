<template>
  <tr :class="{view: isChecked}" @click="visible" @mouseenter="msEnter" @mouseleave="msLeave">
    <td>
      <div class="d-flex px-2 py-1" @onclick="getApplicantList"> <!-- 등록한 공고의 제목 -->
        <div class="d-flex flex-column justify-content-center">
          {{ jplInfo.jpl_title }}
        </div>
      </div>
    </td>
    <td> <!-- 현재까지 지원한 사람 수 -->
      <div class="d-flex flex-column justify-content-center">
        {{ countCdd }}
      </div>
    </td>
    <td class="align-middle text-center text-sm"> <!-- 공고 등록일 -->
      <span class="text-secondary text-s font-weight-bold">
        {{ jplInfo.jpl_regDate }}
      </span>
    </td>
    <td class="align-middle text-center text-sm"> <!-- 모집 종료일 -->
      <span class="text-secondary text-s font-weight-bold">
        {{ jplInfo.jpl_endDate }}
      </span>
    </td>
    <td class="align-middle"> <!-- 종료일이 sysdate 보다 작으면 모집중, 크면 모집완료 -->
      <!-- color: Date.now() > this.endDate ? secondary : success ???? 개어렵네;;;
      String을 날짜로 형변환해서 endDate랑 비교하고 그에 따라 변경값 대입시키면 될듯?-->
      <soft-badge color="secondary" variant="gradient" size="sm" v-if="!recruiting">
        모집 완료
      </soft-badge >
      <soft-badge color="success" variant="gradient" size="sm" v-if="recruiting">
        모집 중
      </soft-badge >
    </td>
  </tr>

  <tr v-if="isVisible">
    <td colspan="5">
      <table class="table align-items-center">
        <thead>
        <tr>
          <th>번호</th>
          <th colspan="2">이력서 제목</th>
          <th>작성자</th>
          <th>현황</th>
        </tr>
        </thead>
        <tbody>
        <!--                미확인 버튼에서 이력서 조회누르면 확인으로 바뀌면서 유저마이페이지에 값을 보내야함-->
        <tr v-if="!hasApplicant"><h3>{{infostr}}</h3></tr>
        <tr v-for="(applicant,index) in applicantList" :key="applicant.al_num" @mouseenter="msEnter" @mouseleave="msLeave">
          <td>{{ index + 1}}</td>
          <td colspan="2" :id ="applicant.res_num" @click="checkDetailRes">{{applicant.res_title}}</td>
          <td>{{ applicant.res_name }}</td>
          <td class="align-middle">
            <button type="button" class="btn btn-outline-success" :value="applicant.res_num" @click="checkBtn"
                    :class="applicant.al_state === 'X' ? isActive = false : isActive = true" :ref="'btn' + index" :id="index">
              {{applicant.al_state === 'X' ? '미열람' : '열람'}}
            </button>
          </td>
        </tr>
        </tbody>
      </table>
      <div v-if="hasApplicant" class="paginationWrap">
        <ul class="pagination">
          <li class="page-item"><a class="page-link"  @click="goFirstPage(page - 1)" style="margin-right: 10px">First</a></li>
          <li class="page-item"><a class="page-link"  @click="goPrevPage(page - 1)" style="margin-right: 10px">Previous</a></li>
          <template v-for="(item, index) in pageVO.pageList" :key="index">
            <li class="page-item" :class="{'active' : item == this.page}"><span class="page-link"  @click.prevent="ClickPage($event), getApplicantList()" id="index">{{item}}</span></li>
          </template>
          <li class="page-item"><a class="page-link"  @click="goNextPage(page + 1)" style="margin-right: 10px">Next</a></li>
          <li class="page-item"><a class="page-link"  @click="goLastPage(page + 1)" style="margin-right: 10px">Last</a></li>
        </ul>
      </div>
    </td>
  </tr>

</template>

<script>
import SoftBadge from "@/components/SoftBadge.vue";
import app from "@/App";

export default {
  name: "SingleAccordian.vue",
  props: [
    'jplInfo',
    'countCdd'
  ],
  data () {
    return {
      isVisible: false,
      isChecked: false,
      isActive: false,
      btnchar: '미열람',
      pageCount: 0,
      hasApplicant: false,
      innerBtn: '미열람',
      //페이지네이션 관련
      applicantList: [], // 지원자 리스트
      pageVO: "", //pageVO
      pageList: [], //pageVO.pageList 배열값
      detailNum: "",
      //페이지 이동에 필요한 초기값
      page: 1,
      amount: 10,
      prev: '',
      start: '',
      end: '',
      realEnd: '',
      recruiting:'',
      infostr: 'Loading...'
    }
  },
  created() {
    let sysDate = new Date();
    let endDate = new Date(this.jplInfo.jpl_endDate);

    let calDate = Math.trunc(((endDate - sysDate) / (1000 * 60 * 60 * 24)));

    if(calDate >= 0) this.recruiting = true;
    else if(calDate < 0) this.recruiting = false;

  },
  methods: {
    async visible (e) {
      this.isVisible = !this.isVisible;
      this.isChecked = !this.isChecked;

      if(this.isVisible){
        let appdata = {
          jpl_num: this.jplInfo.jpl_num,
          page: this.page,
          amount: this.amount
        }

        let res = await this.$axios.post("/jobfair/getApplicantList",
            appdata) .catch( err => console.log(err))
        this.pageVO = res.data.pageVO;
        this.applicantList= res.data.applicantList;
        this.hasApplicant = this.applicantList.length > 0 ? true : false;
        if(this.hasApplicant === false) this.infostr = "지원자가 없습니다."
      }
    },
    //테이블 제목 마우스엔터, 리브 이벤트 (마우스 올리면 백그라운드 변경)
    msEnter (e) {
      e.target.style=
          "background-color: gainsboro; cursor: pointer"
    },
    msLeave (e) {
      e.target.style=
          "background-color: none;"
    },
    // 미열람에서 버튼 클릭 시 버튼값 열람으로 변경
    checkBtn(e){
      var etarget = e.target
      var tmpstate = e.target.innerHTML === '미열람' ? 'X' : 'O';
      this.$axios.get("/jobfair/chgApplicantState",
                { params:
                        { res_num: e.target.value,
                          al_state: tmpstate}})
          .then((response) => {
            etarget.innerHTML === '미열람' ?
                etarget.innerHTML = '열람' : etarget.innerHTML = '미열람'
          })
          .catch(err => {
            alert("변경 실패")
          })
    },
    //클릭한 이력서 상세페이지로 이동
    checkDetailRes(e) {
      this.$router.push({
        name: 'uResumeDetailView',
        query: {
          res_num: e.target.id,
          isAble: false
        }
      })
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
    async getApplicantList () {
      let applicantData = {
        res_num: this.res_num,
        page: this.page,
        amount: this.amount
      }

      let res = await this.$axios.post("/jobfair/getApplicantList",
          applicantData) .catch( err => console.log(err))
      this.pageVO = res.data.pageVO;
      this.applicantList= res.data.applicantList;
      this.hasApplicant = this.applicantList.length > 0 ? true : false;
    }
  },
  components: {
    SoftBadge
  }
}
</script>

<style scoped>
.childTable {
  width: 100%;
}
.view {
  background-color: gainsboro;
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
