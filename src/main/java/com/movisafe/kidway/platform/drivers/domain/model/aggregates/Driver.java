package com.movisafe.kidway.platform.drivers.domain.model.aggregates;

import com.movisafe.kidway.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "drivers")
public class Driver extends AuditableAbstractAggregateRoot {
private String fullName;
private String licenseNumber;
private String phone;
private String status;
private String assignedVehicle;
private Double rating;

    public Driver() { }

    public Driver(String fullName, String licenseNumber, String phone, String status, String assignedVehicle, Double rating) {
    this.fullName = fullName;
    this.licenseNumber = licenseNumber;
    this.phone = phone;
    this.status = status;
    this.assignedVehicle = assignedVehicle;
    this.rating = rating;
    }

public String getFullName() { return fullName; }
public void setFullName(String fullName) { this.fullName = fullName; }
public String getLicenseNumber() { return licenseNumber; }
public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }
public String getPhone() { return phone; }
public void setPhone(String phone) { this.phone = phone; }
public String getStatus() { return status; }
public void setStatus(String status) { this.status = status; }
public String getAssignedVehicle() { return assignedVehicle; }
public void setAssignedVehicle(String assignedVehicle) { this.assignedVehicle = assignedVehicle; }
public Double getRating() { return rating; }
public void setRating(Double rating) { this.rating = rating; }
}
