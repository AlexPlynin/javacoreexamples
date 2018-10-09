package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);


        switch (args[0]) {
            case "-c": {
                //System.out.println("case");
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i = i + 3) {


                        if (args[i + 1].equalsIgnoreCase("м")) {
                            // System.out.println("в мужике");
                            allPeople.add(Person.createMale(args[i], simpleDateFormat.parse(args[i + 2])));

                            //System.out.println(allPeople.size() - 1);
                            System.out.println(allPeople.size() - 1);
                        } else if (args[i + 1].equalsIgnoreCase("ж")) {
                            allPeople.add(Person.createFemale(args[i], simpleDateFormat.parse(args[i + 2])));
                            System.out.println(allPeople.size() - 1);
                        }
                    }
                }
                //System.out.println(allPeople.size());
                break;

            }
            case "-u": {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i = i + 4) {


                        allPeople.get(Integer.valueOf(args[i])).setName(args[i + 1]);
                        if (args[i + 2].equals("м"))
                            allPeople.get(Integer.valueOf(args[i])).setSex(Sex.MALE);
                        else
                            allPeople.get(Integer.valueOf(args[i])).setSex(Sex.FEMALE);

                        allPeople.get(Integer.valueOf(args[i])).setBirthDay(simpleDateFormat.parse(args[i + 3]));
                        // System.out.println(allPeople.get(Inte
                    }
                    break;
                }
            }
            case "-d": {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {


                        allPeople.get(Integer.valueOf(args[i])).setName(null);
                        allPeople.get(Integer.valueOf(args[i])).setSex(null);
                        allPeople.get(Integer.valueOf(args[i])).setBirthDay(null);

                    }
                }

                break;
            }
            case "-i": {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {


                        if (allPeople.get(Integer.valueOf(args[i])).getSex().equals(Sex.MALE))
                            System.out.println(allPeople.get(Integer.valueOf(args[i])).getName() + " м " +
                                    simpleDateFormat2.format(allPeople.get(Integer.valueOf(args[i])).getBirthDay()));
                        else
                            System.out.println(allPeople.get(Integer.valueOf(args[i])).getName() + " ж " +
                                    simpleDateFormat2.format(allPeople.get(Integer.valueOf(args[i])).getBirthDay()));


                    }
                }
                break;
            }


        }
    }
}

