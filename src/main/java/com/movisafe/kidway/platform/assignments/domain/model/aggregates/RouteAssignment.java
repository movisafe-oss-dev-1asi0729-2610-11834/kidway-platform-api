package com.movisafe.kidway.platform.assignments.domain.model.aggregates;

import com.movisafe.kidway.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "assignments")
public class RouteAssignment extends AuditableAbstractAggregateRoot {
private String routeName;
private String driverName;
private String vehiclePlate;
private String studentName;
private String pickupStop;
private String status;

    public RouteAssignment() { }

    public RouteAssignment(String routeName, String driverName, String vehiclePlate, String studentName, String pickupStop, String status) {
    this.routeName = routeName;
    this.driverName = driverName;
    this.vehiclePlate = vehiclePlate;
    this.studentName = studentName;
    this.pickupStop = pickupStop;
    this.status = status;
    }

public String getRouteName() { return routeName; }
public void setRouteName(String routeName) { this.routeName = routeName; }
public String getDriverName() { return driverName; }
public void setDriverName(String driverName) { this.driverName = driverName; }
public String getVehiclePlate() { return vehiclePlate; }
public void setVehiclePlate(String vehiclePlate) { this.vehiclePlate = vehiclePlate; }
public String getStudentName() { return studentName; }
public void setStudentName(String studentName) { this.studentName = studentName; }
public String getPickupStop() { return pickupStop; }
public void setPickupStop(String pickupStop) { this.pickupStop = pickupStop; }
public String getStatus() { return status; }
public void setStatus(String status) { this.status = status; }
}
