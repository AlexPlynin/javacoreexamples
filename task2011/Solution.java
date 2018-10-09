package com.javarush.task.task20.task2011;

import java.io.*;

/*
Externalizable для апартаментов
*/
public class Solution {




    public static class Apartment implements Externalizable {

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() { super(); }

        public Apartment(String adr, int y) {
            address = adr;
            year = y;
        }

        /**
         * Prints out the fields. used for testing!
         */
        public String toString() {
            return("Address: " + address + "\n" + "Year: " + year);
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(address);
            out.writeInt(year);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            address = (String) in.readObject();
            year =  in.readInt();

        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File objectFile = File.createTempFile("file1", null);
        Apartment ap = new Apartment("Brighton",23);
        System.out.println(ap.toString());
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(objectFile));
        oos.writeObject(ap);
        oos.close();

        System.out.println("*********************************************");

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(objectFile));

        Apartment ap2 = (Apartment) ois.readObject();

        System.out.println(ap2.toString());



    }
}
