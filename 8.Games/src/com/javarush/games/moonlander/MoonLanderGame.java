package com.javarush.games.moonlander;

import com.javarush.engine.cell.*;

public class MoonLanderGame extends Game {
    private int score;
    private boolean isGameStopped;
    private GameObject platform;
    private boolean isUpPressed;
    private boolean isLeftPressed;
    private boolean isRightPressed;
    private GameObject landscape;
    private Rocket rocket;
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;

    @Override
    public void initialize() {
        showGrid(false);
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame() {
        score = 1000;
        isGameStopped = false;
        isUpPressed = false;
        isLeftPressed = false;
        isRightPressed = false;
        setTurnTimer(50);
        createGameObjects();
        drawScene();
    }

    private void drawScene() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                setCellColor(i, j, Color.BLUE);
            }
        }
        landscape.draw(this);
        rocket.draw(this);
    }

    private void createGameObjects() {
        rocket = new Rocket(WIDTH / 2, 2);
        landscape = new GameObject(0, 25, ShapeMatrix.LANDSCAPE);
        platform = new GameObject(23, MoonLanderGame.HEIGHT - 1, ShapeMatrix.PLATFORM);
    }

    @Override
    public void onTurn(int step) {
        if (score > 0) score = score - 1;
        rocket.move(isUpPressed, isLeftPressed, isRightPressed);
        check();
        setScore(score);
        drawScene();
    }

    @Override
    public void setCellColor(int x, int y, Color color) {
        if (x <= 0 | x >= WIDTH | y <= 0 | y >= HEIGHT) {

        } else super.setCellColor(x, y, color);
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.UP) isUpPressed = true;
        if (key == Key.LEFT) {
            isLeftPressed = true;
            isRightPressed = false;
        }
        if (key == Key.RIGHT) {
            isLeftPressed = false;
            isRightPressed = true;
        }
        if (key == Key.SPACE && isGameStopped == true) createGame();
    }

    @Override
    public void onKeyReleased(Key key) {
        if (key == Key.UP) isUpPressed = false;
        if (key == Key.RIGHT) isRightPressed = false;
        if (key == Key.LEFT) isLeftPressed = false;
    }

    private void check() {
        if (rocket.isCollision(landscape) == true || rocket.isCollision(platform) == false &&
                rocket.isStopped() == true) gameOver();
        if (rocket.isCollision(platform) == true &&
                rocket.isStopped() == true) win();

    }

    private void win() {
        rocket.land();
        isGameStopped = true;
        showMessageDialog(Color.YELLOW, "You win!", Color.BLACK, 50);
        stopTurnTimer();
    }

    private void gameOver() {
        rocket.crash();
        isGameStopped = true;
        showMessageDialog(Color.BLUE, "CRASH!", Color.BLACK, 50);
        stopTurnTimer();
        score = 0;
    }

}
