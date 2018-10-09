package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        //запоминаем настоящий PrintStream в специальную переменную

        PrintStream printStream = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(byteArrayOutputStream);
        System.setOut(stream);
        testString.printSomething();//суть в том что данной строкой мы пишем в наш байтаррэй динамически расширяемый
        //testString.printSomething();
        String line = byteArrayOutputStream.toString().toUpperCase();
        //testString.printSomething();
        System.setOut(printStream);
        System.out.println(line);
    }

    public static class TestString {
        public void printSomething() {

            System.out.println("it's a text for testing");
        }
    }
}
