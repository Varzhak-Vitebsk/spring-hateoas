package example.exception;

public class UserForSubscriptionNotFoundException extends RuntimeException {

  public UserForSubscriptionNotFoundException(String message) {
    super(message);
  }

  public UserForSubscriptionNotFoundException(String message, Object... args) {
    super(String.format(message, args));
  }
}
