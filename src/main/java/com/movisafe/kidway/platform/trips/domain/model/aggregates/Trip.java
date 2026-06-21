package com.movisafe.kidway.platform.trips.domain.model.aggregates;

import com.movisafe.kidway.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "trips")
public class Trip extends AuditableAbstractAggregateRoot {
private String routeName;
private String driverName;
private String vehiclePlate;
private String startedAt;
private String endedAt;
private String status;

    public Trip() { }

    public Trip(String routeName, String driverName, String vehiclePlate, String startedAt, String endedAt, String status) {
    this.routeName = routeName;
    this.driverName = driverName;
    this.vehiclePlate = vehiclePlate;
    this.startedAt = startedAt;
    this.endedAt = endedAt;
    this.status = status;
    }

public String getRouteName() { return routeName; }
public void setRouteName(String routeName) { this.routeName = routeName; }
public String getDriverName() { return driverName; }
public void setDriverName(String driverName) { this.driverName = driverName; }
public String getVehiclePlate() { return vehiclePlate; }
public void setVehiclePlate(String vehiclePlate) { this.vehiclePlate = vehiclePlate; }
public String getStartedAt() { return startedAt; }
public void setStartedAt(String startedAt) { this.startedAt = startedAt; }
public String getEndedAt() { return endedAt; }
public void setEndedAt(String endedAt) { this.endedAt = endedAt; }
public String getStatus() { return status; }
public void setStatus(String status) { this.status = status; }
}
