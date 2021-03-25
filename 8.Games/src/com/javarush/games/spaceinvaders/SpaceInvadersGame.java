package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.*;
import com.javarush.games.spaceinvaders.gameobjects.Star;

import java.util.ArrayList;
import java.util.List;

public class SpaceInvadersGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    private List<Star> stars;

    @Override
    public void initialize() {
//        super.initialize();
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }
    private void createGame(){
        createStars();
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
        for (int i = 0; i < stars.size(); i++) {
            stars.get(i).draw(this);
        }
    }
    private void createStars(){
        stars = new ArrayList<Star>();
        for (int i = 0; i < 8; i++) {
            stars.add(new Star(Math.random()*5,Math.random()*5));
        }
    }
}
