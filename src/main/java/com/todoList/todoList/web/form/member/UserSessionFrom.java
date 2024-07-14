package com.todoList.todoList.web.form.member;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserSessionFrom {
  private Long memberId;
  private String email;
  private String nickname;

}
