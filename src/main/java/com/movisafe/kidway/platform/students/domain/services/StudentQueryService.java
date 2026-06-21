package com.movisafe.kidway.platform.students.domain.services;

import com.movisafe.kidway.platform.students.domain.model.aggregates.Student;
import java.util.List;

public interface StudentQueryService {
    List<Student> findAll();
    Student findById(Long id);
}
