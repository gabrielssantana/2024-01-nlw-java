package com.gabrielssantana.certification_nlw.modules.students.entities;

import java.time.LocalDateTime;
import java.util.List;
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
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "certification")
public class CertificationStudentEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "student_id")
  private Long studentID;

  @Column(length = 50)
  private String technology;

  @Column(length = 10)
  private int grade;

  @CreationTimestamp
  @Column(name = "created_at", columnDefinition = "timestamp(6) DEFAULT now()")
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", columnDefinition = "timestamp(6) DEFAULT now()")
  private LocalDateTime updatedAt;

  @ManyToOne
  @JoinColumn(name = "student_id", insertable = false, updatable = false)
  private StudentEntity studentEntity;

  @OneToMany(mappedBy = "certificationStudentEntity")
  private List<AnswerCertificationEntity> answerCertificationEntities;
}
