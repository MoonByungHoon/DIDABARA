package com.example.university.model.entity.repositoryboard;

import com.example.university.model.entity.base.BaseRepository;
import com.example.university.model.entity.base.BaseTime;

import javax.persistence.Embedded;

public class FormRepository extends BaseTime {

  @Embedded
  private BaseRepository baseRepository;
}
