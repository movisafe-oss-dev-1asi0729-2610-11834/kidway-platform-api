package com.movisafe.kidway.platform.iam.interfaces.rest;

import com.movisafe.kidway.platform.iam.application.internal.queryservices.UserQueryService;
import com.movisafe.kidway.platform.iam.interfaces.rest.resources.UserResource;
import com.movisafe.kidway.platform.iam.interfaces.rest.transform.UserResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping({"/api/v1/users", "/api/users"})
@Tag(name = "1BC - Identity & Access Management", description = "User query endpoints")
public class UsersController {
    private final UserQueryService queryService;
    public UsersController(UserQueryService queryService) { this.queryService = queryService; }
    @GetMapping
    public List<UserResource> getAll() { return queryService.findAll().stream().map(UserResourceAssembler::toResource).toList(); }
    @GetMapping("/{id}")
    public UserResource getById(@PathVariable Long id) { return UserResourceAssembler.toResource(queryService.findById(id)); }
}
