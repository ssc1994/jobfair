<template>
  <div class="adminBg" >



    <div class="container empBoxWrap" >
      <!--   채용 검색 폼   -->

      <div class="empSearchBox">
        <h3>채용공고 상세검색</h3>
        <form name="" action="">
          <div class="empSearchWrap">

            <div class="empSearchLocal">
              <input type="button" class="topBtn1" value="지역을 선택하세요" @click="upDown1"/>

            </div>
            <div class="empSearchJob">
              <input type="button" class="topBtn2" value="직무를 선택하세요" @click="upDown2"/>
            </div>

            <div class="empSearchInput">
              <input placeholder="채용공고명 또는 기관명을 입력해주세요." v-model="inputSearch">
            </div>
          </div>


          <!--#################################-->
          <!--  지역 또는 직무 클릭시 나오는 div -->
          <div class="showLocal" v-if="fold1">
            <!--  지역 검색 -->
            <div class="empBoxLabel citySrc1">
              <!--시-->
              <div v-for="city in city" :key="city.cityCode">
                <input type="checkbox" :id="city.cityCode" name="city" @change="plus" :value="city.cityName" v-model="selectedTag[0].tagValue">
                <label :for="city.cityCode">{{ city.cityName }}</label>
              </div>
            </div>
            <div class="empBoxLabel citySrc2">
              <!--구-->
              <div v-for="(goo,i) in cityGoo.filter( gc => gc.cityCode == checkedCity).values()" :key="i" >
                <div v-for="(gooName,j) in goo.gooName" :key="j">
                  <input type="checkbox" :id="gooName" name="gooName" :value="gooName" v-model="selectedTag[1].tagValue">
                  <label :for="gooName">{{ gooName}}</label>
                </div>
              </div>
            </div>

          </div>
          <!--   직무  -->
          <div class="showJob" v-if="fold2">

            <div class="empBoxLabel jobSrc1">
              <div v-for="job in jobArr" :key="job" class="jobSrc1Div">
                <input type="checkbox" :id="job" name="jpl_duty" @change="plus" :value="job" v-model="selectedTag[2].tagValue">
                <label :for="job">{{ job }}</label>
              </div>
            </div>


          </div>





          <div class="row">

            <div class="row">



              <div class="col-sm-2 empSearchBoxWrap">
                <div class="empBoxTitle">경력</div>
                <div class="empBoxLabel">
                  <div>
                    <input type="checkbox" id="jpl_workHistory1" name="jpl_workHistory" v-model="selectedTag[3].tagValue" value="신입"><label for="jpl_workHistory1">신입</label>
                  </div>
                  <div>
                    <input type="checkbox" id="jpl_workHistory2" name="jpl_workHistory" v-model="selectedTag[3].tagValue" value="경력"><label for="jpl_workHistory2">경력</label>
                  </div>
                </div>
              </div>

              <div class="col-sm-2 empSearchBoxWrap">
                <div class="empBoxTitle">학력</div>
                <div class="empBoxLabel">
                  <div>
                    <input type="checkbox" id="jpl_education1" name="jpl_education" v-model="selectedTag[4].tagValue" value="학력무관"><label for="jpl_education1">학력무관</label>
                  </div>
                  <div>
                    <input type="checkbox" id="jpl_education2" name="jpl_education" v-model="selectedTag[4].tagValue" value="고졸"><label for="jpl_education2">고졸</label>
                  </div>
                  <div>
                    <input type="checkbox" id="jpl_education3" name="jpl_education" v-model="selectedTag[4].tagValue" value="초대졸(2~3년)"><label for="jpl_education3">초대졸(2~3년)</label>
                  </div>
                  <div>
                    <input type="checkbox" id="jpl_education4" name="jpl_education" v-model="selectedTag[4].tagValue" value="대졸(4년)"><label for="jpl_education4">대졸(4년)</label>
                  </div>
                  <div>
                    <input type="checkbox" id="jpl_education5" name="jpl_education" v-model="selectedTag[4].tagValue" value="석사"><label for="jpl_education5">석사</label>
                  </div>
                  <div>
                    <input type="checkbox" id="jpl_education6" name="jpl_education" v-model="selectedTag[4].tagValue" value="박사"><label for="jpl_education6">박사</label>
                  </div>
                </div>
              </div>

              <div class="col-sm-2 empSearchBoxWrap">
                <div class="empBoxTitle">연봉</div>
                <div class="empBoxLabel">
                  <div>
                    <input type="checkbox" id="jpl_salary1" name="jpl_salary" v-model="selectedTag[5].tagValue" value="2500만원 이하"><label for="jpl_salary1">2500만원 이하</label>
                  </div>
                  <div>
                    <input type="checkbox" id="jpl_salary2" name="jpl_salary" v-model="selectedTag[5].tagValue" value="2500~3000만원"><label for="jpl_salary2">2500~3000만원</label>
                  </div>
                  <div>
                    <input type="checkbox" id="jpl_salary3" name="jpl_salary" v-model="selectedTag[5].tagValue" value="3000~4000만원"><label for="jpl_salary3">3000~4000만원</label>
                  </div>
                  <div>
                    <input type="checkbox" id="jpl_salary4" name="jpl_salary" v-model="selectedTag[5].tagValue" value="4000~5000만원"><label for="jpl_salary4">4000~5000만원</label>
                  </div>
                  <div>
                    <input type="checkbox" id="jpl_salary5" name="jpl_salary" v-model="selectedTag[5].tagValue" value="5000~6000만원"><label for="jpl_salary5">5000~6000만원</label>
                  </div>
                  <div>
                    <input type="checkbox" id="jpl_salary6" name="jpl_salary" v-model="selectedTag[5].tagValue" value="6000~7000만원"><label for="jpl_salary6">6000~7000만원</label>
                  </div>
                  <div>
                    <input type="checkbox" id="jpl_salary7" name="jpl_salary" v-model="selectedTag[5].tagValue" value="7000만원 이상"><label for="jpl_salary7">7000만원 이상</label>
                  </div>
                </div>
              </div>

              <div class="col-sm-2 empSearchBoxWrap">
                <div class="empBoxTitle">자격증</div>
                <div class="empBoxLabel">
                  <div>
                    <input type="checkbox" id="jpl_certificate1" name="jpl_certificate" v-model="selectedTag[6].tagValue" value="정보처리기사"><label for="jpl_certificate1">정보처리기사</label>
                  </div>
                  <div>
                    <input type="checkbox" id="jpl_certificate2" name="jpl_certificate" v-model="selectedTag[6].tagValue" value="웹디자인기능사"><label for="jpl_certificate2">웹디자인기능사</label>
                  </div>
                  <div>
                    <input type="checkbox" id="jpl_certificate3" name="jpl_certificate" v-model="selectedTag[6].tagValue" value="컴퓨터그래픽스"><label for="jpl_certificate3">컴퓨터그래픽스</label>
                  </div>
                  <div>
                    <input type="checkbox" id="jpl_certificate4" name="jpl_certificate" v-model="selectedTag[6].tagValue" value="정보기술자격(ITQ)"><label for="jpl_certificate4">정보기술자격(ITQ)</label>
                  </div>
                </div>
              </div>
              <div class="col-sm-2 empSearchBoxWrap">
                <div class="empBoxTitle">우대조건</div>
                <div class="empBoxLabel">
                  <div>
                    <input type="checkbox" id="jpl_conditions1" name="jpl_conditions" v-model="selectedTag[7].tagValue" value="국가유공자"><label for="jpl_conditions1">국가유공자</label>
                  </div>
                  <div>
                    <input type="checkbox" id="jpl_conditions2" name="jpl_conditions" v-model="selectedTag[7].tagValue" value="보훈대상자"><label for="jpl_conditions2">보훈대상자</label>
                  </div>
                  <div>
                    <input type="checkbox" id="jpl_conditions3" name="jpl_conditions" v-model="selectedTag[7].tagValue" value="고용촉진지원금 대상자"><label for="jpl_conditions3">고용촉진지원금 대상자</label>
                  </div>
                  <div>
                    <input type="checkbox" id="jpl_conditions4" name="jpl_conditions" v-model="selectedTag[7].tagValue" value="취업보호대상자"><label for="jpl_conditions4">취업보호대상자</label>
                  </div>
                  <div>
                    <input type="checkbox" id="jpl_conditions5" name="jpl_conditions" v-model="selectedTag[7].tagValue" value="병역특례"><label for="jpl_conditions5">병역특례</label>
                  </div>
                </div>
              </div>
              <div class="col-sm-2 empSearchBoxWrap">
                <div class="empBoxTitle">고용형태</div>
                <div class="empBoxLabel">
                  <div>
                    <input type="checkbox" id="jpl_Form1" name="jpl_Form" v-model="selectedTag[8].tagValue" value="정규직"><label for="jpl_Form1">정규직</label>
                  </div>
                  <div>
                    <input type="checkbox" id="jpl_Form2" name="jpl_Form" v-model="selectedTag[8].tagValue" value="계약직"><label for="jpl_Form2">계약직</label>
                  </div>
                  <div>
                    <input type="checkbox" id="jpl_Form3" name="jpl_Form" v-model="selectedTag[8].tagValue" value="인턴직"><label for="jpl_Form3">인턴직</label>
                  </div>
                </div>
              </div>
            </div>
            <div class="empSearchTag">

              <p v-for="(tagValue, i) in selectedTag" :key="i" style="display: inline-block; float: left; line-height: 3;">
                <span v-for="(tag, i) in tagValue.tagValue" :key="i" class="tagDesign">
                  {{tag}}<input type="button" @click="del" value="X" :id="tagValue.tagCode+i" style="border:0;padding:0 5px;">
                </span>
              </p>
              <button type="button" class="btn btn-primary searchBtn" @click.prevent="jobPostSearch">검색</button>

            </div>

          </div>

        </form>
      </div>


      <b style="padding:10px;color:#0064ff;border:1px solid #0064ff;border-radius: 20px;">분류기준</b>
      <select class="col-2 selSort" v-model="selSort" @change="sortEvent" style="padding:10px;">
        <option>최신등록순</option>
        <option>마감임박순</option>
        <option>연봉순</option>
      </select>

      <div class="row empListBox">

        <div v-for="(jobpost, i)  in jobPostList" :key=i @click.prevent="detail(jobpost.jpl_num)" class="empBoxConWrap col-6">

          <div class="empBoxCon">
            <router-link to="" class="left empBoxCompany">
              <p>{{ jobpost.com_name }}</p>
              <img :src="urlList[i]" >
            </router-link>
            <div class="left empBoxText">
              <router-link to="">
                <p class="empTitle">{{ jobpost.jpl_title }}</p>

                <p class="empBoxTag">{{ jobpost.jpl_workHistory }} {{ jobpost.jpl_education }} {{ jobpost.jpl_locationSi }} {{ jobpost.jpl_locationGu }} {{ jobpost.jpl_workForm}} {{ jobpost.jpl_salary}}</p>
              </router-link>
              <div style="padding-top:20px;">

                <span class="left empBoxDday">{{jobpost.jpl_endDate}}까지</span>
                <router-link to="" v-for="(appliedList, j) in appliedList" :key=j>

                  <button type="button" class="btn btn-primary aplBtn right applied" v-if="jobpost.jpl_num === appliedList.jpl_num"> <!---->
                    지원완료
                  </button>
                  <!--                  <button type="button" class="btn btn-primary aplBtn right" style="background-color: #0064ff;" v-if="jobpost.jpl_num != appliedList.jpl_num"> &lt;!&ndash;v-if="jobpost.user_id==null && jobpost.jpl_endDate"&ndash;&gt;-->
                  <!--                    지원하기{{jobpost.jpl_num}}-->
                  <!--                  </button>-->
                </router-link>
              </div>

            </div>

          </div>
        </div>
      </div>

      <!--페이지네이션 부분-->
      <div class="paginationWrap">
        <ul class="pagination">
          <li class="page-item"><a class="page-link"  @click="goFirstPage(page - 1)" style="margin-right: 10px">First</a></li>
          <li class="page-item"><a class="page-link"  @click="goPrevPage(page - 1)" style="margin-right: 10px" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
          <template v-for="(item, index) in pageList" :key="index">
            <li class="page-item" :class="{'active' : item == this.page}"><span class="page-link important"  @click.prevent="ClickPage($event), getJobPostList()" id="index">{{item}}</span></li>
          </template>
          <li class="page-item"><a class="page-link"  @click="goNextPage(page + 1)" style="margin-right: 10px" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
          <li class="page-item"><a class="page-link"  @click="goLastPage(page + 1)" style="margin-right: 10px">Last</a></li>
        </ul>
      </div>




    </div>
  </div>
</template>

<script>
import axios from 'axios'
import moment from "moment/moment";
export default {
  name: "uJobPostView",
  props : [
    'jobPost',
  ],
  data() {
    return {
      //채용공고 데이터
      jobPostList : [],
      d_day: '',
      endDate: '',
      //해당 유저가 지원한 jpl_num
      appliedList : [],
      //url
      urlList : [],
      //검색어 입력한 값
      inputSearch : "",
      //검색 태그
      selectedTag : [
        {tagCode : "jpl_locationSi", tagValue : [] }, //시
        {tagCode : "jpl_locationGu", tagValue : [] }, //구
        {tagCode : "jpl_duty", tagValue : [] }, //직무
        {tagCode : "jpl_workHistory", tagValue : [] }, //경력
        {tagCode : "jpl_education", tagValue : [] }, //학력
        {tagCode : "jpl_salary", tagValue : [] }, //연봉
        {tagCode : "jpl_certificate", tagValue : [] }, //자격증
        {tagCode : "jpl_conditions", tagValue : [] }, //우대조건
        {tagCode : "jpl_workForm", tagValue : [] } //고용형태
      ],
      checkedCity : 0,
      detailGoocode: 'noshow',
      //지역 배열
      city : [
        {cityCode: 1, cityName: "서울"},
        {cityCode: 2, cityName: "부산"},
        {cityCode: 3, cityName: "인천"},
        {cityCode: 4, cityName: "대구"},
        {cityCode: 5, cityName: "광주"},
        {cityCode: 6, cityName: "대전"},
        {cityCode: 7, cityName: "울산"},
        {cityCode: 8, cityName: "세종"},
        {cityCode: 9, cityName: "경기도"},
        {cityCode: 10, cityName: "강원도"},
        {cityCode: 11, cityName: "충청북도"},
        {cityCode: 12, cityName: "충청남도"},
        {cityCode: 13, cityName: "경상북도"},
        {cityCode: 14, cityName: "경상남도"},
        {cityCode: 15, cityName: "전라북도"},
        {cityCode: 16, cityName: "전라남도"},
        {cityCode: 17, cityName: "제주도"}
      ],
      cityGoo : [
        { cityCode: 1, gooName: ["종로구", "중구", "용산구", "성동구", "광진구", "동대문구", "중랑구", "성북구", "강북구", "도봉구", "노원구", "은평구", "서대문구", "마포구", "양천구", "강서구", "구로구", "금천구", "영등포구", "동작구", "관악구", "서초구", "강남구", "송파구","강동구"]},
        { cityCode: 2, gooName: ["중구", "서구", "동구", "영도구", "부산진구", "동래구", "남구", "북구", "해운대구", "사하구", "금정구", "강서구", "연제구", "수영구", "사상구", "기장군"] },
        { cityCode: 3, gooName: ["중구", "동구", "남구", "연수구", "남동구", "부평구", "계양구", "서구", "강화군", "옹진군"] },
        { cityCode: 4, gooName: ["중구", "동구", "서구", "남구", "북구", "수성구", "달서구", "달성군"] },
        { cityCode: 5, gooName: ["동구", "서구", "남구", "북구", "광산구"] },
        { cityCode: 6, gooName: ["동구", "중구", "서구", "유성구", "대덕구"] },
        { cityCode: 7, gooName: ["중구", "남구", "동구", "북구", "울주군"] },
        { cityCode: 8, gooName: [] },
        { cityCode: 9, gooName: ["가평군", "고양시", "과천시", "광명시", "광주시", "구리시", "군포시", "김포시", "남양주시", "동두천시", "부천시", "성남시", "수원시", "시흥시", "안산시", "안성시", "안양시", "양주시", "양평군", "여주시", "연천군", "오산시", "용인시", "의왕시", "의정부시", "이천시", "파주시", "평택시", "포천시", "하남시", "화성시"] },
        { cityCode: 10, gooName: ["원주시", "춘천시", "강릉시", "동해시", "속초시", "삼척시", "홍천군", "태백시", "철원군", "횡성군", "평창군", "영월군", "정선군", "인제군", "고성군", "양양군", "화천군", "양구군"] },
        { cityCode: 11, gooName: ["청주시", "충주시", "제천시", "보은군", "옥천군", "영동군", "증평군", "진천군", "괴산군", "음성군", "단양군"] },
        { cityCode: 12, gooName: ["천안시", "공주시", "보령시", "아산시", "서산시", "논산시", "계룡시", "당진시", "금산군", "부여군", "서천군", "청양군", "홍성군", "예산군", "태안군"] },
        { cityCode: 13, gooName: ["포항시", "경주시", "김천시", "안동시", "구미시", "영주시", "영천시", "상주시", "문경시", "경산시", "군위군", "의성군", "청송군", "영양군", "영덕군", "청도군", "고령군", "성주군", "칠곡군", "예천군", "봉화군", "울진군", "울릉군"] },
        { cityCode: 14, gooName: ["창원시", "김해시", "진주시", "양산시", "거제시", "통영시", "사천시", "밀양시", "함안군", "거창군", "창녕군", "고성군", "하동군", "합천군", "남해군", "함양군", "산청군", "의령군"] },
        { cityCode: 15, gooName: ["전주시", "익산시", "군산시", "정읍시", "완주군", "김제시", "남원시", "고창군", "부안군", "임실군", "순창군", "진안군", "장수군", "무주군"] },
        { cityCode: 16, gooName: ["여수시", "순천시", "목포시", "광양시", "나주시", "무안군", "해남군", "고흥군", "화순군", "영암군", "영광군", "완도군", "담양군", "장성군", "보성군", "신안군", "장흥군", "강진군", "함평군", "진도군", "곡성군", "구례군"] },
        { cityCode: 17, gooName: ["제주시", "서귀포시"]}
      ],
      jobArr : [
        "경영ㆍ사무",
        "마케팅ㆍ광고ㆍ홍보",
        "ITㆍ인터넷",
        "디자인",
        "무역ㆍ유통",
        "영업ㆍ고객상담",
        "서비스",
        "연구개발ㆍ설계",
        "생산ㆍ제조",
        "교육",
        "건설",
        "의료",
        "미디어",
        "전문특수직"
      ],
      fold1 : false,
      fold2 : false,
      arrSrc : "up",
      selSort : '최신등록순',
      selSortInt : 1,
      user_id: sessionStorage.getItem('sessionId').replaceAll("\"", ""),


      //엑시오스 테스트
      users : '',

      //은영 테스트
      com_num: 3,

      // list: "",
      pages: "", // pageVO
      pageList: "", //pageVO.pageList 배열값
      detailNum: "",

      //페이지 이동에 필요한 초기값
      page: 1,
      amount: 10,
      prev: "",
      start: "",
      end: "",
      realEnd: "",


    }
  },

  created()  {

    this.getJobPostList();


    let sysDate = new Date();
    let endDate = new Date(this.jobPostList.jpl_endDate);

    let calDate = Math.trunc(((endDate - sysDate) / (1000 * 60 * 60 * 24)));

    if(calDate > 0) this.d_day = 'D - ' + calDate;
    else if(calDate === 0) this.d_day = "금일 마감";
    else if(calDate < 0) this.d_day = "모집종료"

    this.endDate = (endDate.getMonth() + 1) + '월 ' + endDate.getDate() + '일 마감'

  },
  methods: {

    //채용공고 가져오기
    async getJobPostList () {

      let {data} = await this.$axios.get('/jobfair/getJobPostList',
          {
            params: {
              page: this.page,
              amount: this.amount,
              selSortInt: this.selSortInt,
              user_id : this.user_id
            }
          }).catch(err => console.log(err))

      this.urlList = data.urlList;
      this.jobPostList = data.empPageGate.list;
      this.appliedList = data.appliedList;
      this.pages = data.empPageGate.pageVO;
      this.pageList = this.pages.pageList;

      //페이지이동에 필요한 데이터 담기
      this.page = this.pages.page;
      this.prev = this.pages.prev;
      this.pageStart = this.pages.pageStart;
      this.pageEnd = this.pages.pageEnd;
      this.realEnd = this.pages.realEnd;
    }
    ,
    //채용공고 검색 목록 가져오기
    async jobPostSearch(){
      var jpl_locationSi = this.selectedTag[0].tagValue;
      var jpl_locationGu = this.selectedTag[1].tagValue;
      var jpl_duty = this.selectedTag[2].tagValue;
      var jpl_workHistory = this.selectedTag[3].tagValue;
      var jpl_education = this.selectedTag[4].tagValue;
      var jpl_salary = this.selectedTag[5].tagValue;
      var jpl_certificate = this.selectedTag[6].tagValue;
      var jpl_conditions = this.selectedTag[7].tagValue;
      var jpl_workForm = this.selectedTag[8].tagValue;

      //검색 태그가 있는지 확인
      var cnt = 0;
      for(var i = 0; i < this.selectedTag.length; i++){
        for(var j = 0; j < this.selectedTag[i].tagValue.length; j++) {
          cnt++;

        }
      }

      const vo = {
        jpl_duty:jpl_duty,
        jpl_workHistory:jpl_workHistory,
        jpl_workForm:jpl_workForm,
        jpl_education:jpl_education,
        jpl_conditions:jpl_conditions,
        jpl_certificate:jpl_certificate,
        jpl_salary:jpl_salary,
        jpl_locationSi:jpl_locationSi,
        jpl_locationGu:jpl_locationGu,
        inputSearch :this.inputSearch,
        selSortInt : this.selSortInt
      }

      if(cnt == 0 && this.inputSearch == ""){
        alert('검색 키워드가 없습니다!')
      } else {
        let {data} = await this.$axios.post('/jobfair/getJobPostSrc',
            {
              page: this.page,
              amount: this.amount,
              jpl_duty: jpl_duty,
              jpl_workHistory:jpl_workHistory,
              jpl_workForm:jpl_workForm,
              jpl_education:jpl_education,
              jpl_conditions:jpl_conditions,
              jpl_certificate:jpl_certificate,
              jpl_salary:jpl_salary,
              jpl_locationSi:jpl_locationSi,
              jpl_locationGu:jpl_locationGu,
              inputSearch :this.inputSearch,
              selSortInt :this.selSortInt

            }).catch(err => console.log(err))




        this.urlList = data.urlList;
        this.jobPostList = data.empSrcPageGate.list
        this.pages = data.empSrcPageGate.pageVO;
        this.pageList = this.pages.pageList;

        //페이지이동에 필요한 데이터 담기
        this.page = this.pages.page;
        this.prev = this.pages.prev;
        this.pageStart = this.pages.pageStart;
        this.pageEnd = this.pages.pageEnd;
        this.realEnd = this.pages.realEnd;

      }
    },

    //페이지 네이션 부분
    goFirstPage() {
      this.page = 1;
      this.getJobPostList();
    },
    goPrevPage() {
      if(this.page > 1) {
        this.page = this.page - 1;
        this.getJobPostList();
      } else {
        alert("첫 페이지입니다.");
      }
    },
    goNextPage() {
      if(this.page < this.realEnd) {
        this.page = this.page + 1;
        this.getJobPostList();
      } else {
        alert("마지막 페이지입니다.")
      }
    },
    goLastPage() {
      this.page = this.realEnd;
      this.getJobPostList();
    },
    ClickPage(e) {
      var clicked = e.target.innerHTML;
      this.page = clicked;
    },
    curcur(){
      const moment = require('moment')
      var time = moment();
      var etime = moment(this.jpl_endDate, 'YYYY-MM-DD');
      var stime = moment(this.jpl_startDate, 'YYYY-MM-DD');

      if(moment(time).isBetween(stime,etime)){
        //현재 시간이 접수 시작일과 마감일 사이일경우 동작
        // this.curTime=moment.duration(etime.diff(time))
        // this.diffDay=this.curTime.days()
        // this.diffHour=this.curTime.hours()
        // this.diffMin=this.curTime.minutes()
        // this.diffSec=this.curTime.seconds()
        // this.diffTime= this.diffDay+"일 "+this.diffHour+"시간"+this.diffMin+"분"+this.diffSec+"초"
      }else {
        //현재 시간이 접수 시작일과 마감일 사이가 아닐경우 남은시간이 아닌 공고 마감 출력
        this.diffTime= "공고 마감"
        clearInterval(this.curcur)
      }
    },
    //구 필터
    plus : function(e) {
      this.checkedCity = e.target.id;
    },
    //태그 삭제 함수
    del : function (e) {

      var regex = /[^0-9]/g;
      var index = e.target.id.replace(regex, "");
      var tagName = e.target.id.replace(index, "");

      for(var i = 0; i < this.selectedTag.length; i++){
        if(this.selectedTag[i].tagCode == tagName){
          for(var j = 0; j < this.selectedTag[i].tagValue.length; j++) {
            this.selectedTag[i].tagValue.splice(index,1);
          }
        }
      }

    },

    detail(jobpost) {
      this.$router.push({
        name: 'uJobPostDetailView',
        params: {
          jpl_num: jobpost
        }
      })
    },
    //지역 열고 닫기
    upDown1 : function (e){
      this.fold1 = !this.fold1;
      this.fold2 = false;
    },
    //직무 열고 닫기
    upDown2 : function (e){
      this.fold2 = !this.fold2;
      this.fold1 = false;
    },
    sortEvent(e){
      if(this.selSort == "최신등록순"){
        this.selSortInt = '1';
      }else if(this.selSort == "마감임박순"){
        this.selSortInt = '2';
      }else if(this.selSort == "연봉순"){
        this.selSortInt = '3';
      }

      var cnt = 0;
      for(var i=0; i < this.selectedTag.length; i++){
        for(var j=0; j < this.selectedTag[i].tagValue.length; j++){
          cnt++;
        }
      }

      if(cnt == 0){
        this.getJobPostList();
      } else {
        this.jobPostSearch();
      }
    },
  }
}
</script>

<style scoped>

@import "uJobPostView.css";

*{
  padding: 0;
  margin: 0;
  list-style: none;
  font-size:15px;
}

a {text-decoration: none;}

select {
  -moz-appearance: none;
}

select:hover {
  border-color: #888;
}

select:focus {
  border-color: #aaa;
  box-shadow: 0 0 1px 3px rgba(59, 153, 252, 0.7);
  box-shadow: 0 0 0 3px -moz-mac-focusring;
  color: #222;
  outline: none;
}

select:disabled {
  opacity: 0.5;
}


html, body {width:100%;
  height:100%;}

.left{float: left;}
.right {float:right;}

.empBoxWrap {
  max-width:1560px;
  margin:0 auto;
}

/*채용리스트*/

.empListBox {padding-top:30px;}

.empBoxTitle {
  font-weight: bold;
  font-size: 18px;
  /*background-color: #efefef;*/
}
.empBoxTag {color:#838383;}


.empBoxConWrap {
  width:780px;
  height:160px;
  display: inline-block;padding:2px;

  text-align: left;
  margin-bottom: 20px;

}

.empBoxCon {
  padding:25px;
  overflow: hidden;
  background-color: white;
  border-radius: 20px;
  border: 2px solid #dedede;
  display:inline-block;
  width:98%;
  height: 160px;
  margin-bottom: 10px;
}

.empTitle {font-size: 18px;font-weight: bold;}

.empBoxCon:hover { border: 2px solid #0064ff; }

.empBoxCompany p {color:black;

  line-height: 1.3;
  white-space: pre-line;
  word-wrap: break-word;
}

.empBoxCompany {
  display: inline-block;
  /*cursor: pointer;*/
  float: left;
  margin-right:10px;
  width:13%;
}
.empBoxCon img{
  float: left;
  width:80px;
  height:80px;
  display: inline;
  object-fit: contain;
}

.aplBtn {border:none;
  background-color: #0064ff;
  width:20%;
  height:40px;

}
.applied {background-color: #dedede;
  color:black;
}

.empBoxText {padding-left: 5px;color:black;display: inline-block;
  /*cursor: pointer;*/
  width:600px;
}

.empBoxText router-link {text-align: left;border:0;}

.empBoxText p {margin:0; padding:0;}

.empBoxDday {
  font-weight: bold;
  padding:5px 15px;
  color:rgb(229, 75, 75);
  border:1px solid rgb(229, 75, 75);
  border-radius:20px;
  margin-right: 5px;
}

h3{font-weight: bold;
  font-size: 20px;

}

/*검색 박스*/
.empSearchBox {border: 1px solid #dedede;
  padding:30px 60px;
  border-radius: 20px;
  text-align: left;
  margin-bottom: 20px;
  height:auto;
  box-shadow: rgba(0, 0, 0, 0.16) 0px 10px 36px 0px, rgba(0, 0, 0, 0.06) 0px 0px 0px 1px;

}

.empSearchBox h3 {padding-bottom: 20px;}

.empSearchBox:hover {}

.empSearchTitle {font-weight:bold;
  /*background-color: #dedede;*/
  display: inline-block;
  /*text-align: center;*/
  width:100%;
  height:30px;

}

.empSearchWrap {overflow: hidden;

}

.empSearchWrap > div {
  float: left;
  width:33.33%;
  box-sizing: border-box;

}

.empSearchWrap > div > div {width:100%;}

.empSearchWrap > div > button {
  width:100%;
  height:50px;
  /*background-color: #efefef;*/
  border:1px solid #dedede;
  font-weight: bold;
}

.empBoxTitle {
  font-weight: bold;
  font-size: 15px;
  padding:10px;
  border: 1px solid #dedede;
  background-color: #efefef;

}

.empSearchInput input {
  width:100%;
  height:50px;
  border:0;
  border: 1px solid #dedede;
  padding-left: 50px;
  background-image: url("@/assets/icon_src.svg");
  background-position: 15px 10px;
  background-repeat: no-repeat;
  background-size: 23px;


}

.empSearchInput input:focus {border:1px solid #0064ff;}

.empSearchLocal input {border-right: none;}
.empSearchJob input {border-right: none;}
.empSearchLocal input, .empSearchJob input{
  text-align: left;
  padding-left: 60px;
  border: 1px solid #dedede;
  background-color: #efefef;
}

.empSearchLocal img, .empSearchJob img{border:0;
  width:20px;
  height:30px;
  object-fit: contain;}

/* 공고 검색 */
.showLocal {height: 200px;

}

.showJob {height:200px;}
.showLocal .empBoxLabel {border:0;height:90%;}
.showJob .empBoxLabel {border:0;height:100%; padding:0px;}
.jobCate_1, .jobCate_2, .jobCate_3 {width:33.3%;display: inline-block;}

.empBoxLabel {
  padding:10px;
  height:120px;
  border: 1px solid #dedede;
  overflow: auto;

}

.empBoxLabel div label{
  padding:5px 10px;
  margin: 2px;
  font-size: 13px;
}

.empBoxLabel div input {display: none;}


.empBoxLabel div input:checked + label{border:1px solid #0064ff;
  border-radius: 20px;}
.empBoxLabel .jobSrc1Div input:checked + label {border:1px solid #0064ff; border-radius:20px;width:90%; height:90%;}

.empBoxLabel label {padding-left:8px;}

.empSearchTag {margin-top:20px;}

.tagDesign {
  margin-top:20px;
  background-color: #efefef;
  border-radius: 20px;
  padding:10px;
  border : 1px solid #dedede;
  color: #0064ff;}

.del {
  margin-left: 5px;
  padding:0 5px;
  border:0;
}

.searchBtn {width:13%;
  height:40px;
  background-color: #dedede;
  float: right;
  margin-top:10px;
  color:black;
}

.searchBtn:hover {
  background-color: #0064ff;
  color:white;
}

.citySrc1 {
  width:40%;
  display: inline-block;

}

.citySrc1 div {display:inline-block;width:50%;}

.citySrc2 {
  width:60%;
  display: inline-block;
}

.citySrc2 div {display: inline-block;width:50%;}

.jobSrc1 {height:auto;}




.jobSrc1 div{display: inline-block;
  width:16.66%;
  height:50px;
  /*border:1px solid #dedede;*/
  /*background-color: #f2f6ff;*/
  text-align: center;
  line-height: 35px;
  cursor:pointer;
}

.jobSrc1 div input {width:100%;display: none;}
.jobSrc1 div label {width:100%;}

.topBtn1 {width:100%;
  height:50px;
  font-weight: bold;
  background-image: url("@/assets/icon_location.svg");
  background-position: 15px 10px;
  background-repeat: no-repeat;
  background-size: 27px;
  background-color: white;
}
.topBtn2 {width:100%;
  height:50px;
  font-weight: bold;
  background-image: url("@/assets/icon_jobcard.svg");
  background-position: 15px 10px;
  background-repeat: no-repeat;
  background-size: 30px;
  background-color: white;

}

.selSort {width:130px;font-weight: bold;border:0;}

/* 페이지네이션 부분 */

.paginationWrap .page-link {
  background-color: white;
}

.paginationWrap li.active span {
  background-color: #202632;
  border: none;
}

.pagination {
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 20px 0;
}

.page-item {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-right: 10px;
}

.page-link {
  color: #333;
  border: none;
  background: none;
  cursor: pointer;
}

.page-link:hover {
  color: #0064ff;
}

.active .page-link {
  color: #fff;
  background-color: #007bff;
  border-color: #007bff;
}

</style>