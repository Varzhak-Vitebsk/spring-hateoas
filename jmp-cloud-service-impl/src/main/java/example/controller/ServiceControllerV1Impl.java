package example.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
        var response = subscriptionService.createSubscription(request);
        response.add(linkTo(methodOn(ServiceControllerV1Impl.class).createSubscription(request)).withSelfRel());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SubscriptionResponseDto> updateSubscription(SubscriptionRequestDto request) {
        var response = subscriptionService.updateSubscription(request);
        response.add(linkTo(methodOn(ServiceControllerV1Impl.class).updateSubscription(request)).withSelfRel());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteSubscription(Long id) {
        subscriptionService.deleteSubscription(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SubscriptionResponseDto> getSubscription(Long id) {
        var response = subscriptionService.getSubscription(id);
        response.add(linkTo(methodOn(ServiceControllerV1Impl.class).getSubscription(id)).withSelfRel());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SubscriptionsResponse> getAllSubscriptions() {
        var response = subscriptionService.getSubscriptions();
        response.subscriptions().forEach((sub) ->
            sub.add(linkTo(methodOn(ServiceControllerV1Impl.class).getSubscription(sub.getId())).withSelfRel()));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
