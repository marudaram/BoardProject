<script>
import {defineComponent} from 'vue'
import '../assets/css/SignIn.css';

export default defineComponent({
  name: "Signin",

  data() {
    return {
      userInfo: {
        id: '',
        password: '',
      }
    }
  },

  methods: {
    signIn() {
      this.$axios.post(`/user/signIn`, {
        id: this.userInfo.id,
        password: this.userInfo.password
      })
          .then((res) => {
            //sessionStorage에 id 추가
            sessionStorage.setItem(`sessionId`, JSON.stringify(res.data.id))
            this.$store.commit(`setId`, sessionStorage.getItem(`sessionId`));
          })
          .catch((error) => console.log(error))
          .finally(() => console.log('로그인 시도'))


    },
    checkId() {

    }
  }


})




</script>

<template>

    <body>
    <div class="login-wrapper">
        <h2>Login</h2>
        <div id="login-form" >
            <input type="text" name="userName" placeholder="id" v-model="userInfo.id">
            <input type="password" name="userPassword" placeholder="Password" v-model="userInfo.password">
            <label for="remember-check">
                <input type="checkbox" id="remember-check">아이디 저장하기
            </label>
            <input type="button" @click="signIn" value="Login">
        </div>
    </div>
    </body>

</template>

<style scoped>

</style>