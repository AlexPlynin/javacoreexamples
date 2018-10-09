package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
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
        testString.printSomething();
        //testString.printSomething();
        String line = byteArrayOutputStream.toString().replaceAll("te","??");
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
