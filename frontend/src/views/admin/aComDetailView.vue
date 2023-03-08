<template>
  <div>

    <div>
      <h3>기업정보</h3>
      <div>
        <div>
          <div>
            <img src="" alt="기업이미지">
            <h5>(주)카카오</h5>
          </div>
          <div>
            <table>
              <tr>
                <td>기업번호</td>
                <td>123-456-789</td>
              </tr>
              <tr>
                <td>사업자등록번호</td>
                <td>0000-0000-0000</td>
              </tr>
              <tr>
                <td>전화번호</td>
                <td>010-1234-5678</td>
              </tr>
              <tr>
                <td>이메일</td>
                <td>~~@gmail.com</td>
              </tr>
              <tr>
                <td>업종</td>
                <td>IT</td>
              </tr>
              <tr>
                <td>대표자</td>
                <td>홍길동</td>
              </tr>
              <tr>
                <td>설립일</td>
                <td>2022.10.11</td>
              </tr>
            </table>
          </div>
        </div>
        <div>
          <button>승인하기</button>
          <button>반려하기</button>
        </div>
      </div>
    </div>

  </div>

  <!-- 반려사유 팝업창 -->
  <div>
    <div>
      <h4>반려사유</h4>
      <button>X</button>
      <input type="text"/>
      <button>반려하기</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "aComDetailView"
}
</script>

<style scoped>

</style>
