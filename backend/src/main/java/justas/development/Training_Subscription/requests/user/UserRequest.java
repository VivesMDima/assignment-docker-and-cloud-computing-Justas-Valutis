package justas.development.Training_Subscription.requests.user;

import justas.development.Training_Subscription.models.User;

public class UserRequest {

    private final String userName;
    private final String email;

    public UserRequest(User user) {
        this.userName = user.getUserName();
        this.email = user.getEmail();
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }
}
