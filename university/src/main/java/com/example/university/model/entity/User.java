package com.example.university.model.entity;


import com.example.university.model.entity.base.BaseTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User extends BaseTime {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "username", nullable = false, length = 45, unique = true, updatable = false)
  private String username;

  @Column(name = "realName", nullable = false, length = 30, updatable = false)
  private String realName;

  @Column(name = "password", nullable = false, length = 45)
  private String password;

  @OneToOne(cascade = CascadeType.ALL, mappedBy = )
  @PrimaryKeyJoinColumn
  private UserInfo userInfo;
}
