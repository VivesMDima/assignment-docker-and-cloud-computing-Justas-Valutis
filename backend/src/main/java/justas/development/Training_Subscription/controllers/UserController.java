package justas.development.Training_Subscription.controllers;

import jakarta.validation.Valid;
import justas.development.Training_Subscription.requests.user.*;
import justas.development.Training_Subscription.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = "*")  // Allow requests from any origin
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Page<UserRequest> getAllUsers(Pageable pageable) {
        return userService.getAllUsers(pageable);
    }

    @GetMapping("/id={userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId) {
        Optional<UserRequest> user = userService.getUserById(userId);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createUser(@RequestBody @Valid CreateUserRequest user) {
        try {
            Long id = userService.createUser(user);
            URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                     .buildAndExpand(id)
                    .toUri();

            return ResponseEntity.created(location).build();
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PatchMapping("patch-username/id={userId}")
    public ResponseEntity<String> updateUser(@PathVariable Long userId, @RequestBody @Valid PatchUserNameRequest user) {
        try {
            userService.updateUserName(userId, user);
            return ResponseEntity.ok("User updated successfully");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PatchMapping("patch-email/id={userId}")
    public ResponseEntity<String> updateUser(@PathVariable Long userId, @RequestBody @Valid PatchUserEmailRequest user) {
        try {
            userService.updateUserEmail(userId, user);
            return ResponseEntity.ok("User updated successfully");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PatchMapping("patch-password/id={userId}")
    public ResponseEntity<String> updateUser(@PathVariable Long userId, @RequestBody @Valid ChangePasswordRequest user) {
        try {
            userService.updateUserPassword(userId, user);
            return ResponseEntity.ok("User updated successfully");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
