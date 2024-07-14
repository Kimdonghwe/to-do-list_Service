package com.todoList.todoList.web.form.member;

import lombok.Data;

@Data
public class AddJoinForm {

  private  String email; //EMAIL    VARCHAR2(30) NOT NULL,
  private  String pw; //PW    VARCHAR2(20) NOT NULL,
  private  String nickname; //NICKNAME    VARCHAR2(36) NOT NULL,

}
