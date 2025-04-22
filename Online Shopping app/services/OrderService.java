package services;

import entities.Customer;
import entities.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private List<Order> orders = new ArrayList<>();

    public Order createOrder(Customer customer) {
        Order order = new Order(orders.size() + 1, customer, "Pending");
        orders.add(order);
        return order;
    }

    public Order getOrder(int orderId) {
        return orders.stream().filter(o -> o.getOrderId() == orderId).findFirst().orElse(null);
    }
}
