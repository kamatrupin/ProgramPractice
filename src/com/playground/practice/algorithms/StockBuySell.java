package com.playground.practice.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rkamat on 8/15/2018.
 */
public class StockBuySell {

    public static List<Structure> calculateMaxProfit(int [] arr, int n) {

        List<Structure> list = new ArrayList<>();

        if(n == 1) {
            System.out.println("Error: Need at least 2 items in an array");
            return list;
        }

        for(int i=0; i<n; i++) {
            while(i<n && (arr[i] >= arr[i + 1])) {
                i++;
            }

            Structure struct = new Structure();
            struct.buy = i;
            i++;

            while(i<n && (arr[i] >= arr[i-1])) {
                i++;
            }

            struct.sell = i-1;
            list.add(struct);
            i--;
        }

        return list;
    }

    public static void main(String args []) {
        int arr [] = {100, 183, 260, 310, 40, 535, 695};
        List<Structure> list = calculateMaxProfit(arr, arr.length);

        for(Structure struct : list) {
            System.out.println("Buy: " + struct.buy + ", Sell: " + struct.sell);
        }
    }

    public static class Structure {
        public int buy;
        public int sell;
    }
}
