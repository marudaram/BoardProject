import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import CKEditor from "@ckeditor/ckeditor5-vue";
import Vue from 'vue';
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'
import 'material-design-icons-iconfont/dist/material-design-icons.css'
import axios from "axios";
import store from "@/assets/store";
import session from 'vue-session'


const app = createApp(App)
app.config.globalProperties.$axios = axios
app.config.globalProperties.$store = store
app.config.globalProperties.$session = session
app.use(router)
app.mount('#app')
app.use(store)

// createApp(App).use(router).mount('#app')

// Vue.use(CKEditor);




