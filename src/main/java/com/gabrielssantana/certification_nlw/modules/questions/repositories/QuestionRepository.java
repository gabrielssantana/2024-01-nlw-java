package com.gabrielssantana.certification_nlw.modules.questions.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gabrielssantana.certification_nlw.modules.questions.entities.QuestionEntity;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {

  List<QuestionEntity> findByTechnology(String technology);
}
