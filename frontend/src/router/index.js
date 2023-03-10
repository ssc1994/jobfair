import { createRouter, createWebHistory } from 'vue-router'
import MainView from '../views/MainView.vue'
import Dashboard from "@/views/Dashboard.vue";
import Tables from "@/views/Tables.vue";
import Billing from "@/views/Billing.vue";
import VirtualReality from "@/views/VirtualReality.vue";
import Profile from "@/views/Profile.vue";
import Rtl from "@/views/Rtl.vue";
import SignIn from "@/views/SignIn.vue";
import SignUp from "@/views/SignUp.vue";

const routes = [
  // { //메인화면 - 로그인페이지
  //   path: '/',
  //   name: 'Main',
  //   component: MainView
  // },
//*********************유저 화면*********************
  {//유저 & 기업 회원가입
    path: '/JoinView',
    name: 'JoinView',
    component: () => import('@/views/JoinView.vue')
  },
  {
    path: '/uMainView',
    name: 'uMainView',
    component: () => import('@/views/user/uMainView.vue')
  },
  {//유저 Q&A 리스트화면
    path: '/uQnAView',
    name: 'uQnAView',
    component: () => import('../views/user/uQnAView.vue')
  },
  {//유저 Q&A 작성화면
    path: '/uQnAWriteView',
    name: 'uQ&uQnAWriteView',
    component: () => import('../views/user/uQnAWriteView.vue')
  },
  {//유저 Q&A 디테일 화면
    path: '/uQnADetailView',
    name: 'uQnADetailView',
    component: () => import('../views/user/uQnADetailView.vue')
  },
  {//유저 지원관리 화면
    path: '/uApplyListView',
    name: 'uApplyListVoew',
    component: () => import('../views/user/uApplyListView.vue')
  },
  {//유저 채용공고 상세화면
    path: '/uJobPostDetailView',
    name: 'uJobPostDetailView',
    component: () => import('../views/user/uJobPostDetailView.vue')
  },
  {//유저 채용공고 리스트 화면
    path: '/uJobPostView',
    name: 'uJobPostView',
    component: () => import('../views/user/uJobPostView.vue')
  },
  {//유저 마이페이지 화면
    path: '/uMypageView',
    name: 'uMypageView',
    component: () => import('../views/user/uMypageView.vue')
  },
  {//유저 회원정보 수정화면
    path: '/uModifyView',
    name: 'uModifyView',
    component: () => import('../views/user/uModifyView.vue')
  },
  {//유저 이력서
    path: '/uResumeView',
    name: 'uResumeView',
    component: () => import('../views/user/uResumeView.vue')
  },
//*********************기업 화면*********************
  {//기업 메인화면
    path: '/cMainView',
    name: 'cMainView',
    component: () => import('../views/company/cMainView.vue')
  },
  {//기업 담당자 등록화면
    path: '/cMngRegistView',
    name: 'cMngRegistView',
    component: () => import('../views/company/cMngRegistView.vue')
  },
  {//기업 담당자 수정화면
    path: '/cMngEditView',
    name: 'cMngEditView',
    component: () => import('../views/company/cMngEditView.vue')
  },
  {//기업 마이페이지
    path: '/cMypageView',
    name: 'cMypageView',
    component: () => import('../views/company/cMyPageView.vue')
  },
  {//기업 채용공고 목록 화면
    path: '/cJobPostListView',
    name: 'cJobPostListView',
    component: () => import('../views/company/cJobPostListView.vue')
  },
  {//기업 채용공고 등록 화면
    path: '/cEmpRegView',
    name: 'cEmpRegView',
    component: () => import('../views/company/cEmpRegView.vue')
  },
  {//기업 채용공고 수정 화면
    path: '/cEmpModiView',
    name: 'cEmpModiView',
    component: () => import('../views/company/cEmpModiView.vue')
  },
  {//기업 채용공고별 지원자 관리 화면
    path: '/cApplyMngView',
    name: 'cApplyMngView',
    component: () => import('../views/company/cApplyMngView.vue')
  },
  {//기업 담당자 승인조회 화면
    path: '/cMngApplyView',
    name: 'cMngApplyView',
    component: () => import('../views/company/cMngApplyView.vue')
  },
  //*********************관리자 화면*********************
  {//관리자 메인화면
    path: '/aMainView',
    name: 'aMainView',
    component: () => import('../views/admin/aMainView.vue')
  },
  {//관리자 참여업체 목록 화면
    path: '/aComListView',
    name: 'aComListView',
    component: () => import('../views/admin/aComListView.vue')
  },
  {//관리자 참여업체 등록 화면
    path: '/aComRegView',
    name: 'aComRegView',
    component: () => import('../views/admin/aComRegView.vue')
  },
  {//관리자 참여업체 수정 화면
    path: '/aComModiView',
    name: 'aComModiView',
    component: () => import('../views/admin/aComModiView.vue')
  },
  {//관리자 참여업체 상세 화면
    path: '/aComDetailView',
    name: 'aComDetailView',
    component: () => import('../views/admin/aComDetailView.vue')
  },
  {//관리자 채용공고 조회 화면
    path: '/aJobPostMngView',
    name: 'aJobPostMngView',
    component: () => import('../views/admin/aJobPostMngView.vue')
  },
  {//관리자 통계조회 화면
    path: '/aStatisticView',
    name: 'aStatisticView',
    component: () => import('../views/admin/aStatisticView.vue')
  },
    /////////////////// 부트스트랩////////////////////////////////////////////////////
  {
    path: "/",
    name: "/",
    redirect: "/dashboard",
  },
  {
    path: "/dashboard",
    name: "Dashboard",
    component: Dashboard,
  },
  {
    path: "/tables",
    name: "Tables",
    component: Tables,
  },
  {
    path: "/billing",
    name: "Billing",
    component: Billing,
  },
  {
    path: "/virtual-reality",
    name: "Virtual Reality",
    component: VirtualReality,
  },
  {
    path: "/profile",
    name: "Profile",
    component: Profile,
  },
  {
    path: "/rtl-page",
    name: "Rtl",
    component: Rtl,
  },
  {
    path: "/sign-in",
    name: "Sign In",
    component: SignIn,
  },
  {
    path: "/sign-up",
    name: "Sign Up",
    component: SignUp,
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})
export default router
