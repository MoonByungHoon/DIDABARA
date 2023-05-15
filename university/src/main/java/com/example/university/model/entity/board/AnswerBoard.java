package com.example.university.model.entity.board;

import com.example.university.model.entity.base.BaseBoard;
import com.example.university.model.entity.base.BaseTime;

import javax.persistence.Embedded;

public class AnswerBoard extends BaseTime {

  @Embedded
  private BaseBoard baseBoard;
}
