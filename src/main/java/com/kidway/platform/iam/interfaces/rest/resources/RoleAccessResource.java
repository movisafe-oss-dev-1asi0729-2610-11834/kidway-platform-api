package com.kidway.platform.iam.interfaces.rest.resources;

import java.util.List;

public record RoleAccessResource(
        String role,
        List<String> allowedModules
) {
}
