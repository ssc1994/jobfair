<template>
<div class="container-fluid container">
  <div class="dropdown">
    <table class="table dropdown-toggle" id="dropdown-toggle" data-bs-toggle="dropdown">
      <thead class="table-dark">
      <tr>
        <th>채용제목</th>
        <th>지원자 수</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="ManyList in 5" :key="ManyList">
        <td><a href="#">채용제목 클릭 시 지원자 상세내역 리스트 보이게하기</a></td>
        <td>3</td>
      </tr>
      </tbody>
          <table class="table dropdown-menu" id="dropdown-menu" data-bs-toggle="dropdown">
            <thead class="table-dark">
            <tr class="">
              <th>지원일자</th>
              <th>이력서제목</th>
              <th>작성자</th>
              <th>상태</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>1</td>
              <td><a href="#">이력서 확인 후 상태수정가능</a></td>
              <td>1</td>
              <td>
                <select class="form-select">
                  <option>이력서 검토중</option>
                  <option>서류 합격</option>
                  <option>불합격</option>
                  <option>최종 합격</option>
                </select>
                <input type="text" placeholder="서류합격시 면접일자등록기능">
              </td>
            </tr>
            <tr>
              <td>1</td>
              <td><a href="#">이력서 확인 후 상태수정가능</a></td>
              <td>1</td>
              <td>
                <select class="form-select">
                  <option>이력서 검토중</option>
                  <option>서류 합격</option>
                  <option>불합격</option>
                  <option>최종 합격</option>
                </select>
                <input type="text" placeholder="서류합격시 면접일자등록기능">
              </td>
            </tr>
            </tbody>
          </table>
    </table>
  </div>
</div>
</template>

<script>
export default {
  name: 'cApplyMngView'
}
</script>

<style scoped>
* {margin: 0 auto; padding: 0;}
a {text-decoration: none; color: black}
a:hover {color: grey}

#dropdown-toggle {
  position: relative;
}

.dropdown-menu {
  position: absolute;
  text-align: center;
  width: auto;
  white-space: nowrap;
}
</style>
