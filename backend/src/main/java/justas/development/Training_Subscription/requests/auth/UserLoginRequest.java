package justas.development.Training_Subscription.requests.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserLoginRequest(
        @NotBlank
        @Size(min=3)
        String userName,
        @NotBlank
        @Size(min=5)
        String password) {
}
