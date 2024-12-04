package justas.development.Training_Subscription.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String user) {
        super(String.format("User '%s' already exists", user));
    }
}
