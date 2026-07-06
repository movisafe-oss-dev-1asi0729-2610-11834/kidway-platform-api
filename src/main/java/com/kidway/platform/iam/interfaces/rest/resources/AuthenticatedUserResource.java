package com.kidway.platform.iam.interfaces.rest.resources;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public record AuthenticatedUserResource(
        String token,
        String tokenType,
        JsonNode user,
        List<String> allowedModules
) {
}
