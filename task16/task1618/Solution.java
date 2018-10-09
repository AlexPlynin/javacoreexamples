package com.javarush.task.task16.task1618;

/* 
Снова interrupt
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        //Add your code here - добавь код тут
        TestThread testThread = new TestThread();
        testThread.start();
       // Thread.sleep(10000);
        testThread.interrupt();
    }

    //Add your code below - добавь код ниже
    public static class TestThread extends Thread {

//        TestThread(){
//            start();
//        }
        @Override
        public void run() {
            System.out.println("В методе run()");
            for (int i = 0; true ; i++) {
                System.out.print("*");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("\nПоток прерван");
                    return;
                }
            }
        }
    }
}