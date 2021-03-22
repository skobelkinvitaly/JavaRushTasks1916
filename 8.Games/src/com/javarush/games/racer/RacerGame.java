package com.javarush.games.racer;

import com.javarush.engine.cell.*;
import com.javarush.engine.cell.Color;
import com.javarush.games.racer.road.RoadManager;

public class RacerGame extends Game {
    private int score;
    private ProgressBar progressBar;
    private FinishLine finishLine;
    private boolean isGameStopped;
    private PlayerCar player;
    private RoadMarking roadMarking;
    private RoadManager roadManager;
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int CENTER_X = WIDTH / 2;
    public static final int ROADSIDE_WIDTH = 14;
    private static final int RACE_GOAL_CARS_COUNT = 40;

    @Override
    public void onKeyReleased(Key key) {
        if (key == Key.RIGHT && player.getDirection() == Direction.RIGHT) player.setDirection(Direction.NONE);
        if (key == Key.LEFT && player.getDirection() == Direction.LEFT) player.setDirection(Direction.NONE);
        if (key == Key.UP) player.speed = 1;
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.RIGHT) player.setDirection(Direction.RIGHT);
        if (key == Key.LEFT) player.setDirection(Direction.LEFT);
        if (key == Key.UP) player.speed = 2;
        if (key == Key.SPACE && isGameStopped == true) createGame();
    }

    private void moveAll() {
        roadMarking.move(player.speed);
        player.move();
        roadManager.move(player.speed);
        finishLine.move(player.speed);
        progressBar.move(roadManager.getPassedCarsCount());
    }

    @Override
    public void onTurn(int step) {
        score = score - 5;
        setScore(score);
        boolean ret;
        ret = roadManager.checkCrush(player);
        if (ret == true) {
            gameOver();
        } else {
            if (roadManager.getPassedCarsCount() >= RACE_GOAL_CARS_COUNT) finishLine.show();
            if (finishLine.isCrossed(player) == true) {
                win();
                drawScene();
            } else {
                roadManager.generateNewRoadObjects(this);
                moveAll();
                drawScene();
            }
        }
    }

    private void drawField() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                if (x == CENTER_X) {
                    setCellColor(CENTER_X, y, Color.WHITE);
                } else if (x >= ROADSIDE_WIDTH && x < (WIDTH - ROADSIDE_WIDTH)) {
                    setCellColor(x, y, Color.DIMGREY);
                } else setCellColor(x, y, Color.GREEN);
            }
        }
    }

    private void createGame() {
        score = 3500;
        roadMarking = new RoadMarking();
        player = new PlayerCar();
        roadManager = new RoadManager();
        finishLine = new FinishLine();
        progressBar = new ProgressBar(RACE_GOAL_CARS_COUNT);
        drawScene();
        setTurnTimer(40);
        isGameStopped = false;
    }

    @Override
    public void setCellColor(int x, int y, Color color) {
        if (x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT) super.setCellColor(x, y, color);
    }

    ;

    private void drawScene() {

        drawField();
        progressBar.draw(this);
        finishLine.draw(this);
        roadMarking.draw(this);
        player.draw(this);
        roadManager.draw(this);
    }

    ;


    @Override
    public void initialize() {
        super.initialize();
        showGrid(false);
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    public static void main(String[] args) {
        RacerGame racerGame = new RacerGame();
        racerGame.initialize();

    }

    private void gameOver() {
        showMessageDialog(Color.AZURE, "Game Over", Color.BLACK, 100);
        stopTurnTimer();
        player.stop();
        isGameStopped = true;
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "You win!", Color.BLACK, 30);
        stopTurnTimer();
    }
}
