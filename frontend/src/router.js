
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);

import Login from "./Login.vue"
import Main from "./Main.vue"
import Sub from "./Sub.vue"
import Result from "./Result.vue"
import Done from "./Done.vue"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/',
                name: 'Login',
                component: Login
            },
            {
                path: '/main',
                name: 'Main',
                component: Main
            },
            {
                path: '/sub',
                name: 'Sub',
                component: Sub
            },
            {
                path: '/result',
                name: 'Result',
                component: Result
            },
            {
                path: '/done',
                name: 'Done',
                component: Done
            },
    ]
})
