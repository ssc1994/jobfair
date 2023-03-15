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
<!--                <span><img src="@/assets/icon_city.png"></span>-->
<!--                <img :src="require(`@/assets/icon_arr_${arrSrc}.png`)"/>-->



            </div>
            <div class="empSearchJob">
              <input type="button" class="topBtn2" value="직무를 선택하세요" @click="upDown2"/>
<!--                <span><img src="@/assets/icon_job.png"></span>-->
                <!--                <img :src="require(`@/assets/icon_arr_${arrSrc}.png`)" @click="upDown"/>-->

            </div>

            <div class="empSearchInput">
              <input placeholder="채용공고명 또는 기관명을 입력해주세요." >
            </div>
          </div>


          <!--#################################-->
          <!--  지역 또는 직무 클릭시 나오는 div -->
          <div class="showLocal" v-if="fold1">
            <!--  지역 검색 -->
            <div>
              <input placeholder="지역을 입력해주세요." >
            </div>

            <div class="empBoxLabel citySrc1">
              <!--시-->
              <div v-for="city in city" :key="city.cityCode">
                <input type="checkbox" :id="city.cityCode" name="city" @change="plus" :value="city.cityName">
                <label :for="city.cityCode">{{ city.cityName }}</label>
              </div>
            </div>
            <div class="empBoxLabel citySrc2">
              <!--구-->
              <div v-for="(goo,i) in cityGoo.filter( gc => gc.cityCode == checkedCity).values()" :key="i">
                <div v-for="(gooName,j) in goo.gooName" :key="j">
                  <input type="checkbox" :id="gooName" name="gooName" :value="gooName" v-model="selectedTag">
                  <label :for="gooName">{{ gooName}}</label>
                </div>
              </div>
            </div>

          </div>
          <!--   직무  -->
          <div class="showJob" v-if="fold2">
            <!--  지역 검색 -->
            <div>
              <input placeholder="직무을 입력해주세요." >
            </div>

            <div class="empBoxLabel citySrc1">
              <!--시-->
              <div v-for="job in jobArr" :key="job">
                <input type="checkbox" :id="job" name="city" @change="plus" :value="job" v-model="selectedTag">
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
                    <input type="checkbox" id="careerCate1" name="careerCate" v-model="selectedTag" value="신입"><label for="careerCate1">신입</label>
                  </div>
                  <div>
                    <input type="checkbox" id="careerCate2" name="careerCate" v-model="selectedTag" value="경력"><label for="careerCate2">경력</label>
                  </div>
                </div>
              </div>

              <div class="col-sm-2 empSearchBoxWrap">
                <div class="empBoxTitle">학력</div>
                <div class="empBoxLabel">
                  <div>
                    <input type="checkbox" id="eduCate1" name="eduCate" v-model="selectedTag" value="학력무관"><label for="eduCate1">학력무관</label>
                  </div>
                  <div>
                    <input type="checkbox" id="eduCate2" name="eduCate" v-model="selectedTag" value="고졸"><label for="eduCate2">고졸</label>
                  </div>
                  <div>
                    <input type="checkbox" id="eduCate3" name="eduCate" v-model="selectedTag" value="초대졸(2~3년)"><label for="eduCate3">초대졸(2~3년)</label>
                  </div>
                  <div>
                    <input type="checkbox" id="eduCate4" name="eduCate" v-model="selectedTag" value="대졸(4년)"><label for="eduCate4">대졸(4년)</label>
                  </div>
                  <div>
                    <input type="checkbox" id="eduCate5" name="eduCate" v-model="selectedTag" value="석사"><label for="eduCate5">석사</label>
                  </div>
                  <div>
                    <input type="checkbox" id="eduCate6" name="eduCate" v-model="selectedTag" value="박사"><label for="eduCate6">박사</label>
                  </div>
                </div>
              </div>

              <div class="col-sm-2 empSearchBoxWrap">
                <div class="empBoxTitle">연봉</div>
                <div class="empBoxLabel">
                  <div>
                    <input type="checkbox" id="salaryCate1" name="salaryCate" v-model="selectedTag" value="2500만원 이하"><label for="salaryCate1">2500만원 이하</label>
                  </div>
                  <div>
                    <input type="checkbox" id="salaryCate2" name="salaryCate" v-model="selectedTag" value="2500~3000만원"><label for="salaryCate2">2500~3000만원</label>
                  </div>
                  <div>
                    <input type="checkbox" id="salaryCate3" name="salaryCate" v-model="selectedTag" value="3000~4000만원"><label for="salaryCate3">3000~4000만원</label>
                  </div>
                  <div>
                    <input type="checkbox" id="salaryCate4" name="salaryCate" v-model="selectedTag" value="4000~5000만원"><label for="salaryCate4">4000~5000만원</label>
                  </div>
                  <div>
                    <input type="checkbox" id="salaryCate5" name="salaryCate" v-model="selectedTag" value="5000~6000만원"><label for="salaryCate5">5000~6000만원</label>
                  </div>
                  <div>
                    <input type="checkbox" id="salaryCate6" name="salaryCate" v-model="selectedTag" value="6000~7000만원"><label for="salaryCate6">6000~7000만원</label>
                  </div>
                  <div>
                    <input type="checkbox" id="salaryCate7" name="salaryCate" v-model="selectedTag" value="7000만원 이상"><label for="salaryCate7">7000만원 이상</label>
                  </div>
                </div>
              </div>

              <div class="col-sm-2 empSearchBoxWrap">
                <div class="empBoxTitle">자격증</div>
                <div class="empBoxLabel">
                  <div>
                    <input type="checkbox" id="certiCate1" name="certiCate" v-model="selectedTag" value="정보처리기사"><label for="certiCate1">정보처리기사</label>
                  </div>
                  <div>
                    <input type="checkbox" id="certiCate2" name="certiCate" v-model="selectedTag" value="웹디자인기능사"><label for="certiCate2">웹디자인기능사</label>
                  </div>
                  <div>
                    <input type="checkbox" id="certiCate3" name="certiCate" v-model="selectedTag" value="컴퓨터그래픽스"><label for="certiCate3">컴퓨터그래픽스</label>
                  </div>
                  <div>
                    <input type="checkbox" id="certiCate4" name="certiCate" v-model="selectedTag" value="정보기술자격(ITQ)"><label for="certiCate4">정보기술자격(ITQ)</label>
                  </div>
                </div>
              </div>
              <div class="col-sm-2 empSearchBoxWrap">
                <div class="empBoxTitle">우대조건</div>
                <div class="empBoxLabel">
                  <div>
                    <input type="checkbox" id="udaeCate1" name="udaeCate" v-model="selectedTag" value="국가유공자"><label for="udaeCate1">국가유공자</label>
                  </div>
                  <div>
                    <input type="checkbox" id="udaeCate2" name="udaeCate" v-model="selectedTag" value="보훈대상자"><label for="udaeCate2">보훈대상자</label>
                  </div>
                  <div>
                    <input type="checkbox" id="udaeCate3" name="udaeCate" v-model="selectedTag" value="고용촉진지원금 대상자"><label for="udaeCate3">고용촉진지원금 대상자</label>
                  </div>
                  <div>
                    <input type="checkbox" id="udaeCate4" name="udaeCate" v-model="selectedTag" value="취업보호대상자"><label for="udaeCate4">취업보호대상자</label>
                  </div>
                  <div>
                    <input type="checkbox" id="udaeCate5" name="udaeCate" v-model="selectedTag" value="병역특례"><label for="udaeCate5">병역특례</label>
                  </div>
                </div>
              </div>
              <div class="col-sm-2 empSearchBoxWrap">
                <div class="empBoxTitle">고용형태</div>
                <div class="empBoxLabel">
                  <div>
                    <input type="checkbox" id="empCate1" name="empCate" v-model="selectedTag" value="정규직"><label for="empCate1">정규직</label>
                  </div>
                  <div>
                    <input type="checkbox" id="empCate2" name="empCate" v-model="selectedTag" value="계약직"><label for="empCate2">계약직</label>
                  </div>
                  <div>
                    <input type="checkbox" id="empCate3" name="empCate" v-model="selectedTag" value="인턴직"><label for="empCate3">인턴직</label>
                  </div>
                </div>
              </div>
            </div>
            <div class="empSearchTag">
              <button type="button" class="btn btn-primary searchBtn" @click="getData">선택된 120건 검색</button>
              <span v-for="(tag, i) in selectedTag" :key="i">
                {{tag}}<input type="button" @click="del" value="X" :id="i" style="border:0;padding:0 5px ;">
              </span>
            </div>

          </div>

        </form>
      </div>


      <select class="col-2">
        <option>최신등록순</option>
        <option>마감임박순</option>

      </select>

      <div class="row empListBox">

        <div class="empBoxConWrap col-6">

          <div class="empBoxCon ">
            <router-link to="" class="left empBoxCompany">
              <p>(주) 카카오</p>
              <img src="@/assets/kakao.png" >
            </router-link>
            <div class="left empBoxText">
              <router-link to="">
                <p class="empTitle">UIUX 디자이너</p>

                <p class="empBoxTag">경력무관 초대졸 경기도 성남시 정규직 3,000~3,400만원</p>
              </router-link>
              <div style="padding-top:20px;">
                <span class="left empBoxDday">D-27</span>
                <span class="left empBoxDday">~7월 14일까지</span>
                <button type="button" class="btn btn-primary aplBtn right applied">지원완료</button>
              </div>

            </div>

          </div>
        </div>

        <div class="empBoxConWrap col-6">
          <div class="empBoxCon ">
            <router-link to="" class="left empBoxCompany">
              <p>(주) 카카오</p>
              <img src="@/assets/kakao.png" >
            </router-link>
            <div class="left empBoxText">
              <router-link to="">
                <p class="empTitle">UIUX 디자이너</p>

                <p class="empBoxTag">경력무관 초대졸 경기도 성남시 정규직 3,000~3,400만원</p>
              </router-link>
              <div style="padding-top:20px;">
                <span class="left empBoxDday">D-27</span>
                <button type="button" class="btn btn-primary aplBtn right" style="background-color: #0064ff;">지원하기</button>
              </div>

            </div>

          </div>
        </div>

        <div class="empBoxConWrap col-6">
          <div class="empBoxCon ">
            <router-link to="" class="left empBoxCompany">
              <p>(주) 카카오</p>
              <img src="@/assets/kakao.png" >
            </router-link>
            <div class="left empBoxText">
              <router-link to="">
                <p class="empTitle">UIUX 디자이너</p>

                <p class="empBoxTag">경력무관 초대졸 경기도 성남시 정규직 3,000~3,400만원</p>
              </router-link>
              <div style="padding-top:20px;">
                <span class="left empBoxDday">D-27</span>
                <button type="button" class="btn btn-primary aplBtn right" style="background-color: #0064ff;">지원하기</button>
              </div>

            </div>

          </div>
        </div>

        <div class="empBoxConWrap col-6">
          <div class="empBoxCon ">
            <router-link to="" class="left empBoxCompany">
              <p>(주) 카카오</p>
              <img src="@/assets/kakao.png" >
            </router-link>
            <div class="left empBoxText">
              <router-link to="">
                <p class="empTitle">UIUX 디자이너</p>

                <p class="empBoxTag">경력무관 초대졸 경기도 성남시 정규직 3,000~3,400만원</p>
              </router-link>
              <div style="padding-top:20px;">
                <span class="left empBoxDday">D-27</span>
                <button type="button" class="btn btn-primary aplBtn right" style="background-color: #0064ff;">지원하기</button>
              </div>

            </div>

          </div>
        </div>

        <div class="empBoxConWrap col-6">
          <div class="empBoxCon ">
            <router-link to="" class="left empBoxCompany">
              <p>(주) 카카오</p>
              <img src="@/assets/kakao.png" >
            </router-link>
            <div class="left empBoxText">
              <router-link to="">
                <p class="empTitle">UIUX 디자이너</p>

                <p class="empBoxTag">경력무관 초대졸 경기도 성남시 정규직 3,000~3,400만원</p>
              </router-link>
              <div style="padding-top:20px;">
                <span class="left empBoxDday">D-27</span>
                <button type="button" class="btn btn-primary aplBtn right" style="background-color: #0064ff;">지원하기</button>
              </div>

            </div>

          </div>
        </div>

      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: "uJobPostView",
  data() {
    return {
      selectedTag : [],
      checkedCity : 0,
      detailGoocode: 'noshow',
      //지역 배열
      city : [
        { cityCode : 1, cityName : "서울특별시"},
        { cityCode : 2, cityName : "부산광역시"},
        { cityCode : 3, cityName : "인천광역시"},
        { cityCode : 4, cityName : "대구광역시"},
        { cityCode : 5, cityName : "광주광역시"},
        { cityCode : 6, cityName : "대전광역시"},
        { cityCode : 7, cityName : "울산광역시"},
        { cityCode : 8, cityName : "세종특별자치시"},
        { cityCode : 9, cityName : "경기도"},
        { cityCode : 10, cityName : "강원도"},
        { cityCode : 11, cityName : "충청북도"},
        { cityCode : 12, cityName : "충청남도"},
        { cityCode : 13, cityName : "경상북도"},
        { cityCode : 14, cityName : "경상남도"},
        { cityCode : 15, cityName : "전라북도"},
        { cityCode : 16, cityName : "전라남도"},
        { cityCode : 17, cityName : "제주특별자치도"}
      ],
      cityGoo : [
        { cityCode: 1, gooName: ["서울 전체", "종로구", "중구", "용산구", "성동구", "광진구", "동대문구", "중랑구", "성북구", "강북구", "도봉구", "노원구", "은평구", "서대문구", "마포구", "양천구", "강서구", "구로구", "금천구", "영등포구", "동작구", "관악구", "서초구", "강남구", "송파구","강동구"]},
        { cityCode: 2, gooName: ["부산 전체", "중구", "서구", "동구", "영도구", "부산진구", "동래구", "남구", "북구", "해운대구", "사하구", "금정구", "강서구", "연제구", "수영구", "사상구", "기장군"] },
        { cityCode: 3, gooName: ["인천 전체", "중구", "동구", "남구", "연수구", "남동구", "부평구", "계양구", "서구", "강화군", "옹진군"] },
        { cityCode: 4, gooName: ["대구 전체", "중구", "동구", "서구", "남구", "북구", "수성구", "달서구", "달성군"] },
        { cityCode: 5, gooName: ["광주 전체", "동구", "서구", "남구", "북구", "광산구"] },
        { cityCode: 6, gooName: ["대전 전체", "동구", "중구", "서구", "유성구", "대덕구"] },
        { cityCode: 7, gooName: ["울산 전체", "중구", "남구", "동구", "북구", "울주군"] },
        { cityCode: 8, gooName: ["세종 전체"] },
        { cityCode: 9, gooName: ["경기 전체", "가평군", "고양시", "과천시", "광명시", "광주시", "구리시", "군포시", "김포시", "남양주시", "동두천시", "부천시", "성남시", "수원시", "시흥시", "안산시", "안성시", "안양시", "양주시", "양평군", "여주시", "연천군", "오산시", "용인시", "의왕시", "의정부시", "이천시", "파주시", "평택시", "포천시", "하남시", "화성시"] },
        { cityCode: 10, gooName: ["강원 전체", "원주시", "춘천시", "강릉시", "동해시", "속초시", "삼척시", "홍천군", "태백시", "철원군", "횡성군", "평창군", "영월군", "정선군", "인제군", "고성군", "양양군", "화천군", "양구군"] },
        { cityCode: 11, gooName: ["충청북도 전체", "청주시", "충주시", "제천시", "보은군", "옥천군", "영동군", "증평군", "진천군", "괴산군", "음성군", "단양군"] },
        { cityCode: 12, gooName: ["충청남도 전체", "천안시", "공주시", "보령시", "아산시", "서산시", "논산시", "계룡시", "당진시", "금산군", "부여군", "서천군", "청양군", "홍성군", "예산군", "태안군"] },
        { cityCode: 13, gooName: ["경상북도 전체", "포항시", "경주시", "김천시", "안동시", "구미시", "영주시", "영천시", "상주시", "문경시", "경산시", "군위군", "의성군", "청송군", "영양군", "영덕군", "청도군", "고령군", "성주군", "칠곡군", "예천군", "봉화군", "울진군", "울릉군"] },
        { cityCode: 14, gooName: ["경상남도 전체", "창원시", "김해시", "진주시", "양산시", "거제시", "통영시", "사천시", "밀양시", "함안군", "거창군", "창녕군", "고성군", "하동군", "합천군", "남해군", "함양군", "산청군", "의령군"] },
        { cityCode: 15, gooName: ["전라북도 전체", "전주시", "익산시", "군산시", "정읍시", "완주군", "김제시", "남원시", "고창군", "부안군", "임실군", "순창군", "진안군", "장수군", "무주군"] },
        { cityCode: 16, gooName: ["전라남도 전체", "여수시", "순천시", "목포시", "광양시", "나주시", "무안군", "해남군", "고흥군", "화순군", "영암군", "영광군", "완도군", "담양군", "장성군", "보성군", "신안군", "장흥군", "강진군", "함평군", "진도군", "곡성군", "구례군"] },
        { cityCode: 17, gooName: ["제주도 전체", "제주시", "서귀포시"]}
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

      // 선택된 value
      job : '',
      local : '',
      career: '',
      education : '',
      salary : '',
      certi : '',

      //엑시오스 테스트
      users : '',
      beforeCreate() {

        this.$axios.get('/jobfair/uJobpostView/' , {params:{qa_num: this.$route.params.qa_num}} )
            .then((res) => {
                  this.uQnADetail = res.data
                  console.log(res.data);
                }
            )
            .catch((error) => this.uQnADetail = error.date)



      }

    }
  },
  methods: {

    // 엑시오스 테스트

    getData: function() {
      axios.get('https://jsonplaceholder.typicode.com/users/')
          .then(function(response) {
            console.log(response);
            this.users = response.data;
          })
          .catch(function(error) {
            console.log(error);
          });
    },


    //구 필터
    plus : function(e) {
      this.checkedCity = e.target.id;

      // if (e.target.value === this.detailGoocode) {
      //   // this.detailGoocode = 'noshow'
      //   console.log(this.detailGoocode)
      // } else if (e.target.value != this.detailGoocode){
      //   this.detailGoocode = e.target.value
      //   console.log(this.detailGoocode)
      // }
    },
    //태그 삭제 함수
    del : function (e) {

      this.selectedTag.splice(e.target.id,1);

    },
    //업다운 아이콘
      upDown1 : function (e){
      this.fold1 = !this.fold1;
      this.fold2 = false;


    },
  //업다운 아이콘
     upDown2 : function (e){
       this.fold2 = !this.fold2;
       this.fold1 = false;


  },
    //사용자가 클릭한 시만 필터링
    // makeFilterCity (e) {
    //   if(this.detailGoocode === e.target.value) this.detailGoocode = 'noshow'
    //   else this.detailGoocode = e.target.value
    //
    //   console.log(this.detailGoocode)
    // }
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
  background-color: #efefef;
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
  margin-bottom: 10px;
}

.empTitle {font-size: 18px;font-weight: bold;}

.empBoxCon:hover { border: 2px solid #0064ff; }

.empBoxCompany p {color:black;}

.empBoxCompany {
  display: inline-block;
  /*cursor: pointer;*/
  float: left;
  margin-right:10px;
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

}

.empSearchBox h3 {padding-bottom: 20px;}

.empSearchBox:hover {box-shadow: rgba(0, 0, 0, 0.16) 0px 10px 36px 0px, rgba(0, 0, 0, 0.06) 0px 0px 0px 1px;}

.empSearchTitle {font-weight:bold;
  background-color: #dedede;
  display: inline-block;
  text-align: center;
  width:100%;
  height:30px;

}

.empSearchWrap {overflow: hidden;

}

.empSearchWrap > div {
  float: left;
  width:33.33%;


}

.empSearchWrap > div > div {width:100%;}

.empSearchWrap > div > button {
  width:100%;
  height:50px;
  text-align: left;
  background-color: #efefef;
  border:1px solid #dedede;
  font-weight: bold;



}

.empBoxTitle {
  font-weight: bold;
  font-size: 15px;
  text-align: center;
  padding:10px;
  border: 1px solid #dedede;
}
.empSearchBoxWrap:hover {border: 1px solid #0064ff;}



.empSearchInput input {
  width:100%;
  height:50px;
  border:0;
  border-bottom: 2px solid black;
}

.empSearchLocal img, .empSearchJob img{border:0;
  width:20px;
  height:30px;
  object-fit: contain;}

/* 공고 검색 */
.showLocal {height: 200px;
  border: 1px solid #dedede;

}
.showLocal .empBoxLabel {border:0;height:90%;}

.jobCate_1, .jobCate_2, .jobCate_3 {width:33.3%;display: inline-block;}

.empBoxLabel {
  padding:10px;
  height:100px;
  border: 1px solid #dedede;
  overflow: auto;
}
.empBoxLabel label {padding-left:8px;}

.empSearchTag {margin-top:20px;}

.empSearchTag span {
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
  width:30%;
  display: inline-block;

}

.citySrc2 {
  width:70%;
  display: inline-block;
}

.topBtn1 {width:100%;
  height:50px;
  border: 1px solid #dedede;
  font-weight: bold;
  background-image: url("@/assets/icon_city.png");
  background-position: 30px 10px;
  background-repeat: no-repeat;
  background-size: 25px;
}
.topBtn2 {width:100%;
  height:50px;
  border: 1px solid #dedede;
  font-weight: bold;
  background-image: url("@/assets/icon_job.png");
  background-position: 30px 10px;
  background-repeat: no-repeat;
  background-size: 25px;

}

</style>