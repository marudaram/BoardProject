<script>
import {defineComponent} from 'vue'

export default defineComponent({
  name: "BoardDetail"
})
</script>

<template>
  <div class="wrapBox">

    <div class="contentBox">
      <div>
        <h2>글 제목</h2>
        <button>글쓰기</button>
      </div>

      <div>
        <div>
          <span>글 내용</span>
        </div>
        <div>
          글내용
        </div>
        <div>
          <h5>작성자: 홍길동</h5>
          <h5>등록 시간: 2023-07-07 07:07</h5>
          <h5>조회수: 77</h5>
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


  <div>
    <ul>
      <li>목록</li>
      <li>수정</li>
      <li>삭제</li>
    </ul>
  </div>

  <!--댓글 불러오기-->
  <div>
    <h3>댓글 목록</h3>
    <div>
      <div>

      </div>
    </div>

    <!--댓글 입력폼-->
    <div>

    </div>

  </div>
</template>

<style scoped>
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