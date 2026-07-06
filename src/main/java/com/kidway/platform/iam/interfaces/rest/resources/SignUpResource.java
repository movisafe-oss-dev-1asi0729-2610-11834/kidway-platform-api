package com.kidway.platform.iam.interfaces.rest.resources;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SignUpResource(
        @NotBlank String firstName,
        @NotBlank String lastName,
        @NotBlank String phone,
        @NotBlank String country,
        @NotBlank String username,
        @Email @NotBlank String email,
        @Size(min = 8) String password,
        @Size(min = 8) String repeatPassword
) {
}
