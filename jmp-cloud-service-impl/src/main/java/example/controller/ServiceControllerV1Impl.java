package example.controller;

import com.epam.example.dto.SubscriptionRequestDto;
import com.epam.example.dto.SubscriptionResponseDto;
import com.epam.example.dto.SubscriptionsResponse;
import com.epam.example.rest.ServiceControllerV1;
import com.epam.example.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ServiceControllerV1Impl implements ServiceControllerV1 {

    private final SubscriptionService subscriptionService;

    @Override
    public ResponseEntity<SubscriptionResponseDto> createSubscription(SubscriptionRequestDto request) {
        return new ResponseEntity<>(subscriptionService.createSubscription(request), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SubscriptionResponseDto> updateSubscription(SubscriptionRequestDto request) {
        return new ResponseEntity<>(subscriptionService.updateSubscription(request), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteSubscription(Long id) {
        subscriptionService.deleteSubscription(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SubscriptionResponseDto> getSubscription(Long id) {
        return new ResponseEntity<>(subscriptionService.getSubscription(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SubscriptionsResponse> getAllSubscriptions() {
        return new ResponseEntity<>(subscriptionService.getSubscriptions(), HttpStatus.OK);
    }
}
