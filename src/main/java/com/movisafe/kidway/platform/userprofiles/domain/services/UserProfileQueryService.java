package com.movisafe.kidway.platform.userprofiles.domain.services;

import com.movisafe.kidway.platform.userprofiles.domain.model.aggregates.UserProfile;
import java.util.List;

public interface UserProfileQueryService {
    List<UserProfile> findAll();
    UserProfile findById(Long id);
}
