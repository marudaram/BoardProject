<script>
import {defineComponent} from 'vue'

export default defineComponent({
  name: "MyBoard",


  data() {
    return {
      myListData: {
        writer: JSON.parse(sessionStorage.getItem('sessionId')),
        title: '',
        content: '',
        regDate: '',
        hit: 0
      },
    }
  },

beforeCreate() {
    const writer = JSON.parse(sessionStorage.getItem('sessionId'))
    this.$axios.get(`/board/myBoard/${writer}`)
        .then((res) => {
          this.myListData = res.data
        })
        .catch((error) => {
          console.log(error)
        })
},


  methods: {
    getMyBoardList() {
      this.$axios.get(`/board/myBoard/${writer}`, {
        params: {
          writer: JSON.parse(sessionStorage.getItem('sessionId'))
        }
      })
          .then((res) => {
            this.myListData = res.data


          })
          .catch((error) =>{
            console.log(error)
          })
    },

    detail(idx) {
      this.$router.push({
        name: 'detail',
        params: ({
          id: idx,
        })
      })

    },

  },

})
</script>

<template>
  <div class="wrapBox">
    <div class="firstBox">
      <button class="writeBtn">글쓰기</button>
      <input type="text" placeholder="검색" class="search">
      <select class="optionBox" >
        <option value="content">본문</option>
        <option value="title">제목</option>
        <option value="writer">작성자</option>
      </select>
    </div>
    <table id="listBox">
      <thead>
      <tr style="background-color: #59a7e1; color: antiquewhite; height: 60px; font-size: 20px">
        <td style="text-align: center; width: 50px"><input type="checkbox"></td>
        <td style="text-align: center; width: 50px">No</td>
        <td style="text-align: center; width: 500px">제목</td>
        <td style="text-align: center; width: 300px">작성자</td>
        <td style="text-align: center; width: 200px">날짜</td>
        <td style="text-align: center; width: 50px">조회수</td>
      </tr>
      </thead>
      <tbody>
      <tr v-for="(row, idx) in myListData" :key=idx>
        <td><input type="checkbox" readonly></td>
        <td @click="detail(row.id)">{{ row.id }}</td>
        <td @click="detail(row.id)">{{ row.title }}</td>
        <td @click="detail(row.id)">{{ row.writer }}</td>
        <td @click="detail(row.id)">{{ row.regDate }}</td>
        <td @click="detail(row.id)">{{ row.hit }}</td>
      </tr>

      </tbody>
    </table>

    <div class="thirdBox">
      <select class="optionBox2">
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
</style>