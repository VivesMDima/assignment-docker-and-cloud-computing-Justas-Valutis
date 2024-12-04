package justas.development.Training_Subscription.requests.user;

import jakarta.validation.constraints.Email;

public record PatchUserEmailRequest(
        @Email(message = "Email is not valid")
        String email) { }
