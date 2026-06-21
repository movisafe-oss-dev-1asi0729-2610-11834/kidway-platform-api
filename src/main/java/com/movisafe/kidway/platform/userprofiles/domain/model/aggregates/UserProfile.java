package com.movisafe.kidway.platform.userprofiles.domain.model.aggregates;

import com.movisafe.kidway.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_profiles")
public class UserProfile extends AuditableAbstractAggregateRoot {
private String userEmail;
private String displayName;
private String role;
private String phone;
private String preferredLanguage;
private String timezone;
private String notificationPreference;

    public UserProfile() { }

    public UserProfile(String userEmail, String displayName, String role, String phone, String preferredLanguage, String timezone, String notificationPreference) {
    this.userEmail = userEmail;
    this.displayName = displayName;
    this.role = role;
    this.phone = phone;
    this.preferredLanguage = preferredLanguage;
    this.timezone = timezone;
    this.notificationPreference = notificationPreference;
    }

public String getUserEmail() { return userEmail; }
public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
public String getDisplayName() { return displayName; }
public void setDisplayName(String displayName) { this.displayName = displayName; }
public String getRole() { return role; }
public void setRole(String role) { this.role = role; }
public String getPhone() { return phone; }
public void setPhone(String phone) { this.phone = phone; }
public String getPreferredLanguage() { return preferredLanguage; }
public void setPreferredLanguage(String preferredLanguage) { this.preferredLanguage = preferredLanguage; }
public String getTimezone() { return timezone; }
public void setTimezone(String timezone) { this.timezone = timezone; }
public String getNotificationPreference() { return notificationPreference; }
public void setNotificationPreference(String notificationPreference) { this.notificationPreference = notificationPreference; }
}
