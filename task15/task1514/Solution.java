package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(45.343435,"Press");
        labels.put(0.000543,"Pressing");
        labels.put(034_43.000543,"Pressings");
        labels.put((double)1,"PressingsD");
        labels.put((double)((float)145),"PressingsD");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
