package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {

        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");

    }


    public static void main(String[] args) {

        Contact contact = new Contact() {
            @Override
            public String getName() {
                return "Plynin, Alex";
            }

            @Override
            public String getPhoneNumber() {
                return "+3(805)0123-4567";
            }
        };

        Customer customer = new Customer() {
            @Override
            public String getCompanyName() {
                return "JavaRush Ltd.";
            }

            @Override
            public String getCountryName() {
                return "Ukraine";
            }
        };


        DataAdapter dataAdapter = new DataAdapter(customer,contact);
        System.out.println(dataAdapter.getContactFirstName());
        System.out.println(dataAdapter.getContactLastName());
        System.out.println(dataAdapter.getDialString());
        System.out.println(dataAdapter.getCountryCode());
    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.contact = contact;
            this.customer = customer;
        }

        @Override
        public String getCountryCode() {
            String rightKey=null;
            for (Map.Entry<String, String> pair : countries.entrySet()) {
                if (customer.getCountryName().equals(pair.getValue())) {
                    // System.out.println(pair.getValue() + " " + pair.getKey());
                    //if () break;}
                     rightKey = pair.getKey();
                }
            }


            return rightKey;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            //return contact.getName().substring(contact.getName().indexOf(" ")+1, contact.getName().length());
            return contact.getName().split(", ")[1];
        }

        @Override
        public String getContactLastName() {
            //return contact.getName().substring(0, contact.getName().indexOf(","));
            return contact.getName().split(",")[0];
        }

        @Override
        public String getDialString() {

            String[] strings = contact.getPhoneNumber().split("[-\\)\\(]");//регулярка парсящая -()
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < strings.length; i++) {
                sb2.append(strings[i]);
            }

            return sb.append("callto://").append(sb2.toString()).toString();
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}