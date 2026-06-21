package com.movisafe.kidway.platform.alerts.domain.services;

import com.movisafe.kidway.platform.alerts.domain.model.aggregates.AlertNotification;

public interface AlertNotificationCommandService {
    AlertNotification create(AlertNotification resource);
    AlertNotification update(Long id, AlertNotification resource);
    void delete(Long id);
}
