package com.epam.example.service;

import com.epam.example.dto.User;
import com.epam.example.dto.UserRequestDto;
import com.epam.example.storage.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserStorageService {

    private final UserRepository repository; //TODO implement calls

    public User createOrUpdateUser(UserRequestDto requestDto) {
        return User.builder().build();
    }

    public void deleteUser(Long id) {

    }

    public User getUser(Long id) {
        return User.builder().build();
    }

    public List<User> getUsers() {
        return List.of();
    }
}
