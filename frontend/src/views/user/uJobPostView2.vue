<template>
  <div class="adminBg" >



    <div class="empBoxWrap" >
      <h3>채용공고 상세</h3>

        <div class="empSearchBox">
          <form name="" action="">
              <div class="empSearchInput">
                <input placeholder="채용공고명 또는 기관명을 입력해주세요." style="width:100%;height:50px;border:0;border-bottom: 2px solid black;">
              </div>
              <div>
                <div class="empSearchTitle jobCate">직무</div>
                  <div class="jobCate_1">
                    <div>
                      <label>경영 사무</label>
                    </div>
                  </div>
                  <div class="jobCate_2">
                    <div>
                      <label>경영 사무</label>
                    </div>
                  </div>
                  <div class="jobCate_3">
                    <div>
                      <label>경영 사무</label>
                    </div>
                  </div>
              </div>

          </form>
        </div>


      <div class="empBoxConWrap">
        <div class="empBoxCon ">
          <a class="left empBoxCompany">
            <p>(주) 카카오</p>
            <img src="2.jpg" >
          </a>
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

      <div class="empBoxConWrap">
        <div class="empBoxCon ">
          <a class="left empBoxCompany">
            <p>(주) 카카오</p>
            <img src="2.jpg" >
          </a>
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

      <div class="empBoxConWrap">
        <div class="empBoxCon ">
          <a class="left empBoxCompany">
            <p>(주) 카카오</p>
            <img src="2.jpg" >
          </a>
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

      <div class="empBoxConWrap">
        <div class="empBoxCon ">
          <a class="left empBoxCompany">
            <p>(주) 카카오</p>
            <img src="2.jpg" >
          </a>
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

</template>

<script>
export default {
  name: "uJobPostView"
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
  width:1200px;
  margin:0 auto;
}

.jobCate > div {display: inline-block;
                width:33.3%;
                border:1px solid red;
}

.empBoxTitle {
  font-weight: bold;
  font-size: 18px;
}
.empBoxTag {color:#838383;}


.empBoxConWrap {
                width:600px;
                height:160px;
  display: inline-block;padding:2px;

  text-align: left;

}

.empBoxCon {
  padding:25px;
  overflow: hidden;
  background-color: white;
  border-radius: 20px;
  border: 1px solid #dedede;
  display:inline-block;
  width:98%;
  margin-bottom: 10px;
}

.empBoxCon:hover { border: 1px solid #0064ff;}

.empBoxCompany p {color:black;}

.empBoxCompany {
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
  width:450px;
}
.empBoxText a {text-align: left;}

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
</style>
