package example.service;

import com.epam.example.dto.User;
import com.epam.example.dto.UserRequestDto;
import example.exception.UserNotFoundException;
import example.mapper.UserEntityToUserMapper;
import example.storage.UserRepository;
import example.storage.entity.UserEntity;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserStorageService {

    private final UserRepository repository;
    private final UserEntityToUserMapper mapper;

    public User createOrUpdateUser(UserRequestDto requestDto) {
        UserEntity user;
        if (Objects.nonNull(requestDto.id())) {
            try {
                user = repository.getReferenceById(requestDto.id());
            } catch (EntityNotFoundException e) {
                throw new UserNotFoundException("User with id %s not found", requestDto.id());
            }
        } else {
            user = buildEntity(requestDto);
        }
        repository.save(user);
        return mapper.map(user);
    }

    public void deleteUser(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new UserNotFoundException("User with id %s not found", id);
        }
    }

    public User getUser(Long id) {
        return repository.findById(id)
            .map(mapper::map)
            .orElseThrow(() -> new UserNotFoundException("User with id %s not found", id));
    }

    public List<User> getUsers() {
        return repository.findAll().stream()
            .map(mapper::map)
            .toList();
    }

    private UserEntity buildEntity(UserRequestDto request) {
        return UserEntity.builder()
            .name(request.name())
            .surname(request.surname())
            .birthday(request.birthday())
            .subscriptions(Set.of())
            .build();
    }
}
