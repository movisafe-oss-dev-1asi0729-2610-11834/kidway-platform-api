package com.movisafe.kidway.platform.subscriptions.domain.model.aggregates;

import com.movisafe.kidway.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "subscriptions_payments")
public class Subscription extends AuditableAbstractAggregateRoot {
private String subscriberName;
private String planName;
private Double monthlyPrice;
private String currency;
private String paymentStatus;
private String renewalDate;

    public Subscription() { }

    public Subscription(String subscriberName, String planName, Double monthlyPrice, String currency, String paymentStatus, String renewalDate) {
    this.subscriberName = subscriberName;
    this.planName = planName;
    this.monthlyPrice = monthlyPrice;
    this.currency = currency;
    this.paymentStatus = paymentStatus;
    this.renewalDate = renewalDate;
    }

public String getSubscriberName() { return subscriberName; }
public void setSubscriberName(String subscriberName) { this.subscriberName = subscriberName; }
public String getPlanName() { return planName; }
public void setPlanName(String planName) { this.planName = planName; }
public Double getMonthlyPrice() { return monthlyPrice; }
public void setMonthlyPrice(Double monthlyPrice) { this.monthlyPrice = monthlyPrice; }
public String getCurrency() { return currency; }
public void setCurrency(String currency) { this.currency = currency; }
public String getPaymentStatus() { return paymentStatus; }
public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
public String getRenewalDate() { return renewalDate; }
public void setRenewalDate(String renewalDate) { this.renewalDate = renewalDate; }
}
