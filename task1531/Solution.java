package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());

        reader.close();

        System.out.println(factorial(input));

        //System.out.println("");
    }

    public static String factorial(int n) {
        //add your code here
        //BigInteger bi = new BigInteger();
//        if (n<0) return String.valueOf(n);
//      //  BigInteger.
//        BigInteger x ;
//        // n == 0 ? 1 :Long.valueOf(n*Long.parseLong(factorial(n-1)));
//        x = BigInteger.valueOf(n == 0 ? 1 :Long.valueOf(n*Long.parseLong(factorial(n-1))));
//        return String.valueOf(x);
        BigInteger x = new BigInteger(String.valueOf(1));
        if (n < 0) return "" + 0;
        else if (n==0) return ""+1;
        else {
            for (int i = 1; i <n+1 ; i++) {
                x=x.multiply(BigInteger.valueOf(i));
            }
            return x+"";
        }


    }
}
