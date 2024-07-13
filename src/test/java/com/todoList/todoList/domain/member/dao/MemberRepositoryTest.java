package com.todoList.todoList.domain.member.dao;

import com.todoList.todoList.domain.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@Slf4j
@SpringBootTest
class MemberRepositoryTest {

  @Autowired
  MemberRepository memberRepository;

  @Test
  @DisplayName("회원삭제")
  void deleteMember() {
    memberRepository.deleteById(22L);
  }

  @Test
  @DisplayName("회원등록")
  void saveMember() {
    String email = "test";
    String pw = "1234";
    String nickname = "kdh";

    Member member = Member.builder()
            .email(email)
            .pw(pw)
            .nickname(nickname)
            .build();

    memberRepository.save(member);
  }

  @Test
  @DisplayName("로그인")
  void loginMember() {
    Optional<Member> member = memberRepository.findByEmailAndPw("test@example.com", "1234");
    if (member.isPresent()) {
      log.info("Login successful: {}", member.get().getNickname());
    } else {
      log.info("Invalid email or password");
    }
  }
}