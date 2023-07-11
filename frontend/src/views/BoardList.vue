<script>
import {defineComponent} from 'vue'


export default defineComponent({

  data() {
    return {
      listData: {
        board_regDate: '',
        board_hit: ''
      }
    }
  },

  beforeCreate() {

  },

  mounted() {
    console.log("BoardList.Vue 생성됨");
    this.getBoardList();
  },

  methods: {
    toBoardWrite() {
      this.$router.push({path:'/write'});
    },
    getBoardList() {
      console.log("created: getBoardList")
      this.$axios.get('/board/list')
          .then((res) => {
            this.listData = res.data
          })
          .catch((error) => {
            console.log(error)
          })
    },

    detail(idx) {
      console.log(idx);

      this.$router.push({
        name: 'detail',
        params: ({
          board_num: idx
        })
      })
    }
  },

  created() {

  }

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
      <tr v-for="(row, idx) in listData" :key=idx @click="detail(row.board_num)">
        <td>{{idx + 1}}</td>
        <td>{{row.board_title}}</td>
        <td>{{row.user_id}}</td>
        <td>{{row.board_regDate}}</td>
        <td>{{row.board_hit}}</td>
      </tr>

      </tbody>
    </table>



    <div class="thirdBox">
      <select class="optionBox2">
        <option value="content">최신글</option>
        <option value="title">조회수</option>
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

</style>