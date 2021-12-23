package com.toyproject.book.springboot.service.user;

import com.toyproject.book.springboot.domain.user.User;
import com.toyproject.book.springboot.domain.user.UserRepository;
import com.toyproject.book.springboot.web.dto.UserResponseDto;
import com.toyproject.book.springboot.web.dto.UserSaveRequestDto;
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
    public Long save(UserSaveRequestDto requestDto) {  // 등록
        return userRepository.save(requestDto.toEntity()).getId();
    }


//    private User saveOrUpdate(UserSaveRequestDto requestDto){
//        User user = userRepository.findByEmail(requestDto.getEmail())
//                .map(entity->entity.update(requestDto.getName(), requestDto.getPicture()))
//                .orElse(requestDto.toEntity().getId());
//
//        return userRepository.save(user);
//    }

    @Transactional
    public void delete(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("해당 이메일의 사용자가 없습니다. email : " + email));
        userRepository.delete(user);
    }



}
