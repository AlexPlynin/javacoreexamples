package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        int numberOfP = 0;
        int numberOfSym = 0;
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            numberOfSym+=line.length();
            for (int i = 0; i <line.length() ; i++) {
                if (line.charAt(i)==' '){
                    numberOfP++;
                }
            }
        }
        System.out.printf("%.2f",(float) numberOfP/numberOfSym*100);//форматируем вывод
        //System.out.println((double) numberOfP/(numberOfSym*100));
        bufferedReader.close();
    }
}
