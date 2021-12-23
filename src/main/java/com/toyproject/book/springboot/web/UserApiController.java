package com.toyproject.book.springboot.web;

import com.toyproject.book.springboot.config.auth.CustomOAuth2UserService;
import com.toyproject.book.springboot.config.auth.dto.OAuthAttributes;
import com.toyproject.book.springboot.config.auth.dto.SessionUser;
import com.toyproject.book.springboot.domain.user.User;
import com.toyproject.book.springboot.domain.user.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import java.security.Principal;
import java.util.Map;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
@Api(tags = {"ToyProject API Test"})  // Swagger 최상단 Controller 명칭
public class UserApiController {

    @GetMapping("/user")
    @ApiOperation(value = "사용자 정보", notes = "현재 로그인한 사용자 정보 받는 API")
    @ApiImplicitParam(name = "사용자 object", value = "전체적인 정보")
    public Map<String, Object> userDetails(@AuthenticationPrincipal OAuth2User user) {
        return user.getAttributes();
    }

    @DeleteMapping("/user/{email}")
    @ApiOperation(value = "사용자 삭제", notes = "현재 로그인한 사용자 삭제 API")
    @ApiImplicitParam(name = "email", value = "사용자 이메일")
    public void delete (@PathVariable String email){
        customOAuth2UserService.delete(email);
    }

}