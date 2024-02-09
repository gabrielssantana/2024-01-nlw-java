package com.gabrielssantana.certification_nlw.modules.questions.controllers;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielssantana.certification_nlw.modules.questions.dto.AlternativeResultDTO;
import com.gabrielssantana.certification_nlw.modules.questions.dto.QuestionAlternativeResultDTO;
import com.gabrielssantana.certification_nlw.modules.questions.entities.AlternativeQuestionEntity;
import com.gabrielssantana.certification_nlw.modules.questions.entities.QuestionEntity;
import com.gabrielssantana.certification_nlw.modules.questions.repositories.QuestionRepository;

@RestController
@RequestMapping("question")
public class QuestionController {
  @Autowired
  private QuestionRepository questionRepository;

  @GetMapping("findByTechnology/{technology}")
  public Object getFindByTechnology(@PathVariable String technology) {
    var result = questionRepository.findByTechnology(technology);
    return result
        .stream()
        .map(e -> mapQuestionToDTO(e))
        .collect(Collectors.toList());
  }

  static QuestionAlternativeResultDTO mapQuestionToDTO(QuestionEntity questionEntity) {
    var questionAlternativeResultDTO = QuestionAlternativeResultDTO
        .builder()
        .id(questionEntity.getId())
        .technology(questionEntity.getTechnology())
        .description(questionEntity.getDescription())
        .build();

    var alternativeResultDTO = questionEntity
        .getAlternativeQuestionEntities()
        .stream()
        .map(e -> mapAlternativeToDTO(e))
        .collect(Collectors.toList());

    questionAlternativeResultDTO.setAlternatives(alternativeResultDTO);
    return questionAlternativeResultDTO;

  }

  static AlternativeResultDTO mapAlternativeToDTO(AlternativeQuestionEntity alternativeQuestionEntity) {
    return AlternativeResultDTO
        .builder()
        .id(alternativeQuestionEntity.getId())
        .description(alternativeQuestionEntity.getDescription())
        .build();
  }
}
