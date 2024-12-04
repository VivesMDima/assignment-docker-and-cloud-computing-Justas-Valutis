package justas.development.Training_Subscription.requests.subscription;

import justas.development.Training_Subscription.models.SUBSCRIPTION_STATUS;
import justas.development.Training_Subscription.models.SUBSCRIPTION_TITLE;

import java.time.LocalDate;

public class SubscriptionRequest {
    private Long id;
    private SUBSCRIPTION_TITLE subscriptionTitle;
    private double amountPaid;
    private LocalDate datePurchased;
    private LocalDate dateExpires;
    private SUBSCRIPTION_STATUS subscriptionStatus;

    public SubscriptionRequest(Long id, SUBSCRIPTION_TITLE subscriptionTitle, double amountPaid, LocalDate datePurchased, LocalDate dateExpires, SUBSCRIPTION_STATUS subscriptionStatus) {
        this.id = id;
        this.subscriptionTitle = subscriptionTitle;
        this.amountPaid = amountPaid;
        this.datePurchased = datePurchased;
        this.dateExpires = dateExpires;
        this.subscriptionStatus = subscriptionStatus;
    }

    public SubscriptionRequest() {}

    public void setSubscriptionStatus(SUBSCRIPTION_STATUS subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus;
    }

    public SUBSCRIPTION_STATUS getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public Long getId() {
        return id;
    }

    public SUBSCRIPTION_TITLE getSubscriptionTitle() {
        return subscriptionTitle;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public LocalDate getDatePurchased() {
        return datePurchased;
    }

    public LocalDate getDateExpires() {
        return dateExpires;
    }
}
