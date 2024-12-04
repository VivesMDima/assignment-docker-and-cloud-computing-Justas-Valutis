package justas.development.Training_Subscription.repositories;

import justas.development.Training_Subscription.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName);
    Optional<User> findByEmail(String email);
    Optional<User> findByUserNameOrEmail(String userName, String email);
    Optional<User> findByUserId(Long userId);

}
