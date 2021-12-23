package com.toyproject.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// Posts 클래스로 데이터베이스에 접근하게 해주는 인터페이스 - DB에 접근하는 영역
// CRUD 메소드 자동 생성
public interface PostsRepository extends JpaRepository<Posts, Long> {
    Optional<Posts> findByAuthor(String author);   //이메일로 이미 가입한 회원인지 아닌지 확인

}
