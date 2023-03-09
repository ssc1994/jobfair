<template>
  <div class="adminBg" >



    <div class="container empBoxWrap" >
      <!--   채용 검색 폼   -->
      <div class="empSearchBox">
        <form name="" action="">
          <div class="empSearchInput">
            <input placeholder="채용공고명 또는 기관명을 입력해주세요." style="width:100%;height:50px;border:0;border-bottom: 2px solid black;">
          </div>
          <div class="container">
            <div class="row">
            <div class="empSearchTitle jobCate">직무</div>
            </div>
            <div class="row">
            <div class="jobCate_1 col-12" >
<!--              v-for="(jobCate1, i) in jobCate1" :key="jobCate1"-->
              <fieldset>
              <div>
                <label><input type="radio">1</label>
              </div>

                <label><input type="radio">2</label>
                <label><input type="radio">3</label>

              </fieldset>
            </div>
            <div class="jobCate_2 col-12">

            </div>
            <div class="jobCate_3 col-12">

            </div>
            </div>
          </div>

        </form>
      </div>

      <h3>채용공고 상세</h3>
      <div class="row">
        <form name="" action="" class="row">
          <div class="empBoxConWrap col-sm-3 col-6">
            <div class="empFormTitle">
              직무
            </div>
            <select class="form-select" aria-label="Default select example">
              <option selected>Open this select menu</option>
              <option value="1">One</option>
              <option value="2">Two</option>
              <option value="3">Three</option>
            </select>
          </div>
          <div class="empBoxConWrap col-sm-3 col-6">
            <div class="empFormTitle">
              시, 구
            </div>
            <select class="form-select" aria-label="Default select example">
              <option selected>Open this select menu</option>
              <option value="1">One</option>
              <option value="2">Two</option>
              <option value="3">Three</option>
            </select>
          </div>
          <div class="empBoxConWrap col-sm-3 col-6">
            <div class="empFormTitle">
              경력
            </div>
            <select class="form-select" aria-label="Default select example">
              <option selected>Open this select menu</option>
              <option value="1">One</option>
              <option value="2">Two</option>
              <option value="3">Three</option>
            </select>
          </div>
          <div class="empBoxConWrap col-sm-3 col-6">
            <div class="empFormTitle">
              학력
            </div>
            <select class="form-select" aria-label="Default select example">
              <option selected>Open this select menu</option>
              <option value="1">One</option>
              <option value="2">Two</option>
              <option value="3">Three</option>
            </select>
          </div>
          <div class="empBoxConWrap col-sm-3 col-6">
            <div class="empFormTitle">
              고용형태
            </div>
            <select class="form-select" aria-label="Default select example">
              <option selected>Open this select menu</option>
              <option value="1">One</option>
              <option value="2">Two</option>
              <option value="3">Three</option>
            </select>
          </div>
          <div class="empBoxConWrap col-sm-3 col-6">
            <div class="empFormTitle">
              우대조건
            </div>
            <select class="form-select" aria-label="Default select example">
              <option selected>Open this select menu</option>
              <option value="1">One</option>
              <option value="2">Two</option>
              <option value="3">Three</option>
            </select>
          </div>
          <div class="empBoxConWrap col-sm-3 col-6">
            <div class="empFormTitle">
              자격증
            </div>
            <select class="form-select" aria-label="Default select example">
              <option selected>Open this select menu</option>
              <option value="1">One</option>
              <option value="2">Two</option>
              <option value="3">Three</option>
            </select>
          </div>
          <div class="empBoxConWrap col-sm-3 col-6">
            <div class="empFormTitle">
              성별
            </div>
            <select class="form-select" aria-label="Default select example">
              <option selected>Open this select menu</option>
              <option value="1">One</option>
              <option value="2">Two</option>
              <option value="3">Three</option>
            </select>
          </div>
          <button type="button" class="btn btn-primary right col-sm-3" style="background-color: #0064ff;">검색</button>
        </form>

      </div>

      <div class="row">


        <div class="empBoxConWrap col-lg-6">
          <div class="empBoxCon ">
            <router-link to="" class="left empBoxCompany">
              <p>(주) 카카오</p>
              <img src="2.jpg" >
            </router-link>
            <div class="left empBoxText">
              <router-link to="">
                <p class="empBoxTitle">UIUX 디자이너</p>

                <p class="empBoxTag">경력무관 초대졸 경기도 성남시 정규직 3,000~3,400만원</p>
              </router-link>
              <div style="padding-top:20px;">
                <p class="left empBoxDday">D-27</p>
                <button type="button" class="btn btn-primary right" style="background-color: #0064ff;width:30%;">지원하기</button>
              </div>

            </div>

          </div>
        </div>

        <div class="empBoxConWrap col-lg-6">
          <div class="empBoxCon ">
            <router-link to="" class="left empBoxCompany">
              <p>(주) 카카오</p>
              <img src="2.jpg" >
            </router-link>
            <div class="left empBoxText">
              <router-link to="">
                <p class="empBoxTitle">UIUX 디자이너</p>

                <p class="empBoxTag">경력무관 초대졸 경기도 성남시 정규직 3,000~3,400만원</p>
              </router-link>
              <div style="padding-top:20px;">
                <p class="left empBoxDday">D-27</p>
                <button type="button" class="btn btn-primary right" style="background-color: #0064ff;width:30%;">지원하기</button>
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
  name: "uJobPostView",
  data() {
    return {
      // 직무
      jobCate1 : ['aaa','bbb','ccc','ddd','eee'],
      jobCate2 : ['aaa','bbb','ccc','ddd','eee'],
      jobCate3 : ['aaa','bbb','ccc','ddd','eee']
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
  max-width:1200px;
  margin:0 auto;
}

.empBoxTitle {
  font-weight: bold;
  font-size: 18px;
}
.empBoxTag {color:#838383;}


.empBoxConWrap {padding:5px;}

.empBoxCon {padding:25px;
  overflow: hidden;
  background-color: white;
  border-radius: 20px;
  border: 1px solid #dedede;
  display:inline-block;
}

.empBoxCon:hover { border: 1px solid #0064ff;}

.empBoxCompany p {color:black;}

.empBoxCompany {
  padding-right:10px;
  display: inline-block;
  cursor: pointer;
  float: left;
}
.empBoxCon img{
  float: left;
  width:80px;
  height:80px;
  border: 1px solid #dedede;
  border-radius: 50%;
  display: inline;

}

.aplBtn {border:none;
  background-color: #0064ff;

}

.empBoxText {padding-left: 5px;color:black;display: inline-block;  cursor: pointer;
}


.empBoxText p {margin:0; padding:0;}

.empBoxDday {color :rgb(229, 75, 75);font-weight: bold; }

h3{font-weight: bold;
   font-size: 20px;
}


/*검색 박스*/
.empSearchBox {border: 1px solid #dedede;
  padding:20px;
  border-radius: 20px;
  text-align: left;
}
.empSearchTitle {font-weight:bold;
  background-color: #dedede;
  display: inline-block;
  text-align: center;
  width:100%;
  height:30px;

}

.jobCate_1, .jobCate_2, .jobCate_3 {width:33.3%;display: inline-block;}

</style>
