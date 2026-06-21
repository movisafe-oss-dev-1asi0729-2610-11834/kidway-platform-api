package com.movisafe.kidway.platform.alerts.application.internal;

import com.movisafe.kidway.platform.alerts.domain.model.aggregates.AlertNotification;
import com.movisafe.kidway.platform.alerts.domain.services.AlertNotificationCommandService;
import com.movisafe.kidway.platform.alerts.domain.services.AlertNotificationQueryService;
import com.movisafe.kidway.platform.alerts.infrastructure.persistence.jpa.repositories.AlertNotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AlertNotificationServiceImpl implements AlertNotificationCommandService, AlertNotificationQueryService {
    private final AlertNotificationRepository repository;
    public AlertNotificationServiceImpl(AlertNotificationRepository repository) { this.repository = repository; }

    @Override
    public List<AlertNotification> findAll() { return repository.findAll(); }

    @Override
    public AlertNotification findById(Long id) { return repository.findById(id).orElseThrow(() -> new NoSuchElementException("AlertNotification not found with id " + id)); }

    @Override
    public AlertNotification create(AlertNotification resource) {
        resource.setId(null);
        return repository.save(resource);
    }

    @Override
    public AlertNotification update(Long id, AlertNotification resource) {
        var existing = findById(id);
    existing.setTitle(resource.getTitle());
    existing.setMessage(resource.getMessage());
    existing.setSeverity(resource.getSeverity());
    existing.setStatus(resource.getStatus());
    existing.setTargetRole(resource.getTargetRole());
    existing.setCreatedAtText(resource.getCreatedAtText());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
