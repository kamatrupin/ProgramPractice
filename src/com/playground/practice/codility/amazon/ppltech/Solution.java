package com.playground.practice.codility.amazon.ppltech;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private Map<String, Integer> emailAddCountMap = new HashMap<>();

    // Assumption - First name and Last name will not be empty / null and will have minimum one letter
    public String solution(String S, String C) {

        if(S == null || S.isEmpty()) {
            return "";
        }

        StringBuilder sbuf = new StringBuilder();

        String [] names = S.split(";");

        for(int i=0; i<names.length; i++) {
            String name = names[i].trim();

            // Add name in the output string
            sbuf.append(name);

            // Append email address
            sbuf.append(" <").append(appendEmailAddress(name.toLowerCase())).append("@").append(C.toLowerCase()).append(".com").append(">");

            if(i < names.length - 1) {
                sbuf.append("; ");
            }
        }

        return sbuf.toString();
    }

    private String appendEmailAddress(String name) {
        StringBuilder sbuf = new StringBuilder();

        String [] nameArr = name.split(" ");
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

        return sbuf.toString();
    }

    private void appendLastName(int index, String [] nameArr, StringBuilder sbuf) {
        String lastName = nameArr[index].replaceAll("-", "");
        if(lastName.length() > 8) {
            sbuf.append(lastName.substring(0, 8));
        } else {
            sbuf.append(lastName);
        }
    }

    public static void main(String[] args) {

        String input = "John Doe; Peter Parker; Mary Jane Watson-Parker; James Doe; John Elvis Doe; Jane Doe; Penny Parker";

        Solution sol = new Solution();
        System.out.println(sol.solution(input, "Company"));
    }
}
