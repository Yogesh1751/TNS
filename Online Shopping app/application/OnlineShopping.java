package application;

import java.util.Scanner;

import entities.Customer;
import entities.Order;
import entities.Product;
import services.CustomerService;
import services.ProductService;

public class OnlineShopping {
    private static ProductService productService = new ProductService();
    private static CustomerService customerService = new CustomerService();
    private static int orderCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Admin Menu\n2. Customer Menu\n3. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    adminMenu(scanner);
                    break;
                case 2:
                    customerMenu(scanner);
                    break;
                case 3:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
        scanner.close();
    }

    private static void adminMenu(Scanner scanner) {
        boolean back = false;
        while (!back) {
            System.out.println("Admin Menu:\n1. Add Product\n2. Remove Product\n3. View Products\n4. Back");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addProduct(scanner);
                    break;
                case 2:
                    removeProduct(scanner);
                    break;
                case 3:
                    viewProducts();
                    break;
                case 4:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private static void customerMenu(Scanner scanner) {
        boolean back = false;
        while (!back) {
            System.out.println("Customer Menu:\n1. Create Customer\n2. View Customers\n3. Place Order\n4. Back");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createCustomer(scanner);
                    break;
                case 2:
                    viewCustomers();
                    break;
                case 3:
                    placeOrder(scanner);
                    break;
                case 4:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private static void addProduct(Scanner scanner) {
        System.out.print("Enter Product ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter Product Name: ");
        String name = scanner.next();
        System.out.print("Enter Product Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Stock Quantity: ");
        int quantity = scanner.nextInt();

        Product product = new Product(id, name, price, quantity);
        productService.addProduct(product);
        System.out.println("Product added successfully!");
    }

    private static void removeProduct(Scanner scanner) {
        System.out.print("Enter Product ID to remove: ");
        int id = scanner.nextInt();
        productService.removeProduct(id);
        System.out.println("Product removed successfully!");
    }

    private static void viewProducts() {
        System.out.println("Products:");
        for (Product product : productService.getAllProducts()) {
            System.out.println(product);
        }
    }

    private static void createCustomer(Scanner scanner) {
        System.out.print("Enter User ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter Username: ");
        String username = scanner.next();
        System.out.print("Enter Email: ");
        String email = scanner.next();
        System.out.print("Enter Address: ");
        String address = scanner.next();

        Customer customer = new Customer(id, username, email, address);
        customerService.addCustomer(customer);
        System.out.println("Customer created successfully!");
    }

    private static void viewCustomers() {
        System.out.println("Customers:");
        for (Customer customer : customerService.getAllCustomers()) {
            System.out.println(customer);
        }
    }

    private static void placeOrder(Scanner scanner) {
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        Customer customer = customerService.getCustomerById(customerId);

        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }

        Order order = new Order(orderCounter++, customer, "Pending");

        while (true) {
            System.out.print("Enter Product ID to add to order (or -1 to complete): ");
            int productId = scanner.nextInt();

            if (productId == -1) {
                break;
            }

            Product product = productService.getAllProducts().stream()
                    .filter(p -> p.getProductId() == productId)
                    .findFirst()
                    .orElse(null);

            if (product == null) {
                System.out.println("Product not found!");
                continue;
            }

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            order.addProduct(product, quantity);
        }

        customer.addOrder(order);
        System.out.println("Order placed successfully!");
    }
}
