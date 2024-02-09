package com.gabrielssantana.certification_nlw.modules.questions.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlternativeResultDTO {
  private Long id;

  private String description;
}
