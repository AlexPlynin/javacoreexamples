package com.javarush.task.task20.task2016;

import java.io.*;

/*
Минимум изменений
*/
public  class Solution implements Serializable {
    public class A implements Serializable {
        String name = "A";

        public A(String name) {
            this.name += name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public class B extends A {
        String name = "B";

        public B(String name) {
            super(name);
            this.name += name;
        }
    }

    public class C extends B {

        String name = "C";

        public C(String name) {
            super(name);
            this.name = name;
        }

    }

    public static void main(String[] args) {
       // Solution sol = new Solution();


        C c = new Solution().new C("forC");

        try (FileInputStream fis = new FileInputStream("file1");
             FileOutputStream fout = new FileOutputStream("file1")) {

            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(c);

            ObjectInputStream ois = new ObjectInputStream(fis);
            C c2 = (C) ois.readObject();

            System.out.println(c2.name);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
