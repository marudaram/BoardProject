<script>
import {defineComponent} from 'vue'

export default defineComponent({
  name: "Header"
})
</script>

<template>

  <header id="header">
    <nav class="wrap">
      <div class="colorHeader">
        <span class="headerTitle">Maver</span>
      </div>
      <div class="anotherColorHeader">
        <ul class="headerBox">
          <li class="board">로그아웃</li>
          <li class="myBoard">게시글</li>
          <li class="logOut">내 게시글</li>
        </ul>
      </div>
    </nav>

  </header>




</template>

<style scoped>

* {
  padding: 0;
  margin: 0;
  list-style: none;
}


.wrap .colorHeader {
  height: 80px;
  background-color: #adfffd;
}

.headerTitle {
  margin-left: 200px;
  font-size: 50px;
}

li {
  float: right;
  margin-right: 60px;
}

.anotherColorHeader {
  height: 30px;
  line-height: 30px;
  background-color: #c4e8ff;
}

</style>