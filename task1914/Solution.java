package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();
    //static PrintStream printStream = System.out;

    public static void main(String[] args) {
        //запоминаем настоящий PrintStream в специальную переменную
        PrintStream printStream = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(byteArrayOutputStream);
        System.setOut(stream);
        testString.printSomething();
        //testString.printSomething();
        String line = doSomeAction(byteArrayOutputStream.toString());
        //String line2 = byteArrayOutputStream.toString().substring(2, 3);
        //testString.printSomething();
        System.setOut(printStream);
        //System.out.println(line2);
        System.out.println(line);

    }

    public static class TestString {
        public void printSomething() {
            System.out.print("3 + 6 = ");
        }
    }//учесть многозначность!


    public static String doSomeAction(String line) {
        int answer = 0;
        //System.setOut(printStream);
        //System.out.print(sign);
        Pattern pattern = Pattern.compile("\\b\\d+\\b");//граница слова
        Pattern pattern2 = Pattern.compile("[+\\-*]");//граница слова
        Matcher matcher = pattern.matcher(line);
        //String[] nums = new String[2];
        ArrayList<String> list = new ArrayList<>();
        while (matcher.find()) {
            list.add(line.substring(matcher.start(), matcher.end()));


        }
        matcher = pattern2.matcher(line);

        String sign = null;
        while (matcher.find()) {
            sign = line.substring(matcher.start(), matcher.end());
        }

        if (sign.equals("+")) answer = Integer.valueOf(list.get(0)) + Integer.valueOf(list.get(1));
        if (sign.equals("-")) answer = Integer.valueOf(list.get(0)) - Integer.valueOf(list.get(1));
        if (sign.equals("*")) answer = Integer.valueOf(list.get(0)) * Integer.valueOf(list.get(1));
//        if (sign.equals("-")) answer = Integer.valueOf(line.substring(0, 1)) - Integer.valueOf(line.substring(4, 5));
//        if (sign.equals("*")) answer = Integer.valueOf(line.substring(0, 1)) * Integer.valueOf(line.substring(4, 5));
        String result = String.valueOf(answer);
        return line+result;
    }
}

