package justas.development.Training_Subscription.services;

import jakarta.validation.Valid;
import justas.development.Training_Subscription.exceptions.ObjectNotFoundException;
import justas.development.Training_Subscription.exceptions.PasswordDoesNotMatchException;
import justas.development.Training_Subscription.exceptions.UserAlreadyExistsException;
import justas.development.Training_Subscription.models.User;
import justas.development.Training_Subscription.repositories.UserRepository;
import justas.development.Training_Subscription.requests.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//    private static final Logger LOG = Logger.getLogger(UserService.class.getName());

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Page<UserRequest> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable).map(UserRequest::new);
    }

    public Optional<UserRequest> getUserById(Long userId) {
        return userRepository.findByUserId(userId).map(UserRequest::new);
    }

    public Long createUser(CreateUserRequest userRequest) {
        checkIfUserExists(userRequest.getUserName(), userRequest.getEmail());
        checkIfPasswordsMatch(userRequest.getPassword(), userRequest.getRepeatPassword());
        String encodedPassword = bCryptPasswordEncoder.encode(userRequest.getPassword());

        User user = userRepository.save(new User(
                userRequest.getUserName(),
                userRequest.getEmail(),
                encodedPassword
        ));

        return user.getUserId();
    }

    // ------------ Assisting methods ------------------------ //

    private void checkIfUserExists(String userName, String email) {
        isUsernameFree(userName);
        isEmailFree(email);
    }

    private void isEmailFree(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new UserAlreadyExistsException(email);
        }
    }

    private void isUsernameFree(String userName) {
        if (userRepository.findByUserName(userName).isPresent()) {
            throw new UserAlreadyExistsException(userName);
        }
    }

    private void checkIfPasswordsMatch(String password, String repeatPassword) {
        if (!password.equals(repeatPassword)) {
            throw new PasswordDoesNotMatchException();
        }
    }

    public void updateUserName(Long userId, @Valid PatchUserNameRequest user) {
        User userToUpdate = userRepository.findByUserId(userId)
                .orElseThrow(() -> new ObjectNotFoundException("User", String.valueOf(userId)));

        if (user.userName() != null) {
            isUsernameFree(user.userName());
            userToUpdate.setUserName(user.userName());
        }

        userRepository.save(userToUpdate);
    }

    public void updateUserEmail(Long userId, @Valid PatchUserEmailRequest user) {
        User userToUpdate = userRepository.findByUserId(userId)
                .orElseThrow(() -> new ObjectNotFoundException("User", String.valueOf(userId)));

        if (user.email() != null) {
            isEmailFree(user.email());
            userToUpdate.setEmail(user.email());
        }

        userRepository.save(userToUpdate);
    }

    public void updateUserPassword(Long userId, ChangePasswordRequest passwordRequest) {
        User userToUpdate = userRepository.findByUserId(userId)
                .orElseThrow(() -> new ObjectNotFoundException("User", String.valueOf(userId)));

        if (!bCryptPasswordEncoder.matches(passwordRequest.oldPassword(), userToUpdate.getPassword())) {
            throw new PasswordDoesNotMatchException();
        }
        userToUpdate.setPassword(bCryptPasswordEncoder.encode(passwordRequest.newPassword()));

        userRepository.save(userToUpdate);
    }
}
