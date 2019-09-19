package com.playground.practice.algorithms;

import java.util.Stack;

/**
 * Created by rkamat on 3/7/2018.
 */
public class ExpressionEvaluation {

    public static Integer evalOperation(Character op, Integer a, Integer b) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }

        return 0;
    }

    public static void main(String args[]) {

        String expression = "100 / ( 2 + 12 ) * 14";

        Stack<Integer> values = new Stack<>();
        Stack<Character> operands = new Stack<>();

        char [] tokens = expression.toCharArray();

        for(int i=0; i<tokens.length; i++) {

            char ch = tokens[i];

            if(ch == ' ') {
                continue;
            }

            if(ch >= '0' && ch <= '9') {
                StringBuffer sbuf = new StringBuffer();
                while(ch >= '0' && ch <= '9') {
                    sbuf.append(ch);
                    i++;
                    if(i < tokens.length) {
                        ch = tokens[i];
                    } else {
                        break;
                    }
                }
                values.push(Integer.parseInt(sbuf.toString()));
            } else if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                operands.push(ch);
            } else if(ch == '(') {
                operands.push(ch);
            } else if(ch == ')') {
                while(operands.peek() != '(') {
                    values.push(evalOperation(operands.pop(), values.pop(), values.pop()));
                }
                operands.pop();
            }
        }

        while(!operands.empty()) {
            values.push(evalOperation(operands.pop(), values.pop(), values.pop()));
        }

        System.out.println("The evaluation of the expression is = " + values.pop());
    }
}
