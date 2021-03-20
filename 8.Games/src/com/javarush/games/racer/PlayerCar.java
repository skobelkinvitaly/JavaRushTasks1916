package com.javarush.games.racer;

import com.javarush.games.racer.road.RoadManager;

public class PlayerCar extends GameObject {
    private static int playerCarHeight = ShapeMatrix.PLAYER.length;
    public int speed = 1;
    private Direction direction;

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void move(){
if (direction == Direction.LEFT) this.x = this.x -1;
RoadManager roadManager = new RoadManager();
if (this.x < RoadManager.LEFT_BORDER) x = RoadManager.LEFT_BORDER;
if (direction == Direction.RIGHT) this.x = this.x +1;
if (this.x > RoadManager.RIGHT_BORDER) x = RoadManager.RIGHT_BORDER - width;
    }

    public PlayerCar() {
        super(RacerGame.WIDTH / 2 + 2, RacerGame.HEIGHT - playerCarHeight - 1, ShapeMatrix.PLAYER);
    }
    public void stop(){
        matrix = ShapeMatrix.PLAYER_DEAD;
    }
}
