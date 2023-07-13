<script>
import {defineComponent} from 'vue'

export default defineComponent({
  name: "Header",


  methods: {
    clickLogo() {
      this.$router.push({path: '/list'});
    },
    goToList() {
      this.$router.push({path: '/list'});
    },
    goToMyList() {
      this.$router.push({path: `/myBoard/${JSON.parse(sessionStorage.getItem('sessionId'))}`})
    }
  }


})
</script>

<template>

  <header id="header">
    <nav class="wrap">
      <div class="colorHeader">
        <span class="headerTitle" @click="clickLogo">Maver</span>
      </div>
      <div class="anotherColorHeader">
        <ul class="headerBox">
          <li class="board">로그아웃</li>
          <li class="myBoard" @click="goToList">게시글</li>
          <li class="logOut" @click="goToMyList">내 게시글</li>
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