package services;

import entities.Product;

import java.util.List;

import java.util.ArrayList;

public class ProductService {
    private List<Product> productCatalog;

    public ProductService() {
        this.productCatalog = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productCatalog.add(product);
    }

    public void removeProduct(int productId) {
        productCatalog.removeIf(product -> product.getProductId() == productId);
    }

    public List<Product> getAllProducts() {
        return productCatalog;
    }
}
