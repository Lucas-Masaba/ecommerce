import com.ecommerce.Customer;
import com.ecommerce.Product;
import com.ecommerce.orders.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    List<Product> products = new ArrayList<>();
    products.add(new Product(1, "Laptop", 1200.00));
    products.add(new Product(2, "Smartphone", 800.00));
    products.add(new Product(3, "Tablet", 500.00));
    products.add(new Product(4, "Smartwatch", 300.00));
    products.add(new Product(5, "Charging Cable", 10.00));

    Customer customer = new Customer(1, "John Doe");
    Scanner scanner = new Scanner(System.in);
    boolean running = true;

    while (running) {
      System.out.println("\n1. Browse Products");
      System.out.println("2. Add to Cart");
      System.out.println("3. View Cart");
      System.out.println("4. Place Order");
      System.out.println("5. Exit");
      System.out.print("Choose an option: ");
      try {
        int option = scanner.nextInt();
        switch (option) {
          case 1:
            System.out.println("\nAvailable Products:");
            for (Product product : products) {
              System.out.println(product);
            }
            break;
          case 2:
            System.out.print("Enter product ID to add to cart: ");
            try {
              int productId = scanner.nextInt();
              Product productToAdd = null;
              for (Product product : products) {
                if (product.getProductID() == productId) {
                  productToAdd = product;
                  break;
                }
              }
              if (productToAdd != null) {
                customer.addProductToCart(productToAdd);
                System.out.println("Product added to cart.");
              } else {
                System.out.println("Product not found.");
              }
            } catch (Exception e) {
              System.out.println("Invalid input. Please enter an integer.");
            }
            break;
          case 3:
            System.out.println("\nYour Cart:");
            for (Product product : customer.getShoppingCart()) {
              System.out.println(product);
            }
            System.out.println("Total: $" + customer.calculateTotalCost());
            break;
          case 4:
            Order order = customer.placeOrder();
            System.out.println("Order placed successfully.");
            System.out.println(order);
            break;
          case 5:
            running = false;
            break;
          default:
            System.out.println("Invalid option. Try again.");
        }
      } catch (Exception e) {
        System.out.println("Invalid input. Please enter an integer.");
        scanner.nextLine();
      }
    }
  }
}
