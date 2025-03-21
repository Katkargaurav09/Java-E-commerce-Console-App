public class ProductPriceException extends Exception {
    @Override
    public String getMessage() {
        return ("Product price cannot be zero");
    }
}
