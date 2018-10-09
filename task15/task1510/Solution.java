package com.javarush.task.task15.task1510;

/* 
Все лишнее - прочь!
*/

public class Solution {
    public static void main(String[] args) {
        add((short) 1, 2f);//расширение в сторону инт 1 аргумента и второго до дабл расширение
        add(1, 2);
        add(2d, 2);//d d

        add((byte) 1, 2d); //int d
    }

    public static void add(int i, int j) {
        System.out.println("Integer addition");
    }

    public static void add(int i, double j) {
        System.out.println("Integer and double addition");
    }

    public static void add(double i, double j) {
        System.out.println("Double addition");
    }
}
