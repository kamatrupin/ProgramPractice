package com.playground.practice.algorithms;

import java.util.Stack;

public class StockSpanProblem {

    public static int [] getStockSpan(int [] arr, int n) {
        int [] res = new int[arr.length];

        Stack<Integer> stack = new Stack<>();

        res[0] = 1;
        stack.push(0);

        for(int i=1; i<n; i++) {

            while(!stack.empty() && (arr[stack.peek()] <= arr[i])) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? i+1 : i - stack.peek();
            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int [] arr = {100, 80, 60, 70, 60, 75, 85};
        int [] res = getStockSpan(arr, arr.length);

        for(int num : res) {
            System.out.print(num + " ");
        }
    }
}
