package com.todoList.todoList.web.controller.member;

import com.todoList.todoList.domain.member.svc.MemberSVC;
import com.todoList.todoList.web.form.member.AddJoinForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping("/join")
@Controller // Controller 역할을 하는 클래스
public class JoinController {

  @Autowired
  MemberSVC memberSVC;

  @GetMapping
  public String join() {
    log.info("join");
    return "member/join";
  }

  @PostMapping
  public String joinAdd(@ModelAttribute AddJoinForm addJoinForm) {

    log.info("joinAddForm = {} ", addJoinForm);
    Long managementId = memberSVC.saveMember(addJoinForm);

    return (managementId != null) ? "redirect:/login" : "redirect:/join";
  }

}
