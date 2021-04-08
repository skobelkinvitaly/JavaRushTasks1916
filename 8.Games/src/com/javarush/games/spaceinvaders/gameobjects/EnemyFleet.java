package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;
import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;
import com.javarush.games.spaceinvaders.SpaceInvadersGame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EnemyFleet {
    private static final int ROWS_COUNT = 3;
    private static final int COLUMNS_COUNT = 10;
    private static final int STEP = ShapeMatrix.ENEMY.length + 1;
    private List<EnemyShip> ships;
    private Direction direction = Direction.RIGHT;

    public EnemyFleet() {
        createShips();
    }

    private void createShips() {
        ships = new ArrayList<EnemyShip>();
        for (int x = 0; x < COLUMNS_COUNT; x++) {
            for (int y = 0; y < ROWS_COUNT; y++) {
                ships.add(new EnemyShip(x * STEP, y * STEP + 12));
            }
        }
        ships.add(new Boss(STEP * COLUMNS_COUNT / 2 - ShapeMatrix.BOSS_ANIMATION_FIRST.length / 2 - 1, 5));
    }

    public void draw(Game game) {
        for (EnemyShip enemyShip :
                ships) {
            enemyShip.draw(game);
        }
    }

    private double getLeftBorder() {
        double minX = Double.MAX_VALUE;
        for (EnemyShip enemyShip :
                ships) {
            if (enemyShip.x < minX) minX = enemyShip.x;
        }
        return minX;
    }

    private double getRightBorder() {
        double maxX = 0;
        for (EnemyShip enemyShip :
                ships) {
            if (enemyShip.x + enemyShip.width > maxX) maxX = enemyShip.x + enemyShip.width;
        }
        return maxX;
    }

    private double getSpeed() {
        double min1 = 3.0 / ships.size();
        double min2 = 2.0;
        if (min1 < min2) return min1;
        else return min2;
    }

    public void move() {
        if (ships.size() != 0) {
            boolean flag = false;
            if (direction == Direction.LEFT && (getLeftBorder() < 0)) {
                direction = Direction.RIGHT;
                flag = true;
            }
            if (direction == Direction.RIGHT && (getRightBorder() > SpaceInvadersGame.WIDTH)) {
                direction = Direction.LEFT;
                flag = true;
            }
            if (flag == true) {
                for (EnemyShip enemyShip :
                        ships) {
                    enemyShip.move(Direction.DOWN, getSpeed());
                }
            } else {
                for (EnemyShip enemyShip
                        : ships
                ) {
                    enemyShip.move(direction, getSpeed());
                }
            }
        }
    }

    public Bullet fire(Game game) {
        if (ships.size() == 0) return null;
        if (game.getRandomNumber(100 / SpaceInvadersGame.COMPLEXITY) > 0) return null;
        return ships.get(game.getRandomNumber(ships.size())).fire();

    }
//
//    public void verifyHit(List<Bullet> bullets) {
//        List<Bullet> bulletsCopy = bullets;
//        List<EnemyShip> shipsCopy = ships;
//        for (Bullet bul :
//                bulletsCopy) {
//            for (EnemyShip enemyship :
//                    shipsCopy) {
//                if (enemyship.isCollision(bul) && bul.isAlive && enemyship.isAlive) {
//                    enemyship.kill();
//                    bul.kill();
//                }
//            }
//        }
//    }

    public void deleteHiddenShips() {
        List<EnemyShip> shipsCopy = ships;
        for (int i = 0; i < shipsCopy.size(); i++) {
            if (!shipsCopy.get(i).isVisible()) ships.remove(shipsCopy.get(i));
        }
    }
    public double getBottomBorder(){
        double max = Double.MIN_VALUE;
        for (EnemyShip enemyShip :
                ships) {
            if ((enemyShip.y + enemyShip.height)>max) max =enemyShip.y + enemyShip.height;
        }
        return max;
    }
    public int getShipsCount(){
        return ships.size();
    }
    public  int verifyHit(List<Bullet> bullets){
        if (bullets.size() == 0) return  0;
        int restultScores = 0;
//        for (EnemyShip enemeShip :
//                ships) {
//            if (enemeShip.isAlive == false) restultScores = restultScores + enemeShip.score;
//        }

                List<Bullet> bulletsCopy = bullets;
        List<EnemyShip> shipsCopy = ships;
        for (Bullet bul :
                bulletsCopy) {
            for (EnemyShip enemyship :
                    shipsCopy) {
                if (enemyship.isCollision(bul) && bul.isAlive && enemyship.isAlive) {
                    enemyship.kill();
                    bul.kill();
                    restultScores = restultScores + enemyship.score;
                }
            }
        }

        return restultScores;
    }
}
