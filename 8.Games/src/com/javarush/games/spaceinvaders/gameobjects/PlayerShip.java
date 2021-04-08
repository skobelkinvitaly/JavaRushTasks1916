package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;
import com.javarush.games.spaceinvaders.SpaceInvadersGame;

import java.util.List;

public class PlayerShip extends Ship {

    @Override
    public Bullet fire() {
//        return super.fire();
        if (isAlive == false) return null;
        else return new Bullet(x+2, y-ShapeMatrix.BULLET.length, Direction.UP);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        if (direction != Direction.DOWN)
            this.direction = direction;
    }

    private Direction direction = Direction.UP;

    public PlayerShip() {
        super(SpaceInvadersGame.WIDTH / 2, SpaceInvadersGame.HEIGHT - ShapeMatrix.PLAYER.length - 1);
        setStaticView(ShapeMatrix.PLAYER);
    }

    public void verifyHit(List<Bullet> bullets) {
        if (bullets == null) {

        } else {
            if (this.isAlive) {
                for (Bullet bu :
                        bullets) {
                    if (bu.isAlive == true) {
                        if (this.isCollision(bu)) {
                            this.kill();
//                        if (bu.isAlive == true)
                            bu.kill();
                        }
                    }
                }
            }
        }
    }

    @Override
    public void kill() {
        if (this.isAlive) {
            isAlive = false;
            setAnimatedView(false, ShapeMatrix.KILL_PLAYER_ANIMATION_FIRST,
                    ShapeMatrix.KILL_PLAYER_ANIMATION_SECOND, ShapeMatrix.KILL_PLAYER_ANIMATION_THIRD, ShapeMatrix.DEAD_PLAYER);
        }
    }

    public void move() {
        if (isAlive) {
            if (direction == Direction.LEFT) x = x - 1;
            if (direction == Direction.RIGHT) x = x + 1;
            if (x < 0) x = 0;
            if ((x + width) > SpaceInvadersGame.WIDTH) x = SpaceInvadersGame.WIDTH - width;
        }
    }
    public void win(){
        setStaticView(ShapeMatrix.WIN_PLAYER);
    }
}
