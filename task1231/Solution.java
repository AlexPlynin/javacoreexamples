package com.javarush.task.task12.task1231;

/* 
Ненужные абстракции
Ненужные абстракции
Необходимо расставить правильно ключевые слова abstract, чтобы программа компилировалась.
Добавь там где надо и удали там, где они не нужны.


Требования:
1. Класс Pegas должен реализовывать интерфейс Fly.
2. Класс Pegas должен наследоваться от класса Horse.
3. Класс SwimPegas должен наследоваться от класса Pegas.
4. Обьект класса Horse создать можно.
5. Обьект класса Pegas создать можно.
6. Метод swim() класса SwimPegas не должен иметь реализации.
*/

public class Solution {

    public static void main(String[] args) {
        Horse horse = new Horse();
        horse.run();
        Pegas pegas = new Pegas();
        pegas.fly();
        pegas.run();
    }

    public static interface Fly {
        public abstract void fly();
    }

    public static  class Horse {
        public void run() {
            System.out.println("Я"+this.getClass().getSimpleName()+"умею бегать!");

        }
    }

    public  static class Pegas extends Horse implements Fly {
        public  void fly() {
            System.out.println("Я лечуууу");

        }

        @Override
        public void run() {
            super.run();
        }
    }

    public  static abstract   class SwimPegas extends Pegas {
        public abstract void swim();
    }

}
