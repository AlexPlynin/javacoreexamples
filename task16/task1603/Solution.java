package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

      public static void main(String[] args) {

       SpecialThread st1 = new SpecialThread();
       SpecialThread st2 = new SpecialThread();
       SpecialThread st3 = new SpecialThread();
       SpecialThread st4 = new SpecialThread();
       SpecialThread st5 = new SpecialThread();
       Thread t1 = new Thread(st1);
       Thread t2 = new Thread(st2);
       Thread t3 = new Thread(st3);
       Thread t4 = new Thread(st4);
       Thread t5 = new Thread(st5);
        list.add(t1);//Add your code here - добавьте свой код тут
        list.add(t2);//Add your code here - добавьте свой код тут
        list.add(t3);//Add your code here - добавьте свой код тут
        list.add(t4);//Add your code here - добавьте свой код тут
        list.add(t5);//Add your code here - добавьте свой код тут
//        for (Thread t:list) {
//            t.start();
//        }


    }

    public static class SpecialThread implements Runnable {
        public void run() {

            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
