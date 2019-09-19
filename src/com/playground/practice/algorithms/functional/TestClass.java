package com.playground.practice.algorithms.functional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestClass {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "zbc"));
        list.add(new Employee(2, "abcs"));
        list.add(new Employee(3, "dabcd"));
        list.add(new Employee(4, "abcf"));

        list.stream().collect(Collectors.toMap(Employee::getId, Employee::getName)).entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).forEach(System.out::println);
    }

    private static class Employee {
        int id;
        String name;

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
