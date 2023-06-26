package com.syrtin.parser.service;

import com.syrtin.parser.model.Customer;
import com.syrtin.parser.repository.CustomerRepository;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

import static com.syrtin.parser.utils.JsonUtils.*;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void parseAndSave(HttpServletRequest request) {
        try {
            var customer = getObjectFromRequest5(request, Customer.class);
            customerRepository.save(customer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
