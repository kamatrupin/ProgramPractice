package com.playground.practice.concepts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestClass {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "abc"));
        employees.add(new Employee(2, "abca"));
        employees.add(new Employee(3, "abdc"));
        employees.add(new Employee(4, "aabc"));
        employees.add(new Employee(5, "abbc"));

        Map<Integer, String> map = employees.stream().collect(Collectors.toMap(Employee::getId, Employee::getName));
        System.out.println();

        List<String> list = employees.stream().map(s -> s.name).collect(Collectors.toList());
        System.out.println();

        List<String> list1 = employees.stream().map(s -> s.name.toUpperCase()).collect(Collectors.toList());
        System.out.println();
    }

    private static class Employee {
        Integer id;
        String name;

        public Employee(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
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
