package com.javarush.task.task24.task2413;

public abstract class BaseObject {

    abstract void draw(Canvas canvas);
    abstract void move();
    boolean isIntersec(BaseObject o){
        boolean inter = false;
        double distance = Math.sqrt(Math.pow(o.x - this.x,2) + Math.pow(o.y - this.y,2));
        if (distance <= o.radius || distance <= this.radius) inter = true;
        return inter;
    }

    protected double x,y, radius;

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
