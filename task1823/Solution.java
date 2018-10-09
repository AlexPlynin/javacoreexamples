package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        System.out.println("Введите имена файлов или exit");
        while (!(line = br.readLine()).equals("exit")) {
            new ReadThread(line).start();

        }

        System.out.println(resultMap);

    }

    public static class ReadThread extends Thread {
        private String filename;
        private FileInputStream fis;

        public ReadThread(String fileName) {
            //implement constructor body
            // fis = new FileInputStream(fileName);
            this.filename = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        //fis = new FileInputStream()

        @Override
        public void run() {
            try {
                fis = new FileInputStream(filename);
                byte[] buffer = new byte[256];
                //fis.read(buffer);
                while (fis.available() > 0) buffer[fis.read()]++;


                byte max = buffer[0];
                int maxi = 0;
                for (int i = 0; i < buffer.length; i++) {
                    if (buffer[i] > max) {
                        max = buffer[i];
                        maxi = i;
                    }
                }


                resultMap.put(filename, maxi);
                fis.close();


//                while (fis.available() > 0) {
//
//                }


            } catch (java.io.IOException e) {
                e.printStackTrace();
            }

        }
    }
}
