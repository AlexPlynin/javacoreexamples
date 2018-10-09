package com.javarush.task.task20.task2010;


import java.io.*;

/*
Как сериализовать что-то свое?
*/
public class Solution {
    public static class Object implements Serializable {
        public String string1;
        public String string2;
    }

    public static int countStrings;

    public static class String implements Serializable {
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }

    public static void main(java.lang.String[] args) throws IOException, ClassNotFoundException {

        // Solution solution = new Solution();
        File objectFile = File.createTempFile("file1", null);
        //System.out.println(objectFile.getPath()); // путь к созданному временному файлу
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(objectFile));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(objectFile));

        Object o = new Object();
        String s = new String();
        o.string1 = new String();
        o.string1.print();
        oos.writeObject(o);
        oos.close();

        Object o1 = new Object();

        Object ob = (Object) ois.readObject();

        ob.string1.print();


    }
}
