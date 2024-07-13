package com.todoList.todoList.domain.member.svc;

import com.todoList.todoList.domain.entity.Member;

import java.util.Optional;

public interface MemberSVC {

  public Optional<Member> login(String email, String pw);
}
