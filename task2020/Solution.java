package com.javarush.task.task20.task2020;

import java.io.*;
import java.util.logging.Logger;

/* 
Сериализация человека
*/
public class Solution {

    public static class Person implements Serializable {
        String firstName;
        String lastName;
        transient String fullName;
         transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fileOutput = new FileOutputStream("file1");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        Person person = new Person("Petr","GG","UA",Sex.MALE);
        outputStream.writeObject(person);

        fileOutput.close();
        outputStream.close();

        //loading
        FileInputStream fiStream = new FileInputStream("file1");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);

        Person loadedObject = (Person) objectStream.readObject();

        fiStream.close();
        objectStream.close();
        System.out.println(loadedObject.country+" "+loadedObject.greetingString+loadedObject.logger+loadedObject.fullName);

    }
}
