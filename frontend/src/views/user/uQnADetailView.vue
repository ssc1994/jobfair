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
            <input type="text" v-model="uQnADetail.user_id" class="form-control" aria-label="Username"
                   aria-describedby="basic-addon1" disabled >
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
            <span class="input-group-text">문의내용</span>
            <textarea class="form-control contentBox" aria-label="With textarea" disabled v-model="cQnADetail.qa_content"></textarea>
          </div>


        </div>
      </div>
    </div>

    <div class="btnBox">
      <!--답변있을경우 수정하기 버튼 안보이게 설정해야함-->
      <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal"
              v-if="cQnADetail.user_id == null && sessionUser_id === uQnADetail.user_id">
        수정하기
      </button>
      <button type="button" class="btn btn-outline-primary" @click.prevent="goBackToList">목록으로</button>
    </div>

    <!--수정하기 모달창 설정-->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content ">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="exampleModalLabel">Q&A수정</h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body" style="height: 100%">
            <div class="infoModalBox">

              <div class=" wrapBox3">
                <div class="input-group mb-3">
                  <span class="input-group-text" id="basic-addon1">작성자</span>
                  <input type="text" class="form-control" placeholder="Username" aria-label="Username"
                         aria-describedby="basic-addon1" v-model="uQnADetail.user_id" disabled>
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

                <div class="btnModalBox">
                  <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" @click.prevent="uQnAModi">
                    수정완료
                  </button>

                </div>
              </div>

            </div>


          </div>
        </div>
      </div>


    </div>

  </div>
</template>

<script>
import SoftInput from "@/components/SoftInput.vue";
import SoftButton from "@/components/SoftButton.vue";
export default {components: {SoftInput, SoftButton},
  data() {
    return {

      sessionUser_id: JSON.parse(sessionStorage.getItem('sessionId')),

      uQnADetail: {
        user_id: '',
        qa_title: '',
        qa_content: '',

      },
      cQnADetail: {
        user_id: JSON.parse(sessionStorage.getItem('sessionId')),
        com_num: JSON.parse(sessionStorage.getItem('sessionComp')),
        qa_content: '',
        qa_type: 'a',
      },
      // uQnAModiList: {
      //   user_id: '',
      //   qa_title: '',
      //   qa_content: ''
      // }
    };
  },


  beforeCreate() {

      this.$axios.get('/jobfair/getQnADetail/' , {params:{qa_num: this.$route.params.qa_num}} )
          .then((res) => {
            this.uQnADetail = res.data
            console.log(res.data);

            this.$axios.get('/jobfair/getComQnADetail', {params: {qa_num: this.$route.params.qa_num}} )
                .then((response) => {
                  this.cQnADetail = response.data
                })
                .catch((error) => console.log(error))
            }
          )
          .catch((error) => console.log(error))



  },
  methods: {
    getQnADetail() {
      this.$axios.get('/jobfair/getQnADetail', {params: {qa_num: this.$route.params.qa_num}})
          .then((res) => this.uQnADetail = res.data)
          .catch((error) => console.log(error))

    },
    goBackToList() {
      this.$router.push("/uQnAView")
    },
    uQnAModi() {
      this.$axios.post('/jobfair/uQnAModi', {
        qa_num: this.$route.params.qa_num,
        user_id: this.uQnADetail.user_id,
        qa_title: this.uQnADetail.qa_title,
        qa_content: this.uQnADetail.qa_content
      })
          .then((res)=> {
            this.uQnADetail = res.data
            this.$router.push({
              name: 'uQnADetailView',
              params: {
                qa_num: this.$route.params.qa_num
              }
            })
            this.$router.push('/uQnAView')
          })
          .catch((error) => {
            console.log(error)
          })
    }

  }
};



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
