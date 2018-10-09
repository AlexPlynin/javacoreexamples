package com.javarush.task.task15.task1501;

/* 
ООП - Расставить интерфейсы
*/

public class Solution {
    public static void main(String[] args) {
        Discountable discountable = new Clothes();
        discountable.getAllowedAction();
        Sellable sellable = new Clothes();
        sellable.getAllowedAction("Buy");
        Movable movable = new Clothes();
        movable.isMovable();
        Clothes clothes = (Clothes)movable;
        clothes.getAllowedAction("PedPerego");

    }

    public interface Movable {
        boolean isMovable();
    }

    public interface Sellable {
        Object getAllowedAction(String name);
    }

    public interface Discountable {
        Object getAllowedAction();
    }

    public static class Clothes implements Movable,Sellable,Discountable {
        @Override
        public boolean isMovable() {
            return true;
        }

        @Override
        public Object getAllowedAction(String name) {
            return name;
        }

        @Override
        public Object getAllowedAction() {
            return null ;
        }
    }
}
