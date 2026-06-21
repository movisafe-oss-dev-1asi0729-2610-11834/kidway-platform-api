package com.movisafe.kidway.platform.iam.interfaces.rest.resources;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
public record SignUpResource(
        @NotBlank String firstName,
        @NotBlank String lastName,
        @NotBlank String username,
        @Email @NotBlank String email,
        @NotBlank String password,
        String role,
        String phone) { }
