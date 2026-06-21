package com.movisafe.kidway.platform.tracking.domain.services;

import com.movisafe.kidway.platform.tracking.domain.model.aggregates.TrackingEvent;
import java.util.List;

public interface TrackingEventQueryService {
    List<TrackingEvent> findAll();
    TrackingEvent findById(Long id);
}
