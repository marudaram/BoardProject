package com.eunyoung.boardproject.dto;

import lombok.*;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BoardRequestDto {
    private Integer id;
    private String writer;
    private String title;
    private String content;
    private Date regDate;
    private Integer hit;
}