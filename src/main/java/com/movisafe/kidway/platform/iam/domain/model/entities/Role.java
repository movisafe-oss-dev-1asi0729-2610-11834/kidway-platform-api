package com.movisafe.kidway.platform.iam.domain.model.entities;

import com.movisafe.kidway.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends AuditableAbstractAggregateRoot {
    @Column(nullable = false, unique = true)
    private String name;
    private String description;
    private String segment;

    public Role() { }
    public Role(String name, String description, String segment) {
        this.name = name;
        this.description = description;
        this.segment = segment;
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getSegment() { return segment; }
    public void setSegment(String segment) { this.segment = segment; }
}
