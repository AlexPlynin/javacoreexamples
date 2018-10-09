package com.javarush.task.task15.task1506;

/* 
Что-то лишнее
*/

public class Solution {
    public static void main(String[] args) {
        print((short) 1);
        print((Number) 1);
        print(1);
        print((Integer) 1);
        print((int) 1);
        //Сначала примитив расширяется: byte->short->int->long->float->double.
        // Если не найдёт подходящий метод, то потом упаковывается в свой объект (int->Integer , short -> Short и.т.д) и ищет именно его.
        // Если не находит, сужается (уже будучи объектом) до Number,  и затем до Object.
        //
        //по-моему так.
    }

    public static void print(Integer i) {
        System.out.println("Это Integer");
    }





    public static void print(Object i) {
        System.out.println("Это Object");
    }

    public static void print(double i) {
        System.out.println("Это double");
    }




}
