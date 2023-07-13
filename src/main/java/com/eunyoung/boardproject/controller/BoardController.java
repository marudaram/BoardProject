package com.eunyoung.boardproject.controller;

import com.eunyoung.boardproject.dto.BoardResponseDto;
import com.eunyoung.boardproject.dto.BoardRequestDto;
import com.eunyoung.boardproject.pagination.Criteria;
import com.eunyoung.boardproject.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    //게시글 저장
    @PostMapping(value = "/save")
    public BoardResponseDto save(@RequestBody BoardRequestDto boardRequestDto ) {
        boardRequestDto.setRegDate(new Date());
        return boardService.save(boardRequestDto);
    }


    //게시판 리스트
    @GetMapping("/list")
    public Page<BoardResponseDto> list(Criteria cri) {
        //총 개수
        Page<BoardResponseDto> boardList = boardService.getBoardList(cri);
        return boardList;
    }

    //게시판 디테일
    @GetMapping(value = "/detail/{boardNum}")
    public ResponseEntity<BoardResponseDto> read(@PathVariable("boardNum") Integer id) {
        boardService.increaseHit(id);
        System.out.println(id);
        return new ResponseEntity<>(boardService.read(id), HttpStatus.OK);
    }

    //게시글 삭제
    @DeleteMapping("/detail")
    public void delete(@RequestParam("id") Integer id) {

        boardService.deletePost(id);
    }

    //게시글 수정
    @PutMapping("/detail/{boardNum}")
    public ResponseEntity<BoardResponseDto> modi(@PathVariable("boardNum") Integer id,
                                                 @RequestBody BoardRequestDto boardRequestDto) {
        boardRequestDto.setId(id);
        return new ResponseEntity<>(boardService.modi(boardRequestDto), HttpStatus.OK);
    }

    //내가 쓴 게시글 리스트 불러오기
//    @GetMapping("/myBoard")
//    public Page<BoardResponseDto> myBoard(Criteria cri, String writer) {
//        Page<BoardResponseDto> myBoardList = boardService.getMyBoardList(cri, writer);
//        return myBoardList;
//    }


    //내가 쓴 게시글 리스트 불러오기(페이지네이션 X)
    @GetMapping("/myBoard/{writer}")
    public List<BoardResponseDto> myBoardList(@PathVariable("writer") String writer) {
        List<BoardResponseDto> boardResponseDto = boardService.getMyBoardList(writer);

        return boardResponseDto;
    }


}
