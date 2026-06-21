package com.movisafe.kidway.platform.attendance.domain.model.aggregates;

import com.movisafe.kidway.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "attendance")
public class AttendanceRecord extends AuditableAbstractAggregateRoot {
private String studentName;
private String routeName;
private String date;
private String checkStatus;
private String checkedAt;
private String notes;

    public AttendanceRecord() { }

    public AttendanceRecord(String studentName, String routeName, String date, String checkStatus, String checkedAt, String notes) {
    this.studentName = studentName;
    this.routeName = routeName;
    this.date = date;
    this.checkStatus = checkStatus;
    this.checkedAt = checkedAt;
    this.notes = notes;
    }

public String getStudentName() { return studentName; }
public void setStudentName(String studentName) { this.studentName = studentName; }
public String getRouteName() { return routeName; }
public void setRouteName(String routeName) { this.routeName = routeName; }
public String getDate() { return date; }
public void setDate(String date) { this.date = date; }
public String getCheckStatus() { return checkStatus; }
public void setCheckStatus(String checkStatus) { this.checkStatus = checkStatus; }
public String getCheckedAt() { return checkedAt; }
public void setCheckedAt(String checkedAt) { this.checkedAt = checkedAt; }
public String getNotes() { return notes; }
public void setNotes(String notes) { this.notes = notes; }
}
