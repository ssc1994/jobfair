import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store/index.js'
import axios from 'axios'
import BootstrapVue3 from 'bootstrap-vue-3'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue-3/dist/bootstrap-vue-3.css'
import "./assets/css/nucleo-icons.css";
import "./assets/css/nucleo-svg.css";
import SoftUIDashboard from "./soft-ui-dashboard";
import "bootstrap/dist/css/bootstrap.min.css" // [bootstrap]
import "bootstrap" // [bootstrap]
import session from 'vue-session'
import VueMoment from 'moment'
// Vue.use(BootstrapVue)


const app = createApp(App)
// app 글로벌 변수 선언 실시
app.config.globalProperties.$axios = axios
app.config.globalProperties.$store = store
app.config.globalProperties.$router = router
app.config.globalProperties.$session = session
app.config.globalProperties.$moment = VueMoment
app.use(SoftUIDashboard)
app.use(BootstrapVue3)
app.use(router)
app.use(store)
app.use(VueMoment)

app.mount('#app')
