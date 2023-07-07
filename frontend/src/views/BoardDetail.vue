<script>
import {defineComponent} from 'vue'

export default defineComponent({
  name: "BoardDetail"
})
</script>

<template>
  <div class="wrapBox">

    <div class="contentBox">
      <div class="firstBox">
        <h2 style="float: left">글 제목</h2>
        <button class="writeBtn">글쓰기</button>
      </div>

      <div class="secondBox">
        <div class="cell1">
          <span>글 내용</span>
        </div>
        <div class="cell2">
          글내용
          <div class="cell3">
            <h5>작성자: 홍길동</h5>
            <h5>등록 시간: 2023-07-07 07:07</h5>
            <h5>조회수: 77</h5>
          </div>
        </div>
      </div>

      <div>
        <span>첨부파일</span>
        파일
      </div>

      <div>
        <button>목록</button>
        <button>수정</button>
        <button>삭제</button>
      </div>
    </div>

    <section style="margin-top: 80px;">
      <div class="container">
        <div class="row">

          <div class="col-xs-12">

            <!--모든 댓글 전체 담고있는 큰 박스-->
            <form class="reply-wrap">

              <!--프로필사진-->
              <div class="reply-image">
                <img src="img2/profile.png">
              </div>


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
              <!--프로필사진-->
              <div class="reply-image">
                <img src="img2/profile.png">
              </div>
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

.wrapBox {
  height: 800px;
  width: 800px;
  margin: 0 auto;
  position: relative;
}

.firstBox {
  border: 1px solid red;
  height: 80px;
  position: relative;
  margin-top: 80px;
}

.firstBox .writeBtn {
  float: right;
  position: absolute;
  width: 80px;
  top: 80%;
  left: 95%;
  transform: translate(-50%, -50%);
}

.secondBox {
  border: 1px solid brown;
  height: 500px;
  display: grid;
  grid-template-columns: 200px 200px 200px;
}

.secondBox .contentTitle {
  border: 1px solid pink;
  width: 20%;
  height: 500px;
}



.cell1 {
  box-sizing: border-box;
  border: 5px solid black;
  border-radius: 10px;
  padding: 10px;
  grid-row-start: 1;
  grid-row-end: 4;
  grid-column-start: 1;
  grid-column-end: 2;
}

.cell2 {
  box-sizing: border-box;
  border: 5px solid black;
  border-radius: 10px;
  width: 600px;
  padding: 10px;
  grid-row-start: 1;
  grid-row-end: 4;

}

.cell3 {
  box-sizing: border-box;
  border: 5px solid black;
  border-radius: 10px;
  padding: 10px;

}

.reply-wrap {
  background-color: #f5f5f5;
  padding: 15px;
  border: 1px solid #ddd;
  position: relative;
}

.reply-wrap .reply-image {
  position: absolute;
  top: 15px;
  left: 15px;

}

.reply-wrap .reply-content {
  margin-left: 60px;
}

.reply-content .form-control {
  border-radius: 0;
  margin: 0 0 10px;

}

.reply-group{
  overflow: hidden;
}

.reply-group .reply-input {
  float: left;
}

.reply-group .right {
  float: right;
}

.reply-group .reply-input input {
  display: block;
  width: 200px;
  padding: 6px 12px;
  margin: 0 0 5px;
}
.reply-group .reply-button {
  float: right;
}

.reply-group {

  overflow: hidden;
}

.reply-group small {
  margin-left: 10px;
}

.reply-group .left {

  float: left;
}

.reply-group .right {

  float: right;
}

.reply-group .right .glyphicon-pencil {
  float: right;
  font-size: 14px;
  color: #666565;
}
.reply-group .right .glyphicon-remove {
  float: right;
  font-size: 14px;
  color: #666565;
}

</style>