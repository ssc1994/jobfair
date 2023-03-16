<template>
  <div>

    <div class="empReg">
      <div class=" mt-3 mb-3">
        <h2>채용공고 등록하기</h2>
      </div>
      <section class="title">
        <div class=" wrapBox3">


        <div class="input-group mt-3 mb-3">
          <span class="input-group-text" id="basic-addon1">공고명</span>
          <input type="text" class="form-control" placeholder="내용을 입력하세요." aria-label="Username"
                 aria-describedby="basic-addon1" v-model="jpl_title" required>
        </div>


        </div>
      </section>
      <div class=" mt-3 mb-3">
        <h2>접수기간</h2>
      </div>

      <section>

      <div class=" mt-3">
        <div class=" wrapBox3">
          <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1">공고시작일</span>
            <input type="date" class="form-control" placeholder="2023.03.03." aria-label="Username"
                   aria-describedby="basic-addon1" v-model="jpl_startDate" required>
            &nbsp; ~ &nbsp;
            <span class="input-group-text" id="basic-addon1">공고종료일</span>
            <input type="date" class="form-control" placeholder="2023.06.05." aria-label="Username"
                   aria-describedby="basic-addon1" v-model="jpl_endDate" required>
            </div>
          </div>
        </div>
      </div>
      </section>
      <div class=" mt-3 mb-3">
        <h2>채용조건</h2>
      </div>

      <div class="container mt-3">
        <div>
          <section>
            <h5>1.포지션 정보</h5>
            <div class="mb-5 mt-5">
              <label for="">포지션 :</label>
              <input type="text" class="form-control" id="position" placeholder="직급을 입력하세요." name="position"
                     v-model="jpl_workPosition">
            </div>
            <div class="mb-5 mt-5">
              <label for="">직무 :</label>
              <input type="text" class="form-control" id="duty" placeholder="직무명을 입력하세요." name="duty"
                     v-model="jpl_duty">

            </div>
            <div class="mb-5 mt-5">
              <label for="">경력 :</label>
              <div class="form-check">
                <input type="radio" class="form-check-input" id="radio1" name="career" value="신입" checked
                       v-model="jpl_workHistory">
                <label class="form-check-label" for="radio1">신입</label>
              </div>
              <div class="form-check">
                <input type="radio" class="form-check-input" id="radio2" name="career" value="경력"
                       v-model="jpl_workHistory">
                <label class="form-check-label" for="radio2">경력</label>
              </div>
              <div class="form-check">
                <input type="radio" class="form-check-input" id="radio3" name="career" value="경력무관"
                       v-model="jpl_workHistory">
                <label class="form-check-label" for="radio3">경력무관</label>
              </div>
            </div>


            <div class="mb-3 mt-3">
              <label for="">고용형태 :</label>
              <div class="form-check">
                <input type="radio" class="form-check-input" id="jobRadio1" name="employement" value="정규직" checked
                       v-model="jpl_workForm">
                <label class="form-check-label" for="jobRadio1">정규직</label>
              </div>
              <div class="form-check">
                <input type="radio" class="form-check-input" id="jobRadio2" name="employement" value="계약직"
                       v-model="jpl_workForm">
                <label class="form-check-label" for="jobRadio2">계약직</label>
              </div>
              <div class="form-check">
                <input type="radio" class="form-check-input" id="jobRadio3" name="employement" value="인턴"
                       v-model="jpl_workForm">
                <label class="form-check-label" for="jobRadio3">인턴</label>
              </div>
              <div class="form-check">
                <input type="radio" class="form-check-input" id="jobRadio4" name="employement" value="파견직"
                       v-model="jpl_workForm">
                <label class="form-check-label" for="jobRadio4">파견직</label>
              </div>
              <div class="form-check">
                <input type="radio" class="form-check-input" id="jobRadio5" name="employement" value="아르바이트"
                       v-model="jpl_workForm">
                <label class="form-check-label" for="jobRadio5">아르바이트</label>
              </div>
            </div>
          </section>
          <section>
            <h5>2.지원 자격</h5>
            <div class="mb-5 mt-5">
              <label for="">학력 :</label>
              <select class="form-select" v-model="jpl_education">
                <option value="학력무관">학력무관</option>
                <option value="대졸(4년제)">대졸(4년제)</option>
                <option value="전문대졸(3년제)">전문대졸(3년제)</option>
                <option value="전문대졸(2년제)">전문대졸(2년제)</option>
                <option value="고졸">고졸</option>
              </select>
            </div>
            <div class="mb-5 mt-5">
              <label for="">우대조건 :</label>
              <select class="form-select" v-model="jpl_conditions">
                <option value="없음">없음</option>
                <option value="국가유공자">국가유공자</option>
                <option value="보훈대상자">보훈대상자</option>
                <option value="고용촉진지원금 대상자">고용촉진지원금 대상자</option>
                <option value="취업보호대상자">취업보호대상자</option>
                <option value="병역특례">병역특례</option>
              </select>
            </div>
            <div class="mb-5 mt-5">
              <label for="">자격증 :</label>
              <input type="text" class="form-control" id="card" placeholder="자격증명을 입력하세요." name="card"
                     v-model="jpl_certificate">
            </div>

            <div class="mb-5 mt-3">
              <label for="">성별 :</label>
              <div class="form-check">

                <input type="radio" class="form-check-input" id="genderRadio1" name="genderRadio" value="nah" checked v-model="jpl_gender">
                <label class="form-check-label" for="genderRadio1">성별무관</label>
              </div>
              <div class="form-check">
                <input type="radio" class="form-check-input" id="genderRadio2" name="genderRadio" value="male"  v-model="jpl_gender">
                <label class="form-check-label" for="genderRadio2">남자</label>
              </div>
              <div class="form-check">
                <input type="radio" class="form-check-input" id="genderRadio3" name="genderRadio" value="female" v-model="jpl_gender">
                <label class="form-check-label" for="genderRadio3">여자</label>

              </div>
            </div>


          </section>

          <section>
            <h5>3.근무조건</h5>

            <div class="mb-5 mt-5" id="app">
              <label for="">근무지 :</label>
              <input type="text" class="form-control" id="location" placeholder="지역을 입력하세요." name="location"
                     v-model="jpl_address">
<!--              데이터 들어가서 나오는지 테스트해봄, 시각적으로 괜찮아보여서 일단 냅둠 -->
              <p>{{jpl_locationSi}} > {{jpl_locationGu}}</p>
              <div class="cityBox">
                <div class="empBoxLabel citySrc1">
                  <!--시-->
                  <div v-for="city in city" :key="city.cityCode">
                    <input type="radio" :id="city.cityCode" name="city" @change="plus" :value="city.cityName"
                           v-model="jpl_locationSi">
                    <label :for="city.cityCode">{{ city.cityName }}</label>
                  </div>
                </div>
                <div class="empBoxLabel citySrc2">
                  <!--구-->
                  <div v-for="(goo,i) in cityGoo.filter( gc => gc.cityCode == checkedCity).values()" :key="i">
                    <div v-for="(gooName,j) in goo.gooName" :key="j">
                      <input type="radio" :id="gooName" name="gooName" :value="gooName" v-model="jpl_locationGu">
                      <label :for="gooName">{{ gooName }}</label>
                    </div>
                  </div>
                </div>
              </div>
            </div>


            <div class="mb-5 mt-5">
              <label for="">근무요일 :</label>
              <select class="form-select" v-model="jpl_workDay">
                <option value="주 5일(월~금)">주 5일(월~금)</option>
                <option value="주 3일">주 3일</option>
                <option value="주 2일">주 2일</option>
                <option value="하루">하루</option>
                <option value="회사내규에 따름">회사내규에 따름</option>
              </select>
            </div>
            <div class="mb-5 mt-5">
              <div >
                <label for="appt">근무시간 :</label>
                <div>
                  <b-form-timepicker v-model="jpl_workTimeS" locale="en"></b-form-timepicker>
                  <div class="mt-2">Value: '{{ value }}'</div>
                  <input type="time" id="appt" name="appt" v-model="jpl_workTimeS"> ~
                  <input type="time" id="appt" name="appt" v-model="jpl_workTimeE">
                </div>
              </div>
            </div>
            <div class=" mb-5 mt-4">
              <label for="">급여 :</label>
              <div class="form-check">
                <input type="radio" class="form-check-input" id="salary1" name="salaryRadio" value="undecided"
                       v-model="salaryType">
                <label class="form-check-label" for="salary1">면접 후 결정</label>
              </div>
              <div class="form-check">
                <label class="form-check-label" for="salary2"><input type="text" class="" placeholder="예상연봉 입력"
                                                                     v-model="jpl_salary"></label>
              </div>
            </div>
          </section>


          <section>
            <div class="introduce">
              <div class="introduce-contact">
                <ul>
                  <li class="introduce-cotact_list">
                    <div>
                      <h5 class="fs-medium">4. 공고내용</h5>
                    </div>
                  </li>
                </ul>
              </div>
              <div class="profile mb-3 mt-5">
                <p class="fs-medium fc-gray"></p>
                <div class="container">
                  <textarea class="form-control col-sm-5" rows="5" v-model="jpl_content"></textarea>
                </div>
                <div class="input-group mb-3">

                  <input type="file" style="display: none" class="form-control" id="inputGroupFile02" v-on:change='fileChange' ref="fileInsert">
                  <input type="button" value="채용공고 이미지선택" @click="clickFile">

                </div>

                <div>
                  <img class="headline-image" :src="viewImg" alt="이미지 미리보기" ref="previewImg">

                </div>

              </div>
            </div>
          </section>

          <button type="submit" class="btn btn-primary" @click="empRegist">등록</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "cEmpRegView",

  data() {
    return {
      com_num:'',
      jpl_title:'',
      jpl_content:'',
      jpl_startDate:'',
      jpl_endDate:'',
      jpl_regDate:'',
      jpl_workPosition:'',
      jpl_duty:'',
      jpl_workHistory:'신입',
      jpl_workForm:'정규직',
      jpl_education:'학력무관',
      jpl_conditions:'없음',
      jpl_certificate:'',
      jpl_gender:'성별무관',
      jpl_salary:'0',
      jpl_locationSi:'',
      jpl_locationGu:'',
      jpl_address:'',
      jpl_workDay:'회사내규에 따름',
      jpl_workTimeS:'',
      jpl_workTimeE:'',
      jpl_name:'',
      jpl_companyName:'',
      jpl_contact:'',
      jpl_phoneNum:'',
      jpl_email:'',
      jpl_fileName:'',
      jpl_filePath:'',
      jpl_fileUuid:'',
      salaryType:'',
      checkedCity: 0,
      city: [
        {cityCode: 1, cityName: "서울"},
        {cityCode: 2, cityName: "부산"},
        {cityCode: 3, cityName: "인천"},
        {cityCode: 4, cityName: "대구"},
        {cityCode: 5, cityName: "광주"},
        {cityCode: 6, cityName: "대전"},
        {cityCode: 7, cityName: "울산"},
        {cityCode: 8, cityName: "세종"},
        {cityCode: 9, cityName: "경기도"},
        {cityCode: 10, cityName: "강원도"},
        {cityCode: 11, cityName: "충청북도"},
        {cityCode: 12, cityName: "충청남도"},
        {cityCode: 13, cityName: "경상북도"},
        {cityCode: 14, cityName: "경상남도"},
        {cityCode: 15, cityName: "전라북도"},
        {cityCode: 16, cityName: "전라남도"},
        {cityCode: 17, cityName: "제주도"}
      ],
      cityGoo: [
        {
          cityCode: 1,
          gooName: ["종로구", "중구", "용산구", "성동구", "광진구", "동대문구", "중랑구", "성북구", "강북구", "도봉구", "노원구", "은평구", "서대문구", "마포구", "양천구", "강서구", "구로구", "금천구", "영등포구", "동작구", "관악구", "서초구", "강남구", "송파구", "강동구"]
        },
        {
          cityCode: 2,
          gooName: ["중구", "서구", "동구", "영도구", "부산진구", "동래구", "남구", "북구", "해운대구", "사하구", "금정구", "강서구", "연제구", "수영구", "사상구", "기장군"]
        },
        {cityCode: 3, gooName: ["중구", "동구", "남구", "연수구", "남동구", "부평구", "계양구", "서구", "강화군", "옹진군"]},
        {cityCode: 4, gooName: ["중구", "동구", "서구", "남구", "북구", "수성구", "달서구", "달성군"]},
        {cityCode: 5, gooName: ["동구", "서구", "남구", "북구", "광산구"]},
        {cityCode: 6, gooName: ["동구", "중구", "서구", "유성구", "대덕구"]},
        {cityCode: 7, gooName: ["중구", "남구", "동구", "북구", "울주군"]},
        {cityCode: 8, gooName: []},
        {
          cityCode: 9,
          gooName: ["가평군", "고양시", "과천시", "광명시", "광주시", "구리시", "군포시", "김포시", "남양주시", "동두천시", "부천시", "성남시", "수원시", "시흥시", "안산시", "안성시", "안양시", "양주시", "양평군", "여주시", "연천군", "오산시", "용인시", "의왕시", "의정부시", "이천시", "파주시", "평택시", "포천시", "하남시", "화성시"]
        },
        {
          cityCode: 10,
          gooName: ["원주시", "춘천시", "강릉시", "동해시", "속초시", "삼척시", "홍천군", "태백시", "철원군", "횡성군", "평창군", "영월군", "정선군", "인제군", "고성군", "양양군", "화천군", "양구군"]
        },
        {cityCode: 11, gooName: ["청주시", "충주시", "제천시", "보은군", "옥천군", "영동군", "증평군", "진천군", "괴산군", "음성군", "단양군"]},
        {
          cityCode: 12,
          gooName: ["천안시", "공주시", "보령시", "아산시", "서산시", "논산시", "계룡시", "당진시", "금산군", "부여군", "서천군", "청양군", "홍성군", "예산군", "태안군"]
        },
        {
          cityCode: 13,
          gooName: ["포항시", "경주시", "김천시", "안동시", "구미시", "영주시", "영천시", "상주시", "문경시", "경산시", "군위군", "의성군", "청송군", "영양군", "영덕군", "청도군", "고령군", "성주군", "칠곡군", "예천군", "봉화군", "울진군", "울릉군"]
        },
        {
          cityCode: 14,
          gooName: ["창원시", "김해시", "진주시", "양산시", "거제시", "통영시", "사천시", "밀양시", "함안군", "거창군", "창녕군", "고성군", "하동군", "합천군", "남해군", "함양군", "산청군", "의령군"]
        },
        {
          cityCode: 15,
          gooName: ["전주시", "익산시", "군산시", "정읍시", "완주군", "김제시", "남원시", "고창군", "부안군", "임실군", "순창군", "진안군", "장수군", "무주군"]
        },
        {
          cityCode: 16,
          gooName: ["여수시", "순천시", "목포시", "광양시", "나주시", "무안군", "해남군", "고흥군", "화순군", "영암군", "영광군", "완도군", "담양군", "장성군", "보성군", "신안군", "장흥군", "강진군", "함평군", "진도군", "곡성군", "구례군"]
        },
        {cityCode: 17, gooName: ["제주시", "서귀포시"]}
      ]
,
      viewImg: ''
    }
  },
  beforeCreate() {
    this.$axios.post('/jobfair/userInfo', {
      user_id:JSON.parse(sessionStorage.getItem('sessionId'))
    }).then(res=>{
      this.jpl_name=res.data.user_name
      this.jpl_phoneNum=res.data.user_phone
      this.jpl_email=res.data.user_email
      this.com_num=res.data.com_num

      this.$axios
          .post('/jobfair/compInfo', {
            com_num:this.com_num})
          .then(res=>{
            this.jpl_comPanyName=res.data.com_name
            this.jpl_contact=res.data.com_phone
            console.log("comData")
            console.log(res)
          }).catch(err=>{
        console.log(err)
      })
      console.log("userData")
      console.log(res)
    }).catch(err=>{
         console.log(err)
    })



  },
  methods:{
    fileChange(e){
      this.jpl_fileName = this.$refs.fileInsert.files[0]
      this.res_img = e.target.files[0]
      //이미지 업로드 시 화면에서 미리보기 기능
      let reader = new FileReader();
      reader.onload = (event) => {
        this.viewImg = event.target.result;
      }
      reader.readAsDataURL(this.res_img);
    },

    empRegist(){
      // 급여 미선택시 0으로 값 주는거
      if(this.salaryType=='undecided'){
        this.jpl_salary=0;
      }

      const empData = {
        com_num:this.com_num,
        jpl_title:this.jpl_title,
        jpl_content:this.jpl_content,
        jpl_startDate:this.jpl_startDate,
        jpl_endDate:this.jpl_endDate,
        jpl_regDate:this.jpl_regDate,
        jpl_workPosition:this.jpl_workPosition,
        jpl_duty:this.jpl_duty,
        jpl_workHistory:this.jpl_workHistory,
        jpl_workForm:this.jpl_workForm,
        jpl_education:this.jpl_education,
        jpl_conditions:this.jpl_conditions,
        jpl_certificate:this.jpl_certificate,
        jpl_gender:this.jpl_gender,
        jpl_salary:this.jpl_salary,
        jpl_locationSi:this.jpl_locationSi,
        jpl_locationGu:this.jpl_locationGu,
        jpl_address:this.jpl_address,
        jpl_workDay:this.jpl_workDay,
        jpl_workTimeS:this.jpl_workTimeS,
        jpl_workTimeE:this.jpl_workTimeE,

        jpl_name:this.jpl_name,
        jpl_phoneNum:this.jpl_phoneNum,
        jpl_email:this.jpl_email,
        jpl_companyName:this.jpl_comPanyName,
        jpl_contact:this.jpl_contact,
        jpl_fileName:'',
        jpl_filePath:'',
        jpl_fileUuid:'',
      };
      const formData = new FormData();

      formData.append('files', this.jpl_fileName);
      formData.append("empData", new Blob([JSON.stringify(empData)], { type: "application/json" }));

      this.$axios.post('/jobfair/EmpRegist'
          ,formData
      ,{
        headers:{
          "Content-Type": `multipart/form-data`
        }
          }).then((res)=>{

        console.log('성공')
        console.log(res)


      }).catch(err => {
        console.log(err)

      })
      // 작성한 채용공고 내용을 가지고가서 유저가 보는 채용공고에 데이터뿌리기.. 하는중인데 먼지 몰겟긴하지만 해본다
      // this.$axios.post('/jobfair/EmpRegistInfo'
      //     ,empData)
      //     .then((res)=>{
      //   console.log('성공')
      //   console.log(res.data)
      //
      // }).catch(err => {
      //   console.log(err)
      // })
    },
    clickFile () {  //버튼 클릭 시 input:file 클릭으로 연동하는 함수
      this.$refs.fileInsert.click();
    },
    previewImg(e) {  //이미지 미리보기
      this.res_img = e.target.files[0]
      //이미지 업로드 시 화면에서 미리보기 기능
      let reader = new FileReader();
      reader.onload = (event) => {
        this.viewImg = event.target.result;
      }
      reader.readAsDataURL(this.res_img);
    },
    plus(e) {
      this.checkedCity = e.target.id
    }
  }

}
</script>


<style scoped>
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
  text-align: center;
}

ul, ol {
  list-style: none;
}

a {
  text-decoration: none;
}

body {
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
  background-color: #fbfbfb;
  word-break: keep-all;
}

/* 공고 양식 제일 바깥 css*/
.empReg {
  width: 900px;
  margin: 60px auto;
  padding: 20px;
  color: #1E1E1E;
  background-color: #FFF;
  box-shadow: rgba(0, 0, 0, 0.16) 0px 10px 36px 0px, rgba(0, 0, 0, 0.06) 0px 0px 0px 1px;
}

.empReg section {
  display: flex;
  position: relative;
  border: 1px solid #000;
  justify-content: space-around;
}

.empReg .title .input-group {
  width: 600px;
  height: 50px;
  font-size: 50px;
}

.empReg section h5 {
  position: absolute;
  left: 0;
}

.empReg section .form-select {
  width: 180px;
}

/* 자기소개서 박스 크기 */
textarea.form-control {
  min-height: calc(1.5em + 0.75rem + 2px);
  width: 800px;
  height: 550px;
}

.showLocal .empBoxLabel {
  border: 0;
  height: 90%;
}

.empBoxLabel {
  padding: 10px;
  height: 100px;
  border: 1px solid #dedede;
  overflow: auto;
}

.empBoxLabel label {
  padding-left: 8px;
}

/* 시, 구 선택박스 */
.cityBox {
  width: 300px;
  height: 300px;
}

.citySrc1 {
  width: 40%;
  height: 100%;
  display: inline-block;
}

.citySrc2 {
  width: 60%;
  height: 100%;
  display: inline-block;
}
.headline-image {
  width: 500px;
  height: 300px;
  border: 1px solid #A4A4A4;
  /*position: absolute;*/
}

</style>

