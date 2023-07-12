package com.eunyoung.boardproject.service;

import com.eunyoung.boardproject.dto.UserDto;
import com.eunyoung.boardproject.entity.User;
import com.eunyoung.boardproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Boolean signIn(UserDto userDto) {

        // 디비에서 사용자 정보를 가져오기
        Optional<User> findUser = userRepository.findById(userDto.getId());

        // 사용자 정보가 없을 경우 실패 처리.
        if(findUser == null){
            return false;
        }

        // 비밀번호 비교
        if (!findUser.get().getPassword().equals(userDto.getPassword())) {
            return false;
        }

        // 세션 만들어야죠.



        return true;
    }

    private UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .password(user.getPassword())
                .name(user.getName())
                .build();
    }


}
