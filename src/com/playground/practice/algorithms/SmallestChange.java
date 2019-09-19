package com.playground.practice.algorithms;

public class SmallestChange {

    private static int change(int amount, int [] coins) {
        if(amount == 0) return 0;

        int min = amount;
        for(int coin : coins) {
            if(amount - coin >= 0) {
                int change = change(amount - coin, coins);
                if(min > change + 1) {
                    min = change + 1;
                }
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int [] coins = {20, 10, 5, 1};
        int amoiunt = 37;

        System.out.println(findChange(37, coins));
    }

    private static int findChange(int amount, int [] coins) {
        if(amount == 0) return 0;

        int min = amount;
        for(int coin : coins) {
            if(amount - coin >= 0) {
                int change = findChange(amount - coin, coins);
                if(min > change +1) {
                    min = change +1;
                }
            }
        }

        return min;
    }



















}
