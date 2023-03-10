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
                 aria-describedby="basic-addon1">
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
                   aria-describedby="basic-addon1">
            &nbsp; ~ &nbsp;
            <span class="input-group-text" id="basic-addon1">공고종료일</span>
            <input type="date" class="form-control" placeholder="2023.06.05." aria-label="Username"
                   aria-describedby="basic-addon1">
          </div>
        </div>
      </div>
      </section>
      <div class=" mt-3 mb-3">
        <h2>채용조건</h2>
      </div>

      <div class="container mt-3">
        <form action="/action_page.php">
          <section>
            <h5>1.포지션 정보</h5>
            <div class="mb-5 mt-5">
              <label for="">포지션 :</label>
              <input type="text" class="form-control" id="position" placeholder="직급을 입력하세요." name="position">
            </div>
            <div class="mb-5 mt-5">
              <label for="">직무 :</label>
              <input type="text" class="form-control" id="position" placeholder="직무명을 입력하세요." name="position">

            </div>
            <div class="mb-5 mt-5">
              <label for="">경력 :</label>
              <div class="form-check">
                <input type="radio" class="form-check-input" id="radio1" name="optradio" value="option1" checked>
                <label class="form-check-label" for="radio1">신입</label>
              </div>
              <div class="form-check">
                <input type="radio" class="form-check-input" id="radio2" name="optradio" value="option2">
                <label class="form-check-label" for="radio2">경력</label>
              </div>
              <div class="form-check">
                <input type="radio" class="form-check-input" id="radio3" name="optradio" value="option3">
                <label class="form-check-label" for="radio3">경력무관</label>
              </div>
            </div>


            <div class="mb-3 mt-3">
              <label for="">고용형태 :</label>
              <div class="form-check">
                <input type="radio" class="form-check-input" id="jobRadio1" name="jobRadio" value="male" checked>
                <label class="form-check-label" for="jobRadio1">정규직</label>
              </div>
              <div class="form-check">
                <input type="radio" class="form-check-input" id="jobRadio2" name="jobRadio" value="female">
                <label class="form-check-label" for="jobRadio2">계약직</label>
              </div>
              <div class="form-check">
                <input type="radio" class="form-check-input" id="jobRadio3" name="jobRadio" value="female">
                <label class="form-check-label" for="jobRadio3">인턴</label>
              </div>
              <div class="form-check">
                <input type="radio" class="form-check-input" id="jobRadio4" name="jobRadio" value="female">
                <label class="form-check-label" for="jobRadio4">파견직</label>
              </div>
              <div class="form-check">
                <input type="radio" class="form-check-input" id="jobRadio5" name="jobRadio" value="female">
                <label class="form-check-label" for="jobRadio5">아르바이트</label>
              </div>
            </div>
          </section>
          <section>
            <h5>2.지원 자격</h5>
            <div class="mb-5 mt-5">
              <label for="">학력 :</label>
              <select class="form-select">
                <option>대졸(4년제)</option>
                <option>전문대졸(3년제)</option>
                <option>전문대졸(2년제)</option>
                <option>고졸</option>
                <option>학력무관</option>
              </select>
            </div>
            <div class="mb-5 mt-5">
              <label for="">우대조건 :</label>
              <select class="form-select">
                <option>국가유공자</option>
                <option>보훈대상자</option>
                <option>고용촉진지원금 대상자</option>
                <option>취업보호대상자</option>
                <option>병역특례</option>
              </select>
            </div>
            <div class="mb-5 mt-5">
              <label for="">자격증 :</label>
              <input type="text" class="form-control" id="card" placeholder="자격증명을 입력하세요." name="card">
            </div>


            <div class="mb-5 mt-5">
              <label for="">성별 :</label>
              <div class="form-check">
                <input type="radio" class="form-check-input" id="genderRadio1" name="genderRadio" value="male" checked>
                <label class="form-check-label" for="genderRadio1">남자</label>
              </div>
              <div class="form-check">
                <input type="radio" class="form-check-input" id="genderRadio2" name="genderRadio" value="female">
                <label class="form-check-label" for="genderRadio2">여자</label>
              </div>
              <div class="form-check">
                <input type="radio" class="form-check-input" id="genderRadio3" name="genderRadio" value="female">
                <label class="form-check-label" for="genderRadio3">성별무관</label>
              </div>
            </div>


          </section>

          <section>
            <h5>3.근무조건</h5>
            <div class=" mb-5 mt-5">
              <input type="checkbox">면접 후 결정<br>
              <input type="text" class="" placeholder="예상연봉 입력">
            </div>
            <div class="mb-5 mt-5">
              <label for="">근무요일 :</label>
              <select class="form-select">
                <option>주 5일(월~금)</option>
                <option>주 3일</option>
                <option>주 2일</option>
                <option>하루</option>
                <option>회사내규에 따름</option>
              </select>
            </div>
            <div class="mb-5 mt-5">
              <form action="/action_page.php">
                <label for="appt">근무시간 :</label>
                <div>
                  <input type="time" id="appt" name="appt"> ~
                  <input type="time" id="appt" name="appt">
                </div>
              </form>
            </div>
            <div class="mb-5 mt-5">
              <label for="">근무지 :</label>
              <input type="text" class="form-control" id="location" placeholder="지역을 입력하세요." name="location">
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
                  <textarea class="form-control col-sm-5" rows="5"></textarea>
                </div>
                <div class="input-group mb-3">
                  <input type="file" class="form-control" id="inputGroupFile02">
                  <label class="input-group-text" for="inputGroupFile02">Upload</label>
                </div>
              </div>
            </div>
          </section>
          <button type="submit" class="btn btn-primary">등록</button>
        </form>
      </div>


    </div>
  </div>



</template>

<script>
export default {
  name: "cEmpRegView"
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

