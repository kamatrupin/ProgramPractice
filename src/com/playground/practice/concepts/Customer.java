package com.playground.practice.concepts;

import java.util.Calendar;
import java.util.Date;

public class Customer {
    private String name;
    private CustomDate dob;

    public Customer(String name, CustomDate dob) {
        this.name = name;
        this.dob = dob;
    }

    public CustomDate getDob() {
        return dob;
    }
}
