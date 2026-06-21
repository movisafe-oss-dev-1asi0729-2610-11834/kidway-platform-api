package com.movisafe.kidway.platform.subscriptions.domain.services;

import com.movisafe.kidway.platform.subscriptions.domain.model.aggregates.Subscription;

public interface SubscriptionCommandService {
    Subscription create(Subscription resource);
    Subscription update(Long id, Subscription resource);
    void delete(Long id);
}
