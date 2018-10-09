package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    public static String fileName1, fileName2;

    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите название первого файла ");
            fileName1 = bf.readLine();
            System.out.println("Введите название второго файла ");
            fileName2 = bf.readLine();
            String line;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FileReadThread fileReadThread1 = new FileReadThread(fileName1);
        FileReadThread fileReadThread2 = new FileReadThread(fileName2);
        fileReadThread1.start();
        fileReadThread2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        allLines = fileReadThread1.lines;
        forRemoveLines = fileReadThread2.lines;
        //System.out.println(allLines);
        //System.out.println(forRemoveLines);
        //allLines.c
        //System.out.println(allLines.containsAll(forRemoveLines));
        try {
            new Solution().joinData();
        }
        catch (CorruptedDataException e){
            System.out.println("Error");
        }

       // System.out.println(allLines);


    }

    public static class FileReadThread extends Thread {

        public String fileName;
        public List<String> lines = new ArrayList<>();

        FileReadThread(String fileName) {
            this.fileName = fileName;
        }

        public void fileReadMethod() {
            try (FileInputStream in = new FileInputStream(fileName); BufferedReader br2 = new BufferedReader(new InputStreamReader(in))) {
                String line;
                //int x;
                while ((line = br2.readLine()) != null) {
                    lines.add(line);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        @Override
        public void run() {
            fileReadMethod();
        }
    }


    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            for (int i = 0; i < allLines.size(); i++) {

                for (int j = 0; j < forRemoveLines.size(); j++) {
                    if (allLines.get(i).contains(forRemoveLines.get(j))) {
                        allLines.remove(i);
                    }
                }
            }
        } else {
            allLines.removeAll(allLines);

            throw new CorruptedDataException();

        }

    }
}
