package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;
        HashSet<String> set = new HashSet<>();
        //set.addAll(set,"fg","dfg");
        Collections.addAll(set,"user","loser","proger","coder");
        try {


            while (set.contains(key = reader.readLine()))//тут цикл по чтению ключей, пункт 1
            {
                if (key.equals(new Person.Coder().getClass().getSimpleName().toLowerCase()))
                    person = new Person.Coder();//создаем объект, пункт 2
                if (key.equals(new Person.Proger().getClass().getSimpleName().toLowerCase()))
                    person = new Person.Proger();
                if (key.equals(new Person.User().getClass().getSimpleName().toLowerCase()))
                    person = new Person.User();
                if (key.equals(new Person.Loser().getClass().getSimpleName().toLowerCase()))
                    person=new Person.Loser();
                doWork(person); //вызываем doWork

            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void doWork(Person person) {
        if (person instanceof Person.User) ((Person.User) person).live();
        if (person instanceof Person.Coder) ((Person.Coder) person).coding();
        if (person instanceof Person.Loser) ((Person.Loser) person).doNothing();//расширение
        if (person instanceof Person.Proger) ((Person.Proger) person).enjoy();
        // пункт 3
    }
}
