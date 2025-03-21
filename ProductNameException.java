public class ProductNameException extends Exception {

    @Override
    public String getMessage() {
        return ("Product Name cannot be empty");
    }

}
