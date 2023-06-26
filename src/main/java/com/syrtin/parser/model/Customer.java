package com.syrtin.parser.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Customer implements Cloneable {

    private Long id;

    private String name;

    private Address address;

    private List<Phone> phones;

    public Customer(String name) {
        this.id = null;
        this.name = name;
    }

    public Customer(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Customer(Long id, String name, Address address, List<Phone> phones) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phones = phones;
        if (phones != null) {
            phones.forEach(phone -> phone.setCustomer(this));
        }
    }

    @Override
    public Customer clone() {
        List<Phone> phonesCopy = this.phones != null ? new ArrayList<>(this.phones) : null;
        Customer customer = new Customer(this.id, this.name, this.address, phonesCopy);
        if (phonesCopy != null) {
            phonesCopy.forEach(phone -> phone.setCustomer(customer));
        }
        return customer;
    }
}
