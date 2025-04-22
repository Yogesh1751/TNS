package entities;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private int orderId;
    private Customer customer;
    private Map<Product, Integer> products; // Product and quantity
    private String status;

    // Constructor with orderId, customer, and status
    public Order(int orderId, Customer customer, String status) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new HashMap<>(); // Initialize empty product list
        this.status = status;
    }

    // Getters and setters
    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void addProduct(Product product, int quantity) {
        this.products.put(product, quantity);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder orderDetails = new StringBuilder("Order ID: " + orderId + ", Status: " + status + "\n");
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            orderDetails.append("Product: ").append(entry.getKey().getName())
                    .append(", Quantity: ").append(entry.getValue()).append("\n");
        }
        return orderDetails.toString();
    }
}
