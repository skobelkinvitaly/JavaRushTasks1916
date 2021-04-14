package com.javarush.games.minesweeper;

import com.javarush.engine.cell.*;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
//        countMinesOnField =
    }

    private void createGame() {
//        countMinesOnField = getRandomNumber(10);
        boolean bool;
        int mines = 0;
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) {
//                bool = gameField[x][y].isMine;
                if (getRandomNumber(10) == 1) {
                    bool = true;
                    countMinesOnField++;
                }
                else bool = false;
                gameField[y][x] = new GameObject(x, y, bool);
                setCellColor(x, y, Color.ORANGE);
            }
        }
    }
}
