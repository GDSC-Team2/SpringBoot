package com.toyproject.book.springboot.service.user;

import com.toyproject.book.springboot.domain.posts.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Posts> getAllPostsByMe(){
        List<Posts> postsList = new ArrayList<>();
        postsList.addAll(jdbcTemplate.queryForList("select * from user where name=author", Posts.class));
        return postsList;
    }

}
