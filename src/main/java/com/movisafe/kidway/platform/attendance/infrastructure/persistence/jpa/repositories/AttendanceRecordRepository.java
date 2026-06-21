package com.movisafe.kidway.platform.attendance.infrastructure.persistence.jpa.repositories;

import com.movisafe.kidway.platform.attendance.domain.model.aggregates.AttendanceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRecordRepository extends JpaRepository<AttendanceRecord, Long> { }
