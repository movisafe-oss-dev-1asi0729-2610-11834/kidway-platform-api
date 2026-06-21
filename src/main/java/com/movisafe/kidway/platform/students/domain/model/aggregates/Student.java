package com.movisafe.kidway.platform.students.domain.model.aggregates;

import com.movisafe.kidway.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student extends AuditableAbstractAggregateRoot {
private String fullName;
private String schoolName;
private String grade;
private String guardianName;
private String guardianPhone;
private String status;

    public Student() { }

    public Student(String fullName, String schoolName, String grade, String guardianName, String guardianPhone, String status) {
    this.fullName = fullName;
    this.schoolName = schoolName;
    this.grade = grade;
    this.guardianName = guardianName;
    this.guardianPhone = guardianPhone;
    this.status = status;
    }

public String getFullName() { return fullName; }
public void setFullName(String fullName) { this.fullName = fullName; }
public String getSchoolName() { return schoolName; }
public void setSchoolName(String schoolName) { this.schoolName = schoolName; }
public String getGrade() { return grade; }
public void setGrade(String grade) { this.grade = grade; }
public String getGuardianName() { return guardianName; }
public void setGuardianName(String guardianName) { this.guardianName = guardianName; }
public String getGuardianPhone() { return guardianPhone; }
public void setGuardianPhone(String guardianPhone) { this.guardianPhone = guardianPhone; }
public String getStatus() { return status; }
public void setStatus(String status) { this.status = status; }
}
