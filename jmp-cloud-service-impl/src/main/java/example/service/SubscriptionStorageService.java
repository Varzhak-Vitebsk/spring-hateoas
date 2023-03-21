package example.service;

import com.epam.example.dto.Subscription;
import com.epam.example.dto.SubscriptionRequestDto;
import example.exception.SubscriptionNotFoundException;
import example.exception.UserForSubscriptionNotFoundException;
import example.mapper.SubscriptionEntityToSubscriptionMapper;
import example.storage.SubscriptionRepository;
import example.storage.UserRepository;
import example.storage.entity.SubscriptionEntity;
import example.storage.entity.UserEntity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionStorageService {

    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionEntityToSubscriptionMapper mapper;
    private final UserRepository userRepository;


    public Subscription createSubscription(SubscriptionRequestDto requestDto) {
        SubscriptionEntity subscription = userRepository.findById(requestDto.userId())
            .map(this::buildEntity)
            .orElseThrow(() -> new UserForSubscriptionNotFoundException("Invalid user id %s", requestDto.userId()));
        subscriptionRepository.save(subscription);
        return mapper.map(subscription);
    }

    public void deleteSubscription(Long id) {
        if (subscriptionRepository.existsById(id)) {
            subscriptionRepository.deleteById(id);
        } else {
            throw new SubscriptionNotFoundException("Subscription with id %s not found", id);
        }
    }

    public Subscription getSubscription(Long id) {
        return subscriptionRepository.findById(id)
            .map(mapper::map)
            .orElseThrow(() -> new SubscriptionNotFoundException("Subscription with id %s not found", id));
    }

    public List<Subscription> getSubscriptions() {
        return subscriptionRepository.findAll().stream()
            .map(mapper::map)
            .toList();
    }

    private SubscriptionEntity buildEntity(UserEntity entity) {
        return SubscriptionEntity.builder()
            .user(entity)
            .build();
    }
}
