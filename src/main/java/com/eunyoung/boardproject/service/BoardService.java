package com.eunyoung.boardproject.service;

import com.eunyoung.boardproject.dto.BoardSaveDto;
import com.eunyoung.boardproject.entity.Board;
import com.eunyoung.boardproject.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public Board save(BoardSaveDto boardSaveDto) {
        return boardRepository.save(boardSaveDto.toEntity());
    }

    @Transactional
    public List<BoardSaveDto> getBoardList() {
        List<Board> boardList = boardRepository.findAll();
        List<BoardSaveDto> boardSaveDtoList = new ArrayList<>();

        for(Board board : boardList) {
            BoardSaveDto boardSaveDto = BoardSaveDto.builder()
                    .board_num(board.getBoard_num())
                    .user_id(board.getUser_id())
                    .board_title(board.getBoard_title())
                    .board_content(board.getBoard_content())
                    .board_regDate(board.getBoard_regDate())
                    .board_hit(board.getBoard_hit())
                    .build();
            boardSaveDtoList.add(boardSaveDto);
        }
        return boardSaveDtoList;
    }

    public Board read(Integer board_num) {
        return boardRepository.findById(board_num)
                .orElseThrow(()-> {
                   return new IllegalArgumentException("글 상세보기 실패");
                });


    }


}
