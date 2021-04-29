package com.javarush.games.moonlander;

import com.javarush.engine.cell.*;

public class MoonLanderGame extends Game {
    private  Rocket rocket;
    public static final int  WIDTH = 64;
    public static final int  HEIGHT = 64;
    @Override
    public void initialize() {
//        super.initialize();
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }
    private void createGame(){

        rocket = new Rocket(WIDTH/2, 0);
        drawScene();
    }
    private void drawScene(){
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                setCellColor(i,j,Color.BLUE);
            }
        }
        rocket.draw(this);
    }
}
