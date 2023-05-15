package com.example.university.model.entity.repositoryboard.info;

import com.example.university.model.entity.base.BaseRepositoryInfo;
import com.example.university.model.entity.base.BaseTime;

import javax.persistence.Embedded;

public class FormRepositoryInfo extends BaseTime {

  @Embedded
  private BaseRepositoryInfo baseRepositoryInfo;
}
