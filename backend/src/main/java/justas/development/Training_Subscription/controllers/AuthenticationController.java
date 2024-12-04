package justas.development.Training_Subscription.controllers;

import jakarta.validation.Valid;
import justas.development.Training_Subscription.requests.auth.UserLoginRequest;
import justas.development.Training_Subscription.requests.auth.UserLoginResponse;
import justas.development.Training_Subscription.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody @Valid UserLoginRequest loginRequest) {
        Optional<UserLoginResponse> user = authenticationService.login(loginRequest.userName(), loginRequest.password());
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get().userId(), HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
    }
}
