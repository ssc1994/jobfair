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
              <input type="text" class="form-control" id="position" placeholder="직급을 입력하세요." name="position" v-model="jpl_workPosition">
            </div>
            <div class="mb-5 mt-5">
              <label for="">직무 :</label>
              <input type="text" class="form-control" id="duty" placeholder="직무명을 입력하세요." name="duty" v-model="jpl_duty">

            </div>
            <div class="mb-5 mt-5">
              <label for="">경력 :</label>
              <div class="form-check">
                <input type="radio" class="form-check-input" id="radio1" name="career" value="신입" checked v-model="jpl_workHistory">
                <label class="form-check-label" for="radio1">신입</label>
              </div>
              <div class="form-check">
                <input type="radio" class="form-check-input" id="radio2" name="career" value="경력" v-model="jpl_workHistory">
                <label class="form-check-label" for="radio2">경력</label>
              </div>
              <div class="form-check">
                <input type="radio" class="form-check-input" id="radio3" name="career" value="경력무관" v-model="jpl_workHistory">
                <label class="form-check-label" for="radio3">경력무관</label>
              </div>
            </div>


            <div class="mb-3 mt-3">
              <label for="">고용형태 :</label>
              <div class="form-check">
                <input type="radio" class="form-check-input" id="jobRadio1" name="employement" value="정규직" checked v-model="jpl_workForm">
                <label class="form-check-label" for="jobRadio1">정규직</label>
              </div>
              <div class="form-check">
                <input type="radio" class="form-check-input" id="jobRadio2" name="employement" value="계약직" v-model="jpl_workForm">
                <label class="form-check-label" for="jobRadio2">계약직</label>
              </div>
              <div class="form-check">
                <input type="radio" class="form-check-input" id="jobRadio3" name="employement" value="인턴" v-model="jpl_workForm">
                <label class="form-check-label" for="jobRadio3">인턴</label>
              </div>
              <div class="form-check">
                <input type="radio" class="form-check-input" id="jobRadio4" name="employement" value="파견직" v-model="jpl_workForm">
                <label class="form-check-label" for="jobRadio4">파견직</label>
              </div>
              <div class="form-check">
                <input type="radio" class="form-check-input" id="jobRadio5" name="employement" value="아르바이트" v-model="jpl_workForm">
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
                <option value="보훈대상자" >보훈대상자</option>
                <option value="고용촉진지원금 대상자">고용촉진지원금 대상자</option>
                <option value="취업보호대상자">취업보호대상자</option>
                <option value="병역특례">병역특례</option>
              </select>
            </div>
            <div class="mb-5 mt-5">
              <label for="">자격증 :</label>
              <input type="text" class="form-control" id="card" placeholder="자격증명을 입력하세요." name="card" v-model="jpl_certificate">
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
            <div class="mb-5 mt-5">
              <label for="">근무지 :</label>
              <input type="text" class="form-control" id="location" placeholder="지역을 입력하세요." name="location" v-model="jpl_address">
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
                  <input type="time" id="appt" name="appt" v-model="workingHourS"> ~
                  <input type="time" id="appt" name="appt" v-model="workingHourE">
                </div>
              </div>
            </div>
            <div class=" mb-5 mt-4">
              <label for="">급여 :</label>
              <div class="form-check">
                <input type="radio" class="form-check-input" id="salary1" name="salaryRadio" value="undecided" v-model="salaryType">
                <label class="form-check-label" for="salary1">면접 후 결정</label>
              </div>
              <div class="form-check">
                <input type="radio" class="form-check-input" id="salary2" name="salaryRadio" value=salary v-model="salaryType">
                <label class="form-check-label" for="salary2"><input type="text" class="" placeholder="예상연봉 입력" v-model="jpl_salary"></label>
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
                  <input type="file" class="form-control" id="inputGroupFile02" v-on:change='fileChange' ref="fileInsert">
                  <label class="input-group-text" for="inputGroupFile02" >Upload</label>
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
  data(){
    return{
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
      jpl_workTime:'',
      jpl_name:'',
      jpl_comPanyName:'',
      jpl_contact:'',
      jpl_phoneNum:'',
      jpl_email:'',
      jpl_fileName:'',
      jpl_filePath:'',
      jpl_fileUuid:'',
      workingHourS:'',
      workingHourE:'',
      salaryType:''
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
    fileChange(){
      this.jpl_fileName = this.$refs.fileInsert.files[0]
    },

    empRegist(){
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
        jpl_locationSi:'',
        jpl_locationGu:'',
        jpl_address:this.jpl_address,
        jpl_workDay:this.jpl_workDay,
        jpl_workTime:this.workingHourS+this.workingHourE,

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


      }).catch(err=>{
        console.log(err)

      })

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

.empReg .title .input-group{
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
</style>

