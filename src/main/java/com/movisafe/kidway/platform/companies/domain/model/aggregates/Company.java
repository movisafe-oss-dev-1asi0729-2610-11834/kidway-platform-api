package com.movisafe.kidway.platform.companies.domain.model.aggregates;

import com.movisafe.kidway.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "companies")
public class Company extends AuditableAbstractAggregateRoot {
private String legalName;
private String ruc;
private String adminName;
private String phone;
private String status;
private Integer fleetSize;

    public Company() { }

    public Company(String legalName, String ruc, String adminName, String phone, String status, Integer fleetSize) {
    this.legalName = legalName;
    this.ruc = ruc;
    this.adminName = adminName;
    this.phone = phone;
    this.status = status;
    this.fleetSize = fleetSize;
    }

public String getLegalName() { return legalName; }
public void setLegalName(String legalName) { this.legalName = legalName; }
public String getRuc() { return ruc; }
public void setRuc(String ruc) { this.ruc = ruc; }
public String getAdminName() { return adminName; }
public void setAdminName(String adminName) { this.adminName = adminName; }
public String getPhone() { return phone; }
public void setPhone(String phone) { this.phone = phone; }
public String getStatus() { return status; }
public void setStatus(String status) { this.status = status; }
public Integer getFleetSize() { return fleetSize; }
public void setFleetSize(Integer fleetSize) { this.fleetSize = fleetSize; }
}
