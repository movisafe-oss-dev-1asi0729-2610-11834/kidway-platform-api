package com.movisafe.kidway.platform.userprofiles.interfaces.rest;

import com.movisafe.kidway.platform.userprofiles.domain.model.aggregates.UserProfile;
import com.movisafe.kidway.platform.userprofiles.domain.services.UserProfileCommandService;
import com.movisafe.kidway.platform.userprofiles.domain.services.UserProfileQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/v1/user-profiles", "/api/user-profiles", "/api/userProfiles"})
@Tag(name = "2BC - User Profiles", description = "REST endpoints for 2BC - User Profiles")
public class UserProfileController {
    private final UserProfileQueryService queryService;
    private final UserProfileCommandService commandService;

    public UserProfileController(UserProfileQueryService queryService, UserProfileCommandService commandService) {
        this.queryService = queryService;
        this.commandService = commandService;
    }

    @GetMapping
    public List<UserProfile> getAll() { return queryService.findAll(); }

    @GetMapping("/{id}")
    public UserProfile getById(@PathVariable Long id) { return queryService.findById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserProfile create(@RequestBody UserProfile resource) { return commandService.create(resource); }

    @PutMapping("/{id}")
    public UserProfile update(@PathVariable Long id, @RequestBody UserProfile resource) { return commandService.update(id, resource); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { commandService.delete(id); }
}
