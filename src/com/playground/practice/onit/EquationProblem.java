package com.playground.practice.onit;

public class EquationProblem {

    public static void main(String[] args) {
        System.out.println(solveEquation(2, 3));
    }

    /**
     * Equation -
     *
     * x^2/x + x^2-n/x+1 + x^2-(n-1)/x+2 + . . . + x^2-1/x+n
     */
    public static double solveEquation(int x, int n) {
        double sum = (Math.pow(x,2)/x);

        for(int i=0; i<n; i++) {
            sum = sum + ((Math.pow(x,2)-(n-i)) / (x+(i+1)));
        }

        return sum;
    }
}
