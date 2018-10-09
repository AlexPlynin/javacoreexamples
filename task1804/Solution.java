package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());

        long[] arrBytes = new long[256];
        long startTime = System.currentTimeMillis();

        while (inputStream.available() > 0) arrBytes[inputStream.read()]++;

        inputStream.close();
        // Выводим отсортированный по байт-коду в обратном порядке
        int min =0;
        // Находим правильный минимум
        for (long i = 255; i >= 0 ; i--) {
            if (arrBytes[(int) i] > 0 ) {
                //System.out.print(i + "("+arrBytes[(int) i]+")"+" ");//очень круто
                min = (int) arrBytes[(int) i];
                break;
            }
        }
        for (long i = 255; i >= 0 ; i--) {
            if (arrBytes[(int) i] > 0 && arrBytes[(int) i] < min  ) {
                //System.out.print(i + "("+arrBytes[(int) i]+")"+" ");//очень круто
                min = (int) arrBytes[(int) i];

            }
        }
       // System.out.println(min);
        for (long i = 255; i >= 0 ; i--) {
            if (arrBytes[(int) i] == min  ) {
                //System.out.print(i + "("+arrBytes[(int) i]+")"+" ");//очень круто
                System.out.print(i+" ");

            }
        }




        //long finishTime = System.currentTimeMillis();
        //System.out.println("\nвремя работы=" + (finishTime-startTime) + "ms.");
    }

}
