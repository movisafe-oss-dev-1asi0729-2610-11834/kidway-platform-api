package com.movisafe.kidway.platform.students.infrastructure.persistence.jpa.repositories;

import com.movisafe.kidway.platform.students.domain.model.aggregates.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> { }
