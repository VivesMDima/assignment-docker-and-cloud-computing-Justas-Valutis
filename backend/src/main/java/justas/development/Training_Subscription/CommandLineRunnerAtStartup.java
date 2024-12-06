package justas.development.Training_Subscription;

import justas.development.Training_Subscription.models.SUBSCRIPTION_TITLE;
import justas.development.Training_Subscription.models.SubscriptionType;
import justas.development.Training_Subscription.repositories.SubscriptionTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("entityManagerFactory")

public class CommandLineRunnerAtStartup implements CommandLineRunner {

    private final SubscriptionTypeRepository subscriptionTypeRepository;

    public CommandLineRunnerAtStartup(SubscriptionTypeRepository subscriptionTypeRepository) {
        this.subscriptionTypeRepository = subscriptionTypeRepository;

    }
    @Override
    public void run(String... args) throws Exception {
        subscriptionTypeRepository.save(new SubscriptionType(SUBSCRIPTION_TITLE.BJJ, 1, 50));
        subscriptionTypeRepository.save(new SubscriptionType(SUBSCRIPTION_TITLE.BJJ, 3, 40));
        subscriptionTypeRepository.save(new SubscriptionType(SUBSCRIPTION_TITLE.BJJ, 12, 35));
        subscriptionTypeRepository.save(new SubscriptionType(SUBSCRIPTION_TITLE.GRAPLING, 1, 50));
        subscriptionTypeRepository.save(new SubscriptionType(SUBSCRIPTION_TITLE.GRAPLING, 3, 40));
        subscriptionTypeRepository.save(new SubscriptionType(SUBSCRIPTION_TITLE.GRAPLING, 12, 35));
        subscriptionTypeRepository.save(new SubscriptionType(SUBSCRIPTION_TITLE.MMA, 1, 50));
        subscriptionTypeRepository.save(new SubscriptionType(SUBSCRIPTION_TITLE.MMA, 3, 40));
        subscriptionTypeRepository.save(new SubscriptionType(SUBSCRIPTION_TITLE.MMA, 12, 35));
        subscriptionTypeRepository.save(new SubscriptionType(SUBSCRIPTION_TITLE.ALL_IN, 1, 100));
        subscriptionTypeRepository.save(new SubscriptionType(SUBSCRIPTION_TITLE.ALL_IN, 3, 60));
        subscriptionTypeRepository.save(new SubscriptionType(SUBSCRIPTION_TITLE.ALL_IN, 12, 50));
    }
}
