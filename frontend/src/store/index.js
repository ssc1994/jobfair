import { createStore } from 'vuex'

export default createStore({
  state: { // 전역으로 사용할 변수들을 여기서 정의 (변수들의 집합소)
    mg_auth : "1"
  },
  getters: { //state 변수들을 사용할 때 사용하는 getter 함수 정의
    getMg_auth(state) {
      return state.mg_auth
    }
  },
  mutations: { //state 변수들을 새로 정의할 때 사용하는
    setMg_auth(state, mg_auth) {
      state.mg_auth = mg_auth
    }
  },
  actions: { //비동기처리 함수
  },
  modules: { // 이건 뭐지..? 스토어 분리?
  }
})
