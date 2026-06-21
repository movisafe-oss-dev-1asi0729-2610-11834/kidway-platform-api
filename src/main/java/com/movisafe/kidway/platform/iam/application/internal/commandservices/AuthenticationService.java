package com.movisafe.kidway.platform.iam.application.internal.commandservices;

import com.movisafe.kidway.platform.iam.application.internal.outboundservices.hashing.HashingService;
import com.movisafe.kidway.platform.iam.domain.model.aggregates.PlatformUser;
import com.movisafe.kidway.platform.iam.infrastructure.persistence.jpa.repositories.PlatformUserRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class AuthenticationService {
    private final PlatformUserRepository userRepository;
    private final HashingService hashingService;

    public AuthenticationService(PlatformUserRepository userRepository, HashingService hashingService) {
        this.userRepository = userRepository;
        this.hashingService = hashingService;
    }

    public PlatformUser signUp(String firstName, String lastName, String username, String email, String password, String role, String phone) {
        if (userRepository.existsByUsername(username)) throw new IllegalArgumentException("Username already exists");
        if (userRepository.existsByEmail(email)) throw new IllegalArgumentException("Email already exists");
        var normalizedRole = (role == null || role.isBlank()) ? "PARENT_GUARDIAN" : role;
        return userRepository.save(new PlatformUser(firstName, lastName, username, email, hashingService.encode(password), normalizedRole, phone, "ACTIVE"));
    }

    public AuthenticatedUser authenticate(String usernameOrEmail, String password) {
        var user = userRepository.findByUsername(usernameOrEmail)
                .or(() -> userRepository.findByEmail(usernameOrEmail))
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        if (!hashingService.matches(password, user.getPasswordHash())) throw new IllegalArgumentException("Invalid credentials");
        var token = "kidway-token-" + user.getId() + "-" + UUID.randomUUID();
        return new AuthenticatedUser(user, token);
    }

    public record AuthenticatedUser(PlatformUser user, String token) { }
}
