package com.gabrielssantana.certification_nlw.modules.students.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielssantana.certification_nlw.modules.students.entities.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
  List<StudentEntity> findByEmail(String email);
}
