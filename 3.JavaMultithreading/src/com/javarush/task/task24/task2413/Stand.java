package com.javarush.task.task24.task2413;

public class Stand extends BaseObject{
    private double speed;

    public Stand(double x, double y) {
        super(x, y, 3);
        speed = 1;
        direction = 0;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDirection() {
        return direction;
    }

    private double direction;
    @Override
    void draw(Canvas canvas) {

    }

    @Override
    void move() {

    }

    public Stand(double x, double y, double radius) {
        super(x, y, radius);
    }
}
