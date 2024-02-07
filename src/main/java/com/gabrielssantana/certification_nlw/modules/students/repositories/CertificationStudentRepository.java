package com.gabrielssantana.certification_nlw.modules.students.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gabrielssantana.certification_nlw.modules.students.entities.CertificationStudentEntity;

@Repository
public interface CertificationStudentRepository extends JpaRepository<CertificationStudentEntity, Long> {
  @Query("SELECT certification FROM certification certification JOIN certification.studentEntity studentEntity WHERE studentEntity.email = :email AND certification.technology = :technology")
  List<CertificationStudentEntity> findByStudentEmailAndTechnology(String email, String technology);
}
