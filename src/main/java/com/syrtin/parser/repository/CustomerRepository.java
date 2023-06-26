package com.syrtin.parser.repository;

import com.syrtin.parser.model.Customer;

public interface CustomerRepository {
    Customer save(Customer customer);
}
