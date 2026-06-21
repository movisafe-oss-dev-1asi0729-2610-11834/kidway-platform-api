package com.movisafe.kidway.platform.iam.interfaces.rest.resources;

import jakarta.validation.constraints.NotBlank;
public record SignInResource(@NotBlank String usernameOrEmail, @NotBlank String password) { }
