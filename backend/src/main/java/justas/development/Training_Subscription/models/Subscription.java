package justas.development.Training_Subscription.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="app_SUBSCRIPTION")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="date_Purchased")
    @Temporal(TemporalType.DATE)
    private LocalDate datePurchased;

    @Column(name="date_expires")
    @Temporal(TemporalType.DATE)
    private LocalDate dateExpires;

    @Column(name="amount_paid")
    private Double amountPaid;

    @ManyToOne
    @JoinColumn(name = "subscription_type_id", nullable = false)
    private SubscriptionType subscriptionType;

    @Enumerated(EnumType.STRING)
    @Column(name = "subscription_status")
    private SUBSCRIPTION_STATUS subscriptionStatus;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Subscription() {}

    public Subscription(LocalDate datePurchased, LocalDate dateExpires, Double amountPaid, SubscriptionType subscriptionType, User user) {
        this.datePurchased = datePurchased;
        this.dateExpires = dateExpires;
        this.amountPaid = amountPaid;
        this.subscriptionType = subscriptionType;
        this.subscriptionStatus = SUBSCRIPTION_STATUS.PENDING;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDatePurchased() {
        return datePurchased;
    }

    public LocalDate getDateExpires() {
        return dateExpires;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public SUBSCRIPTION_STATUS getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public User getUser() {
        return user;
    }

    public void setSubscriptionStatus(SUBSCRIPTION_STATUS subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus;
    }
}
