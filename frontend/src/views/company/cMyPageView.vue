<template>

  <div class="container" style="max-width:1560px;">
    <!--이력서 관리-->
    <div class="resumeBoxCon">
      <div>
        <h3 class="title">우리 기업 채용공고</h3>
        <button class="arrDown"><img src="@/assets/icon_arr_down.png"></button>
      </div>
      <div class="resumeBoxWrap">
        <div class="resumeBox">
          <div class="left">
            <p class="resumeTitle">창의적인 개발자가 되겠습니다.</p>
            <p>2023.03.09</p>
          </div>
          <div class="right">
            <button type="button" class="btn btn-outline-primary" style="border-color: #0064ff;color:#0064ff;">수정
            </button>
            <button type="button" class="btn btn-outline-primary"
                    style="border-color: rgb(229, 75, 75);color:rgb(229, 75, 75);">삭제
            </button>
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
            <button type="button" class="btn btn-outline-primary" style="border-color: #0064ff;color:#0064ff;">수정
            </button>
            <button type="button" class="btn btn-outline-primary"
                    style="border-color: rgb(229, 75, 75);color:rgb(229, 75, 75);">삭제
            </button>
          </div>
        </div>
      </div>
    </div>


    <hr>


    <div class="aplBoxCon">
      <div>
        <h3 class="title">기업 정보</h3>
      </div>

      <div class="infoBoxWrap">
        <div class="infoBox">

          <div class="info_head">
            <div class="comLogoWrap">
              <img :src="comInfo.img_url" class="comLogo">
            </div>
            <div class="com_name_wrap">
              <div class="com_name">{{ comInfo.com_name }}</div>
            </div>
          </div>

          <div class="info_body">
            <div class="input-group mb-3">
              <span class="input-group-text" id="basic-addon1">사업자등록번호</span>
              <input type="text" class="form-control" placeholder="Title" aria-label="Username"
                     aria-describedby="basic-addon1" disabled :value="comInfo.com_businessRegistration">
            </div>

            <div class="input-group mb-3">
              <span class="input-group-text" id="basic-addon1">설립일</span>
              <input type="text" class="form-control" placeholder="Username" aria-label="Username"
                     aria-describedby="basic-addon1" disabled :value="comInfo.com_establishmentDate">
            </div>

            <div class="input-group mb-3">
              <span class="input-group-text" id="basic-addon1">업종</span>
              <input type="text" class="form-control" placeholder="Username" aria-label="Username"
                     aria-describedby="basic-addon1" disabled :value="comInfo.com_category">
            </div>

            <div class="input-group mb-3">
              <span class="input-group-text" id="basic-addon1">대표자</span>
              <input type="text" class="form-control" placeholder="대표자" aria-label="Username"
                     aria-describedby="basic-addon1" disabled :value="comInfo.com_ceo">
            </div>

            <div class="input-group mb-3">
              <span class="input-group-text" id="basic-addon1">전화번호</span>
              <input type="text" class="form-control" placeholder="Username" aria-label="Username"
                     aria-describedby="basic-addon1" disabled :value="comInfo.com_phone">
            </div>

            <div class="input-group mb-3">
              <span class="input-group-text" id="basic-addon1">이메일</span>
              <input type="text" class="form-control" placeholder="Username" aria-label="Username"
                     aria-describedby="basic-addon1" disabled :value="comInfo.com_email">
            </div>


            <div class="input-group mb-3">
              <span class="input-group-text" id="basic-addon1">주소</span>
              <input type="text" class="form-control" placeholder="Username" aria-label="Username"
                     aria-describedby="basic-addon1" disabled :value="comInfo.com_address">
            </div>

            <div class="input-group mb-3">
              <span class="input-group-text" id="basic-addon1">상세주소</span>
              <input type="text" class="form-control" placeholder="" aria-label="Username"
                     aria-describedby="basic-addon1" disabled :value="comInfo.com_detail_address">
            </div>
          </div>


          <div class="btnBox info_footer">
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal"
                    @click="getComInfo">
              수정하기
            </button>
          </div>

        </div>
      </div>

      <!--수정하기 모달창 설정-->
      <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
          <div class="modal-content ">
            <div class="modal-header">
              <h1 class="modal-title fs-5, title" id="exampleModalLabel">기업 정보 수정</h1>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" ref="closeBtn"
                      @click="toDefault"></button>
            </div>
            <div class="modal-body" style="height: 100%">
              <div class="infoModalBox">

                <div class="m_logoPart">
                  <div class="m_comLogoWrap">
                    <img :src="comInfo.img_url" alt="image" class="m_comLogo"/>
                    <input type="file" hidden="true" accept="image/*"
                           ref="image" @change="imgUploaded($event)"
                           name="image" multiple/>
                    <button type="button" style="margin-bottom: 0px" class="btn btn-primary" @click="runUploadImg">로고수정</button>
                  </div>
                </div>

                <div class="data_box">
                  <div class="data_title_wrap">
                    <span>기업명</span><span :hidden="comName_errorMsg === ''"
                                          class="pass_error">{{ comName_errorMsg }}</span>
                  </div>
                  <input type="text" class="data_insert_box" placeholder="기업명"
                         v-model="comInfo.com_name" @keyup="comNameCheck"
                  />
                </div>

                <div class="data_box">
                  <div class="data_title_wrap">
                    <span>사업자 등록번호</span><span :hidden="comBizReg_errorMsg === ''"
                                               class="pass_error">{{ comBizReg_errorMsg }}</span>
                  </div>
                  <input type="text" class="data_insert_box" placeholder="사업자 등록번호는 3글자-2글자-5글자 형식으로 입력해주세요"
                         v-model="comInfo.com_businessRegistration" @keyup="comBizRegNumCheck"/>
                </div>

                <div class="data_box">
                  <div class="data_title_wrap">
                    <span>전화 번호</span><span :hidden="comPh_errorMsg === ''"
                                            class="pass_error">{{ comPh_errorMsg }}</span>
                  </div>
                  <input type="text" class="data_insert_box" placeholder="숫자만 입력 -자동 추가"
                         v-model="comInfo.com_phone" @keyup="comAutoHyphen($event), phCheck()" maxlength="13"/>
                </div>

                <div class="data_box">
                  <div class="data_title_wrap">
                    <span>이메일</span><span :hidden="comEmail_errorMsg === ''"
                                          class="pass_error">{{ comEmail_errorMsg }}</span>
                  </div>
                  <input type="text" class="data_insert_box" placeholder="이메일"
                         v-model="comInfo.com_email" @keyup="emailCheck"/>
                </div>

                <div class="data_box">
                  <div class="data_title_wrap">
                    <span>업종</span><span :hidden="comCategory_errorMsg === ''"
                                         class="pass_error">{{ comCategory_errorMsg }}</span>
                  </div>
                  <input type="text" class="data_insert_box" placeholder="업종을 입력해주세요"
                         v-model="comInfo.com_category" @keyup="comCategoryCheck"/>
                </div>

                <div class="data_box">
                  <div class="data_title_wrap">
                    <span>대표자</span><span :hidden="comCeo_errorMsg === ''"
                                          class="pass_error">{{ comCeo_errorMsg }}</span>
                  </div>
                  <input type="text" class="data_insert_box" placeholder="대표자명을 입력해주세요"
                         v-model="comInfo.com_ceo" @keyup="ceoCheck"/>
                </div>

                <div class="data_box">
                  <div class="data_title_wrap">
                    <span>주소</span><span :hidden="comAddress_errorMsg === ''"
                                         class="pass_error">{{ comAddress_errorMsg }}</span>
                  </div>
                  <div class="with_btn_wrap">
                    <input type="text" class="data_insert_box" placeholder="주소를 입력해주세요"
                           v-model="comInfo.com_address" readonly/>
                    <button type="button" class="btn btn-primary" @click="execDaumPostcode">
                      주소변경
                    </button>
                  </div>
                </div>

                <div class="data_box">
                  <div class="data_title_wrap">
                    <span>상세주소</span><span :hidden="comDeAddress_errorMsg === ''"
                                           class="pass_error">{{ comDeAddress_errorMsg }}</span>
                  </div>
                  <input type="text" class="data_insert_box" placeholder="상세주소를 입력해주세요"
                         v-model="comInfo.com_detail_address" @keyup="detailAddCheck"/>
                </div>

                <div class="data_box">
                  <div class="data_title_wrap">
                    <span>설립일</span><span :hidden="comEsDate_errorMsg === ''"
                                          class="pass_error">{{ comEsDate_errorMsg }}</span>
                  </div>
                  <input type="date" class="data_insert_box" placeholder="설립일을 지정해주세요"
                         v-model="comInfo.com_establishmentDate"/>
                </div>

                <div class="m_footer">
                  <button type="button" class="btn btn-primary" @click="requestModyInfo" data-bs-target="#exampleModal">
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

import axios from "axios";

export default {
  name: "uMypageView",
  data() {
    return {
      //기업 정보 한번에 담아 오기 위한 객체
      comInfo: {
        com_name: '',
        com_num: sessionStorage.getItem('sessionComp'),
        com_phone: '',
        com_email: '',
        com_address: '',
        com_detail_address: '',
        com_category: '',
        com_ceo: '',
        com_businessRegistration: '',
        com_establishmentDate: '',
        com_fileName: '',
        com_filePath: '',
        com_fileUuid: '',
        img_url: ''
      },
      //주소 api 관련
      postcode: "",
      address: "",
      //유효성 검사 정규식
      nameRule: /^[가-힣]{2,4}$/, //한글만 2~4글자
      idRule: /^[a-z0-9]{4,12}$/, // 영문 소문자, 숫자만 사용가능 길이는 4~12 글자
      passwordRule: /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$/,  //비밀번호 유효성 검사 정규표현식
      emailRule: /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/, //이메일 형식 유호성 검사 정규표현식
      phoneNumRule: /^\d{2,3}-\d{3,4}-\d{4}$/, //전화번호, 핸드폰 번호 형식인지 검사
      businessRegisRule: /^[0-9]{3}-[0-9]{2}-[0-9]{5}$/, //사업자 등록번호 정규식 3글자-2글자-5글자
      //유효성 검사 에러메세지 담을 변수들
      comName_errorMsg: '',
      comPh_errorMsg: '',
      comEmail_errorMsg: '',
      comAddress_errorMsg: '',
      comDeAddress_errorMsg: '', //기업 상세주소 에러메세지
      comCategory_errorMsg: '',
      comCeo_errorMsg: '',
      comBizReg_errorMsg: '', //사업자등록번호 입력 오류 메시지
      comEsDate_errorMsg: '', //회사 설립일 지정 오류 메시지
      //유효성 검사 통과여부 변수
      check_result: 'success'

    }

  },
  created() {
    this.getComInfo()
  },
  methods: {
    //로고수정 버튼 클릭시 파일 업로드 버튼 활성화
    runUploadImg() {
      this.$refs.image.click()
    },
    //파일업로드시 실행되는 메서드
    async imgUploaded(e) {

      // console.log(e.target.files) //files는 배열로 들어온다.

      let form = new FormData() //form 데이타를 담기위해 form 인스턴스 생성
      let image = e.target.files[0];

      form.append('com_num', this.comInfo.com_num)
      form.append('image', image)

      const {data} = await this.$axios.post('/jobfair/companyMypage/modiLogo', form,
          {headers: {'Content-Type': 'multipart/form-data'}}).catch(err => console.log(err));

      this.comInfo.img_url = data // aws s3에 올라간 이미지 파일의 url

    },

    //로그인한 기업의 정보 받아와서 화면에 뿌려주기
    async getComInfo() {
      const {data} = await this.$axios.post('/jobfair/companyMypage/getComInfo',
          {com_num: this.comInfo.com_num})
          .catch(err => console.log(err))

      console.log(data.img_url)

      this.comInfo = data;

    },

    //  ------- 유효성 검사 부분 -------
    //기업 이름 유효성 검사
    comNameCheck() {
      if (this.comInfo.com_name === '') {
        this.comName_errorMsg = '필수 입력 정보입니다'
        this.check_result = 'fail'
        return
      } else {
        this.comName_errorMsg = ''
        this.check_result = 'success'
      }
    },
    //사업자 등록번호 유효성 검사
    //사업자 등록번호 정규식 3글자-2글자-5글자
    comBizRegNumCheck() {
      if (this.businessRegisRule.test(this.comInfo.com_businessRegistration) === false) {
        if (this.comInfo.com_businessRegistration === '') {
          this.comBizReg_errorMsg = '필수 입력 정보입니다'
          this.check_result = 'fail'
          return
        }
        this.comBizReg_errorMsg = '사업자 등록번호를 확인해주세요'
        this.check_result = 'fail'
        return
      } else {
        this.comBizReg_errorMsg = ''
        this.check_result = 'success'
      }
    },

    //전화 번호 유효성 검사 메서드
    phCheck() {
      if (this.phoneNumRule.test(this.comInfo.com_phone) === false) {
        if (this.comInfo.com_phone === '') {
          this.comPh_errorMsg = '필수 입력 정보입니다'
          this.check_result = 'fail'
          return
        }
        this.comPh_errorMsg = '전화번호를 확인해주세요'
        this.check_result = 'fail'
        return
      } else {
        this.comPh_errorMsg = ''
        this.check_result = 'success'
      }
    },
    //이메일 유효성 검사 메서드
    emailCheck() {
      if (this.emailRule.test(this.comInfo.com_email) === false) {
        if (this.comInfo.com_email === '') {
          this.comEmail_errorMsg = '필수 입력 정보입니다'
          this.check_result = 'fail'
          return
        }
        this.comEmail_errorMsg = '이메일을 확인해 주세요'
        this.check_result = 'fail'
        return
      } else {
        this.comEmail_errorMsg = ''
        this.check_result = 'success'
      }
    },
    //업종 유효성 검사
    comCategoryCheck() {
      if (this.comInfo.com_category === '') {
        this.comCategory_errorMsg = '필수 입력 정보입니다'
        this.check_result = 'fail'
        return
      } else {
        this.comCategory_errorMsg = ''
        this.check_result = 'success'
      }
    },
    //ceo 유효성 검사 메서드
    ceoCheck() {
      if (!this.nameRule.test(this.comInfo.com_ceo.trim())) {
        if (this.comInfo.com_ceo === '') {
          this.comCeo_errorMsg = '필수입력 정보 입니다'
          this.check_result = 'fail'
          return
        }
        this.comCeo_errorMsg = '한글로 2~4글자만 가능합니다'
        this.check_result = 'fail'
      } else {
        this.comCeo_errorMsg = ''
        this.check_result = 'success'
      }
    },
    //기업 상세주소 체크
    detailAddCheck() {
      if (this.comInfo.com_detail_address === '') {
        this.comDeAddress_errorMsg = '필수 입력 정보입니다'
        this.check_result = 'fail'
        return
      } else {
        this.comDeAddress_errorMsg = ''
        this.check_result = 'success'
      }
    },
    comAutoHyphen(e) {
      let value = e.target.value
      this.comInfo.com_phone = value.replace(/[^0-9]/g, "").replace(
          /(^02.{0}|^01.{1}|[0-9]{3})([0-9]+)([0-9]{4})/,
          "$1-$2-$3")
    },
    // -------------- 유효성 검사 END ----------------

    //카카오 주소 검색
    execDaumPostcode() {
      new window.daum.Postcode({
        oncomplete: (data) => {
          if (this.extraAddress !== "") {
            this.extraAddress = "";
          }
          if (data.userSelectedType === "R") {
            // 사용자가 도로명 주소를 선택했을 경우
            this.comInfo.com_address = data.roadAddress;
          } else {
            // 사용자가 지번 주소를 선택했을 경우(J)
            this.comInfo.com_address = data.jibunAddress;
          }

          // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
          if (data.userSelectedType === "R") {
            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if (data.bname !== "" && /[동|로|가]$/g.test(data.bname)) {
              this.extraAddress += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if (data.buildingName !== "" && data.apartment === "Y") {
              this.extraAddress +=
                  this.extraAddress !== ""
                      ? `, ${data.buildingName}`
                      : data.buildingName;
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if (this.extraAddress !== "") {
              this.extraAddress = `(${this.extraAddress})`;
            }
          } else {
            this.extraAddress = "";
          }
          // 우편번호를 입력한다.
          this.postcode = data.zonecode;
        },
      }).open();
    },

    //수정요청 날리기
    requestModyInfo() {

      if (this.check_result === 'success') {

        this.$axios.post('/jobfair/companyMypage/modifyInfo', this.comInfo)
            .then(response => {
              console.log(response)

              //수정이 완료된 후 모달창 닫기2
              alert('수정되었습니다 ^^!')
              this.$refs.closeBtn.click()

            })
            .catch(error => {
              console.log(error)
            })

      } else { // check_resutl 가 fail일 때
        alert('입력 정보를 확인해주세요')
      }
    },
    // 모달창 닫을 때 디폴트값으로 다시 바꿔주기
    // 모달창 닫힐 때, 에러메세지, modi_type을 info 로  즉, 기본값으로 지정해주기.
    toDefault() {
      //에러메세지 리셋
      this.comName_errorMsg = ''
      this.comBizReg_errorMsg = ''
      this.comPh_errorMsg = ''
      this.comEmail_errorMsg = ''
      this.comCategory_errorMsg = ''
      this.comCeo_errorMsg = ''
      this.comAddress_errorMsg = ''
      this.comDeAddress_errorMsg = ''
      this.comEsDate_errorMsg = ''
      //check_result 결과 기본값으로
      this.check_result = 'success'
    }

  }
}
</script>

<style scoped>

.left {
  float: left;
}

.right {
  float: right;
}

/*이력서*/
.resumeBoxCon h3 {
  display: inline-block;
}

.resumeBoxWrap {
  display: inline-block;
  width: 50%;
}

.arrDown {
  border: 0;
  margin-left: 10px;
  background: transparent;
}

.arrDown img {
  border: 0;
  width: 20px;
  height: 30px;
  object-fit: contain;
}

.resumeBox {
  border: 1px solid #dedede;
  border-radius: 20px;
  overflow: hidden;
  padding: 20px;
  width: 98%;
  margin-bottom: 10px;
  display: inline-block;
  margin-left: 5px;
}

.resumeBox p {
  margin: 0;
  padding: 0;
}

.resumeBox button {
  margin: 5px;
}

.resumeBox:hover {
  border: 1px solid #0064ff;
}

.resumeTitle {
  font-weight: bold;
  font-size: 18px;
}

/* title  공용 css */
.title{
  font-weight: bold;
  color: #202632;
}

/*---------- cMypage 기업 정보 부분 ----------*/

.infoBoxWrap {
  border: 1px solid #AAAAAA;
  border-radius: 15px;
  padding: 10px;
  width: 100%;
  height: 800px;
}

.infoBox {
  width: 80%;
  height: 500px;
  margin: 0 auto;
  margin-top: 50px;
}

/*----------------------------------*/
.info_head {
  display: block;
  margin-bottom: 40px;
  overflow: hidden;
}

/* cMypage 로고 부분*/
.info_head .comLogoWrap {
  overflow: hidden;
  display: inline-block;
  width: 150px;
  height: 150px;
  float: left;
}
.comLogo {
  width: 150px;
  height: 150px;
  object-fit:cover;
}

/*기업 이름 부분*/
.info_head .com_name_wrap{
  margin-left: 10px;
  display: inline-block;
  float: left;
}
.info_head .com_name_wrap .com_name{
  color: #202632;
  font-weight: bold;
  font-size: 40px;
  padding:20px;
}


/*----------------------------------*/
.info_body{
  display: block;
}

.input-group-text{
  font-weight: bold;
  color: #202632;
  font-size: 15px;
}

/*----------------------------------*/
.info_footer {
  /*cMypage 수정하기 버튼 부분*/
  text-align: center;
  margin-top: 30px;
  height: 50px;
  line-height: 50px;
}


/*------------------ 여기서부턴  모달부분 ------------------*/
.modal {
  --bs-modal-width: 700px
}

.modal-header .title{
  font-weight: bold;
  font-size: 20px;
  color: #202632;
}

/*모달 속 로고부분*/
.m_logoPart {
  margin-bottom: 10px;
}
.m_comLogoWrap {
  display: inline-block;
  width: 150px;
  height: 150px;
  position: relative;
}
.m_comLogo {
  width: 150px;
  height: 150px;
  object-fit: cover;
}
.m_comLogoWrap button{
  position: absolute;
  right: -95px;
  bottom: 0px;
}


/*모달 속 info 부분*/
.data_title_wrap span:first-child{
  font-weight: bold;
  color: #202632;
  font-size: 15px;
}

.data_insert_box {
  /* data 입력되는 input 태그들*/
  display: block;
  width: 100%;
  padding: 0.375rem 0.75rem;
  font-size: 1rem;
  font-weight: 400;
  line-height: 1.5;
  color: #212529;
  background-color: #fff;
  background-clip: padding-box;
  border: 1px solid #ced4da;
  appearance: none;
  border-radius: 0.375rem;
  transition: border-color .15s ease-in-out, box-shadow .15s ease-in-out;
}

/* 각각 컬럼별 데이터 입력 박스 */

.data_box {
  margin-bottom: 10px;
}

.data_insert_box {
  /* data 입력되는 input 태그들*/
  display: block;
  width: 100%;
  padding: 0.375rem 0.75rem;
  font-size: 1rem;
  font-weight: 400;
  line-height: 1.5;
  color: #212529;
  background-color: #fff;
  background-clip: padding-box;
  border: 1px solid #ced4da;
  appearance: none;
  border-radius: 0.375rem;
  transition: border-color .15s ease-in-out, box-shadow .15s ease-in-out;
}

/* 입력된 데이터 에러메세지 띄우는 부분*/
.data_title_wrap span {
  display: inline-block;
  height: 100%;
}

.data_title_wrap span:first-child {
  margin-right: 10px;
}

.data_title_wrap span:last-child {
  font-size: 12px;
}

/*유효성 검사 에러메세지 css*/
.pass_error {
  font-size: 10px;
  color: red;
}

/*유효성 검사 통과 시 글자색 초록색*/
.pass_color {
  color: green;
}

/* 주소 변경 버튼 부분*/
.with_btn_wrap {
  display: flex;
  justify-content: space-between;
}

.with_btn_wrap input {
  display: inline-block;
  width: 79%;
}

.with_btn_wrap button {
  width: 20%;
  display: inline-block;
  margin: 0;
}

.m_footer{
text-align: center;
margin-top: 30px;
height: 50px;
line-height: 50px;
}

</style>
