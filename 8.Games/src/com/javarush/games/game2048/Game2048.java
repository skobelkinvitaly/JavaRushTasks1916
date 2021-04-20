package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

public class Game2048 extends Game {
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    private void createGame() {
        createNewNumber();
        createNewNumber();
    }

    private void drawScene() {
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) {
                setCellColor(x, y, Color.GREEN);
            }
        }
    }

    private void createNewNumber() {
        while (true) {
            int x = getRandomNumber(SIDE);
            int y = getRandomNumber(SIDE);
            if (gameField[x][y] == 0) {
                int random = getRandomNumber(10);
                if (random == 9) gameField[x][y] = 4;
                else gameField[x][y] = 2;
                break;
            }
        }
//        for (int x = 0; x < SIDE; x++) {
//            for (int y = 0; y < SIDE; y++) {
//
//            }
//        }
    }
}