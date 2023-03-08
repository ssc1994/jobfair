<template>
  <div>

    <div>
      <div>
        <span>채용제목</span>
        <input type="text" placeholder="내용을 입력하세요.">
      </div>

      <div>
        <span>접수기간</span>
        <span>2023.03.03~2023.06.05</span>
      </div>
      <div class="container mt-3">
        <h2>채용조건</h2>
        <h5>1.포지션 정보</h5>
        <form action="/action_page.php">
          <div class="mb-3 mt-3">
            <label for="">포지션 :</label>
            <input type="text" class="form-control" id="position" placeholder="직무명을 입력하세요." name="position">
          </div>
          <div class="mb-3 mt-3">
            <label for="">직무 :</label>

          </div>
          <div class="mb-3 mt-3">
            <label for="">경력 :</label>
            <div class="form-check">
              <input type="radio" class="form-check-input" id="radio1" name="optradio" value="option1" checked>신입
              <label class="form-check-label" for="radio1"></label>
            </div>
            <div class="form-check">
              <input type="radio" class="form-check-input" id="radio1" name="optradio" value="option1" checked>경력
              <label class="form-check-label" for="radio1"></label>
            </div>
            <div class="form-check">
              <input type="radio" class="form-check-input" id="radio1" name="optradio" value="option1" checked>경력무관
              <label class="form-check-label" for="radio1"></label>
            </div>
          </div>
          <div class="container mb-3 mt-3">
            <label for="">고용형태 :</label><br />
            <div class="btn-group">
              <button type="button" class="btn btn-primary">정규직</button>
              <button type="button" class="btn btn-primary">계약직</button>
              <button type="button" class="btn btn-primary">인턴</button>
              <button type="button" class="btn btn-primary">파견직</button>
              <button type="button" class="btn btn-primary">아르바이트</button>
            </div>
          </div>

          <h5>2.지원 자격</h5>
          <div class="mb-3 mt-3">
            <label for="">학력 :</label>
            <select class="form-select">
              <option>대졸(4년제)</option>
              <option>전문대졸(3년제)</option>
              <option>전문대졸(2년제)</option>
              <option>고졸</option>
              <option>학력무관</option>
            </select>
          </div>
          <div class="mb-3 mt-3">
            <label for="">우대조건 :</label>
            <select class="form-select">
              <option>국가유공자</option>
              <option>보훈대상자</option>
              <option>고용촉진지원금 대상자</option>
              <option>취업보호대상자</option>
              <option>병역특례</option>
            </select>
          </div>
          <div class="mb-3 mt-3">
            <label for="">자격증 :</label>
            <input type="text" class="form-control" id="card" placeholder="자격증명을 입력하세요." name="card">
          </div>
          <div class="mb-3 mt-3">
            <label for="">성별 :</label>
            <div class="form-check">
              <input type="checkbox" class="form-check-input" id="check1" name="option1" value="something" checked>
              <label class="form-check-label" for="check1">남자</label>
            </div>
            <div class="form-check">
              <input type="checkbox" class="form-check-input" id="check1" name="option1" value="something">
              <label class="form-check-label" for="check1">여자</label>
            </div>
          </div>

          <h5>3.근무조건</h5>
          <div class="input-group mb-3">
            <div class="input-group-text">
              <input type="checkbox">면접 후 결정
            </div>
            <input type="text" class="form-control" placeholder="희망연봉 입력">
          </div>
          <div class="mb-3 mt-3">
            <label for="">희망근무요일 :</label>
            <select class="form-select">
              <option>주 5일(월~금)</option>
              <option>주 3일</option>
              <option>주 2일</option>
              <option>하루</option>
              <option>회사내규에 따름</option>
            </select>
          </div>
          <form action="/action_page.php">
            <label for="appt">희망근무시간 :</label>
            <input type="time" id="appt" name="appt"> ~
            <input type="time" id="appt" name="appt">
          </form>
          <div class="mb-3 mt-3">
            <label for="">희망근무지 :</label>
            <input type="text" class="form-control" id="location" placeholder="지역을 입력하세요." name="location">
          </div>
          <button type="submit" class="btn btn-primary">수정하기</button>
        </form>
      </div>


    </div>
  </div>
</template>

<script>
export default {
  name: "cEmpModiView"
}
</script>

<style scoped>
*{
  padding: 0;
  margin: 0 auto;
  list-style: none;
  text-decoration: none;
  box-sizing: border-box;
  text-align: center;
}
</style>
