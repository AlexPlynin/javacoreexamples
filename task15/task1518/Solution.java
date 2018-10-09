package com.javarush.task.task15.task1518;

/* 
Статики и котики
*/

public class Solution {
    public static Cat cat;
    static {
        cat = new Cat();
        System.out.println(cat.name);// почему инициализация работает без мэйн?
    }

    public static void main(String[] args) {
       // Solution solution = new Solution();

    }
public static class Cat {
        public String name;
    {
        name = "Barsik";//инициализация обычных полей скрытое поле
    }
    }
}
