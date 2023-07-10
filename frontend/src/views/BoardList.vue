<script>
import {defineComponent} from 'vue'
import router from "@/router";
import {createRouter as $router, useRoute} from "vue-router";

const route = useRoute();
export default defineComponent({
  name: "BoardList",

  data() {
    return {
      BoardList: {
        board_regDate: '',
        board_hit: ''
      }
    }
  },

  methods: {
    toBoardWrite() {
      router.push({path:'/boardWrite'});
    },
    getBoardList() {
      this.$axios.post('/board/list')
          .then((res) => {
            this.BoardList = res.data
          })
          .catch((error) => {
            console.log(error)
          })
    },

    detail(idx) {
      this.$router.push({
        name: 'boardDetail',
        params: {
          board_num: idx
        }
      })
    }
  },

  created() {
    this.getBoardList();
  }

})
</script>

<template>


  <div class="wrapBox">
    <div class="firstBox">
      <button class="writeBtn" @click="toBoardWrite">글쓰기</button>
      <input type="text" placeholder="검색" class="search">
      <select>
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
      <tr v-for="(row, idx) in BoardList" :key=idx @click="detail(row.board_num)">
        <td>{{idx + 1}}</td>
        <td>{{row.board_title}}</td>
        <td>{{row.user_id}}</td>
        <td>{{BoardList.board_regDate}}</td>
        <td>{{BoardList.board_hit}}</td>
      </tr>

      </tbody>
    </table>



    <div class="thirdBox">
      <select>
        <option value="content">본문</option>
        <option value="title">제목</option>
        <option value="writer">작성자</option>
      </select>
    </div>
  </div>
</template>

<style scoped>

table {
  border-collapse: collapse;
}
th ,td {
  width: 100px;
  height: 50px;
  text-align: center;
  border: 1px solid #000;

  vertical-align: top;	/* 위 */
  vertical-align: bottom;   /* 아래 */
  vertical-align: middle;   /* 가운데 */
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
}

.firstBox .writeBtn {
  margin-right: 20px;
}

.firstBox .search {
  margin-right: 20px;

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
}

</style>