package com.playground.practice.codility.amazon.ppltech;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem2Eff {

    private Map<String, Integer> emailAddCountMap = new ConcurrentHashMap<>();
    private String company;

    // Assumption - First name and Last name will not be empty / null and will have minimum one letter
    public String solution(String S, String C) {
        if(S == null || S.isEmpty()) {
            return "";
        }

        this.company = C;

        return Stream.of(S.split(";")).map(this::appendEmailAddress).collect(Collectors.joining("; "));
    }

    private String appendEmailAddress(String name) {
        name = name.trim();
        String eName = name.toLowerCase();

        StringBuffer sbuf = new StringBuffer();

        String [] nameArr = eName.split(" ");
        sbuf.append(nameArr[0].charAt(0)).append("_");

        if(nameArr.length == 3) {
            sbuf.append(nameArr[1].charAt(0)).append("_");

            // lastname
            appendLastName(2, nameArr, sbuf);
        } else {
            // lastname
            appendLastName(1, nameArr, sbuf);
        }

        if(emailAddCountMap.containsKey(sbuf.toString())) {
            int emailAddressCount = emailAddCountMap.get(sbuf.toString());
            emailAddCountMap.put(sbuf.toString(), emailAddressCount + 1);
            sbuf.append(emailAddressCount + 1);
        } else {
            emailAddCountMap.put(sbuf.toString(), 1);
        }

        sbuf.insert(0, name + " <").append(String.format("@%s.com>", company.toLowerCase()));

        return sbuf.toString();
    }

    private void appendLastName(int index, String [] nameArr, StringBuffer sbuf) {
        String lastName = nameArr[index].replaceAll("-", "");
        if(lastName.length() > 8) {
            sbuf.append(lastName, 0, 8);
        } else {
            sbuf.append(lastName);
        }
    }

    public static void main(String[] args) {

        String input = "John Doe; Peter Parker; Mary Jane Watson-Parker; James Doe; John Elvis Doe; Jane Doe; Penny Parker";

        Problem2Eff sol = new Problem2Eff();
        System.out.println(sol.solution(input, "Example"));
    }
}
