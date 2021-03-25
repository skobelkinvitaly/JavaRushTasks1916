package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.*;

public class SpaceInvadersGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;

    @Override
    public void initialize() {
//        super.initialize();
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }
    private void createGame(){
        drawScene();
    }
    private void drawScene(){
        drawField();
    }
    private void drawField(){
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
//                setCellColor(i, j, Color.BLACK, "");
//                setCellValue(i,j,Color.BLACK,"");
                setCellValueEx(i,j,Color.BLACK, "");
            }
        }
    }
}
