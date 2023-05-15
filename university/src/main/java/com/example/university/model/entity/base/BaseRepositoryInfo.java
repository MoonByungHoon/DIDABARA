package com.example.university.model.entity.base;

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
public class BaseRepositoryInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "file_path", length = 255)
  private String filePath;

  @Column(name = "repository_id", nullable = false, updatable = false)
  private Long repository;
}
