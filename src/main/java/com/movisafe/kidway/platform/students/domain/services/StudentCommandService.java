package com.movisafe.kidway.platform.students.domain.services;

import com.movisafe.kidway.platform.students.domain.model.aggregates.Student;

public interface StudentCommandService {
    Student create(Student resource);
    Student update(Long id, Student resource);
    void delete(Long id);
}
