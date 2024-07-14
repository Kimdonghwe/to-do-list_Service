package com.todoList.todoList.domain.member.svc;

import com.todoList.todoList.domain.entity.Member;
import com.todoList.todoList.web.form.member.AddJoinForm;

import java.util.Optional;

public interface MemberSVC {

  public Optional<Member> existMemberByEmailAndPw(String email, String pw);

  public Long saveMember(AddJoinForm addJoinForm);
}
