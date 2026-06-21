package com.movisafe.kidway.platform.attendance.domain.services;

import com.movisafe.kidway.platform.attendance.domain.model.aggregates.AttendanceRecord;
import java.util.List;

public interface AttendanceRecordQueryService {
    List<AttendanceRecord> findAll();
    AttendanceRecord findById(Long id);
}
