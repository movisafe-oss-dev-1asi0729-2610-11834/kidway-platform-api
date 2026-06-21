package com.movisafe.kidway.platform.iam.interfaces.rest.transform;

import com.movisafe.kidway.platform.iam.domain.model.aggregates.PlatformUser;
import com.movisafe.kidway.platform.iam.interfaces.rest.resources.AuthenticatedUserResource;
import com.movisafe.kidway.platform.iam.interfaces.rest.resources.UserResource;

public class UserResourceAssembler {
    public static UserResource toResource(PlatformUser entity) {
        return new UserResource(entity.getId(), entity.getFirstName(), entity.getLastName(), entity.getUsername(), entity.getEmail(), entity.getRole(), entity.getPhone(), entity.getStatus());
    }
    public static AuthenticatedUserResource toAuthenticatedResource(PlatformUser entity, String token) {
        return new AuthenticatedUserResource(entity.getId(), entity.getFirstName(), entity.getLastName(), entity.getUsername(), entity.getEmail(), entity.getRole(), token);
    }
}
