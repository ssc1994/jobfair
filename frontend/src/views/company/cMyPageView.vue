<template>

  <div class="container" style="max-width:1560px;">
    <!--이력서 관리-->
    <div class="resumeBoxCon">
      <div>
        <h3>우리 기업 채용공고</h3>
        <button class="arrDown"><img src="@/assets/icon_arr_down.png"></button>
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
    </div>


    <hr>


    <div class="aplBoxCon">
      <div>
        <h3>기업 정보</h3>
      </div>

      <div class="infoWrapBox">
        <div class="infoBox">
          <div class="logoBox">
            <img src="#">
            <h3>카카오</h3>
          </div>
          <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1" >기업번호</span>
            <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1" disabled>
          </div>

          <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1">사업자등록번호</span>
            <input type="text" class="form-control" placeholder="Title" aria-label="Username" aria-describedby="basic-addon1" disabled>
          </div>

          <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1" >전화번호</span>
            <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1" disabled>
          </div>

          <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1" >이메일</span>
            <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1" disabled>
          </div>

          <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1" >업종</span>
            <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1" disabled>
          </div>

          <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1" >대표자</span>
            <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1" disabled>
          </div>

          <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1" >설립일</span>
            <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1" disabled>
          </div>

          <div class="btnBox">
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
              수정하기
            </button>
          </div>

        </div>
      </div>

      <!--지원하기 모달창 설정-->
      <!--state 적용해서 데이터 넣어야해유-->
      <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
          <div class="modal-content ">
            <div class="modal-header">
              <h1 class="modal-title fs-5" id="exampleModalLabel">기업 정보 수정</h1>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body" style="height: 100%">
              <div class="infoModalBox">
                <div class="logoBox">
                  <img src="#">
                  <h3>카카오</h3>
                </div>
                <div class="input-group mb-3">
                  <span class="input-group-text" id="basic-addon1" >기업번호</span>
                  <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
                </div>

                <div class="input-group mb-3">
                  <span class="input-group-text" id="basic-addon1">사업자등록번호</span>
                  <input type="text" class="form-control" placeholder="Title" aria-label="Username" aria-describedby="basic-addon1">
                </div>

                <div class="input-group mb-3">
                  <span class="input-group-text" id="basic-addon1" >전화번호</span>
                  <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
                </div>

                <div class="input-group mb-3">
                  <span class="input-group-text" id="basic-addon1" >이메일</span>
                  <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
                </div>

                <div class="input-group mb-3">
                  <span class="input-group-text" id="basic-addon1" >업종</span>
                  <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
                </div>

                <div class="input-group mb-3">
                  <span class="input-group-text" id="basic-addon1" >대표자</span>
                  <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
                </div>

                <div class="input-group mb-3">
                  <span class="input-group-text" id="basic-addon1" >설립일</span>
                  <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
                </div>

                <div class="btnBox">
                  <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    수정하기
                  </button>
                </div>

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


.logoBox {
  height: 100px;
}

.logoBox img {
  float: left;
  margin-right: 30px;
  width: 50px;
  height: 50px;
}

.logoBox h3 {
  line-height: 50px;
}

.infoWrapBox {
  border: 1px solid grey;
  width: 100%;
  height: 600px;
  margin: 0 auto;
  margin-bottom: 100px;
}

.infoBox {
  width: 80%;
  height: 500px;
  margin: 0 auto;
  margin-top: 50px;
}

.btnBox {
  text-align: center;
  margin-top: 30px;
  height: 50px;
  line-height: 50px;
}

.modal {
  --bs-modal-width: 800px
}


</style>
