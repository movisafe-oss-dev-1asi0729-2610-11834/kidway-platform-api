package com.movisafe.kidway.platform.students.application.internal;

import com.movisafe.kidway.platform.students.domain.model.aggregates.Student;
import com.movisafe.kidway.platform.students.domain.services.StudentCommandService;
import com.movisafe.kidway.platform.students.domain.services.StudentQueryService;
import com.movisafe.kidway.platform.students.infrastructure.persistence.jpa.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentServiceImpl implements StudentCommandService, StudentQueryService {
    private final StudentRepository repository;
    public StudentServiceImpl(StudentRepository repository) { this.repository = repository; }

    @Override
    public List<Student> findAll() { return repository.findAll(); }

    @Override
    public Student findById(Long id) { return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Student not found with id " + id)); }

    @Override
    public Student create(Student resource) {
        resource.setId(null);
        return repository.save(resource);
    }

    @Override
    public Student update(Long id, Student resource) {
        var existing = findById(id);
    existing.setFullName(resource.getFullName());
    existing.setSchoolName(resource.getSchoolName());
    existing.setGrade(resource.getGrade());
    existing.setGuardianName(resource.getGuardianName());
    existing.setGuardianPhone(resource.getGuardianPhone());
    existing.setStatus(resource.getStatus());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
