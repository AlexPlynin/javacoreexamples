package com.javarush.task.task18.task1815;

import java.util.ArrayList;
import java.util.List;

/* 
Таблица
*/

public class Solution {
    public static class TableInterfaceWrapper implements ATableInterface {
        ATableInterface component;
        //String newHeaderText;

        TableInterfaceWrapper(ATableInterface component) {
            this.component = component;
        }

        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            component.setModel(rows);
        }

        @Override
        public String getHeaderText() {
            return component.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            //this.newHeaderText = newHeaderText;
            component.setHeaderText(newHeaderText);
        }
    }

    public static interface ATableInterface {
        //String newHeaderText=null;

        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static class ATableIntReal implements ATableInterface {
        List list = new ArrayList<>();
        String HeaderText ;

        @Override
        public void setModel(List rows) {
            list = rows;
        }

        @Override
        public String getHeaderText() {
            return HeaderText;
        }

        @Override
        public void setHeaderText(String newHeaderText) {
        this.HeaderText = newHeaderText;
        }
    }

    public static void main(String[] args) {
        ATableIntReal aTableIntReal = new ATableIntReal();
        List a = new ArrayList();
        TableInterfaceWrapper tableInterfaceWrapper = new TableInterfaceWrapper(aTableIntReal);
        tableInterfaceWrapper.setHeaderText("lol");
        System.out.println(tableInterfaceWrapper.getHeaderText());
        tableInterfaceWrapper.setModel(a);
    }
}