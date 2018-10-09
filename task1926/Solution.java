package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(fileName));
        String line;
        StringBuilder sb = new StringBuilder();
//        while (matcher.find()) {
//            System.out.println(line.substring(matcher.start(),matcher.end()));
//        }
        while ((line = bufferedReader2.readLine()) != null) {
            System.out.println(sb.append(line).reverse());
            sb.setLength(0);//очищение сб
//
        }
        bufferedReader.close();
        bufferedReader2.close();

    }
}
