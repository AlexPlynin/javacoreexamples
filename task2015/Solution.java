package com.javarush.task.task20.task2015;

import java.io.*;

/* 
Переопределение сериализации
*/
public class Solution implements Serializable, Runnable {
    private transient Thread runner;

    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }


    public void run() {
        // do something here, does not matter
//        while (!runner.isInterrupted()) {
//            System.out.println("Lol");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//                break;
//            }
//        }

        System.out.println("lol");
        System.out.println("lol");
        System.out.println("lol");

    }

    /**
     * Переопределяем сериализацию.
     * Для этого необходимо объявить методы:
     * private void writeObject(ObjectOutputStream out) throws IOException
     * private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     * Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        //Thread thread = new Thread(this);

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
//роль псевдоконстркутора
        runner = new Thread(this);
        runner.start();
       // Thread thread = (Thread) in.readObject();
        //runner = thread;
        //thread.start();
        //this.runner = (Thread) in.readObject();
        //this.runner.start();
    }

    public static void main(String[] args) throws InterruptedException {

        Solution solution = new Solution(34);
//        Thread.sleep(10000);
//        solution.runner.interrupt();
        Solution solution1;

        try (FileOutputStream fout = new FileOutputStream("file1");
             FileInputStream fis = new FileInputStream("file1")
        ) {

            // ObjectInputStream ois = new ObjectInputStream(fis);
            ObjectOutputStream oos = new ObjectOutputStream(fout);

            //com.javarush.task.task20.task2014.Solution savedObject = new com.javarush.task.task20.task2014.Solution(5);

            oos.writeObject(solution);
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(fis);

            solution1 = (Solution) ois.readObject();
            ois.close();



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
