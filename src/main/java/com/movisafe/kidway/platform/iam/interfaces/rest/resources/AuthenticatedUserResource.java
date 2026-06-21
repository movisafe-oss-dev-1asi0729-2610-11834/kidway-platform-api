package com.movisafe.kidway.platform.iam.interfaces.rest.resources;

public record AuthenticatedUserResource(Long id, String firstName, String lastName, String username, String email, String role, String token) { }
