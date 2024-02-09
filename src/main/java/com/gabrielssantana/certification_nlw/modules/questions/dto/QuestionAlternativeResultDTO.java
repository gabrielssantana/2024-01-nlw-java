package com.gabrielssantana.certification_nlw.modules.questions.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionAlternativeResultDTO {

  private Long id;

  private String technology;

  private String description;

  private List<AlternativeResultDTO> alternatives;
}
