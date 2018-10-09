package com.javarush.task.task19.task1921;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {

        FileReader fileReader = new FileReader(args[0]);
        BufferedReader br = new BufferedReader(fileReader);
        String line;
        // HashMap<String,Double> map = new HashMap<>();
        Pattern pattern = Pattern.compile("\\b\\D+[ ]\\b");
        String line2 = "Иван 31 12 1987";


        ArrayList<String> list = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
        String name,date;
        String parse = "Иванов Иван Иванович 31 12 1987";

//        name = parse.replaceAll("\\d", "").trim();//trim уберает пробел с конца и начала
//        date = parse.replace(name, "").trim();
//        System.out.println(name);
//        System.out.println(date);


        while ((line = br.readLine()) != null) {

            name = line.replaceAll("\\d", "").trim();
            date = line.replace(name, "").trim();
            PEOPLE.add(new Person(name, dateFormat.parse(date)));

            //SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
            //PEOPLE.add(new Person(subS, dateFormat.parse(line.substring(index, line.length()))));
            //System.out.println(PEOPLE.get(0));
            //System.out.println(line2.substring(index, line2.length()));


        }

        br.close();
        fileReader.close();
    }
}
