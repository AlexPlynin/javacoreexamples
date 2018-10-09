package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        //Person.createMale(" ffdffd",);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        if (args[0].equals("-c")) {
            if (args[2].equalsIgnoreCase("м")) {

                allPeople.add(Person.createMale(args[1], simpleDateFormat.parse(args[3])));

                System.out.println(allPeople.size() - 1);
            } else if (args[2].equalsIgnoreCase("ж")) {
                allPeople.add(Person.createFemale(args[1], simpleDateFormat.parse(args[3])));
                System.out.println(allPeople.size() - 1);
            }
        }
        if (args[0].equals("-u")) {
            allPeople.get(Integer.valueOf(args[1])).setName(args[2]);
            if (args[3].equals("м"))
                allPeople.get(Integer.valueOf(args[1])).setSex(Sex.MALE);
            else
                allPeople.get(Integer.valueOf(args[1])).setSex(Sex.FEMALE);

            allPeople.get(Integer.valueOf(args[1])).setBirthDay(simpleDateFormat.parse(args[4]));
           // System.out.println(allPeople.get(Integer.valueOf(args[1])));
        }
        if  (args[0].equals("-d")){
            allPeople.get(Integer.valueOf(args[1])).setName(null);
            allPeople.get(Integer.valueOf(args[1])).setSex(null);
            allPeople.get(Integer.valueOf(args[1])).setBirthDay(null);
           // System.out.println(allPeople.get(Integer.valueOf(args[1])));
        }

        if (args[0].equals("-i")){
            if (allPeople.get(Integer.valueOf(args[1])).getSex().equals(Sex.MALE))
                System.out.println(allPeople.get(Integer.valueOf(args[1])).getName()+" м "+
                        simpleDateFormat2.format(allPeople.get(Integer.valueOf(args[1])).getBirthDay()));
            else
                System.out.println(allPeople.get(Integer.valueOf(args[1])).getName()+" ж "+
                        simpleDateFormat2.format(allPeople.get(Integer.valueOf(args[1])).getBirthDay()));
        }

    }
}
