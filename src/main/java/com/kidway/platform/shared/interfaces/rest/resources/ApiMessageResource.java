package com.kidway.platform.shared.interfaces.rest.resources;

import java.time.LocalDateTime;

public record ApiMessageResource(
        String message,
        LocalDateTime timestamp
) {
    public static ApiMessageResource of(String message) {
        return new ApiMessageResource(message, LocalDateTime.now());
    }
}
