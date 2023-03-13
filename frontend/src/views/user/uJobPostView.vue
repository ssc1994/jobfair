<template>
  <div class="adminBg" >



    <div class="container empBoxWrap" >
      <!--   채용 검색 폼   -->

      <div class="empSearchBox">
        <h3>채용공고 상세검색</h3>
        <form name="" action="">
          <div class="empSearchWrap">

            <div class="empSearchLocal">
              <button @click="upDown">지역을 선택하세요
                <img :src="require(`@/assets/icon_arr_${arrSrc}.png`)"/>
              </button>



            </div>
            <div class="empSearchJob">
              <button>직무를 선택하세요
                <!--                <img :src="require(`@/assets/icon_arr_${arrSrc}.png`)" @click="upDown"/>-->
              </button>
            </div>

            <div class="empSearchInput">
              <input placeholder="채용공고명 또는 기관명을 입력해주세요." >
            </div>
          </div>


          <!--#################################-->
          <!--  지역 또는 직무 클릭시 나오는 div -->
          <div v-if="fold!=false" class="showLocal">
            <!--  지역 검색 -->
            <div>
              <input placeholder="지역을 입력해주세요." >
            </div>

            <div class="empBoxLabel">
              <!--시-->
              <div v-for="(city, index) in city" :key="city.cityCode">
                <input type="checkbox" :id="city.cityCode" name="city" @change="plus" :value="city.cityCode" v-model="selectedCity">
                <label :for="city.cityCode">{{ city.cityName }}</label>
              </div>
              <!--구-->
              <div v-for="goo in cityGoo.filter(x => x.cityCode === selectedCity.cityCode )" :key="goo.gooCode">
                <input type="checkbox" :id="goo.gooCode" name="goo" @change="plus" :value="goo.gooName">
                <label :for="goo.gooCode">{{ goo.gooName }}</label>
              </div>
            </div>
          </div>

          <div class="row">

            <div class="row">



              <div class="col-sm-3 empSearchBoxWrap">
                <div class="empBoxTitle">경력</div>
                <div class="empBoxLabel">
                  <div>
                    <input type="radio" id="careerCate1" name="careerCate"><label for="careerCate1">1</label>
                  </div>
                  <div>
                    <input type="radio" id="careerCate2" name="careerCate"><label for="careerCate2">2</label>
                  </div>
                  <div>
                    <input type="radio" id="careerCate3" name="careerCate"><label for="careerCate3">3</label>
                  </div>
                </div>
              </div>

              <div class="col-sm-3 empSearchBoxWrap">
                <div class="empBoxTitle">학력</div>
                <div class="empBoxLabel">
                  <div>
                    <input type="radio" id="eduCate1" name="eduCate"><label for="eduCate1">1</label>
                  </div>
                  <div>
                    <input type="radio" id="eduCate2" name="eduCate"><label for="eduCate2">2</label>
                  </div>
                  <div>
                    <input type="radio" id="eduCate3" name="eduCate"><label for="eduCate3">3</label>
                  </div>
                </div>
              </div>

              <div class="col-sm-3 empSearchBoxWrap">
                <div class="empBoxTitle">연봉</div>
                <div class="empBoxLabel">
                  <div>
                    <input type="radio" id="salaryCate1" name="salaryCate"><label for="salaryCate1">1</label>
                  </div>
                  <div>
                    <input type="radio" id="salaryCate2" name="salaryCate"><label for="salaryCate2">2</label>
                  </div>
                  <div>
                    <input type="radio" id="salaryCate3" name="salaryCate"><label for="salaryCate3">3</label>
                  </div>
                </div>
              </div>

              <div class="col-sm-3 empSearchBoxWrap">
                <div class="empBoxTitle">자격증</div>
                <div class="empBoxLabel">
                  <div>
                    <input type="radio" id="certiCate1" name="certiCate" @click="plus" value="정보처리기사"><label for="certiCate1">정보처리기사</label>
                  </div>
                  <div>
                    <input type="radio" id="certiCate2" name="certiCate"><label for="certiCate2">2</label>
                  </div>
                  <div>
                    <input type="radio" id="certiCate3" name="certiCate"><label for="certiCate3">3</label>
                  </div>
                </div>
              </div>
            </div>
            <div class="empSearchTag">
              <button type="button" class="btn btn-primary searchBtn">선택된 120건 검색</button>
              <span v-if="job!=''">{{job}}
                  <button class="del" @click="del">

                  </button>
                </span>
              <span v-if="local!=''">{{local }}<button class="del">X</button></span>
              <span v-if="career!=''">{{career }}<button class="del">X</button></span>
              <span v-if="education!=''">{{education }}<button class="del">X</button></span>
              <span v-if="salary!=''">{{salary }}<button class="del">X</button></span>
              <span v-if="certi!=''">{{certi }}<button class="del" @click="del">X</button></span>
            </div>

          </div>

        </form>
      </div>




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
      selectedCity : [],

      //지역 배열
      city : [
        { cityCode : 1, cityName : "서울특별시"},
        { cityCode : 2, cityName : "부산광역시"},
        { cityCode : 3, cityName : "대구광역시"},
        // { "서울특별시" : ["종로구", "중구", "용산구", "성동구", "광진구", "동대문구", "중랑구", "성북구", "강북구", "도봉구", "노원구", "은평구", "서대문구", "마포구", "양천구", "강서구", "구로구", "금천구", "영등포구", "동작구", "관악구", "서초구", "강남구", "송파구","강동구"] },
        // { "부산광역시"  : ["중구", "서구", "동구", "영도구", "부산진구", "동래구", "남구", "북구", "해운대구", "사하구", "금정구", "강서구", "연제구", "수영구", "사상구", "기장군"] },
        // { "대구광역시"  : ["중구", "동구", "서구", "남구", "북구", "수성구", "달서구", "달성군"]},
      ],
      cityGoo : [
        { cityCode: 1, gooCode : 1, gooName : "종로구"},
        { cityCode: 1, gooCode : 2, gooName : "중구"},
        { cityCode: 1, gooCode : 3, gooName : "용산구"}
      ],

      fold : true,
      arrSrc : "up",

      // 선택된 value
      job : '',
      local : '',
      career: '',
      education : '',
      salary : '',
      certi : '',

      //엑시오스 테스트
      users : ''

    }
  },
  // created() {
  //   this.localArr : [
  //     { "서울특별시" : ["종로구", "중구", "용산구", "성동구", "광진구", "동대문구", "중랑구", "성북구", "강북구", "도봉구", "노원구", "은평구", "서대문구", "마포구", "양천구", "강서구", "구로구", "금천구", "영등포구", "동작구", "관악구", "서초구", "강남구", "송파구","강동구"] },
  //     { "부산광역시"  : ["중구", "서구", "동구", "영도구", "부산진구", "동래구", "남구", "북구", "해운대구", "사하구", "금정구", "강서구", "연제구", "수영구", "사상구", "기장군"] },
  //     { "대구광역시"  : ["중구", "동구", "서구", "남구", "북구", "수성구", "달서구", "달성군"]},
  //   ]
  //
  // },
  methods: {

    // 엑시오스 테스트
    /*
    getData: function() {
      axios.get('https://jsonplaceholder.typicode.com/users/')
          .then(function(response) {
            console.log(response);
            this.users = response.data;
          })
          .catch(function(error) {
            console.log(error);
          });
    },*/


    // radio 태그 함수
    plus : function(e){

      if(e.target.name=="job"){
        this.job = e.target.value;
      } else if(e.target.name=="local"){
        this.local = e.target.value;
      } else if(e.target.name=="career"){
        this.career = e.target.value;
      } else if(e.target.name=="education"){
        this.education = e.target.value;
      } else if(e.target.name=="salary"){
        this.salary = e.target.value;
      } else{
        this.certi = e.target.value;
      }
    },
    //radio 태그 삭제 함수
    del : function (e) {
      this.certi = '';
    },
    //업다운 아이콘
    upDown : function (){
      this.fold = !this.fold;

      if(this.arrSrc!="up"){
        this.arrSrc = "up";
      } else {
        this.arrSrc = "down";
      }

    }
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
  cursor: pointer;
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

.empBoxText {padding-left: 5px;color:black;display: inline-block;  cursor: pointer;
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
.empSearchBox:hover {box-shadow: rgba(0, 0, 0, 0.16) 0px 10px 36px 0px, rgba(0, 0, 0, 0.06) 0px 0px 0px 1px;}

.empSearchTitle {font-weight:bold;
  background-color: #dedede;
  display: inline-block;
  text-align: center;
  width:100%;
  height:30px;

}

.empSearchWrap {overflow: hidden;}

.empSearchWrap > div {
  float: left;
  width:33.33%;


}

.empSearchWrap > div > div {width:100%;}

.empSearchWrap > div > button {
  width:100%;
  height:50px;
  border: 2px solid #dedede;
  text-align: left;
  background-color: transparent;


}

.empBoxTitle {
  font-weight: bold;
  font-size: 15px;
  text-align: center;
  padding:10px;
  border: 1px solid #dedede;
}
.empSearchBoxWrap:hover {border: 1px solid #0064ff;}

.empSearchInput {margin-bottom:30px;

}


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
.showLocal .empBoxLabel {border:0;}

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

</style>