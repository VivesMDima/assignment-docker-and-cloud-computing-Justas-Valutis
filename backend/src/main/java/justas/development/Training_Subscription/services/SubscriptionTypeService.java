package justas.development.Training_Subscription.services;

import justas.development.Training_Subscription.models.SUBSCRIPTION_TITLE;
import justas.development.Training_Subscription.models.SubscriptionType;
import justas.development.Training_Subscription.repositories.SubscriptionTypeRepository;
import justas.development.Training_Subscription.requests.subscriptionType.SubscriptionTypeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SubscriptionTypeService {
    private final SubscriptionTypeRepository subscriptionTypeRepository;

    @Autowired
    public SubscriptionTypeService(SubscriptionTypeRepository subscriptionTypeRepository) {
        this.subscriptionTypeRepository = subscriptionTypeRepository;
    }


    public Set<String> getAllSubscriptionTypes() {
        return subscriptionTypeRepository.findAll()
                .stream()
                .map(SubscriptionType::getSubscriptionType)
                .map(SUBSCRIPTION_TITLE::getTitle)
                .collect(Collectors.toSet());
    }

    public Set<Integer> getAllSubscriptionDurationInMonths() {
        return subscriptionTypeRepository.findAll()
                .stream()
                .map(SubscriptionType::getSubscriptionDurationInMonths)
                .collect(Collectors.toSet());
    }

    public Optional<SubscriptionTypeResponse> getSubscriptionTypeByTitleAndDuration(String type, int durationInMonths) {
        SUBSCRIPTION_TITLE title = SUBSCRIPTION_TITLE.getSubscriptionTitle(type);

        return subscriptionTypeRepository
                .findSubscriptionTypeBySubscriptionTypeAndSubscriptionDurationInMonths(title, durationInMonths)
                .map(subscriptionType -> new SubscriptionTypeResponse(
                        subscriptionType.getId(),
                        subscriptionType.getPricePerMonth()
                ));
    }
}
