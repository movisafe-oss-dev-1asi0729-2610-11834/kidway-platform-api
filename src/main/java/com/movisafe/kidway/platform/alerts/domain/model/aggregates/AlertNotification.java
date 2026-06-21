package com.movisafe.kidway.platform.alerts.domain.model.aggregates;

import com.movisafe.kidway.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "alerts_notifications")
public class AlertNotification extends AuditableAbstractAggregateRoot {
private String title;
private String message;
private String severity;
private String status;
private String targetRole;
private String createdAtText;

    public AlertNotification() { }

    public AlertNotification(String title, String message, String severity, String status, String targetRole, String createdAtText) {
    this.title = title;
    this.message = message;
    this.severity = severity;
    this.status = status;
    this.targetRole = targetRole;
    this.createdAtText = createdAtText;
    }

public String getTitle() { return title; }
public void setTitle(String title) { this.title = title; }
public String getMessage() { return message; }
public void setMessage(String message) { this.message = message; }
public String getSeverity() { return severity; }
public void setSeverity(String severity) { this.severity = severity; }
public String getStatus() { return status; }
public void setStatus(String status) { this.status = status; }
public String getTargetRole() { return targetRole; }
public void setTargetRole(String targetRole) { this.targetRole = targetRole; }
public String getCreatedAtText() { return createdAtText; }
public void setCreatedAtText(String createdAtText) { this.createdAtText = createdAtText; }
}
