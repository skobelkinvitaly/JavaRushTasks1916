package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.*;
import com.javarush.games.spaceinvaders.gameobjects.Bullet;
import com.javarush.games.spaceinvaders.gameobjects.EnemyFleet;
import com.javarush.games.spaceinvaders.gameobjects.PlayerShip;
import com.javarush.games.spaceinvaders.gameobjects.Star;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SpaceInvadersGame extends Game {
    private int score = 0;
    private final static int PLAYER_BULLETS_MAX = 1;
    private List<Bullet> playerBullets;
    private int animationsCount;
    private boolean isGameStopped;
    private PlayerShip playerShip;
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    private List<Star> stars;
    private EnemyFleet enemyFleet;
    public static final int COMPLEXITY = 5;
    private List<Bullet> enemyBullets;

    @Override
    public void onTurn(int step) {
        moveSpaceObjects();
        check();
        Bullet bullet = enemyFleet.fire(this);
        if (bullet != null) enemyBullets.add(bullet);
        setScore(score);
        drawScene();
    }

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame() {
        score = 0;
        createStars();
        enemyFleet = new EnemyFleet();
        setTurnTimer(40);
        enemyBullets = new ArrayList<Bullet>();
        playerShip = new PlayerShip();
        isGameStopped = false;
        animationsCount = 0;
        playerBullets = new ArrayList<Bullet>();
        drawScene();
    }

    private void drawScene() {

        drawField();
        for (Bullet bul :
                playerBullets) {
            bul.draw(this);
        }
        playerShip.draw(this);
        for (Bullet bullet :
                enemyBullets) {
            bullet.draw(this);
        }
        enemyFleet.draw(this);
    }

    private void drawField() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                setCellValueEx(i, j, Color.BLACK, "");
            }
        }
        for (int i = 0; i < stars.size(); i++) {
            stars.get(i).draw(this);
        }
    }

    private void createStars() {
        stars = new ArrayList<Star>();
        stars.add(new Star(30, 31));
        stars.add(new Star(54, 53));
        stars.add(new Star(5, 40));
        stars.add(new Star(25, 20));
        stars.add(new Star(8, 53));
        stars.add(new Star(42, 31));
        stars.add(new Star(20, 26));
        stars.add(new Star(35, 58));
    }

    private void moveSpaceObjects() {
        enemyFleet.move();
        for (Bullet bullet :
                enemyBullets) {
            bullet.move();
        }
        playerShip.move();
        for (Bullet bullet :
                playerBullets) {
            bullet.move();
        }
    }

    private void removeDeadBullets() {
        Iterator iterator = enemyBullets.iterator();
        while (iterator.hasNext()) {
            Bullet b = (Bullet) iterator.next();
            if ((b.y >= HEIGHT - 1) || (!b.isAlive)) iterator.remove();
        }
//        playerBullets.removeIf()
//        Iterator iterator2 = playerBullets.iterator();
//        while (iterator2.hasNext()) {
//            Bullet b2 = (Bullet) iterator2.next();
//            if ((b2.y  + b2.height > 0 ) || (!b2.isAlive)) iterator2.remove();
//        }
        playerBullets.removeIf(bullet -> bullet.y + bullet.height < 0 || !bullet.isAlive);
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.ENTER && isGameStopped == true) createGame();
        if (key == Key.LEFT) playerShip.setDirection(Direction.LEFT);
        if (key == Key.RIGHT) playerShip.setDirection(Direction.RIGHT);
        if (key == Key.SPACE) {
            Bullet bullet = playerShip.fire();
            if (bullet != null && playerBullets.size() < PLAYER_BULLETS_MAX) playerBullets.add(bullet);
        }
    }

    private void check() {
        score = score + enemyFleet.verifyHit(enemyBullets);
        playerShip.verifyHit(enemyBullets);
        enemyFleet.verifyHit(playerBullets);
        enemyFleet.deleteHiddenShips();
        removeDeadBullets();
        if (!playerShip.isAlive) stopGameWithDelay();
        if (enemyFleet.getBottomBorder() >= playerShip.y) playerShip.kill();
        if (enemyFleet.getShipsCount() == 0) {
            playerShip.win();
            stopGameWithDelay();
        }
    }

    private void stopGame(boolean isWin) {
        isGameStopped = true;
        stopTurnTimer();
        if (!isWin) showMessageDialog(Color.BLACK, "Game over!", Color.RED, 50);
        else showMessageDialog(Color.BLUE, "You win!", Color.GREEN, 50);
    }

    private void stopGameWithDelay() {
        animationsCount = animationsCount + 1;
        if (animationsCount >= 10) stopGame(playerShip.isAlive);
    }

    @Override
    public void onKeyReleased(Key key) {
        if (key == Key.LEFT && playerShip.getDirection() == Direction.LEFT) playerShip.setDirection(Direction.LEFT);
        if (key == Key.RIGHT && playerShip.getDirection() == Direction.RIGHT) playerShip.setDirection(Direction.RIGHT);
    }

    @Override
    public void setCellValueEx(int x, int y, Color cellColor, String value) {
        if ((x < 0) || (x >= WIDTH) || (y < 0) || (y >= HEIGHT)) {
        } else super.setCellValueEx(x, y, cellColor, value);
    }
}
