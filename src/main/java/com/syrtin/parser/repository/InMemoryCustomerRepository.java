package com.syrtin.parser.repository;

import com.syrtin.parser.model.Customer;

import java.util.HashMap;
import java.util.Map;


public class InMemoryCustomerRepository implements CustomerRepository {

    private final Map<Long, Customer> customers = new HashMap<>();

    @Override
    public Customer save(Customer customer) {
        Customer result = customers.get(customer.getId());
        if (result != null) {
            customer = result.clone();
        }
        customers.put(customer.getId(), customer);

        return customers.get(customer.getId());
    }
}
