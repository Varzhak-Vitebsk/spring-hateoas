package example.controller;

import com.epam.example.dto.ErrorResponse;
import example.exception.SubscriptionNotFoundException;
import example.exception.UserForSubscriptionNotFoundException;
import example.exception.UserNotFoundException;
import java.time.Instant;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  private static final String ERROR_MESSAGE = "Exception has occurred: ";

  @ExceptionHandler({SubscriptionNotFoundException.class, UserNotFoundException.class})
  public ResponseEntity<ErrorResponse> handleNotFoundException(Exception ex,
      HttpServletRequest request) {
    log.error(ERROR_MESSAGE, ex);
    return buildResponse(ex.getMessage(), HttpStatus.NOT_FOUND, request);
  }

  @ExceptionHandler({Exception.class})
  public ResponseEntity<ErrorResponse> handleServerException(Exception ex,
      HttpServletRequest request) {
    log.error(ERROR_MESSAGE, ex);
    return buildResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, request);
  }

  @ExceptionHandler({UserForSubscriptionNotFoundException.class})
  public ResponseEntity<ErrorResponse> handleBadRequest(Exception ex,
      HttpServletRequest request) {
    log.error(ERROR_MESSAGE, ex);
    return buildResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, request);
  }

  private ResponseEntity<ErrorResponse> buildResponse(final String message, HttpStatus httpStatus,
      HttpServletRequest request) {
    final var body = ErrorResponse.builder()
        .timestamp(Instant.now())
        .status(httpStatus.value())
        .error(message)
        .path(request.getRequestURI())
        .build();

    return ResponseEntity.status(httpStatus)
        .contentType(MediaType.APPLICATION_JSON)
        .body(body);
  }

}
