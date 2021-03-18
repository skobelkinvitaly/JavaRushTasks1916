package com.javarush.games.racer;

import com.javarush.engine.cell.*;
import com.javarush.engine.cell.Color;
import com.javarush.games.racer.road.RoadManager;

public class RacerGame extends Game {
    private PlayerCar player;
    private RoadMarking roadMarking;
    private RoadManager roadManager;
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int CENTER_X = WIDTH / 2;
    public static final int ROADSIDE_WIDTH = 14;

    @Override
    public void onKeyReleased(Key key) {
        if (key == Key.RIGHT && player.getDirection() == Direction.RIGHT) player.setDirection(Direction.NONE);
        if (key == Key.LEFT && player.getDirection() == Direction.LEFT) player.setDirection(Direction.NONE);

    }

    @Override
    public void onKeyPress(Key key) {
//        super.onKeyPress(key);
        if (key == Key.RIGHT) player.setDirection(Direction.RIGHT);
        if (key == Key.LEFT) player.setDirection(Direction.LEFT);
    }

    private void moveAll() {
        roadMarking.move(player.speed);
        player.move();
        roadManager.move(player.speed);
    }

    @Override
    public void onTurn(int step) {
        moveAll();
        roadManager.generateNewRoadObjects(this);
        drawScene();

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
        roadMarking = new RoadMarking();
        player = new PlayerCar();
        roadManager = new RoadManager();
        drawScene();
        setTurnTimer(40);
    }

    @Override
    public void setCellColor(int x, int y, Color color) {
        if (x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT) super.setCellColor(x, y, color);
    }

    ;

    private void drawScene() {

        drawField();
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
}
