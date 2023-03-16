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
            <input type="text" v-model="uQnADetail.user_id" class="form-control" placeholder="Username" aria-label="Username"
                   aria-describedby="basic-addon1" disabled>
          </div>

          <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1">문의제목</span>
            <input type="text" v-model="uQnADetail.qa_title" class="form-control" placeholder="Title" aria-label="Username"
                   aria-describedby="basic-addon1" disabled>
          </div>

          <div class="input-group">
            <span class="input-group-text">문의내용</span>
            <textarea class="form-control contentBox" v-model="uQnADetail.qa_content" aria-label="With textarea" disabled></textarea>
          </div>


        </div>
      </div>

      <div class="wrapBox4" v-if="cQnADetail.user_id != null">
        <div class="qnaBox">
          <h3>A.</h3>
        </div>

        <div class=" wrapBox5">
          <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1">담당자</span>
            <input type="text" class="form-control" placeholder="Username" aria-label="Username"
                   aria-describedby="basic-addon1" disabled v-model="cQnADetail.user_id">
          </div>


          <div class="input-group">
            <span class="input-group-text">답변</span>
            <textarea class="form-control contentBox" aria-label="With textarea" disabled v-model="cQnADetail.qa_content"></textarea>
          </div>


        </div>
      </div>
    </div>

    <div class="btnBox">
      <!--답변은 하나만 달 수 있게 설정-->
      <button type="button" class="btn btn-primary" @click.prevent="addAnswer" v-if="cQnADetail.user_id == null">
        답변 등록하기
      </button>
      <button type="button" class="btn btn-outline-primary" @click.prevent="goBackToList">목록으로</button>
    </div>



  </div>
</template>

<script>
import SoftInput from "@/components/SoftInput.vue";
import SoftButton from "@/components/SoftButton.vue";

export default {
  components: {SoftInput, SoftButton},
  data() {
    return {
      uQnADetail: {
        user_id: 'user123',
        qa_title: '',
        qa_content: '',
        com_num: '',
        qa_type: ''
      },
      cQnADetail: {
        user_id: 'testCom5',
        com_num: '2',
        qa_content: '',
        qa_type: 'a'
      },
    };
  },


  beforeCreate() {

    this.$axios.get('/jobfair/getQnADetail/', {params: {qa_num: this.$route.params.qa_num}})
        .then((res) => {
          console.log('유저시작')
              this.uQnADetail = res.data
              console.log(res.data);
          // this.$axios.get('/jobfair/cQnAInfo/' , {params: {qa_num: this.$route.params.qa_num}} )
          //     .then((res) => {
          //
          //         console.log("successsss")
          //
          //         }
          //
          //     )
          //     .catch((error) => this.uQnADetail = error.date)
          //     .finally(()=>{
          //       console.log('기업완료')
          //       this.cQnADetail = res.data
          //       console.log(res.data);
          //     })

          this.$axios.get('/jobfair/getComQnADetail', {params: {qa_num: this.$route.params.qa_num}} )
              .then((response) => {
                console.log('기업시작')
                this.cQnADetail = response.data
                console.log(response.data);
              })
              .catch((err) => console.log(err))

            }
        )
        .catch((error) => console.log(error))


  },
  methods: {

    addAnswer() {
      this.$router.push({
        //params를 넘겨줄 때엔 push할 때 path보단 name을 사용함
        name: 'cQnAWriteView',
        params: {
          qa_num: this.$route.params.qa_num
        }
      })

    },
    goBackToList() {
      this.$router.push("/cQnAView")
    },

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
