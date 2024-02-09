package com.gabrielssantana.certification_nlw.modules.questions.entities;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "question")
public class QuestionEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 50)
  private String technology;

  @Column(length = 255)
  private String description;

  @CreationTimestamp
  @Column(name = "created_at", columnDefinition = "timestamp(6) DEFAULT now()")
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", columnDefinition = "timestamp(6) DEFAULT now()")
  private LocalDateTime updatedAt;

  @OneToMany(mappedBy = "questionEntity")
  private List<AlternativeQuestionEntity> alternativeQuestionEntities;
}
