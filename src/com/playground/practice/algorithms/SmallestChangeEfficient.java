package com.playground.practice.algorithms;

import java.util.Arrays;

public class SmallestChangeEfficient {

    private static int change(int amount, int [] coins) {
        int [] cache = new int[amount];

        Arrays.fill(cache, -1);
        cache[0] = 0;

        return change(amount, coins, cache);
    }

    private static int change(int amount, int [] coins, int [] cache) {
        if(amount == 0) return 0;

        int min = amount;
        for(int coin : coins) {
            if(amount - coin >= 0) {
                int change;
                if(cache[amount - coin] >= 0) {
                    change = cache[amount - coin];
                } else {
                    change = change(amount - coin, coins, cache);
                    cache[amount - coin] = change;
                }
                if(min > change + 1) {
                    min = change + 1;
                }
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int [] coins = {20, 10, 5, 1};

        System.out.println(change(79, coins));
    }
}
