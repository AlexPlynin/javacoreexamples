package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());

    }

    public static void main(String[] args) {
       threads.get(0).start();
       threads.get(1).start();
       threads.get(2).start();
       threads.get(3).start();
       threads.get(4).start();

        //threads.get(3).showWarning();


    }

    static class Thread1 extends Thread {
        @Override
        public void run() {
            while (true) {

            }
        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    static class Thread3 extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    Thread.sleep(500);

                }
            } catch (InterruptedException e) {

            }
        }
    }

    static class Thread4 extends Thread implements Message {
        @Override
        public void showWarning() {
            interrupt();
        }

        @Override
        public void run() {
            while (!isInterrupted()) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Thread5 extends Thread {
        //private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        @Override
        public void run() {

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                String s;
                int sum=0;
                while ( (s = reader.readLine())!=null){
                    if  (s.equals("N")) {
                        //System.out.println("Stop!");
                        break;}
                    sum+=Integer.parseInt(s);
                }
                System.out.println(sum);

            } catch (IOException e) {

            }

        }
    }
}