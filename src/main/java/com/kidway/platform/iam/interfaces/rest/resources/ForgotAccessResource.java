package com.kidway.platform.iam.interfaces.rest.resources;

import jakarta.validation.constraints.NotBlank;

public record ForgotAccessResource(
        @NotBlank String usernameOrEmail
) {
}
