package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

public class Solution {
    public static int minOfNumbers(int a, int b) {
        return a < b ? a : b;
    }

    public static int maxOfNumbers(int a, int b) {
        return a > b ? a : b;
    }

    public static int NOD;

    public static void main(String[] args) throws Exception {
        /*try  {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            int firstNumber = Math.abs(Integer.parseInt(bufferedReader.readLine()));
            int secondNumber = Math.abs(Integer.parseInt(bufferedReader.readLine()));
            int maxN = maxOfNumbers(firstNumber, secondNumber);
            int minN = minOfNumbers(firstNumber, secondNumber);
            int sum;
            boolean keyWord = true;
            //if (maxN == 0 && minN==0) throw new ArithmeticException();
            if (maxN!=0 || minN!=0) {
                while (keyWord) {
                    for (int i = 0; true; i++) {
                        if ((maxN - i * minN < minN) || (maxN - i * minN == 0)) {

                            if (maxN - i * minN == 0) {
                                NOD = minN;
                                keyWord = false;
                                //  break;
                            }

                            int maxNi = minN;
                            minN = maxN - i * minN;
                            maxN = maxNi;
                            i = 0;
                            break;
                        }

                    }
                }
            }
            System.out.println(NOD);

        } catch (Exception e) {
            System.out.println("Исключиельная ситуация " + e.getMessage());
            throw e;
        }
        */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int nod = 0;
        for (int i = 1; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0)
                nod = i;
        }
        if (a <= 0 || b <= 0) {
            throw new Exception();
        }
        System.out.println(nod);

    }


}
