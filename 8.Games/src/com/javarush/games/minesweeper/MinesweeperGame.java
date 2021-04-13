package com.javarush.games.minesweeper;

import com.javarush.engine.cell.*;

public class MinesweeperGame extends Game {
    @Override
    public void initialize() {
//        super.initialize();
        setScreenSize(SIDE, SIDE);
    }

    private  static final int SIDE = 9;
}
