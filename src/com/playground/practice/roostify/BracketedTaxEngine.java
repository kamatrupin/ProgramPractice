package com.playground.practice.roostify;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 * 0 - 10  = 10%
 * 10 - 20 = 20%
 * 20 - 50 = 30%
 *
 * Brackets 0 - 10 - 20 - 50
 * Percent    10 - 20 - 30
 *
 */
public class BracketedTaxEngine {

    private static final HashMap<Double, Double> cache = new HashMap<>();

    static {
        cache.put(0.0, 0.0);
        cache.put(10000.0, 0.0);
        cache.put(20000.0, 1000.0);
        cache.put(50000.0, 7000.0);
    }

    private static double calculateTaxAmount(List<TaxBracket> taxBrackets, double income) {
        if(income == 0.0) return 0.0;

        double taxAmount = 0.0;
        // Check if the income falls under the highest bracket
        if(income > taxBrackets.get(0).low) {
            double portion = income - taxBrackets.get(0).low;
            return taxAmount + portion * (taxBrackets.get(0).percent/100) + cache.get(taxBrackets.get(0).low);
        } else {
            for(int i=1; i<taxBrackets.size(); i++) {
                TaxBracket bracket = taxBrackets.get(i);
                if(income > bracket.low)
                    return taxAmount + ((income - bracket.low) * (bracket.percent/100)) + cache.get(bracket.low);
            }
        }

        return taxAmount;
    }

    /*
     *  This function will perform binary search on the list of brackets to find the bracket income falls into.
     *  This step will come into the picture only when the income is less than the max bracket.
     */
    private static int findMatchingBracket(List<TaxBracket> taxBrackets) {
        return 0;
    }

    /*
     *  Cache tax amount for each bracket to avoid repeat calculations.
     */
    private static void buildCache(List<TaxBracket> taxBrackets) {

    }

    public static void main(String[] args) {
        List<TaxBracket> taxBrackets = Arrays.asList(new TaxBracket(50000.0, null, 30.0),
                                                        new TaxBracket(20000.0, 50000.0, 20.0),
                                                        new TaxBracket(10000.0, 20000.0, 10.0),
                                                        new TaxBracket(0.0, 10000.0, 0.0));

        System.out.println(calculateTaxAmount(taxBrackets, 0.0));
        System.out.println(calculateTaxAmount(taxBrackets, 120000.0));
        System.out.println(calculateTaxAmount(taxBrackets, 25000.0));
        System.out.println(calculateTaxAmount(taxBrackets, 27000.0));
    }

    private static class TaxBracket {
        Double low, high, percent;

        public TaxBracket(Double low, Double high, Double percent) {
            this.low = low;
            this.high = high;
            this.percent = percent;
        }
    }
}
