package justas.development.Training_Subscription.requests.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PatchUserNameRequest (
    @NotBlank(message = "userName is mandatory")
    @Size(min=3, message = "userName has to have at least 3 characters")
     String userName
) {}
