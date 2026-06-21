package com.movisafe.kidway.platform.routes.interfaces.rest;

import com.movisafe.kidway.platform.routes.domain.model.aggregates.SchoolRoute;
import com.movisafe.kidway.platform.routes.domain.services.SchoolRouteCommandService;
import com.movisafe.kidway.platform.routes.domain.services.SchoolRouteQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/v1/routes", "/api/routes", "/api/school-routes"})
@Tag(name = "7BC - Route Management", description = "REST endpoints for 7BC - Route Management")
public class SchoolRouteController {
    private final SchoolRouteQueryService queryService;
    private final SchoolRouteCommandService commandService;

    public SchoolRouteController(SchoolRouteQueryService queryService, SchoolRouteCommandService commandService) {
        this.queryService = queryService;
        this.commandService = commandService;
    }

    @GetMapping
    public List<SchoolRoute> getAll() { return queryService.findAll(); }

    @GetMapping("/{id}")
    public SchoolRoute getById(@PathVariable Long id) { return queryService.findById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SchoolRoute create(@RequestBody SchoolRoute resource) { return commandService.create(resource); }

    @PutMapping("/{id}")
    public SchoolRoute update(@PathVariable Long id, @RequestBody SchoolRoute resource) { return commandService.update(id, resource); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { commandService.delete(id); }
}
