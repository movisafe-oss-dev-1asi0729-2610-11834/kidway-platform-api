package com.movisafe.kidway.platform.dashboard.domain.model.aggregates;

import com.movisafe.kidway.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "dashboard")
public class DashboardMetric extends AuditableAbstractAggregateRoot {
private String metricKey;
private String metricLabel;
private Double metricValue;
private String unit;
private String scope;
private String trend;

    public DashboardMetric() { }

    public DashboardMetric(String metricKey, String metricLabel, Double metricValue, String unit, String scope, String trend) {
    this.metricKey = metricKey;
    this.metricLabel = metricLabel;
    this.metricValue = metricValue;
    this.unit = unit;
    this.scope = scope;
    this.trend = trend;
    }

public String getMetricKey() { return metricKey; }
public void setMetricKey(String metricKey) { this.metricKey = metricKey; }
public String getMetricLabel() { return metricLabel; }
public void setMetricLabel(String metricLabel) { this.metricLabel = metricLabel; }
public Double getMetricValue() { return metricValue; }
public void setMetricValue(Double metricValue) { this.metricValue = metricValue; }
public String getUnit() { return unit; }
public void setUnit(String unit) { this.unit = unit; }
public String getScope() { return scope; }
public void setScope(String scope) { this.scope = scope; }
public String getTrend() { return trend; }
public void setTrend(String trend) { this.trend = trend; }
}
