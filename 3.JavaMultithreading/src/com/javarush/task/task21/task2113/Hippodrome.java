package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    public static Hippodrome game;

    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void run() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    };
    public void move(){
        for (Horse horse :
                horses) {
            horse.move();
        }
    };
    public void print(){};

    public static void main(String[] args) {
        Hippodrome hippodrome = new Hippodrome(new ArrayList<>());

        game = hippodrome;

        Horse horseSivka = new Horse("Sivka", 3, 0);
        hippodrome.horses.add(horseSivka);
        Horse horsePegii = new Horse("Pegii", 3, 0);
        hippodrome.horses.add(horsePegii);
        Horse horseRusak = new Horse("Rusak", 3, 0);
        hippodrome.horses.add(horseRusak);


    }
}
