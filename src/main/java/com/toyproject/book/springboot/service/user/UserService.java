package com.toyproject.book.springboot.service.user;

import com.toyproject.book.springboot.domain.user.UserRepository;
import com.toyproject.book.springboot.web.dto.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public Long save(UserSaveRequestDto requestDto) {  // 등록
        return userRepository.save(requestDto.toEntity()).getId();
    }

}
