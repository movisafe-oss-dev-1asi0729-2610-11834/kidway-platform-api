package com.movisafe.kidway.platform.incidents.domain.model.aggregates;

import com.movisafe.kidway.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "incidents")
public class IncidentReport extends AuditableAbstractAggregateRoot {
private String title;
private String description;
private String routeName;
private String reportedBy;
private String severity;
private String status;

    public IncidentReport() { }

    public IncidentReport(String title, String description, String routeName, String reportedBy, String severity, String status) {
    this.title = title;
    this.description = description;
    this.routeName = routeName;
    this.reportedBy = reportedBy;
    this.severity = severity;
    this.status = status;
    }

public String getTitle() { return title; }
public void setTitle(String title) { this.title = title; }
public String getDescription() { return description; }
public void setDescription(String description) { this.description = description; }
public String getRouteName() { return routeName; }
public void setRouteName(String routeName) { this.routeName = routeName; }
public String getReportedBy() { return reportedBy; }
public void setReportedBy(String reportedBy) { this.reportedBy = reportedBy; }
public String getSeverity() { return severity; }
public void setSeverity(String severity) { this.severity = severity; }
public String getStatus() { return status; }
public void setStatus(String status) { this.status = status; }
}
