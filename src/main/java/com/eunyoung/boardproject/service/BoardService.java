package com.eunyoung.boardproject.service;

import com.eunyoung.boardproject.dto.BoardResponseDto;
import com.eunyoung.boardproject.dto.BoardSaveDto;
import com.eunyoung.boardproject.entity.Board;
import com.eunyoung.boardproject.pagination.Criteria;
import com.eunyoung.boardproject.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public BoardResponseDto save(BoardSaveDto boardSaveDto) {
        Board board = boardRepository.save(toEntity(boardSaveDto));
        return toDto(board);
    }

    @Transactional
    public Page<BoardResponseDto> getBoardList(Criteria cri) {

        PageRequest pageRequest = PageRequest.of(cri.getPage(), cri.getAmount());
        Page<Board> boardPage = boardRepository.findAll(pageRequest);
        List<BoardResponseDto> dtoList = boardPage.stream().map(this::toDto).collect(Collectors.toList());

        return new PageImpl<>(dtoList, boardPage.getPageable(), boardPage.getTotalElements());
    }

    public BoardResponseDto read(Integer board_num) {
        Board board = boardRepository.findById(board_num).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. board_num=" + board_num));
        board.increaseHit();
        return toDto(board);
    }

    @Transactional
    public void deletePost(Integer board_num) {
        boardRepository.deleteById(board_num);
    }

    @Transactional
    public BoardResponseDto modi(BoardSaveDto boardSaveDto) {
        Board board = boardRepository.findById(boardSaveDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. board_num=" + boardSaveDto.getId()));
        board.changeBoard(boardSaveDto.getTitle(), boardSaveDto.getContent());
        return toDto(board);
    }

    private BoardResponseDto toDto(Board board) {
        return BoardResponseDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .hit(board.getHit())
                .writer(board.getWriter())
                .regDate(board.getRegDate())
                .build();
    }

    private Board toEntity(BoardSaveDto dto) {
        return Board.builder()
                .writer(dto.getWriter())
                .title(dto.getTitle())
                .content(dto.getContent())
                .regDate(dto.getRegDate())
                .hit(dto.getHit())
                .build();
    }

    @Transactional
    public long getBoardTotal(Criteria cri) {

//        int total = boardSaveDto.getBoard_num();

        return boardRepository.count();
    }

}



