<template>

  <div class="wrapBox">
    <div class="container ">
      <div class="row ">
        <div class="col-sm-12">

          <div class="qnaBox">
            <h3>Q&A</h3>
            <button>+ 질의 등록</button>
          </div>

          <table class="table table-bordered">
            <thead>
            <tr>
              <td>Firstname</td>
              <td>Lastname</td>
              <td>Email</td>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>John</td>
              <td>Doe</td>
              <td>john@example.com</td>
            </tr>
            <tr>
              <td>Mary</td>
              <td>Moe</td>
              <td>mary@example.com</td>
            </tr>
            <tr>
              <td>July</td>
              <td>Dooley</td>
              <td>july@example.com</td>
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

body, html {
  padding: 0;
  margin: 0;
}

.wrapBox {
  margin-top: 5%;
  margin-right: 10%;
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

table {
  width: 100%;
  border: 1px solid #444444;
  border-collapse: collapse;
}

.table thead {
  background-color: grey;
  color: white;
}

.table tbody tr:last-child td {
  border-width: 1px;
}


</style>
