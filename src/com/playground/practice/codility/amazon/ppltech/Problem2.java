package com.playground.practice.codility.amazon.ppltech;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class Problem2 {

    private Map<String, Integer> emailAddCountMap = new ConcurrentHashMap<>();

    // Assumption - First name and Last name will not be empty / null and will have minimum one letter
    public String solution(String S, String C) {

        if(S == null || S.isEmpty()) {
            return "";
        }

        String s = Stream.of(S.split(";")).collect(StringBuffer::new, (res, name) -> res.append(name.trim()).append(" <").append(appendEmailAddress(name.trim().toLowerCase())).append("@").append(C.toLowerCase()).append(".com").append(">").append("; "), (res1, res2) -> res1.append(res2.toString())).toString();
        return s.substring(0, s.length()-2);
    }

    private String appendEmailAddress(String name) {
        StringBuffer sbuf = new StringBuffer();

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

//        System.out.println(emailAddCountMap);

        return sbuf.toString();
    }

    private void appendLastName(int index, String [] nameArr, StringBuffer sbuf) {
        String lastName = nameArr[index].replaceAll("-", "");
        if(lastName.length() > 8) {
            sbuf.append(lastName.substring(0, 8));
        } else {
            sbuf.append(lastName);
        }
    }

    public static void main(String[] args) {

        String input = "John Doe; Peter Parker; Mary Jane Watson-Parker; James Doe; John Elvis Doe; Jane Doe; Penny Parker";

        Problem2 sol = new Problem2();
        System.out.println(sol.solution(input, "Company"));
    }
}
