package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;

public class Boss extends EnemyShip {
    private int frameCount = 0;

    @Override
    public void nextFrame() {
//        super.nextFrame();
        frameCount = frameCount + 1;
        if (frameCount % 10 == 0 || !this.isAlive) {
            super.nextFrame();
        }
    }

    public Boss(double x, double y) {
        super(x, y);
        setAnimatedView(true, ShapeMatrix.BOSS_ANIMATION_FIRST, ShapeMatrix.BOSS_ANIMATION_SECOND);
        score = 100;
    }

    @Override
    public Bullet fire() {
        if (isAlive) {
            if (matrix == ShapeMatrix.BOSS_ANIMATION_FIRST) return new Bullet(x + 6, y + height, Direction.DOWN);
            if (matrix != ShapeMatrix.BOSS_ANIMATION_FIRST) return new Bullet(x, y + height, Direction.DOWN);
        }
        return null;
    }

    @Override
    public void kill() {
        if (isAlive) {
            isAlive = false;
            setAnimatedView(false, ShapeMatrix.KILL_BOSS_ANIMATION_FIRST, ShapeMatrix.KILL_BOSS_ANIMATION_SECOND,
                    ShapeMatrix.KILL_BOSS_ANIMATION_THIRD);
        }
    }
}
