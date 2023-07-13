package com.eunyoung.boardproject.pagination;

import com.eunyoung.boardproject.dto.BoardResponseDto;
import lombok.Data;

import java.util.List;

@Data
public class PageGate {

    private List<BoardResponseDto> list;
    private PageVO pageVO;

    public PageGate() {
        super();
    }

    public PageGate(List<BoardResponseDto> list, PageVO pageVO) {
        this.list = list;
        this.pageVO = pageVO;
    }


}
