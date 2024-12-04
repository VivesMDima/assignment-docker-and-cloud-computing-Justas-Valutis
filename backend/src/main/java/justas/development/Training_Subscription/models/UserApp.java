package justas.development.Training_Subscription.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "app_USER")
public class UserApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long userId;

    @Column(name="user_name")
    private String userName;

    @Column(name="user_email")
    private String email;

    @Column(name="user_password")
    private String password;

    @Column(name="user_isAdmin")
    private boolean isAdmin;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Subscription> subscriptions;

    public UserApp(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.subscriptions = new ArrayList<>();
        isAdmin = false;
    }

    public UserApp() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}
