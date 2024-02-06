package com.gabrielssantana.certification_nlw.modules.students.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.gabrielssantana.certification_nlw.modules.students.dto.VerifyIfHasCertificationDTO;
import com.gabrielssantana.certification_nlw.modules.students.useCases.VerifyIfHasCertificationUseCase;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("student")
public class StudentController {
  @Autowired
  private VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;

  @PostMapping("verifyIfHasCertification")
  public Object postVerifyIfHasCertification(@RequestBody VerifyIfHasCertificationDTO request) {
    return verifyIfHasCertificationUseCase.handle(request);
  }
}
