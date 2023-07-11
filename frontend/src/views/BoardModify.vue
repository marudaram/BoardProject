<script>
import CKEditor from '@ckeditor/ckeditor5-vue';
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';

import {reactive} from '@vue/reactivity'
import {useRouter} from 'vue-router';
import axios from 'axios';

export default {
  components: {
    ckeditor: CKEditor.component
  },

  data() {
    return {
      boardChangeData: {
        board_num: '',
        board_title: '',
        board_content: '',
        user_id: '',
        board_regDate: '',
        board_hit: ''
      }
    }

  },

  created() {
    const board_num = this.$route.params.board_num;
    this.$axios.get(`board/detail/${board_num}` )
        .then((res) => {
          this.boardChangeData = res.data
          console.log(res.data)
        })
  },

  methods: {
    boardModi() {
      this.$axios.put(`board/detail/${this.boardChangeData.board_num}`, this.boardChangeData)
          .then((res) => {
            this.boardChangeData = res.data
            console.log(res.data)

          })
    },


    toBoardList() {
      console.log('목록으로 이동');
      this.$router.push({path: '/list'});
    }
  },

  setup() {
    const router = useRouter();


    const state = reactive({
      title: '',
      content: '',
      writer: '',
      editor: ClassicEditor,
    });

    const handleEditorInit = (editor) => {
      editor.editing.view.change(writer => {
        writer.setStyle('height', '400px',
            editor.editing.view.document.getRoot());
      });
    };


    return {state, handleEditorInit}
  }
}
</script>

<template>
  <div class="wrapBox">
    <div class="title">
      <input type="text" placeholder="제목" class="titleBox" v-model="boardChangeData.board_title">
    </div>

    <div label-width="100px">

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

      <div label="내용" class="contentBox">
        <ckeditor v-model="boardChangeData.board_content"
                  :editor="state.editor" @ready="handleEditorInit"></ckeditor>
      </div>

      <div class="btnBox">
        <button type="button" style="margin-right: 30px" @click="toBoardList">목록</button>
        <button type="button" @click="boardModi">수정</button>
      </div>

    </div>
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