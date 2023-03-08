<template>
  <div>

    <h3>인적사항</h3>
    <div>
      <div>
        <div>
          <span>이름</span>
          <input type="text">
        </div>
        <div>
          <span>생일</span>
          <input type="text">
        </div>
        <div>
          <span>성별</span>
          <input type="text">
        </div>
        <div>
          <span>이메일</span>
          <input type="text">
        </div>
      </div>

      <div>
        <div>
          <span>핸드폰번호</span>
          <input type="text">
        </div>
        <div>
          <span>주소</span>
          <input type="text">
        </div>
      </div>

      <div>
        <span>프로필사진</span>
        <img src="" alt="사진">
        <span>사진추가</span>
      </div>

    </div>

    <hr/>

    <h3>학력</h3>
    <div>
      <div>
        <div>
          <span>학력구분</span>
          <select>
            <option>대졸</option>
            <option>초대졸</option>
            <option>고졸</option>
            <option>중졸</option>
          </select>
        </div>
        <div>
          <span>학교명</span>
          <input type="text">
        </div>
        <div>
          <span>입학년월</span>
          <input type="text">
        </div>
        <div>
          <span>졸업년월</span>
          <input type="text">
        </div>
        <div>
          <span>졸업상태</span>
          <input type="text">
        </div>
      </div>

      <div>
        <div>
          <span>전공명</span>
          <input type="text">
        </div>
        <div>
          <span>학점</span>
          <input type="text">
        </div>
        <div>
          <span>학점총점</span>
          <input type="text">
        </div>
      </div>

    </div>


    <hr/>

    <h3>경력</h3>
    <div>
      <div>
        <div>
          <span>회사명</span>
          <input type="text">
        </div>
        <div>
          <span>부서명</span>
          <input type="text">
        </div>
        <div>
          <span>입사년월</span>
          <input type="text">
        </div>
        <div>
          <span>퇴사년월</span>
          <input type="text">
        </div>
      </div>

      <div>
        <div>
          <span>직급/직책</span>
          <input type="text">
        </div>
        <div>
          <span>담당직무</span>
          <input type="text">
        </div>
        <div>
          <span>연봉</span>
          <input type="text">
        </div>
      </div>

      <div>
        <button>+</button>
        <button>추가</button>
      </div>
    </div>


    <hr/>


    <h3>자격증</h3>
    <div>
      <div>
        <span>자격증명</span>
        <input type="text">
      </div>
      <div>
        <span>발행처</span>
        <input type="text">
      </div>
      <div>
        <span>취득일</span>
        <input type="text">
      </div>
      <div>
        <button>+</button>
        <button>추가</button>
      </div>
    </div>

    <hr/>


    <h3>자기소개서</h3>
    <div>
      <input type="text" size="80" placeholder="항목 제목 ">
      <input type="text" size="20" placeholder="작성일">
      <br/>
      <input type="text" size="100" placeholder="해당 내용을 입력">

    </div>


    <hr/>

    <button>이력서 저장</button>

  </div>
</template>

<script>
export default {
  name: "uResumeView"
}
</script>

<style scoped>

</style>
