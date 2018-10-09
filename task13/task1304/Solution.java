package com.javarush.task.task13.task1304;

/* 
Selectable и Updatable
Selectable и Updatable
Создай класс Screen и реализуй в нем интерфейсы Selectable и Updatable.
Не забудь реализовать методы!


Требования:
1. Класс Screen должен реализовывать(implements) интерфейс Selectable.
2. Класс Screen должен реализовывать(implements) интерфейс Updatable.
3. В классе Screen должен быть реализован метод onSelect интерфейса Selectable.
4. В классе Screen должен быть реализован метод refresh интерфейса Updatable.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    Screen screen = new Screen();
    screen.onSelect();
    screen.refresh();
    }

    interface Selectable {
        void onSelect();
    }

    interface Updatable {
        void refresh() throws InterruptedException;
    }

    public static class Screen implements Selectable,Updatable{
        @Override
        public void onSelect() {
            System.out.println("Target lock");
        }

        @Override
        public void refresh() throws InterruptedException {

            System.out.println("\tTarget lost");
            System.out.println("\tRefresh");
            for (int i = 0; i < 10; i++) {
                System.out.print("*");
                Thread.sleep(100);
            }

        }
    }

    //напишите тут ваш класс
}
