package com.toyproject.book.springboot.web;

import com.toyproject.book.springboot.domain.user.UserRepository;
import com.toyproject.book.springboot.service.user.UserService;
import com.toyproject.book.springboot.web.dto.UserSaveRequestDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
@Api(tags = {"ToyProject API Test"})  // Swagger 최상단 Controller 명칭
public class UserApiController {

    private final UserService userService;

    @PostMapping("/user")  // 유저 등록 API
    @ApiOperation(value = "유저 등록", notes = "유저 등록 API")
    public Long save(@RequestBody UserSaveRequestDto requestDto) {
        return userService.save(requestDto);
    }
}