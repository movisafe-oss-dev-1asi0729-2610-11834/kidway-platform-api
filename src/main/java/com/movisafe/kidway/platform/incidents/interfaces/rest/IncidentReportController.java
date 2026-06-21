package com.movisafe.kidway.platform.incidents.interfaces.rest;

import com.movisafe.kidway.platform.incidents.domain.model.aggregates.IncidentReport;
import com.movisafe.kidway.platform.incidents.domain.services.IncidentReportCommandService;
import com.movisafe.kidway.platform.incidents.domain.services.IncidentReportQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/v1/incidents", "/api/incidents", "/api/incident-management"})
@Tag(name = "14BC - Incident Management", description = "REST endpoints for 14BC - Incident Management")
public class IncidentReportController {
    private final IncidentReportQueryService queryService;
    private final IncidentReportCommandService commandService;

    public IncidentReportController(IncidentReportQueryService queryService, IncidentReportCommandService commandService) {
        this.queryService = queryService;
        this.commandService = commandService;
    }

    @GetMapping
    public List<IncidentReport> getAll() { return queryService.findAll(); }

    @GetMapping("/{id}")
    public IncidentReport getById(@PathVariable Long id) { return queryService.findById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IncidentReport create(@RequestBody IncidentReport resource) { return commandService.create(resource); }

    @PutMapping("/{id}")
    public IncidentReport update(@PathVariable Long id, @RequestBody IncidentReport resource) { return commandService.update(id, resource); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { commandService.delete(id); }
}
