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
                setCellColoredNumber(x,y,gameField[y][x]);
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
    }
    private  Color getColorByValue(int value){
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
    private void setCellColoredNumber(int x, int y, int value){
        Color color2 = getColorByValue(value);
        String num = "";
        if (value !=0) num = String.valueOf(value);
        setCellValueEx(x,y,color2, num);
    }
}