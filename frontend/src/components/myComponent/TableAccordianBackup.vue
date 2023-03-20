<template>
  <tr :class="{view: isChecked}" @click="visible" @mouseenter="msEnter" @mouseleave="msLeave">
    <td>
      <div class="d-flex px-2 py-1"> <!-- 등록한 공고의 제목 -->
        <div class="d-flex flex-column justify-content-center">
          {{ jpl_title }}
        </div>
      </div>
    </td>
    <td> <!-- 현재까지 지원한 사람 수 -->
      <div class="d-flex flex-column justify-content-center">
        {{ countCdd }}
      </div>
    </td>
    <td class="align-middle text-center text-sm"> <!-- 공고 등록일 -->
      <span class="text-secondary text-s font-weight-bold">
        {{ jpl_regDate }}
      </span>
    </td>
    <td class="align-middle text-center text-sm"> <!-- 모집 종료일 -->
      <span class="text-secondary text-s font-weight-bold">
        {{ jpl_endDate }}
      </span>
    </td>
    <td class="align-middle"> <!-- 종료일이 sysdate 보다 작으면 모집중, 크면 모집완료 -->
      <!-- color: Date.now() > this.endDate ? secondary : success ???? 개어렵네;;;
      String을 날짜로 형변환해서 endDate랑 비교하고 그에 따라 변경값 대입시키면 될듯?-->
      <soft-badge color="secondary" variant="gradient" size="sm">
        모집 완료
      </soft-badge >
      <soft-badge color="success" variant="gradient" size="sm">
        모집 중
      </soft-badge >
    </td>
  </tr>

  <tr v-if="isVisible">
        <td colspan="5">
            <table class="table align-items-center">
              <thead>
              <tr>
                <th>번호</th>
                <th colspan="2">이력서 제목</th>
                <th>작성자</th>
                <th>현황</th>
              </tr>
              </thead>
              <tbody>
                <!--
                  아래 tr을 반복시켜서 테이블 리스트를 생성한다.
                  번호 컬럼 : index 부여
                  이력서 제목: DB에서 꺼낸 res_title
                  작성자: DB에서 꺼낸 작성자
                  현황: 1 미열람 2 열람 3 서류 합격 4 최종합격 5 불합격 // 랜더링될 때 DB 저장된 값에 따라 checked 되어 있어야하고
                       change 이벤트로 DB 값 변경시켜야 함.....
                -->
<!--                미확인 버튼에서 이력서 조회누르면 확인으로 바뀌면서 유저마이페이지에 값을 보내야함-->
              <tr @mouseenter="msEnter" @mouseleave="msLeave">
                <td>1</td>
                <td colspan="2">모든 코딩 제가 하겠습니다.</td>
                <td>최성수</td>
                <td class="align-middle">
                  <input type="radio" class="btn-check" name="resumeState1" id="notChecked1" autocomplete="off" checked>
                  <label class="btn btn-outline-success" for="notChecked1" @click="selectCheck(o)" :class="{isSelect : unSelect === true}" v-for="o in x" :key="o.code">{{o.label}}</label>
                </td>
              </tr>
              <tr @mouseenter="msEnter" @mouseleave="msLeave">
                <td>1</td>
                <td colspan="2">모든 코딩 제가 하겠습니다.</td>
                <td>최성수</td>
                <td class="align-middle">
                  <input type="radio" class="btn-check" name="resumeState2" id="notChecked2" autocomplete="off" checked>
                  <label class="btn btn-outline-success" for="notChecked2">미확인</label>
                </td>
              </tr>
              <tr @mouseenter="msEnter" @mouseleave="msLeave">
                <td>1</td>
                <td colspan="2">모든 코딩 제가 하겠습니다.</td>
                <td>최성수</td>
                <td class="align-middle">
                  <input type="radio" class="btn-check" name="resumeState3" id="notChecked3" autocomplete="off" checked>
                  <label class="btn btn-outline-success" for="notChecked3">미확인</label>
                </td>
              </tr>
              <tr @mouseenter="msEnter" @mouseleave="msLeave">
                <td>1</td>
                <td colspan="2">모든 코딩 제가 하겠습니다.</td>
                <td>최성수</td>
                <td class="align-middle">
                  <input type="radio" class="btn-check" name="resumeState4" id="notChecked4" autocomplete="off" checked>
                  <label class="btn btn-outline-success" for="notChecked4">미확인</label>
                </td>
              </tr>
              </tbody>
            </table>
        </td>
  </tr>
</template>

<script>
import SoftBadge from "@/components/SoftBadge.vue";

export default {
  name: "SingleAccordian.vue",
  props: [
      'jpl_title',
      'countCdd',
      'jpl_regDate',
      'jpl_endDate'
  ],
  data () {
    return {
      isVisible: false,
      isChecked: false,
      x: [
        {code:'Yes', label: '열람', selected: false, count: 0},
        {code:'No', label: '미열람', selected: true, count: 0}
      ]
    }
  },
  methods: {
    visible (e) {
      this.isChecked = !this.isChecked
      this.isVisible = !this.isVisible
    },
    //테이블 제목 마우스엔터, 리브 이벤트 (마우스 올리면 백그라운드 변경)
    msEnter (e) {
      e.target.style=
          "background-color: gainsboro; cursor: pointer"
    },
    msLeave (e) {
      e.target.style=
          "background-color: none;"
    },
    selectCheck(item){
      item.selected = !item.selected;
      console.log(item)
      console.log(item.selected)
      item.count++
      console.log(item.count)

    }
  },
  components: {
    SoftBadge
  }
}
</script>

<style scoped>
.childTable {
  width: 100%;
}
.view {
  background-color: gainsboro;
}
</style>