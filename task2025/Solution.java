package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;

/*
Алгоритмы-числа
*/
public class Solution {
    public static Long[] getNumbers(long N) {
        //String num = String.valueOf(N);
        //char[] number = num.toCharArray();
        Long[] result;
        char[] number;
        ArrayList<Long> list = new ArrayList<>();
        long sum = 0;
        for (int i = 0; i < N; i++) {
            //sumOfDef(i);
            number = String.valueOf(i).toCharArray();
            sum = 0;
            for (char aNumber : number) {
                sum += Math.pow(Character.getNumericValue(aNumber), number.length);
                // System.out.println(sum);
            }

            if (sum == i) {

                System.out.println("Число армстронга: " + i);
                list.add((long) i);

            }

        }

        result = list.toArray(new Long[0]);


        return result;
    }

//    public static void sumOfDef(int n) {
//        char[] number = String.valueOf(n).toCharArray();
//        long sum = 0;
//        for (char aNumber : number) {
//            sum += Math.pow(Character.getNumericValue(aNumber), number.length);
//            System.out.println(sum);
//        }
//
//        if (sum == n) {
//
//            System.out.println("Число армстронга: " + n);
//
//        }
//
//    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        //sumOfDef(9);

        getNumbers(3);
        //Arrays.toString(getNumbers(9));
        long end = System.currentTimeMillis() - start;
        System.out.println(end);
    }
}
