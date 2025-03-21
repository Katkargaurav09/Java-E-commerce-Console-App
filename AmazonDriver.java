import java.util.Scanner;

public class AmazonDriver {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Amazon amazon = new Amazon();

        char choice;
        do {
            System.out.println("\nWelcome to Amazon Store!");
            System.out.println("1. Add Product to Store");
            System.out.println("2. Remove Product from Store");
            System.out.println("3. Display All Products");
            System.out.println("4. Add Product to Cart");
            System.out.println("5. Remove Product from Cart");
            System.out.println("6. Display Cart");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int option = scanner.nextInt();
            switch (option) {
                case 1: // Add Product
                    System.out.print("Enter Product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Brand: ");
                    String brand = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();

                    try {
                        Product p = new Product(id, name, brand, price);
                        amazon.addProduct(p);
                    } catch (ProductIdException | ProductNameException | ProductPriceException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2: // Remove Product
                    System.out.print("Enter Product ID to remove: ");
                    int removeId = scanner.nextInt();
                    amazon.removeProduct(removeId);
                    break;

                case 3: // Display Products
                    amazon.displayAllProducts();
                    break;

                case 4: // Add to Cart
                    System.out.print("Enter Product ID to add to Cart: ");
                    int cartAddId = scanner.nextInt();
                    for (Product product : amazon.getProducts()) {
                        if (product.getId() == cartAddId) {
                            amazon.getCart().addProduct(product);
                            break;
                        }
                    }
                    break;

                case 5: // Remove from Cart
                    System.out.print("Enter Product ID to remove from Cart: ");
                    int cartRemoveId = scanner.nextInt();
                    amazon.getCart().removeProduct(cartRemoveId);
                    break;

                case 6: // Display Cart
                    amazon.getCart().displayCart();
                    break;

                case 7: // Exit
                    System.out.println("Exiting... Thank you for using Amazon Store!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.print("Do you want to continue? (Y/N): ");
            choice = scanner.next().charAt(0);
        } while (choice == 'Y' || choice == 'y');

        scanner.close();
    }
}
