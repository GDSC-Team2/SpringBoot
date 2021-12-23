package com.toyproject.book.springboot.web.dto;

import com.toyproject.book.springboot.domain.user.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
public class UserResponseDto {

    @ApiModelProperty(example = "사용자 이름")
    private String name;

    @ApiModelProperty(example = "사용자 이메일")
    private String email;

    @ApiModelProperty(example = "사용자 사진")
    private String picture;

    public UserResponseDto(User entity){
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.picture=entity.getPicture();
    }
}
