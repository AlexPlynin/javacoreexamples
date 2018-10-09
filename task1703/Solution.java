package com.javarush.task.task17.task1703;

import java.util.ArrayList;
import java.util.List;

/* 
Синхронизированные заметки
*/

public class Solution {

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                new Note().addNote(0,"LOL");
                new Note().addNote(0,"LOL2");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                new Note().addNote(0,"LOL3");
                new Note().addNote(0,"LOL24");
                new Note().removeNote(0);
            }
        });
        thread.start();
        thread2.start();

    }

    public static class Note {

         public   final  List<String> notes = new ArrayList<String>(10);

        public  void addNote(int index, String note) {
            System.out.println("Сейчас будет добавлена заметка [" + note + "] На позицию " + index);
            synchronized (notes) {

                notes.add(index, note);

            }
            System.out.println("Уже добавлена заметка [" + note + "]");
        }

        public void removeNote(int index) {
            System.out.println("Сейчас будет удалена заметка с позиции " + index);
            String note;
            synchronized (notes) {

                note = notes.remove(index);

            }
            System.out.println("Уже удалена заметка [" + note + "] с позиции " + index);
        }
    }

}
