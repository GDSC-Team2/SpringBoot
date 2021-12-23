package com.toyproject.book.springboot.web;

import com.toyproject.book.springboot.domain.posts.Posts;
import com.toyproject.book.springboot.domain.posts.PostsRepository;
import com.toyproject.book.springboot.service.posts.PostsService;
import com.toyproject.book.springboot.web.dto.PostsResponseDto;
import com.toyproject.book.springboot.web.dto.PostsSaveRequestDto;
import com.toyproject.book.springboot.web.dto.PostsUpdateRequestDto;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// API를 요청받는 컨트롤러로 요청을 받는 영역
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
@Api(tags = {"ToyProject API Test"})  // Swagger 최상단 Controller 명칭
public class PostsApiController {

    private final PostsService postsService;
    private final PostsRepository postsRepository;

    @GetMapping("/home")  // 스프링부트 리액트 연동 테스트
    @ApiOperation(value = "연동 테스트", notes = "스프링부트와 리액트 연동을 테스트한다.")  // Swagger에 사용하는 API에 대한 간단 설명
    public String getHome() {
        return "Hello World!";
    }

    @PostMapping("/posts")  // 등록 API
    @ApiOperation(value = "글 등록", notes = "글 등록 API")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @GetMapping("/posts")  // 조회 API - 전체 조회
    @ApiOperation(value = "글 조회", notes = "글 전체 조회 API")
    public List<Posts> getAllPosts() {
        return postsRepository.findAll();
    }

//    @GetMapping("/posts/my")  // 조회 API - 전체 조회
//    @ApiOperation(value = "내 글 조회", notes = "내 글 조회 API")
//    @ApiImplicitParam(name = "author", value = "작성자")  // Swagger에 사용하는 파라미터에 대해 설명
//    public PostsResponseDto findByAuthorContaining (@PathVariable String author) {
//        return postsService.findByAuthorContaining();
//    }

    @GetMapping("/posts/my")  // 조회 API - 전체 조회
    @ApiOperation(value = "내 글 조회", notes = "내 글 조회 API")
    @ApiImplicitParam(name = "author", value = "작성자")  // Swagger에 사용하는 파라미터에 대해 설명
    public List<Posts> getAllPostsByMe() {
        return postsRepository.getAllPostsByMe();
    }

    @GetMapping("/posts/{id}")  // 조회 API by ID - 아이디로 하나씩 조회
    @ApiOperation(value = "글 조회 by ID", notes = "글 조회 API by ID")
    @ApiImplicitParam(name = "id", value = "글 아이디")  // Swagger에 사용하는 파라미터에 대해 설명
    public PostsResponseDto findById (@PathVariable Long id) {
        return postsService.findById(id);
    }

    @PutMapping("/posts/{id}")   // 수정 API
    @ApiOperation(value = "글 수정", notes = "글 수정 API")
    @ApiImplicitParam(name = "id", value = "글 아이디")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @DeleteMapping("/posts/{id}")   // 삭제 API
    @ApiOperation(value = "글 삭제", notes = "글 삭제 API")
    @ApiImplicitParam(name = "id", value = "글 아이디")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }
}
