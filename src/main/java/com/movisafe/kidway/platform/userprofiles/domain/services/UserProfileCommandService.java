package com.movisafe.kidway.platform.userprofiles.domain.services;

import com.movisafe.kidway.platform.userprofiles.domain.model.aggregates.UserProfile;

public interface UserProfileCommandService {
    UserProfile create(UserProfile resource);
    UserProfile update(Long id, UserProfile resource);
    void delete(Long id);
}
