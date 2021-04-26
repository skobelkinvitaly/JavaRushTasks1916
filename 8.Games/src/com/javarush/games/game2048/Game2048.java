package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

public class Game2048 extends Game {
    private boolean isGameStopped = false;
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
                setCellColoredNumber(x, y, gameField[y][x]);
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
        int num = getMaxTileValue();
        if (num == 2048) win();
    }

    private Color getColorByValue(int value) {
        Color color = null;
        if (value == 2) color = Color.DEEPSKYBLUE;
        if (value == 4) color = Color.DEEPPINK;
        if (value == 8) color = Color.DIMGRAY;
        if (value == 16) color = Color.YELLOWGREEN;
        if (value == 32) color = Color.DARKORANGE;
        if (value == 64) color = Color.GRAY;
        if (value == 128) color = Color.RED;
        if (value == 256) color = Color.ROYALBLUE;
        if (value == 512) color = Color.GREENYELLOW;
        if (value == 1024) color = Color.BEIGE;
        if (value == 2048) color = Color.YELLOW;
        return color;
    }

    private void setCellColoredNumber(int x, int y, int value) {
        Color color2 = getColorByValue(value);
        String num = "";
        if (value != 0) num = String.valueOf(value);
        setCellValueEx(x, y, color2, num);
    }

    private boolean compressRow(int[] row) {

        boolean move = false;
        for (int i = 1; i < row.length; i++) {
            if (row[i] == 0) continue;
            if (row[i] != 0 && row[i - 1] == 0) {
                row[i - 1] = row[i];
                row[i] = 0;
                move = true;
                i = 0;
            }
        }
        return move;
    }

    private boolean mergeRow(int[] row) {
        boolean isMerged = false;
        for (int i = 0; i < row.length - 1; i++) {
            if (row[i] != 0 && row[i] == row[i + 1]) {
                row[i] = row[i] * 2;
                row[i + 1] = 0;
                isMerged = true;
            }
        }
        return isMerged;
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.LEFT) {
            moveLeft();
            drawScene();
        }
        if (key == Key.RIGHT) {
            moveRight();
            drawScene();
        }
        if (key == Key.UP) {
            moveUp();
            drawScene();
        }
        if (key == Key.DOWN) {
            moveDown();
            drawScene();
        }
    }

    private void moveLeft() {
        boolean isMoved = false;
        for (int i = 0; i < gameField.length; i++) {
            if (compressRow(gameField[i])) isMoved = true;
            if (mergeRow(gameField[i])) isMoved = true;
            if (compressRow(gameField[i])) isMoved = true;
        }
        if (isMoved == true) createNewNumber();
    }

    private void moveRight() {
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }

    private void moveUp() {
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }

    private void moveDown() {
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    private void rotateClockwise() {
        int[][] gameFieldCopy = new int[SIDE][SIDE];
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                gameFieldCopy[i][j] = gameField[3 - j][i];
            }
        }
        for (int z = 0; z < SIDE; z++) {
            for (int w = 0; w < SIDE; w++) {
                gameField[z][w] = gameFieldCopy[z][w];
            }
        }
    }

    private int getMaxTileValue() {
        int max = 0;
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (gameField[i][j] > max) max = gameField[i][j];
            }
        }
        return max;
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.GREEN, "You win!", Color.BLACK, 50);
    }
}