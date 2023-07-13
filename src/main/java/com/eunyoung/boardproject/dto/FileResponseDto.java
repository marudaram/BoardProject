package com.eunyoung.boardproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FileResponseDto {
    private String id; //파일 UUID
    private Integer boardId; //게시판 번호
    private String name; //파일명
    private String path; //파일경로
    private String uploader; //유저
}
