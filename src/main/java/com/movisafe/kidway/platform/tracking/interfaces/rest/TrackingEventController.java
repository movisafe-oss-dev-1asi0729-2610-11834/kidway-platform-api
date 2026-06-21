package com.movisafe.kidway.platform.tracking.interfaces.rest;

import com.movisafe.kidway.platform.tracking.domain.model.aggregates.TrackingEvent;
import com.movisafe.kidway.platform.tracking.domain.services.TrackingEventCommandService;
import com.movisafe.kidway.platform.tracking.domain.services.TrackingEventQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/v1/real-time-tracking", "/api/real-time-tracking", "/api/tracking"})
@Tag(name = "10BC - Real-Time Tracking", description = "REST endpoints for 10BC - Real-Time Tracking")
public class TrackingEventController {
    private final TrackingEventQueryService queryService;
    private final TrackingEventCommandService commandService;

    public TrackingEventController(TrackingEventQueryService queryService, TrackingEventCommandService commandService) {
        this.queryService = queryService;
        this.commandService = commandService;
    }

    @GetMapping
    public List<TrackingEvent> getAll() { return queryService.findAll(); }

    @GetMapping("/{id}")
    public TrackingEvent getById(@PathVariable Long id) { return queryService.findById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TrackingEvent create(@RequestBody TrackingEvent resource) { return commandService.create(resource); }

    @PutMapping("/{id}")
    public TrackingEvent update(@PathVariable Long id, @RequestBody TrackingEvent resource) { return commandService.update(id, resource); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { commandService.delete(id); }
}
