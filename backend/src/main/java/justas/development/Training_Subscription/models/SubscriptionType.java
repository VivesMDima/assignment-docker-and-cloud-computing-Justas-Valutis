package justas.development.Training_Subscription.models;

import jakarta.persistence.*;

@Entity
@Table(name="app_Subscription_Type")
public class SubscriptionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name="subscription_type")
    private SUBSCRIPTION_TITLE subscriptionType;

    @Column(name="subscription_duration_in_months")
    private int subscriptionDurationInMonths;

    @Column(name="subscription_price_per_month")
    private double pricePerMonth;

    public SubscriptionType(SUBSCRIPTION_TITLE subscriptionTitle, int subscriptionDurationInMonths, double pricePerMonth) {
        this.subscriptionType = subscriptionTitle;
        this.subscriptionDurationInMonths = subscriptionDurationInMonths;
        this.pricePerMonth = pricePerMonth;
    }

    public SubscriptionType() {

    }

    public Long getId() {
        return id;
    }

    public SUBSCRIPTION_TITLE getSubscriptionType() {
        return subscriptionType;
    }

    public int getSubscriptionDurationInMonths() {
        return subscriptionDurationInMonths;
    }

    public double getPricePerMonth() {
        return pricePerMonth;
    }
}
