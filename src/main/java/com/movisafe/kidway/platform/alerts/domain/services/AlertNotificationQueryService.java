package com.movisafe.kidway.platform.alerts.domain.services;

import com.movisafe.kidway.platform.alerts.domain.model.aggregates.AlertNotification;
import java.util.List;

public interface AlertNotificationQueryService {
    List<AlertNotification> findAll();
    AlertNotification findById(Long id);
}
