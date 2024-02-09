package com.gabrielssantana.certification_nlw.modules.students.entities;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "answer")
public class AnswerCertificationEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "certification_id")
  private Long certificationID;

  @Column(name = "student_id")
  private Long studentID;

  @Column(name = "question_id")
  private Long questionID;

  @Column(name = "answer_id")
  private Long answerID;

  @ManyToOne
  @JoinColumn(name = "certification_id", insertable = false, updatable = false)
  private CertificationStudentEntity certificationStudentEntity;

  @Column(name = "is_correct")
  private boolean isCorrect;

  @CreationTimestamp
  @Column(name = "created_at", columnDefinition = "timestamp(6) DEFAULT now()")
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", columnDefinition = "timestamp(6) DEFAULT now()")
  private LocalDateTime updatedAt;
}
