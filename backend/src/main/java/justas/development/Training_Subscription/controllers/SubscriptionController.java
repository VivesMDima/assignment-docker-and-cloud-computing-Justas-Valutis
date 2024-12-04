package justas.development.Training_Subscription.controllers;

import justas.development.Training_Subscription.exceptions.ObjectNotFoundException;
import justas.development.Training_Subscription.requests.subscription.AddSubscriptionRequest;
import justas.development.Training_Subscription.requests.subscription.SubscriptionRequest;
import justas.development.Training_Subscription.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addSubscription(@RequestBody AddSubscriptionRequest addSubscriptionRequest) {
        try {
            subscriptionService.addSubscription(addSubscriptionRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body("Subscription successfully added");
        } catch (ObjectNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/userId={id}")
    public ResponseEntity<?> getSubscriptionsByUserId(@PathVariable Long id) {
        List<SubscriptionRequest> response = subscriptionService.findSubscriptionsByUserId(id);
        if (response.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(response);
    }
}
