package com.eunyoung.boardproject.controller;

import com.eunyoung.boardproject.dto.BoardResponseDto;
import com.eunyoung.boardproject.dto.BoardSaveDto;
import com.eunyoung.boardproject.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    //게시글 저장
    @PostMapping("/save")
    public BoardResponseDto save(@RequestBody BoardSaveDto boardSaveDto) {
        boardSaveDto.setBoard_regDate(new Date());
        return boardService.save(boardSaveDto);
    }


    //게시판 리스트
    @GetMapping("/list")
    public List<BoardSaveDto> list(Model model) {
        List<BoardSaveDto> boardSaveDtoList = boardService.getBoardList();
        return boardSaveDtoList;
    }


    //게시판 디테일
    @GetMapping(value = "/detail/{boardNum}")
    public ResponseEntity<BoardResponseDto> read(@PathVariable("boardNum") Integer board_num) {
        return new ResponseEntity<>(boardService.read(board_num), HttpStatus.OK);
    }

    //게시글 삭제
    @DeleteMapping("/detail/{boardNum}")
    public void delete(@PathVariable("boardNum") Integer board_num) {
        boardService.deletePost(board_num);

    }

    //게시글 수정
    @PutMapping("/detail/{boardNum}")
    public ResponseEntity<BoardResponseDto> modi(@PathVariable("boardNum") Integer board_num,
                                                 @RequestBody BoardSaveDto boardSaveDto) {
        boardSaveDto.setBoard_num(board_num);
        boardSaveDto.setBoard_regDate(new Date());
        return new ResponseEntity<>(boardService.modi(boardSaveDto), HttpStatus.OK);
    }

}
