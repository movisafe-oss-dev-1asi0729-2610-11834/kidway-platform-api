package com.movisafe.kidway.platform.analytics.domain.model.aggregates;

import com.movisafe.kidway.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "monitoring_analytics")
public class AnalyticsReport extends AuditableAbstractAggregateRoot {
private String reportName;
private String period;
private Double attendanceRate;
private Double routeCoverage;
private Integer incidentCount;
private String format;

    public AnalyticsReport() { }

    public AnalyticsReport(String reportName, String period, Double attendanceRate, Double routeCoverage, Integer incidentCount, String format) {
    this.reportName = reportName;
    this.period = period;
    this.attendanceRate = attendanceRate;
    this.routeCoverage = routeCoverage;
    this.incidentCount = incidentCount;
    this.format = format;
    }

public String getReportName() { return reportName; }
public void setReportName(String reportName) { this.reportName = reportName; }
public String getPeriod() { return period; }
public void setPeriod(String period) { this.period = period; }
public Double getAttendanceRate() { return attendanceRate; }
public void setAttendanceRate(Double attendanceRate) { this.attendanceRate = attendanceRate; }
public Double getRouteCoverage() { return routeCoverage; }
public void setRouteCoverage(Double routeCoverage) { this.routeCoverage = routeCoverage; }
public Integer getIncidentCount() { return incidentCount; }
public void setIncidentCount(Integer incidentCount) { this.incidentCount = incidentCount; }
public String getFormat() { return format; }
public void setFormat(String format) { this.format = format; }
}
