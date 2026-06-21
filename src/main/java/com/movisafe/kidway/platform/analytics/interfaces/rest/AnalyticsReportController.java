package com.movisafe.kidway.platform.analytics.interfaces.rest;

import com.movisafe.kidway.platform.analytics.domain.model.aggregates.AnalyticsReport;
import com.movisafe.kidway.platform.analytics.domain.services.AnalyticsReportCommandService;
import com.movisafe.kidway.platform.analytics.domain.services.AnalyticsReportQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/v1/monitoring-analytics", "/api/monitoring-analytics", "/api/analytics", "/api/reports"})
@Tag(name = "15BC - Monitoring & Analytics", description = "REST endpoints for 15BC - Monitoring & Analytics")
public class AnalyticsReportController {
    private final AnalyticsReportQueryService queryService;
    private final AnalyticsReportCommandService commandService;

    public AnalyticsReportController(AnalyticsReportQueryService queryService, AnalyticsReportCommandService commandService) {
        this.queryService = queryService;
        this.commandService = commandService;
    }

    @GetMapping
    public List<AnalyticsReport> getAll() { return queryService.findAll(); }

    @GetMapping("/{id}")
    public AnalyticsReport getById(@PathVariable Long id) { return queryService.findById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AnalyticsReport create(@RequestBody AnalyticsReport resource) { return commandService.create(resource); }

    @PutMapping("/{id}")
    public AnalyticsReport update(@PathVariable Long id, @RequestBody AnalyticsReport resource) { return commandService.update(id, resource); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { commandService.delete(id); }
}
