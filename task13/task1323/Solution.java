package com.javarush.task.task13.task1323;

/* 
Интерфейс Updatable в классе Screen
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Screen screen = new Screen("dot.org", 34561);
        screen.onSelect();
        screen.refresh();
        System.out.println(screen);

    }

    interface Selectable {
        void onSelect();
    }

    interface Updatable extends Selectable {
        void refresh();
    }

    static class Screen implements Updatable {
        String nameOfSite;
        int userId;

        public Screen(String nameOfSite, int userId) {
            this.nameOfSite = nameOfSite;
            this.userId = userId;
        }

        @Override
        public void onSelect() {
            System.out.println("Select current page:" + nameOfSite);
        }

        @Override
        public String toString() {
            return String.format("%s page visited by user id :%d", nameOfSite, userId);
        }

        @Override
        public void refresh() {

            System.out.println("Page is refreshed");

        }
    }
}
