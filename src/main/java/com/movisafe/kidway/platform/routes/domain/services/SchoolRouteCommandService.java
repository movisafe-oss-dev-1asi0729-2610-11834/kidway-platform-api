package com.movisafe.kidway.platform.routes.domain.services;

import com.movisafe.kidway.platform.routes.domain.model.aggregates.SchoolRoute;

public interface SchoolRouteCommandService {
    SchoolRoute create(SchoolRoute resource);
    SchoolRoute update(Long id, SchoolRoute resource);
    void delete(Long id);
}
