package com.movisafe.kidway.platform.tracking.infrastructure.persistence.jpa.repositories;

import com.movisafe.kidway.platform.tracking.domain.model.aggregates.TrackingEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackingEventRepository extends JpaRepository<TrackingEvent, Long> { }
