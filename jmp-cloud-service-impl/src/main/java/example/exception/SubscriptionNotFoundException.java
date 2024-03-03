package example.exception;

public class SubscriptionNotFoundException extends RuntimeException {

  public SubscriptionNotFoundException(String message) {
    super(message);
  }

  public SubscriptionNotFoundException(String message, Object... args) {
    super(String.format(message, args));
  }
}
