package com.example.university.model.entity.base;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
//implements 한 Entity 클래스들이 BaseTime 클래스를 컬럼으로 인식하도록 하는 어노테이션
@MappedSuperclass
//implements 된 Entity들의 CRU 등의 작업을 감지하고 해당 이벤트시에 자동 처리되게 하기 위한 어노테이션
@EntityListeners(AutoCloseable.class)
public abstract class BaseTime {

  @CreatedDate
  @Column(name = "created_date", nullable = false)
  private LocalDateTime createdDate;

  @LastModifiedDate
  @Column(name = "modifiedDate", nullable = false)
  private LocalDateTime modifiedDate;
}
