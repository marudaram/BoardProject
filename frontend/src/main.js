import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import CKEditor from "@ckeditor/ckeditor5-vue";
import Vue from 'vue';
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'
import 'material-design-icons-iconfont/dist/material-design-icons.css'
import axios from "axios";



const app = createApp(App)
app.config.globalProperties.$axios = axios
app.use(router)
app.mount('#app')


// createApp(App).use(router).mount('#app')

// Vue.use(CKEditor);




