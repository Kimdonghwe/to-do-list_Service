package com.todoList.todoList.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MEMBERS")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBERS_MEMBER_ID_SEQ")
  @SequenceGenerator(name = "MEMBERS_MEMBER_ID_SEQ", sequenceName = "MEMBERS_MEMBER_ID_SEQ", allocationSize = 1)
  @Column(name = "MEMBER_ID")
  private Long memberId;

  @Column(name = "EMAIL", nullable = false, unique = true)
  private String email;

  @Column(name = "PW", nullable = false)
  private String pw;

  @Column(name = "NICKNAME", nullable = false)
  private String nickname;
}