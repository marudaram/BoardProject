<script>
import {defineComponent} from 'vue'


export default defineComponent({

    data() {
        return {
            listData: {
                title: '',
                content: '',
                regDate: '',
                hit: 0
            },

            //페이지 이동에 필요한 초기값
            page: 1,
            amount: 10,
            totalElements: 0,
            totalPages: 0
        }
    },

    computed: {
        showPrev() {
            return this.page > 1;
        },
        param() {
            return this.$route.params.criteriaObj;
        }
    },

    watch: {
        param(criteriaObj) {
            const {page, amount} = JSON.parse(criteriaObj)
            this.page = page;
            this.amount = amount;
            this.getBoardList();
        }
    },

    beforeCreate() {
    },


    created() {
    },

    mounted() {
        if (this.$route.name == "listParam") {
            const param = this.$route.params.criteriaObj;
            const {page, amount} = JSON.parse(param)
            this.page = page;
            this.amount = amount;
        }
        this.getBoardList();
    },

    methods: {
        toBoardWrite() {
            this.$router.push({path: '/write'});
        },
        async getBoardList() {

            await this.$axios.get('/board/list', {
                params: {
                    page: this.page > 0 ? this.page - 1 : this.page,
                    amount: this.amount,
                }
            })
                .then((res) => {

                    const {status, data} = res;

                    // TODO status 코드로 에러 처리

                    const {content: list, number: page, totalElements, size: amount, totalPages} = data;
                    this.listData = list;
                    this.page = page + 1;
                    this.amount = amount;
                    this.totalElements = totalElements;
                    this.totalPages = totalPages;

                })
                .catch((error) => {
                    console.log(error)
                })
        },

        detail(idx) {
            this.$router.push({
                name: 'detail',
                params: ({
                    id: idx,
                    hit: 3,
                })
            })

        },
        // 페이지 이동
        routePage({page = 1, amount = this.amount}) {
            this.$router.push({
                name: 'listParam',
                params: ({
                    criteriaObj: JSON.stringify({page, amount})
                })
            });
        }
    },


})
</script>

<template>


    <div class="wrapBox">
        <div class="firstBox">
            <button class="writeBtn" @click="toBoardWrite">글쓰기</button>
            <input type="text" placeholder="검색" class="search">
            <select class="optionBox">
                <option value="content">본문</option>
                <option value="title">제목</option>
                <option value="writer">작성자</option>
            </select>
        </div>

        <table id="listBox">
            <thead>
            <tr style="background-color: #59a7e1; color: antiquewhite; height: 60px; font-size: 20px">
                <td style="text-align: center; width: 100px">No</td>
                <td style="text-align: center; width: 500px">제목</td>
                <td style="text-align: center; width: 200px">작성자</td>
                <td style="text-align: center; width: 200px">날짜</td>
                <td style="text-align: center; width: 100px">조회수</td>
            </tr>
            </thead>
            <tbody>
            <tr v-for="(row, idx) in listData" :key=idx @click="detail(row.id)">
                <td>{{ idx + 1 }}</td>
                <td>{{ row.title }}</td>
                <td>{{ row.writer }}</td>
                <td>{{ row.regDate }}</td>
                <td>{{ row.hit }}</td>
            </tr>

            </tbody>
        </table>


        <div class="thirdBox">
            <select class="optionBox2">
                <option value="content">최신글</option>
                <option value="title">조회수</option>
            </select>
        </div>


        <!--페이지네이션 부분-->
        <div class="paginationWrap">
            <ul class="pagination">
                <li class="page-item"><a class="page-link" @click="routePage({page : 1})" style="margin-right: 10px">First</a>
                </li>
                <li class="page-item"><a class="page-link" v-if="showPrev" @click="routePage({page : page-1})"
                                         style="margin-right: 10px"
                                         aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
                <template v-for="index in totalPages">
                    <li class="page-item" :class="index == this.page?'active':''"><span class="page-link important"
                                                                                        @click.prevent="routePage({page : index}), getBoardList()"
                                                                                        id="index">{{ index }}</span>
                    </li>
                </template>
                <li class="page-item"><a class="page-link" @click="routePage({page : page+1})"
                                         style="margin-right: 10px"
                                         aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
                <li class="page-item"><a class="page-link" @click="routePage({page : this.totalPages})"
                                         style="margin-right: 10px">Last</a>
                </li>
            </ul>
        </div>


    </div>
</template>

<style scoped>

table {
    border-collapse: collapse;
}

th, td {
    width: 100px;
    height: 50px;
    text-align: center;
    border: 1px solid #000;

    vertical-align: top; /* 위 */
    vertical-align: bottom; /* 아래 */
    vertical-align: middle; /* 가운데 */
}

.wrapBox {
    height: 800px;
    width: 1000px;
    margin: 0 auto;
}

.firstBox {
    text-align: right;
    padding-top: 80px;
    padding-bottom: 20px;
    position: relative;
}

.firstBox .writeBtn {
    position: absolute;
    top: 80%;
    left: 70%;
}

.firstBox .search {
    border: 3px solid lightblue;
    margin-right: 20px;
    position: absolute;
    top: 70%;
    left: 75%;
}

.firstBox .optionBox {
    border: 3px solid lightblue;
    text-align: center;
    width: 80px;
    position: absolute;
    top: 70%;
    left: 92%;
}

#listBox {
    border-collapse: collapse;
    width: 1000px;
    border: 1px solid #444444;
    border-collapse: collapse;
    margin: 0 auto;
}

.thirdBox {
    text-align: right;
    padding-top: 20px;
    position: relative;
}

.thirdBox .optionBox2 {
    border: 3px solid skyblue;
    text-align: center;
    width: 80px;
    position: absolute;
    left: 91%;
}

/* 페이지네이션 부분 */


.paginationWrap .page-link {
    background-color: white;
}

.paginationWrap li.active span {
    background-color: #202632;
    border: none;
}

.pagination {
    display: flex;
    justify-content: center;
    align-items: center;
    margin: 20px 0;
}

.page-item {
    display: flex;
    justify-content: center;
    align-items: center;
    margin-right: 10px;
}

.page-link {
    color: #333;
    border: none;
    background: none;
    cursor: pointer;
}

.page-link:hover {
    color: #0064ff;
}

.active .page-link {
    color: #fff;
    background-color: #007bff;
    border-color: #007bff;
}


</style>