package com.movisafe.kidway.platform.userprofiles.application.internal;

import com.movisafe.kidway.platform.userprofiles.domain.model.aggregates.UserProfile;
import com.movisafe.kidway.platform.userprofiles.domain.services.UserProfileCommandService;
import com.movisafe.kidway.platform.userprofiles.domain.services.UserProfileQueryService;
import com.movisafe.kidway.platform.userprofiles.infrastructure.persistence.jpa.repositories.UserProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserProfileServiceImpl implements UserProfileCommandService, UserProfileQueryService {
    private final UserProfileRepository repository;
    public UserProfileServiceImpl(UserProfileRepository repository) { this.repository = repository; }

    @Override
    public List<UserProfile> findAll() { return repository.findAll(); }

    @Override
    public UserProfile findById(Long id) { return repository.findById(id).orElseThrow(() -> new NoSuchElementException("UserProfile not found with id " + id)); }

    @Override
    public UserProfile create(UserProfile resource) {
        resource.setId(null);
        return repository.save(resource);
    }

    @Override
    public UserProfile update(Long id, UserProfile resource) {
        var existing = findById(id);
    existing.setUserEmail(resource.getUserEmail());
    existing.setDisplayName(resource.getDisplayName());
    existing.setRole(resource.getRole());
    existing.setPhone(resource.getPhone());
    existing.setPreferredLanguage(resource.getPreferredLanguage());
    existing.setTimezone(resource.getTimezone());
    existing.setNotificationPreference(resource.getNotificationPreference());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
