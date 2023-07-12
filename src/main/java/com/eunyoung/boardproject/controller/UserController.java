package com.eunyoung.boardproject.controller;

import com.eunyoung.boardproject.dto.UserDto;
import com.eunyoung.boardproject.entity.User;
import com.eunyoung.boardproject.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @PostMapping("/signIn")
    public String signIn(@RequestBody UserDto userDto) {

        if (userService.signIn(userDto)) {
            return "Success";
        }
        return "signIn";


    }
}
