<template>

  <div class="adminBg" >
    <div class="container companyWrap" >
      <div class="row">
        <h3>참여 기업 상태</h3>
        <div class="col-lg-3 col-sm-4  aBox" >
          <a href="#" style="background-color:rgb(95, 75, 229)">
            <div class="companyNumImg">
            </div>
            <div class="companyNum_text">

              <span>참여 기업 수</span>
              <p>8</p>
            </div>
          </a>
        </div>
        <div class="col-lg-3 col-sm-4  aBox" >
          <a href="#" style="background-color:rgb(229, 75, 75)">
            <div class="companyNumImg">
            </div>
            <div class="companyNum_text">

              <span>참여 기업 수</span>
              <p>8</p>
            </div>
          </a>
        </div>
        <div class="col-lg-3 col-sm-4  aBox">
          <a href="#" style="background-color:rgb(62, 162, 72)">
            <div class="companyNumImg">
            </div>
            <div class="companyNum_text">

              <span>참여 기업 수</span>
              <p>8</p>
            </div>
          </a>
        </div>
        <div class="col-lg-3 col-sm-3  aBox" >
          <div style="border:1px solid rgb(199, 199, 199)">
            <div class="userInfoBox">
              <div class="userInfoFirstLine">
                <div>
                  <img src="#">
                  <h3>OOO님의 <br/>입사 지원 현황</h3>
                  <a href="#">쪽지(3)</a>
                </div>
              </div>
              <div class="userInfoSecondLine">
                <ul class="userInfoSecondLine1">
                  <li>10</li>
                  <li>지원완료</li>
                </ul>

                <ul class="userInfoSecondLine2">
                  <li>10</li>
                  <li>열람</li>
                </ul>

                <ul class="userInfoSecondLine3">
                  <li>10</li>
                  <li>미열람</li>
                </ul>

              </div>

              <div class="aBoxBtn">
                <button>이력서 관리</button>
                <button>mypage</button>
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
  name: 'aMainView'
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


.adminBg{
  width:100%;
  height:100%;
  background-color: #efefef;
}


.companyWrap {
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

.userInfoSecondLine {overflow: hidden;}
.userInfoSecondLine ul {float: left;}

.aBoxBtn {width:100%;}
.aBoxBtn button{width:50%;
  display: inline-block;
  height:20px;
  border:0;
  background-color: #efefef;

}


</style>
