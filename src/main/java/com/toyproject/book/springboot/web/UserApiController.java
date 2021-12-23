package com.toyproject.book.springboot.web;

import com.toyproject.book.springboot.service.user.UserService;
import com.toyproject.book.springboot.web.dto.PostsResponseDto;
import com.toyproject.book.springboot.web.dto.UserResponseDto;
import com.toyproject.book.springboot.web.dto.UserSaveRequestDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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

    @GetMapping("/user/{id}")  // 조회 API by ID - 아이디로 하나씩 조회
    @ApiOperation(value = "사용자 조회 by ID", notes = "글 사용자 API by ID")
    @ApiImplicitParam(name = "id", value = "사용자 아이디")  // Swagger에 사용하는 파라미터에 대해 설명
    public UserResponseDto findById (@PathVariable Long id) {
        return userService.findById(id);
    }
}