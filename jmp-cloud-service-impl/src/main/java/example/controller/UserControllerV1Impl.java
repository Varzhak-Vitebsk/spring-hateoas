package example.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
    var response = userService.createUser(request);
    response.add(linkTo(methodOn(UserControllerV1Impl.class).createUser(request)).withSelfRel());
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<UserResponseDto> updateUser(UserRequestDto request) {
    var response = userService.updateUser(request);
    response.add(linkTo(methodOn(UserControllerV1Impl.class).updateUser(request)).withSelfRel());
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> deleteUser(Long id) {
    userService.deleteUser(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<UserResponseDto> getUser(Long id) {
    var response = userService.getUser(id);
    response.add(linkTo(methodOn(UserControllerV1Impl.class).getUser(id)).withSelfRel());
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<UsersResponse> getAllUsers() {
    var response = userService.getUsers();
    response.users().forEach((user) ->
        user.add(linkTo(methodOn(UserControllerV1Impl.class).getUser(user.getId())).withSelfRel()));
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
