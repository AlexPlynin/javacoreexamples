package com.javarush.task.task16.task1611;

/* 
Часы
*/

public class Solution {
    public static volatile boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException {
        Clock clock = new Clock();
        Thread.sleep(2000);
        isStopped = true;
        System.out.println("Clock has to be stopped");
        Thread.sleep(2000);
        System.out.println("Double-check");

    }
    //Thread.sleep(24);

    public static class Clock extends Thread {
        public Clock() {
            setPriority(MAX_PRIORITY);
            start();
        }

        public void run() {
            try {
                while (!isStopped) {
                    printTikTak();
                }
            } catch (InterruptedException e) {
            }
        }

        private void printTikTak() throws InterruptedException {
            //long start = System.currentTimeMillis();
            Thread.sleep(500);
            //long start = System.currentTimeMillis();
            System.out.println("Tik");//add your code here - добавь код тут
            long stop = System.currentTimeMillis();
            //System.out.println(stop-start);
            Thread.sleep(500);
            System.out.println("Tak");//add your code here - добавь код тут
        }
    }
}
