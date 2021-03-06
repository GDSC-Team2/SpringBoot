package com.toyproject.book.springboot.domain.user;

import com.toyproject.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Builder
    public User(String name, String email, String picture){
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    public void update(String name, String picture){
        this.name = name;
        this.picture = picture;
    }
}
