package com.example.university.model.entity.base;

import com.example.university.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseBoard {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;

  @Column(name = "title", nullable = false, length = 100)
  private String title;

  @Column(name = "content", nullable = false, length = 1000)
  private String content;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id", nullable = false, updatable = false)
  private User writer;

  @Column(name = "view_count", nullable = false)
  private int viewCount;
}
