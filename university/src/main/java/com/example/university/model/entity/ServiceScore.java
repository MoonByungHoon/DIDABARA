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
@Table(name = "service_score")
public class ServiceScore extends BaseTime {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "user_id", nullable = false, updatable = false)
  private Long user;

  @Column(name = "score", nullable = false)
  private Double score;
}
