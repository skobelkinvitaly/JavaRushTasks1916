package com.javarush.task.task24.task2413;

public class Ball extends BaseObject{
    private double dx, dy, direction, speed;

    public Ball(double dx, double dy, double speed, double direction) {
        super(dx, dy, 1);

        this.dx = dx;
        this.dy = dy;
        this.direction = direction;
        this.speed = speed;
        isFrozen = true;

    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    public double getDirection() {
        return direction;
    }

    public double getSpeed() {
        return speed;
    }

    private boolean isFrozen;
    @Override
    void draw(Canvas canvas) {

    }

    @Override
    void move() {

    }

//    public Ball(double x, double y) {
//        super(x, y, 1);
//    }
}
