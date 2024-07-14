package com.todoList.todoList.web.controller.member;


import com.todoList.todoList.domain.entity.Member;
import com.todoList.todoList.domain.member.svc.MemberSVC;
import com.todoList.todoList.web.form.member.LoginCheckForm;
import com.todoList.todoList.web.form.member.SessionConst;
import com.todoList.todoList.web.form.member.UserSessionFrom;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Slf4j
@RequestMapping("/login")
@Controller // Controller 역할을 하는 클래스
public class MemberController {

  @Autowired
  MemberSVC memberSVC;


  @GetMapping
  public String login() {
    log.info("login");
    return "member/login";
  }


  @PostMapping
  public String loginOffer(@ModelAttribute LoginCheckForm loginCheckForm, HttpServletRequest request,
                           RedirectAttributes redirectAttributes) {
    log.info("loginForm={}", loginCheckForm);

//    // 회원 아이디 존재 유무 체크
    Optional<Member> optionalMember = memberSVC.existMemberByEmailAndPw(loginCheckForm.getEmail(), loginCheckForm.getPw());

      // 회원 정보가 존재하면 세션에 저장
      if (optionalMember.isPresent()) {
        HttpSession session = request.getSession(true);  // 세션 생성
        Member member = optionalMember.get();
        UserSessionFrom userSessionFrom = new UserSessionFrom(member.getMemberId(), member.getEmail(),member.getNickname());
        session.setAttribute(SessionConst.LOGIN_MEMBER, userSessionFrom);
        return "redirect:/";
      }
      else {
      // 아이디가 존재하지 않음
      redirectAttributes.addFlashAttribute("message", "존재하지 않는 사용자입니다.");
      return "redirect:/login";
    }



  }





}
