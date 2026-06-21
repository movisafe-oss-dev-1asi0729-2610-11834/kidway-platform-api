package com.movisafe.kidway.platform.dashboard.interfaces.rest;

import com.movisafe.kidway.platform.dashboard.domain.model.aggregates.DashboardMetric;
import com.movisafe.kidway.platform.dashboard.domain.services.DashboardMetricCommandService;
import com.movisafe.kidway.platform.dashboard.domain.services.DashboardMetricQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/v1/dashboard", "/api/dashboard"})
@Tag(name = "4BC - Dashboard", description = "REST endpoints for 4BC - Dashboard")
public class DashboardMetricController {
    private final DashboardMetricQueryService queryService;
    private final DashboardMetricCommandService commandService;

    public DashboardMetricController(DashboardMetricQueryService queryService, DashboardMetricCommandService commandService) {
        this.queryService = queryService;
        this.commandService = commandService;
    }

    @GetMapping
    public List<DashboardMetric> getAll() { return queryService.findAll(); }

    @GetMapping("/{id}")
    public DashboardMetric getById(@PathVariable Long id) { return queryService.findById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DashboardMetric create(@RequestBody DashboardMetric resource) { return commandService.create(resource); }

    @PutMapping("/{id}")
    public DashboardMetric update(@PathVariable Long id, @RequestBody DashboardMetric resource) { return commandService.update(id, resource); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { commandService.delete(id); }
}
