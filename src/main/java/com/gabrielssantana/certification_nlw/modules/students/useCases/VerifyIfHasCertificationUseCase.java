package com.gabrielssantana.certification_nlw.modules.students.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielssantana.certification_nlw.modules.students.dto.VerifyIfHasCertificationDTO;
import com.gabrielssantana.certification_nlw.modules.students.repositories.CertificationStudentRepository;

@Service
public class VerifyIfHasCertificationUseCase {
  @Autowired
  private CertificationStudentRepository certificationStudentRepository;

  public boolean handle(VerifyIfHasCertificationDTO request) {
    var certifications = certificationStudentRepository.findByStudentEmailAndTechnology(request.getEmail(),
        request.getTechnology());
    if (!certifications.isEmpty()) {
      return true;
    }

    return false;
  }
}
