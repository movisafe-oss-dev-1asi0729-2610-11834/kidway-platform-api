package com.kidway.platform.iam.interfaces.rest;

import com.fasterxml.jackson.databind.JsonNode;
import com.kidway.platform.iam.application.internal.services.AuthApplicationService;
import com.kidway.platform.iam.application.internal.services.RoleAccessService;
import com.kidway.platform.iam.interfaces.rest.resources.*;
import com.kidway.platform.shared.interfaces.rest.resources.ApiMessageResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@Tag(name = "Identity & Access Management", description = "Demo authentication endpoints prepared for future backend IAM integration.")
public class AuthController {
    private final AuthApplicationService authApplicationService;
    private final RoleAccessService roleAccessService;

    public AuthController(AuthApplicationService authApplicationService, RoleAccessService roleAccessService) {
        this.authApplicationService = authApplicationService;
        this.roleAccessService = roleAccessService;
    }

    @PostMapping("/sign-in")
    @Operation(summary = "Sign in", description = "Authenticates a static demo user from the identityUsers collection and returns a demo bearer token plus role modules.")
    public AuthenticatedUserResource signIn(@RequestBody @Valid SignInResource resource) {
        return authApplicationService.signIn(resource);
    }

    @PostMapping("/sign-up")
    @Operation(summary = "Sign up", description = "Creates a pending Parent / Guardian user record. Password confirmation is validated.")
    public AuthenticatedUserResource signUp(@RequestBody @Valid SignUpResource resource) {
        return authApplicationService.signUp(resource);
    }

    @PostMapping("/forgot-access")
    @Operation(summary = "Forgot username or password", description = "Returns a mock recovery response for the current static frontend flow.")
    public ApiMessageResource forgotAccess(@RequestBody @Valid ForgotAccessResource resource) {
        return ApiMessageResource.of("Recovery instructions were generated for " + resource.usernameOrEmail() + ". This is a mock flow for the static frontend version.");
    }

    @GetMapping("/me")
    @Operation(summary = "Get user by username or email", description = "Utility endpoint for validating the current demo account.")
    public JsonNode me(@RequestParam String usernameOrEmail) {
        return authApplicationService.getUserByUsernameOrEmail(usernameOrEmail);
    }

    @GetMapping("/role-access")
    @Operation(summary = "Get allowed modules by role query", description = "Returns visible modules using a query parameter, useful for roles containing slashes such as Parent / Guardian.")
    public RoleAccessResource roleAccessByQuery(@RequestParam String role) {
        return new RoleAccessResource(role, roleAccessService.allowedModulesFor(role));
    }

    @GetMapping("/role-access/{role}")
    @Operation(summary = "Get allowed modules by role", description = "Returns the current module visibility configuration used by the frontend.")
    public RoleAccessResource roleAccess(@PathVariable String role) {
        return new RoleAccessResource(role, roleAccessService.allowedModulesFor(role));
    }
}
