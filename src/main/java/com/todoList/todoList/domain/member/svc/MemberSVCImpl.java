package com.todoList.todoList.domain.member.svc;

import com.todoList.todoList.domain.entity.Member;
import com.todoList.todoList.domain.member.dao.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberSVCImpl implements MemberSVC{

  @Autowired
  private MemberRepository memberRepository;

  public Optional<Member> login(String email, String pw) {
    return memberRepository.findByEmailAndPw(email, pw);
  }

}
