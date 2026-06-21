package com.movisafe.kidway.platform.alerts.interfaces.rest;

import com.movisafe.kidway.platform.alerts.domain.model.aggregates.AlertNotification;
import com.movisafe.kidway.platform.alerts.domain.services.AlertNotificationCommandService;
import com.movisafe.kidway.platform.alerts.domain.services.AlertNotificationQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/v1/alerts-notifications", "/api/alerts-notifications", "/api/alerts", "/api/notifications"})
@Tag(name = "13BC - Alerts & Notifications", description = "REST endpoints for 13BC - Alerts & Notifications")
public class AlertNotificationController {
    private final AlertNotificationQueryService queryService;
    private final AlertNotificationCommandService commandService;

    public AlertNotificationController(AlertNotificationQueryService queryService, AlertNotificationCommandService commandService) {
        this.queryService = queryService;
        this.commandService = commandService;
    }

    @GetMapping
    public List<AlertNotification> getAll() { return queryService.findAll(); }

    @GetMapping("/{id}")
    public AlertNotification getById(@PathVariable Long id) { return queryService.findById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlertNotification create(@RequestBody AlertNotification resource) { return commandService.create(resource); }

    @PutMapping("/{id}")
    public AlertNotification update(@PathVariable Long id, @RequestBody AlertNotification resource) { return commandService.update(id, resource); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { commandService.delete(id); }
}
