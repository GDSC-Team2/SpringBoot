package com.toyproject.book.springboot.web.dto;

import com.toyproject.book.springboot.domain.user.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {

    @ApiModelProperty(example = "사용자 이름")
    private String name;

    @ApiModelProperty(example = "사용자 이메일")
    private String email;

    @ApiModelProperty(example = "사용자 사진")
    private String picture;

    @Builder
    public UserSaveRequestDto(String name, String email, String picture){
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .build();
    }
}