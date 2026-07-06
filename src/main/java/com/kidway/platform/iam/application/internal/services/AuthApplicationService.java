package com.kidway.platform.iam.application.internal.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.kidway.platform.iam.interfaces.rest.resources.AuthenticatedUserResource;
import com.kidway.platform.iam.interfaces.rest.resources.SignInResource;
import com.kidway.platform.iam.interfaces.rest.resources.SignUpResource;
import com.kidway.platform.shared.application.internal.services.JsonResourceService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Base64;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthApplicationService {
    private final JsonResourceService jsonResourceService;
    private final RoleAccessService roleAccessService;
    private final ObjectMapper objectMapper;

    public AuthApplicationService(JsonResourceService jsonResourceService, RoleAccessService roleAccessService, ObjectMapper objectMapper) {
        this.jsonResourceService = jsonResourceService;
        this.roleAccessService = roleAccessService;
        this.objectMapper = objectMapper;
    }

    public AuthenticatedUserResource signIn(SignInResource resource) {
        JsonNode user = findUser(resource.usernameOrEmail())
                .orElseThrow(() -> new EntityNotFoundException("Invalid username or password."));
        String storedPassword = user.path("password").asText();
        if (!storedPassword.equals(resource.password())) {
            throw new EntityNotFoundException("Invalid username or password.");
        }
        String role = user.path("role").asText("User");
        return new AuthenticatedUserResource(
                createDemoToken(user.path("username").asText(), role),
                "Bearer",
                sanitizeUser(user),
                roleAccessService.allowedModulesFor(role)
        );
    }

    public AuthenticatedUserResource signUp(SignUpResource resource) {
        if (!resource.password().equals(resource.repeatPassword())) {
            throw new IllegalArgumentException("Passwords do not match.");
        }
        if (findUser(resource.username()).isPresent() || findUser(resource.email()).isPresent()) {
            throw new IllegalArgumentException("Username or email is already registered.");
        }
        ObjectNode user = objectMapper.createObjectNode();
        String id = "usr-" + UUID.randomUUID();
        user.put("id", id);
        user.put("firstName", resource.firstName());
        user.put("lastName", resource.lastName());
        user.put("displayName", resource.firstName() + " " + resource.lastName());
        user.put("username", resource.username());
        user.put("email", resource.email());
        user.put("phone", resource.phone());
        user.put("country", resource.country());
        user.put("role", "Parent / Guardian");
        user.put("company", "Pending account validation");
        user.put("avatarInitials", initials(resource.firstName(), resource.lastName()));
        user.put("accountStatus", "pending-validation");
        user.put("password", resource.password());
        JsonNode created = jsonResourceService.createResource("identityUsers", user);
        String role = created.path("role").asText("Parent / Guardian");
        return new AuthenticatedUserResource(
                createDemoToken(created.path("username").asText(), role),
                "Bearer",
                sanitizeUser(created),
                roleAccessService.allowedModulesFor(role)
        );
    }

    public JsonNode getUserByUsernameOrEmail(String usernameOrEmail) {
        return findUser(usernameOrEmail)
                .map(this::sanitizeUser)
                .orElseThrow(() -> new EntityNotFoundException("User not found: " + usernameOrEmail));
    }

    private Optional<JsonNode> findUser(String usernameOrEmail) {
        return jsonResourceService.findAllArrayItems("identityUsers").stream()
                .filter(user -> usernameOrEmail.equalsIgnoreCase(user.path("username").asText())
                        || usernameOrEmail.equalsIgnoreCase(user.path("email").asText()))
                .findFirst();
    }

    private JsonNode sanitizeUser(JsonNode user) {
        ObjectNode copy = (ObjectNode) user.deepCopy();
        copy.remove("password");
        return copy;
    }

    private String createDemoToken(String username, String role) {
        String payload = username + ":" + role + ":" + Instant.now();
        return Base64.getUrlEncoder().withoutPadding().encodeToString(payload.getBytes(StandardCharsets.UTF_8));
    }

    private String initials(String firstName, String lastName) {
        return (firstName.substring(0, 1) + lastName.substring(0, 1)).toUpperCase();
    }
}
