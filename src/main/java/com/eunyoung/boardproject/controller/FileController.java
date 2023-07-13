package com.eunyoung.boardproject.controller;

import com.eunyoung.boardproject.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class FileController {

    @Autowired
    private FileService fileService;


    //파일 저장
    @PostMapping("/fileSave")
    public String fileSave() {




        return "";

    }


}
