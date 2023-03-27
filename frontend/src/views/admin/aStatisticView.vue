<template>
  <div class="allGroup">
    <div class="personGroup">
      <h2>인기있는 채용공고순위 TOP5</h2>
      <canvas
          ref="personGroup"
      />
      <div>
        <div class="genderGroup">
          <h2>성비 통계</h2>
          <canvas
              ref="genderGroup"
          />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { Chart, registerables } from 'chart.js'
Chart.register(...registerables)
let chart
let chart1
export default {
  name: 'aStatisticView',
  data: () => ({
    woman: 0,
    man: 0,
    sList: [],
    type: 'bar',
    data: {
      labels: [],
      datasets: [{
        label: 'Date of Join',
        data: [],
        backgroundColor: [
          'rgba(255, 99, 132, 0.2)',
          'rgba(54, 162, 235, 0.2)',
          'rgba(255, 206, 86, 0.2)',
          'rgba(75, 192, 192, 0.2)',
          'rgba(153, 102, 255, 0.2)'
        ],
        borderColor: [
          'rgba(255, 99, 132, 1)',
          'rgba(54, 162, 235, 1)',
          'rgba(255, 206, 86, 1)',
          'rgba(75, 192, 192, 1)',
          'rgba(153, 102, 255, 1)'
        ],
        borderWidth: 1
      }]
    },
    data1: {
      labels: [
        '여성',
        '남성'
      ],
      datasets: [{
        label: 'Login Gender Total',
        data: [],
        backgroundColor: [
          'rgb(255, 99, 132)',
          'rgb(54, 162, 235)'
        ],
        hoverOffset: 4
      }]
    },
    options: {
      scales: {
        y: {
          beginAtZero: true
        }
      }
    }
  }),
  watch: {
    woman () { this.genderChart() },
    man () { this.genderChart() }
  },
  mounted () {
    this.createChart()
    this.genderChart()
  },
  created () {
    this.getPopList()
    this.getUserInfo()
  },
  methods: {
    getPopList () {
      this.$axios.post('/jobfair/getPopList')
          .then((res) => {
            this.sList = res.data
            // console.log(this.sList)
            // console.log(this.sList[0].cnt)
            for(var i = 0; i < this.sList.length; i++){
              chart1.data.datasets[0].data[i] = this.sList[i].cnt
              chart1.data.labels[i] = this.sList[i].jpl_title
            }
            chart1.update()
          })
          .catch((error) => console.log(error))
    },
    getUserInfo () {
      this.$axios.post('/jobfair/getUserInfo')
          .then((res) => {
            for (var i = 0; i < res.data.length; i++) {
              if (res.data[i].user_gender === 'F') {
                this.woman++
              } else if (res.data[i].user_gender === 'M') {
                this.man++
              }
            }
            chart.data.datasets[0].data[0] = this.woman
            chart.data.datasets[0].data[1] = this.man
            chart.update()
            // chart.destroy()
          })
          .catch((error) => console.log(error))
    },
    createChart() {
      chart1 = new Chart(this.$refs.personGroup, {
        type: 'bar',
        data: this.data,
        options: this.options
      })
    },
    //가입자 남녀성비율 확인그래프
    genderChart() {
      chart = new Chart(this.$refs.genderGroup, {
        type: 'doughnut',
        data: this.data1
      })
    }
  }
}
</script>

<style scoped>
* {
  padding: 0;
  margin: 0;
  list-style: none;
  font-size: 15px;
}

a {
  text-decoration: none;
}
/* canvas의 height는 자동으로 조절된다!! 신기하다~ */
canvas {
  width: 500px;
}

.allGroup {
  display: flex;
  flex-direction: row;
  align-items: center;
  padding: 20px;
  border: 1px solid #AAAAAA;
  border-radius: 15px;
}

/* Style for the heading */
.personGroup h2 {
  font-weight: bold;
  font-size: 20px;
  padding:20px;
  color: #202632;
}

/* Style for the gender group heading */
.genderGroup h2 {
  font-weight: bold;
  font-size: 20px;
  padding:20px;
  color: #202632;
}

/* Style for the form */
.datePerson {
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 20px;
}

/* Style for the form heading */
.datePerson h2 {
  font-weight: bold;
  font-size: 20px;
  padding:20px;
  color: #202632;
}

/* Style for the form input */
.datePerson input {
  width: 100%;
  max-width: 400px;
  height: 40px;
  padding: 10px;
  margin-bottom: 10px;
  font-size: 16px;
  border: 1px solid #ccc;
}

/* Style for the form button */
.datePerson button {
  width: 100px;
  height: 40px;
  background-color: #0064ff;
  color: #fff;
  font-size: 16px;
  border: none;
  cursor: pointer;
}

/* 기간조회 버튼 hover */
.datePerson button:hover {
  background-color: #3e8e41;
}
</style>

