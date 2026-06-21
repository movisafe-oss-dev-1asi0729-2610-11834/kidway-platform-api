package com.movisafe.kidway.platform.iam.infrastructure.hashing.bcrypt.services;

import com.movisafe.kidway.platform.iam.application.internal.outboundservices.hashing.HashingService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BcryptHashingService implements HashingService {
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Override
    public String encode(String rawPassword) { return encoder.encode(rawPassword); }
    @Override
    public boolean matches(String rawPassword, String passwordHash) { return encoder.matches(rawPassword, passwordHash); }
}
