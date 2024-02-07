package com.gabrielssantana.certification_nlw.modules.questions.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielssantana.certification_nlw.modules.questions.entities.QuestionEntity;
import com.gabrielssantana.certification_nlw.modules.questions.repositories.QuestionRepository;

@RestController
@RequestMapping("question")
public class QuestionController {
  @Autowired
  private QuestionRepository questionRepository;

  @GetMapping("findByTechnology/{technology}")
  public List<QuestionEntity> getFindByTechnology(@PathVariable String technology) {
    return questionRepository.findByTechnology(technology);
  }
}
