package com.javarush.task.task16.task1626;

public class Solution {
    public static int number = 5;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new CountDownRunnable(), "Уменьшаем").start();
        new Thread(new CountUpRunnable(), "Увеличиваем").start();
       // Thread.sleep(2500);

    }

    public static class CountUpRunnable implements Runnable {
        private int countIndexUp = 1;

        @Override
        public void run() {
            try {
               // Thread.sleep(2400);
               // Thread.sleep(2500);
                while (true) {
                    Thread.sleep(500);
                    System.out.println(toString());
                    countIndexUp += 1;

                    if (countIndexUp == Solution.number) {
                        Thread.sleep(500);
                        System.out.println(toString());
                        return;
                    }


                }
            } catch (InterruptedException e) {

            }

        }

        @Override
        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexUp;
        }

        //Add your code here - добавь код тут
    }


    public static class CountDownRunnable implements Runnable {
        private int countIndexDown = Solution.number;

        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countIndexDown -= 1;
                    if (countIndexDown == 0) return;
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexDown;
        }
    }
}
