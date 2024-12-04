package justas.development.Training_Subscription.services;

import justas.development.Training_Subscription.models.User;
import justas.development.Training_Subscription.repositories.UserRepository;
import justas.development.Training_Subscription.requests.auth.UserLoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    public AuthenticationService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Optional<UserLoginResponse> login(String identifier, String password) {
        Optional<User> optionalUser = userRepository.findByUserNameOrEmail(identifier, identifier);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (bCryptPasswordEncoder.matches(password, user.getPassword())) {
                UserLoginResponse response = new UserLoginResponse(user.getUserId());
                return Optional.of(response);
            }
        }
        return Optional.empty();
    }
}
