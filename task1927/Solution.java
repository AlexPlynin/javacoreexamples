package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream printStream = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(byteArrayOutputStream);

        System.setOut(stream);
        testString.printSomething();
        System.setOut(printStream);
        String [] st = byteArrayOutputStream.toString().split("\\n"); // режем вывод на консоль по строкам
        int i = 0;
        for (String sti : st) { // пока есть строки, что загнаны в наш массив
            System.out.println(sti); // выводим первую строку
            i++; // считаем счетчик второй строки
            if  ((i % 2) == 0) { // если строка третья, то выводим в консоль рекламу
                System.out.println("JavaRush - курсы Java онлайн");
            }
        }
       // System.setOut(printStream);
       // System.out.println(line);


    }






    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
