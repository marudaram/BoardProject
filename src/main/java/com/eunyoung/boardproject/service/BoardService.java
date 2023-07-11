package com.eunyoung.boardproject.service;

import com.eunyoung.boardproject.dto.BoardResponseDto;
import com.eunyoung.boardproject.dto.BoardSaveDto;
import com.eunyoung.boardproject.entity.Board;
import com.eunyoung.boardproject.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public BoardResponseDto save(BoardSaveDto boardSaveDto) {
        Board board = boardRepository.save(boardSaveDto.toEntity());
        return toDto(board);
    }

    @Transactional
    public List<BoardSaveDto> getBoardList() {
        List<Board> boardList = boardRepository.findAll();
        List<BoardSaveDto> boardSaveDtoList = new ArrayList<>();

        for (Board board : boardList) {
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


    public BoardResponseDto read(Integer board_num) {
        Board board = boardRepository.findById(board_num).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. board_num=" + board_num));
        return toDto(board);
    }

    @Transactional
    public void deletePost(Integer board_num) {
        boardRepository.deleteById(board_num);
    }

    @Transactional
    public BoardResponseDto modi(BoardSaveDto boardSaveDto) {
        Board board = boardRepository.findById(boardSaveDto.getBoard_num())
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. board_num=" + boardSaveDto.getBoard_num()));
        board.changeBoard(boardSaveDto.getBoard_title(), board.getBoard_content());
        return toDto(board);
    }

    private BoardResponseDto toDto(Board board) {
        return BoardResponseDto.builder()
                .board_num(board.getBoard_num())
                .board_title(board.getBoard_title())
                .board_content(board.getBoard_content())
                .board_hit(board.getBoard_hit())
                .user_id(board.getUser_id())
                .board_regDate(board.getBoard_regDate())
                .build();
    }
}



