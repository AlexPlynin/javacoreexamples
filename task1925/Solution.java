package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br1 = new BufferedReader(new FileReader(args[0]));
        BufferedWriter br2 = new BufferedWriter(new FileWriter(args[1]));
        String line = "";
        StringBuilder sb = new StringBuilder();
        while ((line = br1.readLine()) != null) {

            String[] buff = line.split(" ");
            for (String s : buff) {
                if (s.length() > 6) {
                    sb.append(s + ",");
                }
            }


        }

        sb.delete(sb.length()-1,sb.length());//не забывать про удобство сб
        //System.out.println(sb.toString());
        br2.write(sb.toString());
//        fileWriter.flush();
//        fileReader.close();
//        fileWriter.close();

        br1.close();
        br2.close();

    }
}
