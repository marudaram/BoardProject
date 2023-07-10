import {createRouter, createWebHistory} from "vue-router";
import Signin from "@/views/Signin.vue";
import BoardList from "@/views/BoardList.vue";
import BoardDetail from "@/views/BoardDetail.vue";
import BoardWrite from "@/views/BoardWrite.vue";
import BoardModify from "@/views/BoardModify.vue";
import MyBoard from "@/views/MyBoard.vue";


const routes = [
    { //로그인 화면
        path: '/',
        name: 'signin',
        component: Signin
    }, {
        //게시판 리스트 화면
        path: '/boardList',
        name: 'boardList',
        component: BoardList
    }, {
        //게시글 읽는 화면
        path: '/boardDetail/:board_num',
        name: 'boardDetail',
        component: BoardDetail
    }, {
        //게시글 작성 화면
        path: '/boardWrite',
        name: 'boardWrite',
        component: BoardWrite
    }, {
        //게시글 수정 화면
        path: '/boardModify',
        name: 'boardModify',
        component: BoardModify
    }, {
        //내가 쓴 게시글 화면
        path: '/myBoard',
        name: 'myBoard',
        component: MyBoard
    }
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router;