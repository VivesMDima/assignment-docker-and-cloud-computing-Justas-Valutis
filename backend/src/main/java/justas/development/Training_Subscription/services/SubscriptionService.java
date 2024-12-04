package justas.development.Training_Subscription.services;

import justas.development.Training_Subscription.exceptions.ObjectNotFoundException;
import justas.development.Training_Subscription.models.Subscription;
import justas.development.Training_Subscription.models.SubscriptionType;
import justas.development.Training_Subscription.models.User;
import justas.development.Training_Subscription.repositories.SubscriptionRepository;
import justas.development.Training_Subscription.repositories.SubscriptionTypeRepository;
import justas.development.Training_Subscription.repositories.UserRepository;
import justas.development.Training_Subscription.requests.subscription.AddSubscriptionRequest;
import justas.development.Training_Subscription.requests.subscription.SubscriptionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionTypeRepository subscriptionTypeRepository;
    private final UserRepository userRepository;

    @Autowired
    public SubscriptionService(SubscriptionRepository subscriptionRepository, SubscriptionTypeRepository subscriptionTypeRepository, UserRepository userRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.subscriptionTypeRepository = subscriptionTypeRepository;
        this.userRepository = userRepository;
    }

    public void addSubscription(AddSubscriptionRequest addSubscriptionRequest) {
        SubscriptionType subscriptionType = subscriptionTypeRepository.findById(addSubscriptionRequest.subscriptionTypeId())
                .orElseThrow(() -> new ObjectNotFoundException("SubscriptionType", String.valueOf(addSubscriptionRequest.subscriptionTypeId())));

        User user = userRepository.findById(addSubscriptionRequest.userId())
                .orElseThrow(() -> new ObjectNotFoundException("User", String.valueOf(addSubscriptionRequest.userId())));

        Subscription subscription = new Subscription(
                LocalDate.now(),
                LocalDate.now().plusMonths(subscriptionType.getSubscriptionDurationInMonths()),
                calculateSubscriptionPrice(subscriptionType),
                subscriptionType,
                user
        );
        subscriptionRepository.save(subscription);
    }

    private double calculateSubscriptionPrice(SubscriptionType subscriptionType) {
        return subscriptionType.getSubscriptionDurationInMonths() * subscriptionType.getPricePerMonth();
    }

    public List<SubscriptionRequest> findSubscriptionsByUserId(Long id) {
        return subscriptionRepository.findAllByUser_UserId(id)
                .stream()
                .map(subscription -> new SubscriptionRequest(
                        subscription.getId(),
                        subscription.getSubscriptionType().getSubscriptionType(),
                        subscription.getAmountPaid(),
                        subscription.getDatePurchased(),
                        subscription.getDateExpires(),
                        subscription.getSubscriptionStatus()
                ))
                .sorted(Comparator.comparing(SubscriptionRequest::getDatePurchased).reversed())
                .collect(Collectors.toList());
    }


}
