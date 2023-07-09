<script>
import {defineComponent} from 'vue'
import '../assets/css/SignIn.css';

export default defineComponent({
  name: "Signin"
})



</script>

<template>

    <body>
    <div class="login-wrapper">
        <h2>Login</h2>
        <form method="post" action="서버의url" id="login-form">
            <input type="text" name="userName" placeholder="Email">
            <input type="password" name="userPassword" placeholder="Password">
            <label for="remember-check">
                <input type="checkbox" id="remember-check">아이디 저장하기
            </label>
            <input type="submit" value="Login">
        </form>
    </div>
    </body>

</template>

<style scoped>

</style>