package com.todoList.todoList.web.controller;


import com.todoList.todoList.web.form.member.SessionConst;
import com.todoList.todoList.web.form.member.UserSessionFrom;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller // Controller 역할을 하는 클래스
public class HomeController {

  @GetMapping("/")
  public String home(Model model, HttpServletRequest request) {

    HttpSession session = request.getSession(false);  // Get existing session, do not create a new one
    // Retrieve the LoginMember object from the session
    UserSessionFrom loginMember = (UserSessionFrom) session.getAttribute(SessionConst.LOGIN_MEMBER);


    log.info("loginMember = {} ", loginMember);

    model.addAttribute("session",session);

    return "index"; // src/main/resources/templates/index.html
  }

}
