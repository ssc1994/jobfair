<template>

  <div style="overflow: hidden">
    <main class="resume left">
      <div class="TopBox">
        <div class="left PostImg tbList">
          <img class="tbLogo" src="#">
          <p>(주)카카오</p>
        </div>
        <div class="left PostText">
          <span style="font-size: 35px; font-weight: bolder;">UIUX디자이너 모집합니다</span> <br/>
          <span style="color: #999; font-weight: bold">경력무관</span>
          <div class="tdCol">
            <dl class="tbList left">
              <dt>직무</dt>
              <dd>
                <strong>신입</strong>
              </dd>
              <dt>경력</dt>
              <dd>
                <strong>신입</strong>
              </dd>
              <dt>학력</dt>
              <dd>
                <strong>학력무관</strong>
              </dd>
              <dt>연봉</dt>
              <dd>
                <strong>얼만데.......</strong>
              </dd>
              <dt>위치</dt>
              <dd>
                <strong>하기싫다..</strong>
              </dd>
            </dl>
          </div>
        </div>
      </div>
      <div class="contents">
        <div class="recruitment">
          <b>업무소개</b> <br/>
          <p>블라블라블라 ~~fnoifoifeoifhewoifheoiwfo
            eiwfhoewihfoewihfoiewhfoiewhfoiewhfoiefenfoewnfoewnfonofewnofewnoifnowncowncownecowneconwecoewncowencoewnoewnoiewncoiewncoiencoiewncowencoiewncownecoiewnconfiheoreoifneimdcdcmdslkcmldknvkndvvowecodcjdbcdbdbcodjjcpocdcdocnodscndncbbcdbdubcdiucb</p>
          <br/>
        </div>
        <p><br></p>
        <p>&nbsp;</p>
        <div class="recruitment">
          <b>전형절차</b><br/>
          <p>서류 지원 - 1차 면접 - 2차 면접 - 합격</p><br/>
        </div>
        <p><br></p>
        <p>&nbsp;</p>
        <div class="recruitment">
          <b>기업정보</b><br/>
          <img src="@/assets/kakao.png">
          <span>기업명 :</span><br/>
          <span>기업전화번호 :</span><br/>
          <span>기업이메일 :</span><br/>
          <span>기업주소 :</span><br/>
          <span>업종 :</span><br/>
          <span>대표자 :</span><br/>
          <span>사업자등록번호 :</span><br/>
        </div>
        <p><br></p>
        <p>&nbsp;</p>
        <p><br></p>
        <p>&nbsp;</p>
      </div>
    </main>

    <div style="position: fixed; right: 50px">
      <div>
        <div class="marginTime">
          <span style="color: #0064ff; font-weight: bolder">남은 시간</span>
          <div class="Time">
            <p>5일 12:59</p>
            <span>접수 시작 : 2023.02.27</span><br/>
            <span>접수 마감 : 2023.04.02</span>
          </div>
          <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
            지원하기
          </button>
          <button type="button" class="btn btn-primary" @click.prevent="uQnABtnClick">
            Q&A 질문하기
          </button>

        </div>

        <div class="marginTime">
          <span style="color: #0064ff; font-weight: bolder">지원자 현황 통계</span>
          <div class="applicant">
            <div class="left">
              <p>지원자 수</p>
              <span>5</span>
            </div>
            <div class="right">
              <p>모집 인원</p>
              <span>1</span>
            </div>
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
      </div>
    </div>

    <!--지원하기 모달창 설정-->
    <!--state 적용해서 데이터 넣어야해유-->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" style="z-index: 10000;">
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content ">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="exampleModalLabel">이력서 선택하기</h1>
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
              <button type="button" class="btn btn-primary">지원하기</button>
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
  data() {
    return {

      QnAComInfo: {
        user_id: JSON.parse(sessionStorage.getItem('sessionId')),
        com_num: ''
      }

    }

  },
  methods: {
    // uQnABtnClick() { // 채용상세공고 페이지에서 해당 기업 번호 넘기기 위한 메서드
    //   let self = this;
    //   this.$axios
    //       .get('/jobfair/uQnABtnClick', {params: {com_num: this.$route.params.com_num}
    //
    //   })
    //       .then((res) => {
    //         console.log("데이터: " + res.data)
    //         self.$router.push({
    //           name: 'cQnAView',
    //           params: {
    //             com_num: this.$route.params.com_num
    //           }
    //         })
    //         self.$router.push('/uQnAWriteView')
    //       })
    //       .catch((error) => {
    //         console.log(error)
    //       })
    // }
  }

}
</script>

<style scoped>

.miniContentModalBox {
  height: 100px;
}

* {
  box-sizing: border-box;
}

ul, ol {
  list-style: none;
}

a {
  text-decoration: none;
}

dl {
  display: block;
  margin-block-start: 1em;
  margin-block-end: 1em;
  margin-inline-start: 0px;
  margin-inline-end: 0px;
}

/* 왼쪽 상단에 기업로고 */
.tbLogo {
  width: 228px;
  height: 160px;
  text-align: center;
  margin: auto;
}

.tdCol {
  width: 326px;
  margin: 0 20px 0 0;
}

.tbList > dt {
  color: #0064ff;
  width: 70px;
}

.tbList > dd {
  color: #333;
  width: 250px;
}

.tbList > dd, .tbList > dt {
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 20px;
  margin: 2px 0 3px;
}

/* 채용공고 상세내역 정보 */
.resume {
  width: 800px;
  height: 1200px;
  color: #1E1E1E;
  border: 2px solid #efefef;
  padding: 50px 30px;
}

.left {
  float: left;
}

.right {
  float: right;
}

/* 남은시간 */
.marginTime {
  width: 280px;
  border: 1px solid #d2d6da;
  padding: 30px;
}

.Time {
  text-align: center;
}

.Time p {
  font-size: 30px;
  font-weight: bolder;
}

.marginTime button {
  width: 200px;
  height: 50px;
  border: none;
  border-radius: 25px;
  margin: 10px;
  background-color: #0064ff;
  color: white;

}

/* 지원자 현황 통계 */
.applicant {
  width: 100%;
  height: 90px;
  padding: 10px;
  text-align: center;
}

.applicant .left {
  padding-right: 40px;
  border-right: 2px solid #d2d6da;
}

.applicant .left span,
.applicant .right span {
  font-size: 28px;
  font-weight: bolder;
  color: #0064ff;
}

/* post 전체 틀 */
.TopBox {
  height: 25%;
}

/* post 왼쪽 창 */
.PostImg {
  width: 30%;
  margin: 20px;
  text-align: center;
}

.PostImg p {
  font-size: 20px;
  font-weight: 600;
  margin-top: 8px;
}

/* post 오른쪽 창*/
.PostText {
  width: 60%;
}

.PostText span {
  width: 100px;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}

/* 채용공고 상세내역 정보 */
.contents {
  width: 100%;
  height: 60%;
}

/* 채용공고 업무소개, 전형절차, 혜택 및 복지란 */
.recruitment {
  border: 1px solid rgb(181, 183, 186, 0.5);
  width: 100%;
  height: 35%;
  padding: 10px;
}

.recruitment b {
  font-size: 20px;
}

.recruitment p {
  line-height: 1.3;
  white-space: pre-line;
  word-wrap: break-word;
}
.recruitment img {
  float: left;
  width: 40%;
  height: 160px;
  margin-right: 30px;
}
</style>
