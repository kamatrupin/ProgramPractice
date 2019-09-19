package com.playground.practice.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rkamat on 8/15/2018.
 */
public class StockBuySellToFindMaxGain {

    public static double maxGain(double[] price) {
        double max_gain = 0.0;
        int buyingIndex = 0;
        int sellingIndex = 0;

        for(int i=0; i<price.length; i++) {

            // Traverse till the buying point
            while(i<price.length-1 && price[i] >= price[i+1]) {
                i++;
            }

            // Buy
            if(price[buyingIndex] > price[i]) {
                buyingIndex = i;
            }
            i++;

            while(i<price.length-1 && price[i] >= price[i-1]) {
                i++;
            }

            if(i == price.length) break;

            i--;
            sellingIndex = i;

            max_gain = price[sellingIndex] - price[buyingIndex];
        }

        return max_gain;
    }

    public static void main(String args []) {
        double arr [] = {100, 99, 98, 97, 98, 99, 98, 99, 100, 101, 100, 99};
        System.out.println("Max gain: " + maxGain(arr));
    }
}
