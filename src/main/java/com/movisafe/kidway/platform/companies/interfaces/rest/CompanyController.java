package com.movisafe.kidway.platform.companies.interfaces.rest;

import com.movisafe.kidway.platform.companies.domain.model.aggregates.Company;
import com.movisafe.kidway.platform.companies.domain.services.CompanyCommandService;
import com.movisafe.kidway.platform.companies.domain.services.CompanyQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/v1/companies", "/api/companies", "/api/company-management"})
@Tag(name = "16BC - Company Management", description = "REST endpoints for 16BC - Company Management")
public class CompanyController {
    private final CompanyQueryService queryService;
    private final CompanyCommandService commandService;

    public CompanyController(CompanyQueryService queryService, CompanyCommandService commandService) {
        this.queryService = queryService;
        this.commandService = commandService;
    }

    @GetMapping
    public List<Company> getAll() { return queryService.findAll(); }

    @GetMapping("/{id}")
    public Company getById(@PathVariable Long id) { return queryService.findById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Company create(@RequestBody Company resource) { return commandService.create(resource); }

    @PutMapping("/{id}")
    public Company update(@PathVariable Long id, @RequestBody Company resource) { return commandService.update(id, resource); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { commandService.delete(id); }
}
