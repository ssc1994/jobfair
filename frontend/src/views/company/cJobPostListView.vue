<template>
  <div class="adminBg" >



    <div class="container empBoxWrap" >
      <!--   채용 검색 폼   -->

      <div class="empSearchBox">
        <h3>채용공고 상세검색</h3>
        <form name="" action="">
          <div class="empSearchInput">
            <input placeholder="채용공고명 또는 기관명을 입력해주세요." >
          </div>

          <div class="row">

            <div class="row">
              <div class="col-sm-2 empSearchBoxWrap">
                <div class="empBoxTitle">직무</div>
                <div class="empBoxLabel">
                  <div>
                    <input type="radio" id="JobCate1" name="JobCate"><label for="JobCate1">1</label>
                  </div>
                  <div>
                    <input type="radio" id="JobCate2" name="JobCate"><label for="JobCate2">2</label>
                  </div>
                  <div>
                    <input type="radio" id="JobCate3" name="JobCate"><label for="JobCate3">3</label>
                  </div>
                </div>
              </div>
              <div class="col-sm-2 empSearchBoxWrap">
                <div class="empBoxTitle">근무지역</div>
                <div class="empBoxLabel">
                  <div>
                    <input type="radio" id="localCate1" name="localCate"><label for="localCate1">1</label>
                  </div>
                  <div>
                    <input type="radio" id="localCate2" name="localCate"><label for="localCate2">2</label>
                  </div>
                  <div>
                    <input type="radio" id="localCate3" name="localCate"><label for="localCate3">3</label>
                  </div>
                </div>
              </div>

              <div class="col-sm-2 empSearchBoxWrap">
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

              <div class="col-sm-2 empSearchBoxWrap">
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

              <div class="col-sm-2 empSearchBoxWrap">
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

              <div class="col-sm-2 empSearchBoxWrap">
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
              <button type="button" class="btn btn-primary searchBtn">검색</button>
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
        <div class="sortBtn">
          <button class="sortMy" style="border-right:1px solid #dedede;">내가 작성한 공고</button>
          <button class="sortAll">전체 공고</button>
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
                <p class="left empBoxDday">D-27</p>
                <button type="button" class="btn btn-primary aplBtn right" style="background-color: #0064ff;">공고보기</button>
              </div>

            </div>

          </div>
        </div>


        <div class="empBoxConWrap col-6">
          <div class="empBoxCon comWriter">
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
                <p class="left empBoxDday">D-27</p>
                <button type="button" class="btn btn-primary aplBtn right" style="
                                                                                  color:#0064ff;
                                                                                  background-color: transparent;
                                                                                  border:2px solid #0064ff;">지원자보기</button>
                <button type="button" class="btn btn-primary aplBtn right" style="
                                                                                  color:rgb(229, 75, 75);
                                                                                  background-color: transparent;
                                                                                  border:2px solid rgb(229, 75, 75);

              ">수정</button>
              </div>

            </div>

          </div>
        </div>


      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "cJobPostListView",
  data() {
    return {
      job : '',
      local : '',
      career: '',
      education : '',
      salary : '',
      certi : ''
    }
  },
  methods: {
    plus : function(e){
      this.certi = e.target.value;
    },
    del : function (e) {
      this.certi = '';
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

.sortMy, .sortAll{border:0;
  font-weight: bold;
  font-size: 20px;
  padding:10px;
  background-color: transparent;
  margin-bottom:20px;
}

.sortBtn {
          width:100%;
}

.sortMy:hover, .sortAll:hover {color:#0064ff;

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

.empBoxText {padding-left: 5px;color:black;display: inline-block;  cursor: pointer;
  width:600px;
}


.empBoxText router-link {text-align: left;border:0;}

.empBoxText p {margin:0; padding:0;}

.empBoxDday {color :rgb(229, 75, 75);font-weight: bold; font-size: 17px;}

h3{font-weight: bold;
  font-size: 20px;

}

/*기업 내가 쓴 공고*/
.comWriter {background-color: #efefef;}
.comWriter button {font-weight: bold;margin-left:10px;}

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
.empSearchInput input {border:0;
  width:100%;height:50px;border:0;border-bottom: 2px solid black;
}

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
}

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
