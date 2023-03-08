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

      <div>
        <span>인사담당자 정보입력란</span> <br/>
        <span>채용조건</span>
        <span>1. 포지션 정보</span>

        <table>
          <thead>
          <tr>
            <td>포지션</td>
            <td><input type="text" placeholder="직무명을 포함하여 입력하세요."></td>


            <td>고용형태</td>
          </tr>
          </thead>

          <tbody>
          <tr>
            <td>직무</td>
            <td><input type="text"><a href="#">전체보기</a></td>
          </tr>

          <tr>
            <td>경력</td>
            <td><input type="checkbox"></td>
            <td>신입/경력/경력무관</td>
          </tr>

          <tr>
            <td>고용형태</td>
            <td><input type="checkbox"></td>
            <td>정규직/계약직/인턴/파견직/아르바이트</td>
          </tr>
          </tbody>
        </table>

      </div>

      <div>
        <p>채용조건</p>
        <form>
          <table>
            <tr>
              <td>학력</td>
              <td>
                <select>
                  <option>대졸(4년제)</option>
                  <option>전문대졸(3년제)</option>
                  <option>전문대졸(2년제)</option>
                  <option>고졸</option>
                  <option>학력무관</option>
                </select>
              </td>
            </tr>
            <tr>
              <td>우대조건</td>
              <td>
                <select>
                  <option>국가유공자</option>
                  <option>보훈대상자</option>
                  <option>고용촉진지원금 대상자</option>
                  <option>취업보호대상자</option>
                  <option>병역특례</option>
                </select>
              </td>
            </tr>
            <tr>
              <td>자격증</td>
              <td>
                <select>
                  <option>정보처리기사</option>
                </select>
              </td>
            </tr>
            <tr>
              <td>성별연령무관</td>
              <td>
                <input type="radio" name="gender"/>여자
                <input type="radio" name="gender"/>남자
              </td>
            </tr>

          </table>

          <table>
            <tr>
              <td>급여</td>
              <td>
                <select>
                  <option>연봉</option>
                </select>
              </td>
            </tr>
            <tr>
              <td>근무지주소</td>
              <td>
                <input type="text">
              </td>
            </tr>
            <tr>
              <td>근무일</td>
              <td>
                <input type="text">
              </td>
            </tr>
            <tr>
              <td>근무시간</td>
              <td>
                <input type="text">
              </td>
            </tr>
          </table>
          <div>
            <button>등록하기</button>
          </div>
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

</style>
