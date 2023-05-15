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
@Table(name = "user_info")
public class UserInfo extends BaseTime {

  @Id
  @Column(name = "user_id")
  private Long id;

  @Enumerated(EnumType.STRING)
  private UserRole role;

  @Column(name = "phone_number", nullable = false, length = 30)
  private String phoneNumber;

  @Column(name = "email", nullable = false, length = 45)
  private String email;
}