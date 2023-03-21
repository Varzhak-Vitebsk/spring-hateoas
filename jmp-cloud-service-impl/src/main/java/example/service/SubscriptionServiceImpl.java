package example.service;

import com.epam.example.dto.SubscriptionRequestDto;
import com.epam.example.dto.SubscriptionResponseDto;
import com.epam.example.dto.SubscriptionsResponse;
import com.epam.example.service.SubscriptionService;
import example.mapper.SubscriptionToSubscriptionDtoResponseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionStorageService storageService;
    private final SubscriptionToSubscriptionDtoResponseMapper mapper;

    public SubscriptionResponseDto createSubscription(SubscriptionRequestDto requestDto) {
        return mapper.map(storageService.createSubscription(requestDto));
    }

    public SubscriptionResponseDto updateSubscription(SubscriptionRequestDto requestDto) {
        log.warn("Subscription can not be updated at the moment");
        return mapper.map(storageService.getSubscription(requestDto.id()));
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
