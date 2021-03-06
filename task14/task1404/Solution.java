package com.javarush.task.task14.task1404;

/* 
Коты
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    //static String name;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String name;
        ArrayList<Cat> cats = new ArrayList<>();
        while (true) {
            name = sc.nextLine();
            if (name.isEmpty()) break;
            Cat cat = CatFactory.getCatByKey(name);
           // System.out.println(cat);//напишите тут ваш код
            cats.add(cat);
        }

        for (Cat cat:cats) {
            System.out.println(cat);

        }
    }

    static class CatFactory {
        static Cat getCatByKey(String key) {
            Cat cat = null;
            if ("vaska".equals(key)) {
                cat = new MaleCat("Василий");
            } else if ("murka".equals(key)) {
                cat = new FemaleCat("Мурочка");
            } else if ("kiska".equals(key)) {
                cat = new FemaleCat("Кисюлька");
            } else {
                cat = new Cat(key);
            }
            return cat;
        }
    }

    static class Cat {
        private String name;

        protected Cat(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public String toString() {
            return "Я уличный кот " + getName();
        }
    }

    static class MaleCat extends Cat {
        MaleCat(String name) {
            super(name);
        }

        public String toString() {
            return "Я - солидный кошак по имени " + getName();
        }
    }

    static class FemaleCat extends Cat {
        FemaleCat(String name) {
            super(name);
        }

        public String toString() {
            return "Я - милая кошечка по имени " + getName();
        }
    }
}
