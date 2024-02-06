package com.gabrielssantana.certification_nlw.modules.students.useCases;

import org.springframework.stereotype.Service;

import com.gabrielssantana.certification_nlw.modules.students.dto.VerifyIfHasCertificationDTO;

@Service
public class VerifyIfHasCertificationUseCase {
  public VerifyIfHasCertificationDTO handle(VerifyIfHasCertificationDTO request) {
    return request;
  }
}
