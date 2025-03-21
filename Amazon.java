import java.util.ArrayList;

public class Amazon {
    private ArrayList<Product> products;
    private Cart cart;

    // Constructor
    public Amazon() {
        this.products = new ArrayList<>();
        this.cart = new Cart();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    // Add product to store
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added to store: " + product);
    }

    // Remove product from store
    public void removeProduct(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
                System.out.println("Product removed from store: " + product);
                return;
            }
        }
        System.out.println("Product with ID " + id + " not found in store.");
    }

    // Display all products in store
    public void displayAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available in the store.");
            return;
        }
        System.out.println("Available Products:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    // Update product details
    public void updateProductDetails(int id, String name, String brand, double price)
            throws ProductNameException, ProductPriceException {
        for (Product product : products) {
            if (product.getId() == id) {
                product.setName(name);
                product.setBrand(brand);
                product.setPrice(price);
                System.out.println("Product updated: " + product);
                return;
            }
        }
        System.out.println("Product with ID " + id + " not found.");
    }

    // Access Cart
    public Cart getCart() {
        return cart;
    }
}
