package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;

public class EnemyShip extends Ship{
    public int score = 15;
    public EnemyShip(double x, double y) {
        super(x, y);
        setStaticView(ShapeMatrix.ENEMY);
    }
    public void move(Direction direction, double speed){
        if (direction == Direction.RIGHT) x = x + speed;
        if (direction == Direction.LEFT) x = x - speed;
        if (direction == Direction.DOWN) y = y + 2;
    }

    @Override
    public void kill() {
        if(this.isAlive) {
            isAlive = false;
        setAnimatedView(true, ShapeMatrix.KILL_ENEMY_ANIMATION_FIRST, ShapeMatrix.KILL_ENEMY_ANIMATION_SECOND,
                ShapeMatrix.KILL_ENEMY_ANIMATION_THIRD);
        }
    }

    @Override
    public Bullet fire() {
        return new Bullet(x+1, y+height, Direction.DOWN);
    }
}
