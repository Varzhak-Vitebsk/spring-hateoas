package com.epam.example.service;

import com.epam.example.dto.SubscriptionRequestDto;
import com.epam.example.dto.SubscriptionResponseDto;
import com.epam.example.dto.SubscriptionsResponse;
import com.epam.example.mapper.SubscriptionToSubscriptionDtoResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionStorageService storageService;
    private final SubscriptionToSubscriptionDtoResponseMapper mapper;

    public SubscriptionResponseDto createSubscription(SubscriptionRequestDto requestDto) {
        return mapper.map(storageService.createOrUpdateSubscription(requestDto));
    }

    public SubscriptionResponseDto updateSubscription(SubscriptionRequestDto requestDto) {
        return mapper.map(storageService.createOrUpdateSubscription(requestDto));
    }
    
    public void deleteSubscription(Long id) {
        storageService.deleteSubscription(id);
    }
    
    public SubscriptionResponseDto getSubscription(Long id) {
        return mapper.map(storageService.getSubscription(id));
    }
    
    public SubscriptionsResponse getSubscriptions() {
        return SubscriptionsResponse.builder()
            .subscriptions(mapper.map(storageService.getSubscriptions()))
            .build();
    }
}
