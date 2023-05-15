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
@Table(name = "school_telephone_number")
public class SchoolTelephoneNumber extends BaseTime {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "undergraduate_ctudent", nullable = false, length = 45)
  private String undergraduateStudent;

  @Column(name = "graduate_student", nullable = false, length = 45)
  private String graduateStudent;

  @Column(name = "teacher_and_teaching_assistant", nullable = false, length = 45)
  private String teacherAngTeachingAssistant;

  @Column(name = "staff", nullable = false, length = 45)
  private String staff;

  @Column(name = "etc", nullable = false, length = 45)
  private String etc;
}