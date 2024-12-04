package justas.development.Training_Subscription.requests.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateUserRequest {

    @NotBlank(message = "userName is mandatory")
    @Size(min=3, message = "userName has to have at least 3 characters")
    private String userName;

    @Email(message = "Email is not valid")
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Size(min=5, message = "Password must be eat least 5 characters long")
    private String password;

    @NotBlank(message = "Repeat Password is mandatory")
    @Size(min=5, message = "Repeat Password must be eat least 5 characters long")
    private String repeatPassword;

    private boolean isAdmin;

    public CreateUserRequest(String userName, String email, String password, String repeatPassword) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.isAdmin = false;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}
