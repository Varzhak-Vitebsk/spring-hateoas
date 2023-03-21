package com.epam.example.service;

import com.epam.example.dto.SubscriptionRequestDto;
import com.epam.example.dto.SubscriptionResponseDto;
import com.epam.example.dto.SubscriptionsResponse;

public interface SubscriptionService {

    SubscriptionResponseDto createSubscription(SubscriptionRequestDto requestDto);

    SubscriptionResponseDto updateSubscription(SubscriptionRequestDto requestDto);
    
    void deleteSubscription(Long id);
    
    SubscriptionResponseDto getSubscription(Long id);
    
    SubscriptionsResponse getSubscriptions();
}
