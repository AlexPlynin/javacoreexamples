package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

//        FileReader fileReader = new FileReader(args[0]);
//        FileWriter fileWriter = new FileWriter(args[1]);
        BufferedReader br1 = new BufferedReader(new FileReader(args[0]));
        BufferedWriter br2 = new BufferedWriter(new FileWriter(args[1]));
        String line = "";
        Pattern pattern = Pattern.compile("\\b[\\S]*[\\d]+[\\S]*\\b");//граница слова
        //Pattern pattern2 = Pattern.compile("[+\\-*]");//граница слова
        Matcher matcher;
//        while (matcher.find()){
//            System.out.println(line.substring(matcher.start(),matcher.end()));
//        }
        while ((line = br1.readLine()) != null) {
            matcher = pattern.matcher(line);
            while (matcher.find()) {
//            System.out.println(line.substring(matcher.start(),matcher.end()));
                br2.write(line.substring(matcher.start(), matcher.end())+" ");
            }


        }
//        fileWriter.flush();
//        fileReader.close();
//        fileWriter.close();

        br1.close();
        br2.close();




    }
}
