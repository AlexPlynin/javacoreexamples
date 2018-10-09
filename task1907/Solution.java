package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        FileReader fileReader = new FileReader(fileName);
        Scanner scanner = new Scanner(fileReader);
//        ArrayList<Character> list = new ArrayList<>();
//       // ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//
//        StringBuilder sb = new StringBuilder();
//        while (fileReader.ready()) {
//            sb.append((char)fileReader.read());
//            //fileReader.read(//list.toArray())
//
//        }

        Pattern pattern = Pattern.compile("\\b(world)\\b");//граница слова
        Matcher matcher;
        int count=0;
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            matcher = pattern.matcher(line);
            while (matcher.find()){//пока находит
                count++;
            }
        }
        fileReader.close();
        scanner.close();
        System.out.println(count);
        br.close();
//        System.out.println(sb.toString());


    }
}
