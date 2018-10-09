package com.javarush.task.task19.task1924;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(fileName));
        String line;
        Pattern pattern = Pattern.compile("\\b[0-9]\\b|\\b1[0-2]\\b");//гениально
        Matcher matcher;
//        while (matcher.find()) {
//            System.out.println(line.substring(matcher.start(),matcher.end()));
//        }
        while ((line = bufferedReader2.readLine()) != null) {
//            matcher = pattern.matcher(line);
//            String subS = "";
//            while (matcher.find()) {
//                subS = line.substring(matcher.start(), matcher.end());
//                System.out.println(subS);
//                System.out.println(map.get(Integer.parseInt(subS)));
//
//                 //line.replace(subS, map.get(Integer.parseInt(subS)));
//                System.out.println(line.replace(subS, map.get(Integer.parseInt(subS))));//subS="";
            for (Map.Entry<Integer, String> pair : map.entrySet())
                line = line.replaceAll("\\b" + pair.getKey() + "\\b", pair.getValue());//умно
            System.out.println(line);
        }
        //System.out.println(line);

        bufferedReader.close();
        bufferedReader2.close();

        //line.replaceAll("\\d", "");

        //SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
        //PEOPLE.add(new Person(subS, dateFormat.parse(line.substring(index, line.length()))));
        //System.out.println(PEOPLE.get(0));
        //System.out.println(line2.substring(index, line2.length()));


    }
}

