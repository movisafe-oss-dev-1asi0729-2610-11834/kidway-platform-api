package com.movisafe.kidway.platform.attendance.application.internal;

import com.movisafe.kidway.platform.attendance.domain.model.aggregates.AttendanceRecord;
import com.movisafe.kidway.platform.attendance.domain.services.AttendanceRecordCommandService;
import com.movisafe.kidway.platform.attendance.domain.services.AttendanceRecordQueryService;
import com.movisafe.kidway.platform.attendance.infrastructure.persistence.jpa.repositories.AttendanceRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AttendanceRecordServiceImpl implements AttendanceRecordCommandService, AttendanceRecordQueryService {
    private final AttendanceRecordRepository repository;
    public AttendanceRecordServiceImpl(AttendanceRecordRepository repository) { this.repository = repository; }

    @Override
    public List<AttendanceRecord> findAll() { return repository.findAll(); }

    @Override
    public AttendanceRecord findById(Long id) { return repository.findById(id).orElseThrow(() -> new NoSuchElementException("AttendanceRecord not found with id " + id)); }

    @Override
    public AttendanceRecord create(AttendanceRecord resource) {
        resource.setId(null);
        return repository.save(resource);
    }

    @Override
    public AttendanceRecord update(Long id, AttendanceRecord resource) {
        var existing = findById(id);
    existing.setStudentName(resource.getStudentName());
    existing.setRouteName(resource.getRouteName());
    existing.setDate(resource.getDate());
    existing.setCheckStatus(resource.getCheckStatus());
    existing.setCheckedAt(resource.getCheckedAt());
    existing.setNotes(resource.getNotes());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
