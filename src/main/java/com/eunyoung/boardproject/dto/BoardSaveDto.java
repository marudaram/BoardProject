package com.eunyoung.boardproject.dto;

import com.eunyoung.boardproject.entity.Board;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
public class BoardSaveDto {
    private Integer board_num;
    private String user_id;
    private String board_title;
    private String board_content;
    private Date board_regDate;
    private Integer board_hit;

    @Builder
    public BoardSaveDto(Integer board_num, String user_id, String board_title, String board_content, Date board_regDate, Integer board_hit) {
        this.board_num = board_num;
        this.user_id = user_id;
        this.board_title = board_title;
        this.board_content = board_content;
        this.board_regDate = board_regDate;
        this.board_hit = board_hit;
    }


    public Board toEntity() {
        return Board.builder()
                .board_num(board_num)
                .user_id(user_id)
                .board_title(board_title)
                .board_content(board_content)
                .board_regDate(board_regDate)
                .board_hit(board_hit)
                .build();
    }


}
