<template>



  <div class="wrapBox">
    <div class="wrapBox2">



      <div class="container empBoxWrap">
        <div>
          <h3>HOT 채용공고</h3>
        </div>
        <div class="row" style="margin-top: 20px">
          <router-link to="" class="hotBoxWrap">
            <div>
              <img src="@/assets/kakao.png"/>
            </div>
            <div class="hotText">
              <div>(주)카카오</div>
              <p class="hotTitle">
                채용전환형 인턴 공개채용
              </p>

                <span class="hotDday">D-9</span>
            </div>
          </router-link>

          <router-link to="" class="hotBoxWrap">
            <div>
              <img src="@/assets/kakao.png"/>
            </div>
            <div class="hotText">
              <div>(주)카카오</div>
              <p class="hotTitle">
                채용전환형 인턴 공개채용
              </p>

              <span class="hotDday">D-9</span>
            </div>
          </router-link>
          <router-link to="" class="hotBoxWrap">
            <div>
              <img src="@/assets/kakao.png"/>
            </div>
            <div class="hotText">
              <div>(주)카카오</div>
              <p class="hotTitle">
                채용전환형 인턴 공개채용
              </p>

              <span class="hotDday">D-9</span>
            </div>
          </router-link>
          <router-link to="" class="hotBoxWrap">
            <div>
              <img src="@/assets/kakao.png"/>
            </div>
            <div class="hotText">
              <div>(주)카카오</div>
              <p class="hotTitle">
                채용전환형 인턴 공개채용
              </p>

              <span class="hotDday">D-9</span>
            </div>
          </router-link>

          <router-link to="" class="hotBoxWrap">
            <div>
              <img src="@/assets/kakao.png"/>
            </div>
            <div class="hotText">
              <div>(주)카카오</div>
              <p class="hotTitle">
                채용전환형 인턴 공개채용
              </p>

              <span class="hotDday">D-9</span>
            </div>
          </router-link>

          <router-link to="" class="hotBoxWrap">
            <div>
              <img src="@/assets/kakao.png"/>
            </div>
            <div class="hotText">
              <div>(주)카카오</div>
              <p class="hotTitle">
                채용전환형 인턴 공개채용
              </p>

              <span class="hotDday">D-9</span>
            </div>
          </router-link>
          <router-link to="" class="hotBoxWrap">
            <div>
              <img src="@/assets/kakao.png"/>
            </div>
            <div class="hotText">
              <div>(주)카카오</div>
              <p class="hotTitle">
                채용전환형 인턴 공개채용
              </p>

              <span class="hotDday">D-9</span>
            </div>
          </router-link>
          <router-link to="" class="hotBoxWrap">
            <div>
              <img src="@/assets/kakao.png"/>
            </div>
            <div class="hotText">
              <div>(주)카카오</div>
              <p class="hotTitle">
                채용전환형 인턴 공개채용
              </p>

              <span class="hotDday">D-9</span>
            </div>
          </router-link>



        </div>
      </div>



    </div>

    <div>
      <div class="qnaBox">
        <h3>Q&A</h3>
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


</template>

<script>
export default {
  name: 'uMainView',
}
</script>

<style scoped>
/*글씨체*/
@font-face {
  font-family: 'MICEGothic Bold';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2206-01@1.0/MICEGothic Bold.woff2') format('woff2');
  font-weight: 700;
  font-style: normal;
}

html, body {width:100%;
  height:100%;}

.left{float: left;}
.right {float:right;}

h3{font-weight: bold;
  font-size: 20px;

}
.empBoxWrap {
  max-width:1560px;
  margin:0 auto;
  height: 100%;
}

/*hot 채용정보*/
.hotBoxWrap {
            border:1px solid #dedede;
            border-radius: 20px;
            width:23%;
            color:black;
            text-decoration: none;
            padding:20px;
            margin-left: 1%;
            margin-bottom: 1%;
}
.hotBoxWrap:hover {
            border:1px solid #0064ff;
  box-shadow: rgba(0, 0, 0, 0.16) 0px 10px 36px 0px, rgba(0, 0, 0, 0.06) 0px 0px 0px 1px;

}

.hotBoxWrap img {
            width:100%;
            padding:40px;
}

.hotTitle {font-size: 18px;
           font-weight: bold;

}

.hotText {border-top:1px solid #dedede;
          padding-top:10px;
}

.hotDday {font-weight: bold;
          padding:5px 15px;
          color:rgb(229, 75, 75);
          border:1px solid rgb(229, 75, 75);
          border-radius:20px;
}

.wrapBox2 {
  display: flex;
  justify-content: center;
  height: 500px;
}

/*큐앤에이*/

.qnaBox {
  font-family: 'MICEGothic Bold';
  display: flex;
  text-align: left;
  width: 80%;
  margin: 0 auto;
  margin-top: 300px;
  height: 60px;

}

.qnaBox h3 {
  float: left;
  font-size: 30px;
}

.table {
  width: 75%;
  margin: 0 auto;
  border: 1px solid grey;
}

.table tbody tr:last-child td {
  border-width: 1px;
}

</style>
