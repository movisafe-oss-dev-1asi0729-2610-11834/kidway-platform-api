package com.movisafe.kidway.platform.iam.interfaces.rest;

import com.movisafe.kidway.platform.iam.domain.model.entities.Role;
import com.movisafe.kidway.platform.iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping({"/api/v1/roles", "/api/roles"})
@Tag(name = "1BC - Identity & Access Management", description = "Role catalog endpoints")
public class RolesController {
    private final RoleRepository repository;
    public RolesController(RoleRepository repository) { this.repository = repository; }
    @GetMapping
    public List<Role> getAll() { return repository.findAll(); }
}
