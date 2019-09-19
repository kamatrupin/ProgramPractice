package com.playground.practice.egen;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestClass {

    public static void main(String[] args) {
        // Find the Top 10 high spending customers during June
        List<Order> orders = new ArrayList<>();
//        orders.add(new Order(1, 10.3, new Timestamp(), "someone@something.com"));
//        orders.add(new Order(2, 10.3, new Timestamp(), "someone@something.com"));
//        orders.add(new Order(3, 10.3, new Timestamp(), "someone@something.com"));
//        orders.add(new Order(4, 10.3, new Timestamp(), "someone@something.com"));

    }

    private List<Order> top10List(List<Order> orders) {
        orders.stream()
                .filter(TestClass::isDateInJune)
                .collect(Collectors.groupingBy(Order::getEmailId, Collectors.summingDouble(Order::getAmount)));
        return null;
    }

    private static boolean isDateInJune(Order order) {
        return true;
    }
}
