<template>
  <div class="resumeBox">
    <div class="left">
      <ul>
        <li>
          <p class="resumeTitle">{{ resDetail.res_title }}</p>
          <p>{{ resDetail.res_regDate }}</p>
        </li>
      </ul>
    </div>
    <div class="right">
      <button type="button" class="btn btn-outline-primary"
              style="border-color: #0064ff;color:#0064ff;" @click="moveDetail">
        상세보기
      </button>
      <button type="button" class="btn btn-outline-primary"
              style="border-color: rgb(229, 75, 75);color:rgb(229, 75, 75);" @click="delBtn">
        삭제
      </button>
    </div>
  </div>
</template>

<script>
export default {
  name: "resumeList",
  props: [
    'resDetail',
    'index',
    'resDetail'
  ],
  data() {
    return {
      fold: true
    }
  },
  methods: {
    delBtn() {
      if (confirm('정말로 삭제하시겠습니까?')) {
        this.$axios.post('/jobfair/deleteResume', {res_num: this.resDetail.res_num})
            .then((res) => {
              this.$router.go(0);
              this.res_num = res.data
            })
            .catch((error) => {
              console.log(error)
            })
      }
    },
    moveDetail() {
      this.$router.push({
        name: 'uResumeDetailView',
        query: {
          res_num: this.resDetail.res_num,
          isAble: true
        }
      })
    }
  }
}
</script>

<style scoped>

ul, ol {
  list-style: none;
}

a {
  text-decoration: none;
}

.left {
  float: left;
}

.right {
  float: right;
}

h3 {
  font-weight: bold;
  font-size: 20px;
  padding: 20px;
}

/*이력서*/
.resumeBoxCon h3 {
  display: inline-block;
}

.resumeBoxWrap {
  display: inline-block;
  width: 50%;
}

.arrDown {
  border: 0;
  margin-left: 10px;
  background: transparent;
}

.arrDown img {
  border: 0;
  width: 20px;
  height: 30px;
  object-fit: contain;
}

.resumeBox {
  border: 1px solid #dedede;
  border-radius: 20px;
  overflow: hidden;
  padding: 20px;
  width: 98%;
  margin-bottom: 10px;
  display: inline-block;
  margin-left: 5px;
  height: 100px;
  line-height: 50px;
}

.resumeBox p {
  margin: 0;
  padding: 0;
}

.resumeBox button {
  margin: 5px;
}

.resumeBox:hover {
  border: 1px solid #0064ff;
}

.resumeTitle {
  font-weight: bold;
  font-size: 18px;
}


/*지원현황*/
.aplBtnBox {
  margin-top: 20px;
  border: 1px solid #dedede;
  display: inline-block;
  border-radius: 20px;
  box-shadow: rgba(0, 0, 0, 0.16) 0px 10px 36px 0px, rgba(0, 0, 0, 0.06) 0px 0px 0px 1px;
  width: 100%;
}

.aplBtnBox button {
  border: 0;
  border-left: 1px solid #dedede;
  background-color: transparent;
  width: 25%;
  background-color: #efefef;
  padding: 10px;
}

.aplBtnBox button:hover {
  color: #0064ff;
}

.aplBtnBox button:first-child {
  border: 0;
}

.aplBtnBox p {
  padding: 0;
  margin: 0;
}

.aplBtnNum {

  font-size: 25px;
  font-weight: bold;
  margin: 0;
  padding: 30px;
}


.aplTable {
  width: 100%;
  padding: 20px;

  text-align: center;
  margin-top: 30px;
}

tr td:nth-child(4) {
  border-right: 0;
  height: 80px;
}

tr {
  border-radius: 20px;
  margin: 10px 0;
}

tr td:hover {
  border-bottom: 2px solid #0064ff;
}

tr td {
  padding: 10px;
  border-left: 0;
  border-bottom: 2px solid #dedede;
}

.aplTableTitle td {
  border: 0;
  padding: 10px;
  font-weight: bold;
  font-size: 20px;
}

.pass {
  color: #202632;
  font-weight: bold;

}

.noPass {
  color: rgb(229, 75, 75);
  font-weight: bold;
}

.allPass {
  color: #0064ff;
  font-weight: bold;
  border-radius: 20px;
  margin: 10px;
}

.applied {
  color: #757575;
  font-weight: bold;
}

/* 이력서 수정 모달창 관련 css */
.contentBox {
  height: 300px;
}

.modal {
}
</style>