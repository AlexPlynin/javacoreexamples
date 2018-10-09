package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {
    String nameOfSolution;
    int countOfSolution;
    String typeOfSolution;
    public Solution(int countOfSolution,String nameOfSolution){
        this.countOfSolution=countOfSolution;
        this.nameOfSolution=nameOfSolution;
    }
    private Solution(String nameOfSolution,int countOfSolution){

    }
    Solution(){

    }

    protected Solution(String typeOfSolution){

    }
    public static void main(String[] args) {
        Solution solution = new Solution("join",34);
       // SubSolution subSolution = new SubSolution("dfdf",24);//ошибка так как доступ имеется тольок у членов внутри класса
    }
}

