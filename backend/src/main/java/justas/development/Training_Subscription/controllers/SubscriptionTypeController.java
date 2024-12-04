package justas.development.Training_Subscription.controllers;

import justas.development.Training_Subscription.requests.subscriptionType.SubscriptionTypeResponse;
import justas.development.Training_Subscription.services.SubscriptionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@RequestMapping("/api/subscriptiontype")
public class SubscriptionTypeController {
    private final SubscriptionTypeService subscriptionTypeService;

    @Autowired

    public SubscriptionTypeController(SubscriptionTypeService subscriptionTypeService) {
        this.subscriptionTypeService = subscriptionTypeService;
    }

    @GetMapping("/types")
    public ResponseEntity<?> getAllSubscriptionTypes() {
        return ResponseEntity.ok(subscriptionTypeService.getAllSubscriptionTypes());
    }

    @GetMapping("/durations")
    public ResponseEntity<?> getAllSubscriptionTypeDurations() {
        return ResponseEntity.ok(subscriptionTypeService.getAllSubscriptionDurationInMonths());
    }

    @GetMapping("/type{type}/duration{duration}")
    public ResponseEntity<?> getSubscriptionTypeByTitleAndDuration(@PathVariable String type, @PathVariable int duration) {
        Optional<SubscriptionTypeResponse> response = subscriptionTypeService.getSubscriptionTypeByTitleAndDuration(type, duration);

        return response.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


}
