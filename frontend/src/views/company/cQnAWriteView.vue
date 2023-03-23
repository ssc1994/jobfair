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
            <input type="text" class="form-control" aria-label="Username"
                   aria-describedby="basic-addon1" v-model="uQnADetail.user_id" >
          </div>

          <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1">문의제목</span>
            <input type="text" class="form-control" placeholder="Title" aria-label="Username"
                   aria-describedby="basic-addon1" v-model="uQnADetail.qa_title" >
          </div>

          <div class="input-group">
            <span class="input-group-text">문의내용</span>
            <textarea class="form-control contentBox" aria-label="With textarea" v-model="uQnADetail.qa_content" ></textarea>
          </div>


        </div>
      </div>

      <div class="wrapBox4">
        <div class="qnaBox">
          <h3>A.</h3>
        </div>

        <div class=" wrapBox5">
          <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1">담당자</span>
            <input type="text" class="form-control" aria-label="Username"
                   aria-describedby="basic-addon1" disabled v-model="cQnADetail.user_id">
          </div>


          <div class="input-group">
            <span class="input-group-text">답변</span>
            <textarea class="form-control contentBox" aria-label="With textarea" v-model="cQnADetail.qa_content"></textarea>
          </div>


        </div>
      </div>
    </div>

    <div class="btnBox">
      <button type="button" class="btn btn-primary" @click.prevent="cqnaRegist">등록하기</button>
      <button type="button" class="btn btn-outline-primary" @click.prevent="goBackToList">목록으로</button>
    </div>
    <input type="button">


  </div>
</template>

<script>
import SoftInput from "@/components/SoftInput.vue";
import SoftButton from "@/components/SoftButton.vue";

export default {components: {SoftInput, SoftButton},

  data() {
    return {
      uQnADetail: {
        user_id: 'user123',
        qa_title: '',
        qa_content: '',
        com_num: ''
      },
      cQnADetail: {
        user_id: JSON.parse(sessionStorage.getItem('sessionId')),
        com_num: JSON.parse(sessionStorage.getItem('sessionComp')),
        qa_content: '',
        qa_type: 'a',
        qa_reply: this.$route.params.qa_num
      }


    }
  },
  beforeCreate() {

  // this.cQnADetail.user_id=JSON.parse(sessionStorage.getItem('sessionId'),



    this.$axios.get('/jobfair/getQnADetail/' , {params:{qa_num: this.$route.params.qa_num}} )
        .then((res) => {
          console.log('유저시작')
              this.uQnADetail = res.data
              console.log(res.data);
          console.log(this.cQnADetail.user_id)
          console.log(this.cQnADetail.com_num)
          console.log(this.cQnADetail.qa_reply)

          // this.$axios.get('/jobfair/cQnAInfo/' , {params:{user_id: JSON.parse(sessionStorage.getItem('sessionId'))}} )
          //     .then((res) => {
          //           console.log('기업시작')
          //
          // //           this.cQnADetail = res.data
          //     this.cQnADetail.qa_type = 'a'
          // this.cQnADetail.user_id = JSON.parse(sessionStorage.getItem('sessionId'))
          // this.cQnADetail.com_num = JSON.parse(sessionStorage.getItem('sessionComp'))
          // this.cQnADetail.qa_reply = this.$route.params.qa_num
          //   //
            //         console.log(res.data);
            //       }
            //   )
            //   .catch((error) => this.uQnADetail = error.date)
            //   .finally(()=>{
            //     console.log('기업완료')
            //   })
            //
            }
        )
        .catch((error) => console.log(error))
        .finally(()=>{
          console.log('유저완료')
        })

  },
    methods: {
      //기업이 답변 등록하고, 데이터 저장해서 보내기 위한 메서드
      cqnaRegist() {
        let myData = {
          user_id: this.cQnADetail.user_id,
          com_num: JSON.parse(sessionStorage.getItem('sessionComp')),
          qa_content: this.cQnADetail.qa_content,
          qa_type: this.cQnADetail.qa_type,
          qa_reply: this.$route.params.qa_num
        }
        console.log(myData)

        this.$axios
            .post('/jobfair/cqnaRegist', myData)
            .then((res) => {
              if(res.status === 200) {
                console.log(res.data)
                this.$router.push({
                  name: 'cQnADetailView',
                  params: {
                    qa_num: this.$route.params.qa_num
                  }
                })
                this.$router.push({
                  name: 'cQnAView',
                  params: {
                    com_num: JSON.parse(sessionStorage.getItem('sessionComp'))
                  }
                })
              }
            })
            .catch((error) => {
              console.log(error)
              alert('에러: ' + error )

            })
            .finally(() => {
              console.log('기업답변등록')
            })
      },
      // getComQnADetail() {
      //   this.$axios.get('/jobfair/cQnADetailView')
      //       .then((res)=> {
      //         this.cQnADetail = res.data
      //       })
      //       .catch((error) => {
      //         console.log(error)
      //       })
      // },
      goBackToList() {
        this.$router.push("/cQnAView")
      },


    },


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
