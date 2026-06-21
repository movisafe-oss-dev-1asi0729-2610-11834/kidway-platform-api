package com.movisafe.kidway.platform.routes.domain.model.aggregates;

import com.movisafe.kidway.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "routes")
public class SchoolRoute extends AuditableAbstractAggregateRoot {
private String name;
private String originDistrict;
private String destinationSchool;
private String schedule;
private String status;
private Integer estimatedMinutes;

    public SchoolRoute() { }

    public SchoolRoute(String name, String originDistrict, String destinationSchool, String schedule, String status, Integer estimatedMinutes) {
    this.name = name;
    this.originDistrict = originDistrict;
    this.destinationSchool = destinationSchool;
    this.schedule = schedule;
    this.status = status;
    this.estimatedMinutes = estimatedMinutes;
    }

public String getName() { return name; }
public void setName(String name) { this.name = name; }
public String getOriginDistrict() { return originDistrict; }
public void setOriginDistrict(String originDistrict) { this.originDistrict = originDistrict; }
public String getDestinationSchool() { return destinationSchool; }
public void setDestinationSchool(String destinationSchool) { this.destinationSchool = destinationSchool; }
public String getSchedule() { return schedule; }
public void setSchedule(String schedule) { this.schedule = schedule; }
public String getStatus() { return status; }
public void setStatus(String status) { this.status = status; }
public Integer getEstimatedMinutes() { return estimatedMinutes; }
public void setEstimatedMinutes(Integer estimatedMinutes) { this.estimatedMinutes = estimatedMinutes; }
}
