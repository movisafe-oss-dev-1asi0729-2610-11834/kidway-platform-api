package com.movisafe.kidway.platform.drivers.interfaces.rest;

import com.movisafe.kidway.platform.drivers.domain.model.aggregates.Driver;
import com.movisafe.kidway.platform.drivers.domain.services.DriverCommandService;
import com.movisafe.kidway.platform.drivers.domain.services.DriverQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/v1/drivers", "/api/drivers"})
@Tag(name = "6BC - Driver Management", description = "REST endpoints for 6BC - Driver Management")
public class DriverController {
    private final DriverQueryService queryService;
    private final DriverCommandService commandService;

    public DriverController(DriverQueryService queryService, DriverCommandService commandService) {
        this.queryService = queryService;
        this.commandService = commandService;
    }

    @GetMapping
    public List<Driver> getAll() { return queryService.findAll(); }

    @GetMapping("/{id}")
    public Driver getById(@PathVariable Long id) { return queryService.findById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Driver create(@RequestBody Driver resource) { return commandService.create(resource); }

    @PutMapping("/{id}")
    public Driver update(@PathVariable Long id, @RequestBody Driver resource) { return commandService.update(id, resource); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { commandService.delete(id); }
}
