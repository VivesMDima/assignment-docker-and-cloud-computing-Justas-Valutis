package justas.development.Training_Subscription.requests.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ChangePasswordRequest(
        @NotBlank(message = "Password is mandatory")
        @Size(min=5, message = "Password must be eat least 5 characters long")
        String oldPassword,
        @NotBlank(message = "Password is mandatory")
        @Size(min=5, message = "New password must be eat least 5 characters long")
        String newPassword)
{}
