package justas.development.Training_Subscription.models;

public enum SUBSCRIPTION_STATUS {
    PENDING("Pending"),
    ACTIVE("Active"),
    EXPIRED("Expired");

    private final String description;

    SUBSCRIPTION_STATUS(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
