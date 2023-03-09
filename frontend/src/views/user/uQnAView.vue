<template>

  <div class="wrapBox">
    <div class="container ">
      <div class="row ">
        <div class="col-sm-12">

          <div class="qnaBox" >
          <h3>Q&A</h3>
          <button>+ 질의 등록</button>
          </div>

        <table class="table" style="border: 1px solid #777;">
          <thead>
          <tr class="firstLine">
            <td class="writer">작성자</td>
            <td class="bigTitle">질문제목</td>
            <td class="bigRegdate">등록시간</td>
          </tr>
          </thead>

          <tbody>
          <tr>
            <td class="id">Id</td>
            <td class="title">Title</td>
            <td class="regdate">Regdate</td>
          </tr>

          </tbody>
        </table>
      </div>
      </div>
    </div>

  </div>
</template>

<script>
export default {
  name: "uQnAView"
}
</script>

<style scoped>

body, html{
  padding: 0;
  margin: 0;
}

.wrapBox {
  margin-top: 100px;
}

.qnaBox {
  display: flex;
  justify-content: space-between;
  margin-bottom: 30px;
}

.qnaBox h3 {
  font-size: 350%;
}

.qnaBox button {
  border: none;
}

</style>
