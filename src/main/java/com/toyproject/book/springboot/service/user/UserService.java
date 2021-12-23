package com.toyproject.book.springboot.service.user;

import com.toyproject.book.springboot.domain.posts.Posts;
import com.toyproject.book.springboot.domain.user.User;
import com.toyproject.book.springboot.domain.user.UserRepository;
import com.toyproject.book.springboot.web.dto.PostsUpdateRequestDto;
import com.toyproject.book.springboot.web.dto.UserResponseDto;
import com.toyproject.book.springboot.web.dto.UserSaveRequestDto;
import com.toyproject.book.springboot.web.dto.UserUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserResponseDto findById (Long id) {  // 조회
        User entity = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id="+ id));
        return new UserResponseDto(entity);
    }

    @Transactional
    public Long save(User requestDto) {  // 등록
        return userRepository.save(requestDto).getId();
    }


    @Transactional
    public String update(String email, UserUpdateRequestDto requestDto){  // 수정
        User user = userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("해당 아이디가 없습니다. email="+ email));
        user.update(requestDto.getName(), requestDto.getPicture());
        return email;
    }

}
