package com.eunyoung.boardproject.dto;

import com.eunyoung.boardproject.entity.Board;
import lombok.*;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BoardSaveDto {
    private Integer id;
    private String writer;
    private String title;
    private String content;
    private Date regDate;
    private Integer hit;
}