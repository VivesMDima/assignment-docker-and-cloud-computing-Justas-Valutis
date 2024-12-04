package justas.development.Training_Subscription.exceptions;

public class PasswordDoesNotMatchException extends RuntimeException {
    public PasswordDoesNotMatchException() {
        super("Passwords do not match");
    }
}
