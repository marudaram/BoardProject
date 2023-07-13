import {createRouter, createWebHashHistory, createWebHistory} from "vue-router";
import Signin from "@/views/Signin.vue";
import BoardList from "@/views/BoardList.vue";
import BoardDetail from "@/views/BoardDetail.vue";
import BoardWrite from "@/views/BoardWrite.vue";
import BoardModify from "@/views/BoardModify.vue";
import MyBoard from "@/views/MyBoard.vue";


const routes = [

    { //로그인 화면
        path: '',
        name: 'signin',
        component: Signin
    }, {
        //게시판 리스트 화면
        path: '/list',
        name: 'list',
        component: BoardList,
        children: [
            {
                //게시판 리스트 화면
                path: '/list/:criteriaObj',
                name: 'listParam',
                component: BoardList,
            }
        ]
    }, {
        //게시글 읽는 화면
        path: '/detail/:id',
        name: 'detail',
        component: BoardDetail
    }, {
        //게시글 작성 화면
        path: '/write',
        name: 'write',
        component: BoardWrite
    }, {
        //게시글 수정 화면
        path: '/modify/:id',
        name: 'modify',
        component: BoardModify
    }, {
        //내가 쓴 게시글 화면
        path: '/myBoard/:writer',
        name: 'myBoard',
        component: MyBoard,

    },
    {
        // 테스트
        path: '/test',
        name: 'test',
        component: BoardList
    }
]

const router = createRouter({
    history: createWebHashHistory(process.env.BASE_URL),
    routes
})

export default router;