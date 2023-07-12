<script>
import {defineComponent} from 'vue'
import '../assets/css/BoardDetail.css';


export default defineComponent({
  name: "detail",

  data() {
    return {
      boardDetailData: {
        id: '',
        title: '',
        content: '',
        writer: '',
        regDate: '',
        hit: ''
      },

    }
  },

  beforeCreate() {
    console.log(this.$route.params.id);
    const boardNum = this.$route.params.id;
    // this.$axios.get('board/detail', {params: {board_num: this.$route.params.board_num}})
    this.$axios.get(`board/detail/${boardNum}`)
        .then((res) => {
          const { status, data } = res;
          if(status !== 200) alert("에러가 발생했습니다.")
          this.boardDetailData = data
        })
        .catch((error) => alert(error))
  },

  methods: {
    // getBoardDetail() {
    //   this.$axios.get('board/detail?board_num=' + this.$route.params.board_num)
    //       .then((res) => {
    //         this.boardDetailData = res.data
    //         console.log(res.data)
    //       })
    //       .catch((error) => console.log(error))
    // },
    toBoardList() {
      console.log('목록으로 이동');
      this.$router.push({path: '/list'});
    },
    boardDelete() {
      if (confirm("삭제하시겠습니까?")) {
        this.$axios.delete('board/detail', {params: {id: this.$route.params.id}})
            .then((res) => {
              this.$router.push('/list')
              console.log(res)
            })
            .catch((error) => alert(error))
      }

    },
    changeBoard() {
      this.$router.push({
        name: 'modify',
        params: ({
          id: this.$route.params.id
        })
      })

    }
  }
})
</script>

<template>
  <div class="wrapBox">

    <div class="contentBox">
      <div class="firstBox">
        <h2 style="float: left">{{ boardDetailData.title }}</h2>
        <button class="writeBtn">글쓰기</button>
      </div>

      <div class="secondBox">
        <div class="cell1">
          <span class="titleMini">글내용</span>
        </div>

        <div class="cell2">
          <div class="cell3">
            <h5>작성자: {{ boardDetailData.writer }}</h5>
            <h5>등록 시간: {{ boardDetailData.regDate }}</h5>
            <h5>조회수: {{ boardDetailData.hit }}</h5>
          </div>
          <div class="cell4" v-html="boardDetailData.content">
          </div>
        </div>
      </div>

      <div class="thirdBox">
        <div class="cell5">
          <span class="fileTitle">첨부파일</span>
        </div>
        <div class="cell6">
          파일
        </div>
      </div>

      <div class="btnBox">
        <button class="backToListBtn" @click="toBoardList">목록</button>
        <button style="float: right" @click="boardDelete">삭제</button>
        <button style="float: right; padding-right: 20px" @click="changeBoard">수정</button>
      </div>
    </div>

    <section style="margin-top: 80px;">
      <div class="container">
        <div class="row">

          <div class="col-xs-12">

            <!--모든 댓글 전체 담고있는 큰 박스-->
            <form class="reply-wrap">


              <!--댓글부분 작은 박스-->
              <div class="reply-content">
                <textarea class="form-control" rows="3"></textarea>

                <div class="reply-group">
                  <div class="reply-input">
                    <input type="text" class="form-control" placeholder="이름">
                    <input type="password" class="form-control" placeholder="비밀번호">
                  </div>
                  <button type="button" class="right btn btn-info">등록하기</button>
                </div>
              </div>
            </form>

            <form class="reply-wrap">

              <div class="reply-content">
                <div class="reply-group">
                  <strong class="left">honggildong</strong>
                  <small class="left">2022.12.27</small>
                  <a href="#" class="right">
                    <span class="glyphicon glyphicon-pencil">수정</span>
                  </a>
                  <a href="#" class="right">
                    <span class="glyphicon glyphicon-remove">삭제</span>
                  </a>

                </div>

              </div>
              <p class="clearfix">여기는 댓글영역</p>

            </form>

          </div>
        </div>
      </div>
    </section>


  </div>

</template>

<style scoped>


</style>