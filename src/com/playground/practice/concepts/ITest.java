package com.playground.practice.concepts;

public class ITest {

    public static void main(String[] args) {
        CustomDate customDate = new CustomDate(1,2,3);
        Customer customer = new Customer("", customDate);
        System.out.println(customer.getDob());
        customDate.setMm(5);
        System.out.println(customer.getDob());
    }
}
