package com.eunyoung.boardproject.service;

import com.eunyoung.boardproject.dto.BoardResponseDto;
import com.eunyoung.boardproject.dto.BoardRequestDto;
import com.eunyoung.boardproject.entity.Board;
import com.eunyoung.boardproject.pagination.Criteria;
import com.eunyoung.boardproject.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public BoardResponseDto save(BoardRequestDto boardRequestDto) {
        Board board = boardRepository.save(toEntity(boardRequestDto));
        return toDto(board);
    }

    @Transactional
    public Page<BoardResponseDto> getBoardList(Criteria cri) {

        PageRequest pageRequest = PageRequest.of(cri.getPage(),cri.getAmount(), Sort.by("id").descending() );
        Page<Board> boardPage = boardRepository.findAll(pageRequest);
        List<BoardResponseDto> dtoList = boardPage.stream().map(this::toDto).collect(Collectors.toList());

        return new PageImpl<>(dtoList, boardPage.getPageable(), boardPage.getTotalElements());
    }

//    //내가 쓴 게시글만 가져오기
//    @Transactional
//    public Page<BoardResponseDto> getMyBoardList(Criteria cri, String writer) {
//        PageRequest pageRequest = PageRequest.of(cri.getPage(), cri.getAmount(), Sort.by("id").descending());
////        Page<Board> boardPage = boardRepository.findByWriter(writer, pageRequest);
//        Page<Board> boardPage = boardRepository.myBoardCollection(writer, pageRequest);
//
//        List<BoardResponseDto> dtoList = boardPage.stream().map(this::toDto).collect(Collectors.toList());
//
//        return new PageImpl<>(dtoList, boardPage.getPageable(), boardPage.getTotalElements());
//    }

    //내가 쓴 게시글 가져오기(페이지네이션 X)
    @Transactional
    public List<BoardResponseDto> getMyBoardList(String writer) {
        List<Board> myBoardList = boardRepository.findByWriter(writer);
        List<BoardResponseDto> boardResponseDtoList = new ArrayList<>();
        for(Board board : myBoardList) {
            BoardResponseDto boardResponseDto = BoardResponseDto.builder()
                    .id(board.getId())
                    .writer(board.getWriter())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .regDate(board.getRegDate())
                    .hit(board.getHit())
                    .build();

            boardResponseDtoList.add(boardResponseDto);
        }
        return boardResponseDtoList;
    }


    @Transactional
    public BoardResponseDto read(Integer id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
//        board.increaseHit();
        return toDto(board);
    }

    @Transactional
    public void deletePost(Integer id) {
        boardRepository.deleteById(id);
    }

    @Transactional
    public BoardResponseDto modi(BoardRequestDto boardRequestDto) { //검증 필요 ***
        Board board = boardRepository.findById(boardRequestDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + boardRequestDto.getId()));
        board.changeBoard(boardRequestDto.getTitle(), boardRequestDto.getContent());
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

    private Board toEntity(BoardRequestDto dto) {
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

    //조회수 증가
    @Modifying
    @Transactional
    public void increaseHit(Integer id) {
        boardRepository.increaseHit(id);
    }

}



