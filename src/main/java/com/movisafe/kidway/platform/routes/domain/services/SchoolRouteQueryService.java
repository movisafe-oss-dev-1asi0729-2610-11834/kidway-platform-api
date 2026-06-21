package com.movisafe.kidway.platform.routes.domain.services;

import com.movisafe.kidway.platform.routes.domain.model.aggregates.SchoolRoute;
import java.util.List;

public interface SchoolRouteQueryService {
    List<SchoolRoute> findAll();
    SchoolRoute findById(Long id);
}
