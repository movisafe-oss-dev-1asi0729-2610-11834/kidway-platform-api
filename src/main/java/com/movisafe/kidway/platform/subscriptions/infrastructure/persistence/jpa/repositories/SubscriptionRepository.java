package com.movisafe.kidway.platform.subscriptions.infrastructure.persistence.jpa.repositories;

import com.movisafe.kidway.platform.subscriptions.domain.model.aggregates.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> { }
