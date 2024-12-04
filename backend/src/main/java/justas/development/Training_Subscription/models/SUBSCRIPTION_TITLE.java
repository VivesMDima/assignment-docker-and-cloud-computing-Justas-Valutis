package justas.development.Training_Subscription.models;

public enum SUBSCRIPTION_TITLE {
    BJJ("BJJ"),
    MMA("MMA"),
    GRAPLING("GRAPLING"),
    ALL_IN("All-in");

    private final String title;
    SUBSCRIPTION_TITLE(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }


    public static SUBSCRIPTION_TITLE getSubscriptionTitle(String subscriptionType) {
        if (!subscriptionType.trim().isEmpty()) {
            if (subscriptionType.equals(SUBSCRIPTION_TITLE.BJJ.toString())) {
                return SUBSCRIPTION_TITLE.BJJ;
            } else if (subscriptionType.equals(SUBSCRIPTION_TITLE.MMA.toString())) {
                return SUBSCRIPTION_TITLE.MMA;
            } else if (subscriptionType.equals(SUBSCRIPTION_TITLE.ALL_IN.getTitle())) {
                return SUBSCRIPTION_TITLE.ALL_IN;
            } else if (subscriptionType.equals(SUBSCRIPTION_TITLE.GRAPLING.toString())) {
                return SUBSCRIPTION_TITLE.GRAPLING;
            }
        }
        return null;
    }


}
