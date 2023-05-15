package com.example.university.model.entity.board.info;

import com.example.university.model.entity.base.BaseBoardInfo;
import com.example.university.model.entity.base.BaseTime;

import javax.persistence.Embedded;

public class ImprovementsBoardInfo extends BaseTime {

  @Embedded
  private BaseBoardInfo baseBoardInfo;
}
