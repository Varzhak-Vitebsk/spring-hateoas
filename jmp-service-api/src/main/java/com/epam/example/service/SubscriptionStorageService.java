package com.epam.example.service;

import com.epam.example.dto.Subscription;
import com.epam.example.dto.SubscriptionRequestDto;
import com.epam.example.storage.SubscriptionRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionStorageService {

    private final SubscriptionRepository repository; //TODO implement calls

    public Subscription createOrUpdateSubscription(SubscriptionRequestDto requestDto) {
        return Subscription.builder().build();
    }

    public Subscription updateSubscription(SubscriptionRequestDto requestDto) {
        return Subscription.builder().build();
    }

    public void deleteSubscription(Long id) {

    }

    public Subscription getSubscription(Long id) {
        return Subscription.builder().build();
    }

    public List<Subscription> getSubscriptions() {
        return List.of();
    }
}
