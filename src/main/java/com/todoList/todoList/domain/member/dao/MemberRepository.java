package com.todoList.todoList.domain.member.dao;

import com.todoList.todoList.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
  Optional<Member> findByEmailAndPw(String email, String pw);

}