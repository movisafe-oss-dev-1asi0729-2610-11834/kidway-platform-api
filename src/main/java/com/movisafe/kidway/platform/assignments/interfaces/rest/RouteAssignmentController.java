package com.movisafe.kidway.platform.assignments.interfaces.rest;

import com.movisafe.kidway.platform.assignments.domain.model.aggregates.RouteAssignment;
import com.movisafe.kidway.platform.assignments.domain.services.RouteAssignmentCommandService;
import com.movisafe.kidway.platform.assignments.domain.services.RouteAssignmentQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/v1/assignments", "/api/assignments", "/api/route-assignments"})
@Tag(name = "9BC - Assignment Management", description = "REST endpoints for 9BC - Assignment Management")
public class RouteAssignmentController {
    private final RouteAssignmentQueryService queryService;
    private final RouteAssignmentCommandService commandService;

    public RouteAssignmentController(RouteAssignmentQueryService queryService, RouteAssignmentCommandService commandService) {
        this.queryService = queryService;
        this.commandService = commandService;
    }

    @GetMapping
    public List<RouteAssignment> getAll() { return queryService.findAll(); }

    @GetMapping("/{id}")
    public RouteAssignment getById(@PathVariable Long id) { return queryService.findById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RouteAssignment create(@RequestBody RouteAssignment resource) { return commandService.create(resource); }

    @PutMapping("/{id}")
    public RouteAssignment update(@PathVariable Long id, @RequestBody RouteAssignment resource) { return commandService.update(id, resource); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { commandService.delete(id); }
}
