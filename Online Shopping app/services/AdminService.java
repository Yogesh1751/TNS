package services;

import entities.Product;

import java.util.ArrayList;
import java.util.List;

public class AdminService {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(Product product) {
        // Logic to update a product in the list
    }

    public void removeProduct(int productId) {
        products.removeIf(p -> p.getProductId() == productId);
    }

    public List<Product> getAllProducts() {
        return products;
    }
}
