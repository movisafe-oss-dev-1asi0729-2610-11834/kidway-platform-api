package com.movisafe.kidway.platform.iam.interfaces.rest.resources;

public record UserResource(Long id, String firstName, String lastName, String username, String email, String role, String phone, String status) { }
