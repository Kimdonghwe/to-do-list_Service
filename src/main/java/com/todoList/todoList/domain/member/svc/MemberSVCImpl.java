package com.todoList.todoList.domain.member.svc;

import com.todoList.todoList.domain.entity.Member;
import com.todoList.todoList.domain.member.dao.MemberRepository;
import com.todoList.todoList.web.form.member.AddJoinForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberSVCImpl implements MemberSVC {

  @Autowired
  private MemberRepository memberRepository;

  public Optional<Member> existMemberByEmailAndPw(String email, String pw) {
    return memberRepository.findByEmailAndPw(email, pw);
  }

  @Override
  public Long saveMember(AddJoinForm addJoinForm) {
    Member member = Member.builder()
            .email(addJoinForm.getEmail())
            .pw(addJoinForm.getPw())
            .nickname(addJoinForm.getNickname())
            .build();

    try {
      member = memberRepository.save(member);
      return member.getMemberId();

    } catch (Exception e) {
      // 예외 처리: 중복된 이메일 등으로 인해 저장 실패 시 null 반환
      return null;
    }
  }

}
