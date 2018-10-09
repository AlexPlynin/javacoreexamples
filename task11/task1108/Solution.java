package com.javarush.task.task11.task1108;

/* 
Неприступный кот
Неприступный кот
Скрыть все внутренние переменные класса Cat, а также методы, позволяющие менять внутреннее состояние объектов класса Cat.


Требования:
1. Переменная name класса Cat должна быть скрыта.
2. Переменная age класса Cat должна быть скрыта.
3. Переменная weight класса Cat должна быть скрыта.
4. Геттер getName должен быть публичным.
5. Сеттер setName должен быть приватным.
6. Геттер getAge должен быть публичным.
7. Сеттер setAge должен быть приватным.
*/

public  class Solution {
    public static void main(String[] args) {
        Cat vaska = new Cat("Pes",3,13);
        vaska.setAge(40);
        System.out.println(vaska.getAge());//бессмысленно так как сам класс объявлен как статик!

    }

    public static class Cat {
        private String name;
        private int age;
        private int weight;

        public Cat(String name, int age, int weight) {
            this.name = name;
            this.age = age;
            this.weight = weight;
        }

        public String getName() {
            return name;
        }

        private void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        private void setAge(int age) {
            this.age = age;
        }
    }
}
