<script>
import CKEditor from '@ckeditor/ckeditor5-vue';
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';

import { reactive } from '@vue/reactivity'
import { useRouter } from 'vue-router';
import axios from 'axios';
export default {
  components : {
    ckeditor : CKEditor.component
  },
  setup () {
    const router = useRouter();


    const state = reactive({
      title : '',
      content : '',
      writer:'',
      editor : ClassicEditor,
    });

    const handleEditorInit = (editor) => {
      editor.editing.view.change(writer => {
        writer.setStyle('height' , '400px',
            editor.editing.view.document.getRoot());
      });
    };

    const onSubmit = async() => {
      // 제목, 내용, 작성자 유효성 검사 자리 생략

      if(state.title === ''){
        alert('제목을 입력하세요.')
        return false;
      }
      if(state.content === ''){
        alert('내용을 입력하세요.')
        return false;
      }

      const url = `/board101/insert.json`;
      const headers = {"Content-Type" : "application/json"}
      const body = {
        title : state.title,
        content : state.content,

      }
      const response = await axios.post(url, body, {headers:headers});
      console.log(response.data);
      if(response.data.status === 200){
        router.push({path:'/boardList'});
      }
    };

    const toBoardList = () => {
      console.log('목록으로 이동');
      router.push({path:'/boardList'});
    }



    return {state, handleEditorInit, onSubmit, toBoardList}
  }
}
</script>

<template>
  <div class="wrapBox">
    <div class="title">
      <input type="text" placeholder="제목" class="titleBox">
    </div>

    <el-form label-width="100px">

      <el-form-item label="제목">
        <el-input v-model="state.title" autofocus />
      </el-form-item>

      <div class="fileBox">
        <div>
          <span>첨부파일</span>
        </div>
        <div>
          <form>
            <input type="file" name="fileUpload" accept="image/*">
          </form>
          <form>
            <input type="file" name="fileUpload" accept="image/*">
          </form>
          <form>
            <input type="file" name="fileUpload" accept="image/*">
          </form>
        </div>
      </div>

      <el-form-item label="내용" class="contentBox">
        <ckeditor v-model="state.content"
                  :editor="state.editor" @ready="handleEditorInit"></ckeditor>
      </el-form-item>

      <div class="btnBox">
        <button type="button" class="btn btn-primary" style="margin-right: 30px" @click="onSubmit" >등록</button>
        <button type="button" class="btn btn-outline-primary" @click="toBoardList" >목록</button>
      </div>

    </el-form>
  </div>

</template>

<style scoped>

.wrapBox {
  height: 800px;
  width: 800px;
  margin: 0 auto;
  position: relative;
}


.titleBox {
  width: 730px;
  height: 40px;
  position: absolute;
  top: 10%;
  left: 50%;
  transform: translate(-50%, -50%);
}

.fileBox {
  border: 1px solid rgba(35, 32, 32, 0.67);
  margin: 0 auto;
  height: 150px;
  width: 735px;
  position: absolute;
  top: 23%;
  left: 50%;
  transform: translate(-50%, -50%);
}

.contentBox {
  border: 1px solid rgba(35, 32, 32, 0.67);
  position: absolute;
  top: 61%;
  left: 50%;
  transform: translate(-50%, -50%);
}

.btnBox {
  text-align: center;
  height: 50px;
  line-height: 50px;
  position: absolute;
  top: 90%;
  left: 40%;
}


</style>