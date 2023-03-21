package example.controller;

import com.epam.example.dto.UserRequestDto;
import com.epam.example.dto.UserResponseDto;
import com.epam.example.dto.UsersResponse;
import com.epam.example.rest.UserControllerV1;
import com.epam.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserControllerV1Impl implements UserControllerV1 {

  private final UserService userService;


  @Override
  public ResponseEntity<UserResponseDto> createUser(UserRequestDto request) {
    return new ResponseEntity<>(userService.createUser(request), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<UserResponseDto> updateUser(UserRequestDto request) {
    return new ResponseEntity<>(userService.updateUser(request), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> deleteUser(Long id) {
    userService.deleteUser(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<UserResponseDto> getUser(Long id) {
    return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<UsersResponse> getAllUsers() {
    return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
  }
}
