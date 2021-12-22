package com.toyproject.book.springboot.web;

import com.toyproject.book.springboot.config.auth.CustomOAuth2UserService;
import com.toyproject.book.springboot.config.auth.dto.SessionUser;
import com.toyproject.book.springboot.domain.user.User;
import com.toyproject.book.springboot.domain.user.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

import java.security.Principal;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
@Api(tags = {"ToyProject API Test"})  // Swagger 최상단 Controller 명칭
public class UserApiController {
    private CustomOAuth2UserService customOAuth2UserService;

//    @GetMapping("/user")
//    public SessionUser findByEmail(@PathVariable String email){
//        return customOAuth2UserService.findByEmail(email);
//    }
}
