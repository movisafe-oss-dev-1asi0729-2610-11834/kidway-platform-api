package com.movisafe.kidway.platform.iam.interfaces.rest;

import com.movisafe.kidway.platform.iam.application.internal.commandservices.AuthenticationService;
import com.movisafe.kidway.platform.iam.interfaces.rest.resources.AuthenticatedUserResource;
import com.movisafe.kidway.platform.iam.interfaces.rest.resources.SignInResource;
import com.movisafe.kidway.platform.iam.interfaces.rest.resources.SignUpResource;
import com.movisafe.kidway.platform.iam.interfaces.rest.transform.UserResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/api/v1/authentication", "/api/authentication", "/api/auth"})
@Tag(name = "1BC - Identity & Access Management", description = "Authentication endpoints for KidWay platform users")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    public AuthenticationController(AuthenticationService authenticationService) { this.authenticationService = authenticationService; }

    @PostMapping("/sign-in")
    public AuthenticatedUserResource signIn(@Valid @RequestBody SignInResource resource) {
        var authenticated = authenticationService.authenticate(resource.usernameOrEmail(), resource.password());
        return UserResourceAssembler.toAuthenticatedResource(authenticated.user(), authenticated.token());
    }

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthenticatedUserResource signUp(@Valid @RequestBody SignUpResource resource) {
        var user = authenticationService.signUp(resource.firstName(), resource.lastName(), resource.username(), resource.email(), resource.password(), resource.role(), resource.phone());
        return UserResourceAssembler.toAuthenticatedResource(user, "kidway-token-" + user.getId());
    }
}
