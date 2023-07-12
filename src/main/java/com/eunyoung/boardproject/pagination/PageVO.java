package com.eunyoung.boardproject.pagination;

import lombok.Data;

import java.util.ArrayList;

@Data
public class PageVO {
    private int end; //페이지 끝번호
    private int start; //페이지 시작번호
    private boolean next; //다음버튼 활성화여부
    private boolean prev; //이전버튼 활성화여부

    private int realEnd; //페이지네이션 실제 끝번호
    private int page; //사용자가 조회하는 페이지 번호
    private int amount; //화면 1페이지에 나타나는 데이터 개수
    private long total; // 전체 게시글 수
    private Criteria cri; //페이지 기준 -> Criteria 객체에 페이지 번호와 amount값이 있으므로 넣어주고 변수로 사용

    private int pageCnt = 5;

    private ArrayList<Integer> pageList; // 화면에 반복시킬 페이지


    //생성자 - pageVO가 만들어질 때 cri, total을 반드시 받음
    public PageVO(Criteria cri, long total) {

        //계산에 필요한 값(페이지번호, 데이터개수, 전체 게시글 수, cri) 를 초기화함
        this.page = cri.getPage();
        this.amount = cri.getAmount();
        this.total = total;
        this.cri = cri;

        //1. 끝페이지 번호 계산
        this.end = (int) Math.ceil(this.page / (double) pageCnt) * pageCnt;

        //2. 시작페이지 번호 계산
        this.start = this.end - pageCnt + 1;

        //3. 실제 끝번호 계산
        this.realEnd = (int) Math.ceil(this.total / (double) this.amount);

        //4. 마지막 페이지번호를 다시 계산
        this.end = this.end > this.realEnd ? this.realEnd : this.end;

        //5. 이전버튼
        this.prev = this.start > 1;

        //6. 다음버튼
        this.next = this.end < this.realEnd;


        //화면에서 반복시킬 페이지 데이터
        this.pageList = new ArrayList<>();
        for (int i = this.start; i <= this.end; i++) {
            pageList.add(i);
        }
    }
}
