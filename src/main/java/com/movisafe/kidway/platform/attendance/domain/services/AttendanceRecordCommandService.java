package com.movisafe.kidway.platform.attendance.domain.services;

import com.movisafe.kidway.platform.attendance.domain.model.aggregates.AttendanceRecord;

public interface AttendanceRecordCommandService {
    AttendanceRecord create(AttendanceRecord resource);
    AttendanceRecord update(Long id, AttendanceRecord resource);
    void delete(Long id);
}
