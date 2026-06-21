package com.movisafe.kidway.platform.tracking.domain.model.aggregates;

import com.movisafe.kidway.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "real_time_tracking")
public class TrackingEvent extends AuditableAbstractAggregateRoot {
private String vehiclePlate;
private Double latitude;
private Double longitude;
private String speed;
private String eventTime;
private String status;

    public TrackingEvent() { }

    public TrackingEvent(String vehiclePlate, Double latitude, Double longitude, String speed, String eventTime, String status) {
    this.vehiclePlate = vehiclePlate;
    this.latitude = latitude;
    this.longitude = longitude;
    this.speed = speed;
    this.eventTime = eventTime;
    this.status = status;
    }

public String getVehiclePlate() { return vehiclePlate; }
public void setVehiclePlate(String vehiclePlate) { this.vehiclePlate = vehiclePlate; }
public Double getLatitude() { return latitude; }
public void setLatitude(Double latitude) { this.latitude = latitude; }
public Double getLongitude() { return longitude; }
public void setLongitude(Double longitude) { this.longitude = longitude; }
public String getSpeed() { return speed; }
public void setSpeed(String speed) { this.speed = speed; }
public String getEventTime() { return eventTime; }
public void setEventTime(String eventTime) { this.eventTime = eventTime; }
public String getStatus() { return status; }
public void setStatus(String status) { this.status = status; }
}
