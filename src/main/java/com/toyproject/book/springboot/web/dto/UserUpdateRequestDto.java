package com.toyproject.book.springboot.web.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserUpdateRequestDto {
    @ApiModelProperty(example = "사용자 이름")
    private String name;

    @ApiModelProperty(example = "사용자 이메일")
    private String email;

    @ApiModelProperty(example = "사용자 사진")
    private String picture;

    @Builder
    public UserUpdateRequestDto(String name, String email, String picture){
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

}
