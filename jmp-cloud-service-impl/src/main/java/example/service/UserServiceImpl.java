package example.service;

import com.epam.example.dto.UserRequestDto;
import com.epam.example.dto.UserResponseDto;
import com.epam.example.dto.UsersResponse;
import com.epam.example.service.UserService;
import example.mapper.UserToUserDtoResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserStorageService storageService;
    private final UserToUserDtoResponseMapper mapper;

    public UserResponseDto createUser(UserRequestDto requestDto) {
        return mapper.map(storageService.createOrUpdateUser(requestDto));
    }

    public UserResponseDto updateUser(UserRequestDto requestDto) {
        return mapper.map(storageService.createOrUpdateUser(requestDto));
    }

    public void deleteUser(Long id) {
        storageService.deleteUser(id);
    }

    public UserResponseDto getUser(Long id) {
        return mapper.map(storageService.getUser(id));
    }

    public UsersResponse getUsers() {
        return UsersResponse.builder()
            .users(mapper.map(storageService.getUsers()))
            .build();
    }
}
