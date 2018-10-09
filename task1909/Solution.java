package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bf.readLine();
        String fileName2 = bf.readLine();
        bf.close();
        bf = new BufferedReader(new FileReader(fileName1));
        BufferedWriter bout = new BufferedWriter(new FileWriter(fileName2));
        String line;

        while ((line=bf.readLine())!=null) {
            //System.out.println(line);
            //matcher = pattern.matcher(line);
            bout.write(line.replaceAll("\\.","!")+"\n");
            bout.flush();

        }

        bf.close();
        bout.close();


    }
}
