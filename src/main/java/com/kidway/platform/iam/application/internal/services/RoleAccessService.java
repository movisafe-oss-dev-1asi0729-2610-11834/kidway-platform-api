package com.kidway.platform.iam.application.internal.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoleAccessService {
    private final Map<String, List<String>> accessByRole = Map.of(
            "Company Admin", List.of(
                    "dashboard", "fleet", "drivers", "routes", "students", "assignments", "tracking",
                    "trips", "attendance", "notifications", "incidents", "analytics", "companies", "profile", "subscriptions"
            ),
            "Parent / Guardian", List.of(
                    "dashboard", "students", "assignments", "tracking", "trips", "attendance", "notifications", "profile"
            ),
            "Independent Operator", List.of(
                    "dashboard", "fleet", "drivers", "routes", "tracking", "trips", "attendance", "notifications", "incidents", "analytics", "profile", "subscriptions"
            ),
            "KidWay Administrator", List.of(
                    "dashboard", "fleet", "drivers", "routes", "students", "assignments", "tracking",
                    "trips", "attendance", "notifications", "incidents", "analytics", "companies", "profile", "subscriptions"
            )
    );

    public List<String> allowedModulesFor(String role) {
        return accessByRole.getOrDefault(role, List.of("dashboard", "profile"));
    }
}
