package com.movisafe.kidway.platform.subscriptions.domain.services;

import com.movisafe.kidway.platform.subscriptions.domain.model.aggregates.Subscription;
import java.util.List;

public interface SubscriptionQueryService {
    List<Subscription> findAll();
    Subscription findById(Long id);
}
