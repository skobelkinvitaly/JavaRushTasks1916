package com.javarush.task.task29.task2909.human;

public class Soldier extends Human{
    public Soldier(String name, int age) {
        super(name, age);
    }
    @Override
    public void live() {
//        super.live();
        fight();
    }
//
//    @Override
//    public void fight() {
//        super.fight();
//    }

    public void fight() {
    }
}
