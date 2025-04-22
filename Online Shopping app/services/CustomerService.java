package services;

import entities.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private List<Customer> customers;

    public CustomerService() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }

    public Customer getCustomerById(int customerId) {
        return customers.stream()
                .filter(customer -> customer.getUserId() == customerId)
                .findFirst()
                .orElse(null);
    }
}
