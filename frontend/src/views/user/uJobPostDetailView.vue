<template>

  <div>
    <div>
      <div>
        <img src="#">
        <h4>(주)카카오</h4>
      </div>

      <div>
        <span>UIUX디자이너 모집</span> <br/>
        <span>경력무관</span>
      </div>

      <div>
        <span>직무 디자이너</span>
        <span>경력</span>
        <span>학력 대졸</span>
        <span>위치</span>
        <span>연봉 3000</span>
      </div>

    </div>

    <div>

      <div>
        <h3>업무소개</h3> <br/>
        <h4>블라블라블라~~</h4><br/>
      </div>

      <div>
        <h3>전형절차</h3><br/>
        <h4>서류 지원 - 1차 면접 - 2차 면접 - 합격</h4><br/>
      </div>

      <div>
        <h3>혜택 및 복지</h3><br/>
        <h4>블라블라블라~~</h4><br/>
      </div>

    </div>

    <div>
      <div>
        <span>남은시간</span>
      </div>

      <div>
        <span>5일 12:59</span><br/>
        <span>접수 시작 : 2023.02.27</span> <br/>
        <span>접수 마감 : 2023.04.02</span>
      </div>

      <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
        Launch demo modal
      </button>

    </div>

    <div>
      <span>지원자 현황 통계</span>

      <div>
        <ul>
          <li>지원자 수</li>
          <li>5</li>
        </ul>
        <ul>
          <li>모집 인원</li>
          <li>1</li>
        </ul>
      </div>

      <div>
        <ul>
          <li>연령</li>
          <li>
            <img src="#">
          </li>
        </ul>
        <ul>
          <li>성별</li>
          <li>
            <img src="#">
          </li>
        </ul>
        <ul>
          <li>학력</li>
          <li>
            <img src="#">
          </li>
        </ul>
      </div>
    </div>

    <!--지원하기 모달창 설정-->
    <!--state 적용해서 데이터 넣어야해유-->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
        <div class="modal-content">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="exampleModalLabel">개인정보수정</h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body" style="height: 100%">
            <div class="contentModalBox">

              <div class="miniContentModalBox">
                <input type="radio" id="test" name="resumeRadio" style="display: none" v-model="a" value="1">
                <label for="test">
                  <h4>창의적머시기</h4>
                  <h5>2023.03.10</h5>
                </label>

              </div>

              <div class="miniContentModalBox">
                <input type="radio" id="test" name="resumeRadio" style="display: none" v-model="a" value="2">
                <label for="test">
                  <h4>창의적머시기</h4>
                  <h5>2023.03.10</h5>
                </label>

              </div>
              <div class="miniContentModalBox">
                <input type="radio" id="test" name="resumeRadio" style="display: none" v-model="a" value="3">
                <label for="test">
                  <h4>창의적머시기</h4>
                  <h5>2023.03.10</h5>
                </label>

              </div>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
              <button type="button" class="btn btn-primary">Save changes</button>
            </div>
          </div>
        </div>
      </div>


    </div>

  </div>
</template>

<script>
export default {
  name: "uJobPostDetailView",
  data(){
    return{
      a: ''
    }

  },
  updated() {
    console.log(this.a)
  }
}
</script>

<style scoped>
.miniContentModalBox {
  height: 100px;
}


.miniContentModalBox h5 {
}
</style>
