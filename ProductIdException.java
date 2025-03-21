public class ProductIdException extends RuntimeException {
    @Override
    public String getMessage() {
        return ("Product ID cannot be negative");
    }
}
