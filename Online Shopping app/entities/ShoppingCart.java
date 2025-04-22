package entities;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Product, Integer> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public void addItem(Product product, int quantity) {
        items.put(product, quantity);
    }

    public void removeItem(Product product) {
        items.remove(product);
    }

    @Override
    public String toString() {
        StringBuilder cartDetails = new StringBuilder("ShoppingCart:\n");
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            cartDetails.append("Product: ").append(entry.getKey().getName())
                    .append(", Quantity: ").append(entry.getValue()).append("\n");
        }
        return cartDetails.toString();
    }
}
