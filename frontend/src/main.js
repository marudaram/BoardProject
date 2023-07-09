import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import CKEditor from "@ckeditor/ckeditor5-vue";

import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'
import 'material-design-icons-iconfont/dist/material-design-icons.css'

createApp(App).use(router).mount('#app')

Vue.use(CKEditor);



