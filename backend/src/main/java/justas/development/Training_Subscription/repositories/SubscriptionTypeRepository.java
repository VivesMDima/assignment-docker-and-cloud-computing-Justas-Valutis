package justas.development.Training_Subscription.repositories;

import justas.development.Training_Subscription.models.SUBSCRIPTION_TITLE;
import justas.development.Training_Subscription.models.SubscriptionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriptionTypeRepository extends JpaRepository<SubscriptionType, Long> {
    Optional<SubscriptionType> findSubscriptionTypeBySubscriptionTypeAndSubscriptionDurationInMonths(SUBSCRIPTION_TITLE subscriptionType, Integer subscriptionDurationInMonths);
}
