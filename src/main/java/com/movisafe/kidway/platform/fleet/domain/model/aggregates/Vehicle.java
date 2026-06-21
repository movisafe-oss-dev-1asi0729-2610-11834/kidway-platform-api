package com.movisafe.kidway.platform.fleet.domain.model.aggregates;

import com.movisafe.kidway.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "fleet")
public class Vehicle extends AuditableAbstractAggregateRoot {
private String plate;
private String model;
private Integer capacity;
private String status;
private String companyName;
private String currentRoute;

    public Vehicle() { }

    public Vehicle(String plate, String model, Integer capacity, String status, String companyName, String currentRoute) {
    this.plate = plate;
    this.model = model;
    this.capacity = capacity;
    this.status = status;
    this.companyName = companyName;
    this.currentRoute = currentRoute;
    }

public String getPlate() { return plate; }
public void setPlate(String plate) { this.plate = plate; }
public String getModel() { return model; }
public void setModel(String model) { this.model = model; }
public Integer getCapacity() { return capacity; }
public void setCapacity(Integer capacity) { this.capacity = capacity; }
public String getStatus() { return status; }
public void setStatus(String status) { this.status = status; }
public String getCompanyName() { return companyName; }
public void setCompanyName(String companyName) { this.companyName = companyName; }
public String getCurrentRoute() { return currentRoute; }
public void setCurrentRoute(String currentRoute) { this.currentRoute = currentRoute; }
}
