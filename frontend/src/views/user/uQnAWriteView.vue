QNAWRITEVIEW
<template>
  <div class="wrapBox">
    <div class="centerBox">
      <div class="wrapBox2">
        <div class="qnaBox">
          <h3>Q.</h3>
        </div>

        <div class=" wrapBox3">
          <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1">작성자</span>
            <input type="text" class="form-control" placeholder="Username" aria-label="Username"
                   aria-describedby="basic-addon1" v-model="uQnADetail.user_id">
          </div>

          <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1">문의제목</span>
            <input type="text" class="form-control" placeholder="Title" aria-label="Username"
                   aria-describedby="basic-addon1" v-model="uQnADetail.qa_title">
          </div>

          <div class="input-group">
            <span class="input-group-text">문의내용</span>
            <textarea class="form-control contentBox" aria-label="With textarea" v-model="uQnADetail.qa_content"></textarea>
          </div>


        </div>


      </div>


    </div>

    <div class="btnBox">
      <button type="button" class="btn btn-primary" @click.prevent="qnaRegist">등록하기</button>
      <button type="button" class="btn btn-outline-primary" @click.prevent="goBackToList">목록으로</button>
    </div>


  </div>
</template>

<script>
import SoftInput from "@/components/SoftInput.vue";
import SoftButton from "@/components/SoftButton.vue";
import axios from "axios";

export default {
  components: {SoftInput, SoftButton},
  name: "uQnAWriteView",


  data() {
    return {

      uQnADetail: {
        user_id: JSON.parse(sessionStorage.getItem('sessionId')),
        qa_title: '',
        qa_content: '',
        qa_type: '',
        com_num: this.$route.params.com_num
      }
    }

  },
  created() {
    console.log('param확인'+ this.uQnADetail.com_num);
  },


  methods: {
    qnaRegist() {
      let self = this;
      this.$axios
          .post('/jobfair/qnaRegist', {
            user_id: this.uQnADetail.user_id,
            qa_title: this.uQnADetail.qa_title,
            qa_content: this.uQnADetail.qa_content,
            qa_type: 'q',
            com_num: this.uQnADetail.com_num
          })
          .then((res) => {
            if (res.status === 200) {
              console.log(res.data)
              self.$router.push("/uQnAView")
            }
          })
          .catch((error) => {
            console.log(error)
            alert('에러: ' + error)

          })
          .finally(() => {
            console.log('큐앤에이등록')
          })
    },
    goBackToList() {
      this.$router.push("/uQnAView")
    }
  }
}

</script>

<style scoped>
.wrapBox {
  width: 100%;
  height: 100%;
}


.wrapBox2 {
  width: 80%;
  height: 50%;
  margin: 0 auto;
}

.wrapBox2 .qnaBox {
  text-align: left;
  font-size: 30px;
  height: 80px;
  position: relative;

}

.qnaBox h3 {
  font-size: 70px;
  position: relative;
  right: 100px;
  top: 60px;
}


.wrapBox3 .writer {
  font-size: 20px;
  height: 5%;
  line-height: 40px;

}

.contentBox {
  height: 300px;
  resize: none;
}

.wrapBox3 .title input {
  height: 30px;
  font-size: 15px;
  position: relative;
  left: 25px;
}

.wrapBox3 .content {
  font-size: 20px;
  text-align: left;
}

.wrapBox3 .content .contentInput {
  height: 350px;
  width: 550px;
  resize: none;
  font-size: 15px;
  position: relative;
  top: 10px;
  left: 120px;
}

.wrapBox4 {
  width: 80%;
  height: 50%;
  margin: 0 auto;
}

.btnBox {
  text-align: center;
  height: 50px;
  line-height: 50px;
}

.btnModalBox {
  text-align: center;
  margin-top: 30px;
  height: 50px;
  line-height: 50px;
}

.modal {
  --bs-modal-width: 800px
}

</style>
