package com.eunyoung.boardproject.controller;

import com.eunyoung.boardproject.dto.BoardSaveDto;
import com.eunyoung.boardproject.entity.Board;
import com.eunyoung.boardproject.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
public class BoardController {

    @Autowired
    private BoardService boardService;

    //게시글 저장
    @PostMapping("/board/save")
    public Board save(@RequestBody BoardSaveDto boardSaveDto) {

        boardSaveDto.setBoard_regDate(Timestamp.valueOf(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now())));

        return boardService.save(boardSaveDto);


    }


    //게시판 리스트
    @PostMapping("/board/list")
    public List<BoardSaveDto> list(Model model) {
        List<BoardSaveDto> boardSaveDtoList = boardService.getBoardList();
        model.addAttribute("boardList", boardSaveDtoList);
        return boardSaveDtoList;
    }


    //게시판 디테일
    @GetMapping("/board/read/{board_num}")
    public String read(@RequestParam("board_num") Integer board_num, Model model) {
        model.addAttribute("board", boardService.read(board_num));
        return "success";
    }


}
