package com.movisafe.kidway.platform.fleet.interfaces.rest;

import com.movisafe.kidway.platform.fleet.domain.model.aggregates.Vehicle;
import com.movisafe.kidway.platform.fleet.domain.services.VehicleCommandService;
import com.movisafe.kidway.platform.fleet.domain.services.VehicleQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/v1/fleet", "/api/fleet", "/api/vehicles"})
@Tag(name = "5BC - Fleet Management", description = "REST endpoints for 5BC - Fleet Management")
public class VehicleController {
    private final VehicleQueryService queryService;
    private final VehicleCommandService commandService;

    public VehicleController(VehicleQueryService queryService, VehicleCommandService commandService) {
        this.queryService = queryService;
        this.commandService = commandService;
    }

    @GetMapping
    public List<Vehicle> getAll() { return queryService.findAll(); }

    @GetMapping("/{id}")
    public Vehicle getById(@PathVariable Long id) { return queryService.findById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vehicle create(@RequestBody Vehicle resource) { return commandService.create(resource); }

    @PutMapping("/{id}")
    public Vehicle update(@PathVariable Long id, @RequestBody Vehicle resource) { return commandService.update(id, resource); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { commandService.delete(id); }
}
