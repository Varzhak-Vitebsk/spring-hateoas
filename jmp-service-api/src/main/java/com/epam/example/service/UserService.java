package com.epam.example.service;

import com.epam.example.dto.UserRequestDto;
import com.epam.example.dto.UserResponseDto;
import com.epam.example.dto.UsersResponse;

public interface UserService {

    UserResponseDto createUser(UserRequestDto requestDto);

    UserResponseDto updateUser(UserRequestDto requestDto);
    void deleteUser(Long id);

    UserResponseDto getUser(Long id);

    UsersResponse getUsers();
}
