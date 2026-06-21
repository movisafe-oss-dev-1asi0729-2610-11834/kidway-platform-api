package com.movisafe.kidway.platform.assignments.domain.services;

import com.movisafe.kidway.platform.assignments.domain.model.aggregates.RouteAssignment;
import java.util.List;

public interface RouteAssignmentQueryService {
    List<RouteAssignment> findAll();
    RouteAssignment findById(Long id);
}
