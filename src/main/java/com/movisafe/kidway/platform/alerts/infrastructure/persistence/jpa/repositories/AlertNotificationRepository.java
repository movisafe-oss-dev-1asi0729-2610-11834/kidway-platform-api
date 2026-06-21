package com.movisafe.kidway.platform.alerts.infrastructure.persistence.jpa.repositories;

import com.movisafe.kidway.platform.alerts.domain.model.aggregates.AlertNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertNotificationRepository extends JpaRepository<AlertNotification, Long> { }
