<template>

  <div class="container" style="max-width:1560px;">
  <!--이력서 관리-->
    <div class="resumeBoxCon">
      <div>
        <h3>이력서 관리</h3>
        <button class="arrDown"><img src="@/assets/icon_arr_down.png"></button>
      </div>
<!--      <div class="row">-->
      <div class="resumeBoxWrap">
        <div class="resumeBox">
          <div class="left">
            <p class="resumeTitle">창의적인 개발자가 되겠습니다.</p>
            <p>2023.03.09</p>
          </div>
          <div class="right">
            <button type="button" class="btn btn-outline-primary" style="border-color: #0064ff;color:#0064ff;">수정</button>
            <button type="button" class="btn btn-outline-primary" style="border-color: rgb(229, 75, 75);color:rgb(229, 75, 75);">삭제</button>
          </div>
        </div>
      </div>
      <div class="resumeBoxWrap">
      <div class="resumeBox">
        <div class="left">
          <p class="resumeTitle">창의적인 개발자가 되겠습니다.</p>
          <p>2023.03.09</p>
        </div>
        <div class="right">
          <button type="button" class="btn btn-outline-primary" style="border-color: #0064ff;color:#0064ff;">수정</button>
          <button type="button" class="btn btn-outline-primary" style="border-color: rgb(229, 75, 75);color:rgb(229, 75, 75);">삭제</button>
        </div>
      </div>
      </div>
<!--      </div>-->
    </div>


    <hr>


    <div class="aplBoxCon">
      <div>
        <h3>지원 현황</h3>
      </div>
      <div class="aplBtnBox">
        <button>
          <p class="aplBtnNum">30</p>
          <p>전체</p>
        </button>
        <button>
          <p class="aplBtnNum">30</p>
          <p>지원완료</p>
        </button>
        <button>
          <p class="aplBtnNum">30</p>
          <p>서류통과</p>
        </button>
        <button>
          <p class="aplBtnNum">30</p>
          <p>최종합격</p>
        </button>
        <button>
          <p class="aplBtnNum">30</p>
          <p>불합격</p>
        </button>
      </div>
    </div>



  </div>

</template>

<script>
export default {
  name: "uMypageView"
}
</script>

<style scoped>

.left{float: left;}
.right {float:right;}
/*이력서*/
.resumeBoxCon h3 {display: inline-block;}

.resumeBoxWrap { display: inline-block;width:50%;}

.arrDown{border:0;
      margin-left:10px;
  background: transparent;
}
.arrDown img{border:0;
          width:20px;
  height:30px;
  object-fit: contain;
}

.resumeBox {border: 1px solid #dedede;
                border-radius: 20px;
  overflow: hidden;
  padding:20px;
width:98%;
  margin-bottom:10px;
  display:inline-block;
  margin-left:5px;
    }
.resumeBox p {margin:0;padding: 0;}
.resumeBox button {margin:5px;}

.resumeBox:hover {border:1px solid #0064ff;}
    .resumeTitle {font-weight: bold;
                  font-size: 18px;
    }

/*지원현황*/
.aplBtnBox {margin-top:20px;}
.aplBtnBox button {
  border:0;
  border-left:1px solid #dedede;
  background-color: transparent;
  width:100px;
}

.aplBtnBox button:hover {color:#0064ff;}
.aplBtnBox button

.aplBtnBox button:first-child {border:0;}

.aplBtnNum {

    font-size: 22px;
    font-weight: bold;
    margin:0;
    padding:0;
}
</style>
