package com.syrtin.parser.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Phone implements Cloneable{

    private Long id;

    private String number;

    private Customer customer;

    public Phone(Customer customer, String number) {
        this.number = number;
        this.customer = customer;
    }
}
