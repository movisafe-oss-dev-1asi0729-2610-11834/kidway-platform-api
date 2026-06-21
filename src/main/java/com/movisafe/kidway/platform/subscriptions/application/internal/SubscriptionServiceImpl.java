package com.movisafe.kidway.platform.subscriptions.application.internal;

import com.movisafe.kidway.platform.subscriptions.domain.model.aggregates.Subscription;
import com.movisafe.kidway.platform.subscriptions.domain.services.SubscriptionCommandService;
import com.movisafe.kidway.platform.subscriptions.domain.services.SubscriptionQueryService;
import com.movisafe.kidway.platform.subscriptions.infrastructure.persistence.jpa.repositories.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SubscriptionServiceImpl implements SubscriptionCommandService, SubscriptionQueryService {
    private final SubscriptionRepository repository;
    public SubscriptionServiceImpl(SubscriptionRepository repository) { this.repository = repository; }

    @Override
    public List<Subscription> findAll() { return repository.findAll(); }

    @Override
    public Subscription findById(Long id) { return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Subscription not found with id " + id)); }

    @Override
    public Subscription create(Subscription resource) {
        resource.setId(null);
        return repository.save(resource);
    }

    @Override
    public Subscription update(Long id, Subscription resource) {
        var existing = findById(id);
    existing.setSubscriberName(resource.getSubscriberName());
    existing.setPlanName(resource.getPlanName());
    existing.setMonthlyPrice(resource.getMonthlyPrice());
    existing.setCurrency(resource.getCurrency());
    existing.setPaymentStatus(resource.getPaymentStatus());
    existing.setRenewalDate(resource.getRenewalDate());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
