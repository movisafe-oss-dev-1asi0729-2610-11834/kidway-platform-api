package com.movisafe.kidway.platform.trips.interfaces.rest;

import com.movisafe.kidway.platform.trips.domain.model.aggregates.Trip;
import com.movisafe.kidway.platform.trips.domain.services.TripCommandService;
import com.movisafe.kidway.platform.trips.domain.services.TripQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/v1/trips", "/api/trips", "/api/trip-management"})
@Tag(name = "11BC - Trip Management", description = "REST endpoints for 11BC - Trip Management")
public class TripController {
    private final TripQueryService queryService;
    private final TripCommandService commandService;

    public TripController(TripQueryService queryService, TripCommandService commandService) {
        this.queryService = queryService;
        this.commandService = commandService;
    }

    @GetMapping
    public List<Trip> getAll() { return queryService.findAll(); }

    @GetMapping("/{id}")
    public Trip getById(@PathVariable Long id) { return queryService.findById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Trip create(@RequestBody Trip resource) { return commandService.create(resource); }

    @PutMapping("/{id}")
    public Trip update(@PathVariable Long id, @RequestBody Trip resource) { return commandService.update(id, resource); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { commandService.delete(id); }
}
