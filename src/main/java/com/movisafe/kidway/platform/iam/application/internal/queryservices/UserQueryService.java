package com.movisafe.kidway.platform.iam.application.internal.queryservices;

import com.movisafe.kidway.platform.iam.domain.model.aggregates.PlatformUser;
import com.movisafe.kidway.platform.iam.infrastructure.persistence.jpa.repositories.PlatformUserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserQueryService {
    private final PlatformUserRepository repository;
    public UserQueryService(PlatformUserRepository repository) { this.repository = repository; }
    public List<PlatformUser> findAll() { return repository.findAll(); }
    public PlatformUser findById(Long id) { return repository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found with id " + id)); }
}
