package com.movisafe.kidway.platform.assignments.infrastructure.persistence.jpa.repositories;

import com.movisafe.kidway.platform.assignments.domain.model.aggregates.RouteAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteAssignmentRepository extends JpaRepository<RouteAssignment, Long> { }
