<template>
  <div class="wrapBox">
    <div class="centerBox">
      <div class="wrapBox2">
        <div class="qnaBox">
          <h3>Q.</h3>
        </div>

        <div class="wrapBox3">

            <button class="btn btn-custom" @click.prevent="adeleteQnA">삭제하기</button>
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

      <div class="wrapBox4" v-if="aQnADetail.user_id != null">
        <div class="qnaBox">
          <h3>A.</h3>
        </div>

        <div class=" wrapBox5">
          <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1">작성자</span>
            <input type="text" class="form-control" placeholder="Username" aria-label="Username"
                   aria-describedby="basic-addon1" disabled v-model="aQnADetail.user_id">
          </div>


          <div class="input-group">
            <span class="input-group-text">답변</span>
            <textarea class="form-control contentBox" aria-label="With textarea" disabled v-model="aQnADetail.qa_content"></textarea>
          </div>


        </div>
      </div>
    </div>

    <div class="btnBox">
      <!--답변은 하나만 달 수 있게 설정-->
      <button type="button" class="btn btn-primary" @click.prevent="addAnswer" v-if="aQnADetail.user_id == null">
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
        user_id: '',
        qa_title: '',
        qa_content: '',
        com_num: '',
        qa_type: ''
      },
      aQnADetail: {
        user_id: '관리자',
        com_num: '',
        qa_content: '',
        qa_type: ''
      },
    };
  },


  beforeCreate() {

    this.$axios.get('/jobfair/getQnADetail/', {params: {qa_num: this.$route.params.qa_num}})
        .then((res) => {
              this.uQnADetail = res.data


              this.$axios.get('/jobfair/getAdmQnADetail', {params: {qa_num: this.$route.params.qa_num}} )
                  .then((response) => {
                    this.aQnADetail = response.data
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
        name: 'aQnAWriteView',
        params: {
          qa_num: this.$route.params.qa_num
        }
      })

    },
    goBackToList() {
      this.$router.push("/aQnAView")
    },
    adeleteQnA() {
      if(confirm('정말로 삭제하시겠습니까?')) {
        this.$axios.get('/jobfair/adeleteQnA?qa_num=' + this.$route.params.qa_num)
            .then((res) => {
              this.$router.push("/aQnAView");
              console.log(res)
            })
            .catch((error) => {
              console.log(error)
            })
      }
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

.wrapBox3 button {
  float: right;
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

.btn-custom {
  background-color: hsl(0, 92%, 36%) !important;
  background-repeat: repeat-x;
  filter: progid:DXImageTransform.Microsoft.gradient(startColorstr="#f74444", endColorstr="#b00707");
  background-image: -khtml-gradient(linear, left top, left bottom, from(#f74444), to(#b00707));
  background-image: -moz-linear-gradient(top, #f74444, #b00707);
  background-image: -ms-linear-gradient(top, #f74444, #b00707);
  background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #f74444), color-stop(100%, #b00707));
  background-image: -webkit-linear-gradient(top, #f74444, #b00707);
  background-image: -o-linear-gradient(top, #f74444, #b00707);
  background-image: linear-gradient(#f74444, #b00707);
  border-color: #b00707 #b00707 hsl(0, 92%, 29.5%);
  color: #fff !important;
  text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.42);
  -webkit-font-smoothing: antialiased;
}

</style>
