package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        System.out.println("Введите имена файлов или exit");
        //FileInputStream fis;
        //FileOutputStream fout = new FileOutputStream("C:\\Users\\hooty\\Desktop\\Jrush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1825\\Barca");
       // ArrayList<byte[]> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        //Map<Integer,String>
        String fileName;
        byte[] buff;
        while (!(line = br.readLine()).equals("end")) {

            //fis = new FileInputStream(line);
            //buff = new byte[fis.available()];

            list2.add(line);


//            byte[] buff = new byte[fis.available()];
//            fis.read(buff);
//            list.add(buff);

        }
        Collections.sort(list2);
        System.out.println(list2);
        fileName = list2.get(0).substring(0, list2.get(0).lastIndexOf("."));
        FileOutputStream fout = new FileOutputStream(fileName);


        for (String s:list2) {

                FileInputStream fis = new FileInputStream(s);
                buff = new byte[fis.available()];
                fis.read(buff);
                fout.write(buff);
                fis.close();

        }
        //
//        for (byte[] b:list) {
//
//            fout.write(b);
//        }
//
        // fis.close();
//        System.out.println(fout.toString());
        fout.close();
       // fis.close();
    }
}
