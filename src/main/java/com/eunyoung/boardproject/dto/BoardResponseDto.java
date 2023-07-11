package com.eunyoung.boardproject.dto;

import com.eunyoung.boardproject.entity.Board;
import lombok.*;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BoardResponseDto {
    private Integer board_num;
    private String user_id;
    private String board_title;
    private String board_content;
    private Date board_regDate;
    private Integer board_hit;
}
