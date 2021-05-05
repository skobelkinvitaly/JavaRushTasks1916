package com.javarush.games.moonlander;

import static com.javarush.games.moonlander.MoonLanderGame.WIDTH;

public class Rocket extends GameObject{
    private double speedX = 0;
    private double speedY = 0;
    private double boost = 0.05;
    private double slowdown = boost/10;
    public Rocket(double x, double y) {
        super(x, y, ShapeMatrix.ROCKET);
    }
//    public void move(){
//        speedY = speedY + boost;
//        y = y + speedY;
//    }
    public void move(boolean isUpPressed, boolean isLeftPressed, boolean isRightPressed){
        if (isLeftPressed == false && isRightPressed == false && speedX > - slowdown && speedX < slowdown) speedX = 0;
        if (isLeftPressed == false && isRightPressed == false && speedX > slowdown) {
            speedX = speedX - slowdown;
            x = x + speedX;
        }
        if (isLeftPressed == false && isRightPressed == false && speedX < - slowdown) {
            speedX = speedX + slowdown;
            x = x + speedX;
        }
        if (isUpPressed == true) {
            speedY = speedY - boost;
            y = y + speedY;
        }
        else {
            speedY = speedY + boost;
            y = y + speedY;
        }
        if (isLeftPressed == true) {
            speedX = speedX - boost;
            x = x + speedX;
        }
        if (isRightPressed == true) {
            speedX = speedX + boost;
            x = x + speedX;
        }
//        x = x + speedX;
        checkBorders();
    }
    private  void checkBorders(){
        if (x<0) {
            x=0;
            speedX = 0;
        }
        if ((x+width)> WIDTH) {
            x = WIDTH - width;
            speedX = 0;
        }
        if (y<0) {
            y = 0;
            speedY = 0;
        }
    }
}
