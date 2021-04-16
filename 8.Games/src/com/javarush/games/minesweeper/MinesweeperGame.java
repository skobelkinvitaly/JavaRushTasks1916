package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private int countFlags;
    private static final String FLAG = "\uD83D\uDEA9";
    private static final String MINE = "\uD83D\uDCA3";
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(10) < 1;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.ORANGE);
            }
        }
        countMineNeighbors();
        countFlags = countMinesOnField;
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }

    private void countMineNeighbors() {
        List<GameObject> list;
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                GameObject obj = gameField[i][j];
                if (!obj.isMine) {
                    list = getNeighbors(obj);
                    for (int k = 0; k < list.size(); k++) {
                        if (list.get(k).isMine) obj.countMineNeighbors++;
                    }
                }
            }
        }
    }

    private void openTile(int x, int y) {
//        for (int y2 = 0; y2 < SIDE; y2++) {
//            for (int x2 = 0; x2 < SIDE; x2++) {
//                if (gameField[y2][x2].isMine) {
//                    setCellValue(x2, y2, MINE);
//                } else {
//                    setCellNumber(x2, y2, gameField[y2][x2].countMineNeighbors);
//                }
//                gameField[y2][x2].isOpen = true;
//                setCellColor(x2, y2, Color.GREEN);
//            }
//        }
        if (gameField[y][x].isMine) setCellValue(x, y, MINE);
        else setCellNumber(x, y, gameField[y][x].countMineNeighbors);
        gameField[y][x].isOpen = true;
        setCellColor(x, y, Color.GREEN);
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
//        super.onMouseLeftClick(x, y);
        openTile(x, y);
    }
}