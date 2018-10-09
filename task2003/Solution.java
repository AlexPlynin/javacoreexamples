package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        load(new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine()));

        //save(fis);


        //implement this method - реализуйте этот метод
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties p = new Properties();
        properties.forEach((k, v) -> p.setProperty(k, v));
        p.store(outputStream, null);
        outputStream.close();

    }

    public void load(InputStream inputStream) throws Exception {

        Properties p = new Properties();
        p.load(inputStream);
        Map<String, String> map = (Map) p;
        //p.forEach((k, v) -> properties.put(String.valueOf(k), String.valueOf(v)));
        properties = map;
        inputStream.close();
    }

    public static void main(String[] args) throws Exception {
        new Solution().fillInPropertiesMap();

    }
}
