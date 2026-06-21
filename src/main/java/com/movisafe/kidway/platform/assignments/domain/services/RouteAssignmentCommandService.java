package com.movisafe.kidway.platform.assignments.domain.services;

import com.movisafe.kidway.platform.assignments.domain.model.aggregates.RouteAssignment;

public interface RouteAssignmentCommandService {
    RouteAssignment create(RouteAssignment resource);
    RouteAssignment update(Long id, RouteAssignment resource);
    void delete(Long id);
}
