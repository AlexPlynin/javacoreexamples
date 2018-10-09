package com.javarush.task.task13.task1301;

/* 
Пиво
Пиво
1. Подумай, какой из двух интерфейсов нужно реализовать в классе Beer.
2. Добавь к классу Beer этот интерфейс и реализуй все его методы.
3. Подумай, как связаны переменная READY_TO_GO_HOME и метод isReadyToGoHome.
4. Верни значение переменной READY_TO_GO_HOME в методе isReadyToGoHome.


Требования:
1. Класс Beer должен реализовывать(implements) интерфейс Alcohol.
2. Класс Beer не должен реализовывать интерфейс Drink напрямую(только опосредованно через Alcohol)
3. В классе Beer должны быть реализованы все методы интерфейса Alcohol.
4. В классе Beer должны быть реализованы все методы интерфейса Drink.
5. Метод isReadyToGoHome должен возвращать значение переменной READY_TO_GO_HOME.
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        Beer drink = new Beer();
        drink.askMore("Вы меня любите?");
        drink.sayThankYou();
        drink.isReadyToGoHome();
        drink.sleepOnTheFloor();

    }

    public interface Drink {
        void askMore(String message);

        void sayThankYou();

        boolean isReadyToGoHome();
    }

    public interface Alcohol extends Drink {
        boolean READY_TO_GO_HOME = false;

        void sleepOnTheFloor();
    }

    public static class Beer implements Alcohol {

        public void sleepOnTheFloor() {
            System.out.println("Я немного полежу");
        }

        @Override
        public void askMore(String message) {
            System.out.println("Я давно вас хотел спросить"+"\n"+message);
        }

        @Override
        public void sayThankYou() {

            System.out.println("Это вам, на чай!");

        }

        @Override
        public boolean isReadyToGoHome() {
            return READY_TO_GO_HOME;
        }
    }
}