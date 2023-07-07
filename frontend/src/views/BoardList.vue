<script>
import {defineComponent} from 'vue'

export default defineComponent({
  name: "BoardList"
})
</script>

<template>


  <div class="wrapBox">
    <div class="firstBox">
      <button class="writeBtn">글쓰기</button>
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
      <tr>
        <td>ex1</td>
        <td>ex2</td>
        <td>ex3</td>
        <td>ex4</td>
        <td>ex5</td>
      </tr>
      <tr>
        <td>ex1</td>
        <td>ex2</td>
        <td>ex3</td>
        <td>ex4</td>
        <td>ex5</td>
      </tr>
      <tr>
        <td>ex1</td>
        <td>ex2</td>
        <td>ex3</td>
        <td>ex4</td>
        <td>ex5</td>
      </tr>
      <tr>
        <td>ex1</td>
        <td>ex2</td>
        <td>ex3</td>
        <td>ex4</td>
        <td>ex5</td>
      </tr>
      <tr>
        <td>ex1</td>
        <td>ex2</td>
        <td>ex3</td>
        <td>ex4</td>
        <td>ex5</td>
      </tr>
      <tr>
        <td>ex1</td>
        <td>ex2</td>
        <td>ex3</td>
        <td>ex4</td>
        <td>ex5</td>
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