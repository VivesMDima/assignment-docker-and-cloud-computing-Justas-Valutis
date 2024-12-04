package justas.development.Training_Subscription.repositories;

import justas.development.Training_Subscription.models.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findAllByUser_UserId(Long userId);
}
