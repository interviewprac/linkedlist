package com.current;

import java.math.BigInteger;

public class Micro {

    public static void main(String[] args) {

        System.out.println(calculateCombinations(100,100));
    }

    static long calculateCombinations(int n, int k) {
        // Write your code here.


        BigInteger product = BigInteger.valueOf(1);
        int limit = n-k+1;
        int j =n;
        while(j>=limit)
        {
            product = product.multiply(BigInteger.valueOf(j));
            //product*=j;
            j=j-1;
        }

        BigInteger fact = factorial(k);
        return (product.divide(fact).longValue());

    }

    public static BigInteger factorial(int num){
        if (num<=1)
            return BigInteger.ONE;
        else return factorial(num - 1).multiply(BigInteger.valueOf(num));
    }

    static long factorialn(int num){
        if (num == 0)
            return 1;
        else
            return(num * factorialn(num-1));
    }


}
