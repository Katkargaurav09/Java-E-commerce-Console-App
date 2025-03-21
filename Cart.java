import java.util.ArrayList;

public class Cart {
    ArrayList<Product> products;

    // Constructor
    public Cart() {
        this.products = new ArrayList<>();
    }

    // Add product to cart
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added to cart: " + product);
    }

    // Remove product from cart
    public void removeProduct(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
                System.out.println("Product removed from cart: " + product);
                return;
            }
        }
        System.out.println("Product with ID " + id + " not found in cart.");
    }

    // Display cart items
    public void displayCart() {
        if (products.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        System.out.println("Cart contains:");
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
