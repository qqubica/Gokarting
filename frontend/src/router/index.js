import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router ({
  routes: [
      { path: '/', name: 'startRide',component: () => import(/* webpackChunkName: "about" */ '@/views/StartRideView.vue') }
  ]
})

