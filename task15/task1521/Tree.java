package com.javarush.task.task15.task1521;

public class Tree {
    public static int globalNumber;
    public int number;

    public Tree() {
        this.number = ++globalNumber;
    }

    public void info(Object s) {
        System.out.println(String.format("Дерево № %d , метод Object, параметр %s", number, s.getClass().getSimpleName()));
    }
    public void info(Number s) {//(Number неявно приведется к Integer)переменная s в нее будет скопированны биты ссылки на (к примеру new Integer()) и при вызове  s.getClass().getSimpleName())) будет ссылаться на Integer
        System.out.println(String.format("Дерево № %d , метод Number, параметр %s", number, s.getClass().getSimpleName()));
    }
    public void info(String s) {
        System.out.println(String.format("Дерево № %d , метод String, параметр %s", number, s.getClass().getSimpleName()));
    }
}
