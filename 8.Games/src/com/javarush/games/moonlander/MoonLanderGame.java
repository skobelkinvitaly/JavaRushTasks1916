package com.javarush.games.moonlander;

import com.javarush.engine.cell.*;
import javafx.scene.transform.MatrixType;

public class MoonLanderGame extends Game {
    private GameObject landscape;
    private  Rocket rocket;
    public static final int  WIDTH = 64;
    public static final int  HEIGHT = 64;
    @Override
    public void initialize() {
//        super.initialize();
        showGrid(false);
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }
    private void createGame(){

//        rocket = new Rocket(WIDTH/2, 0);
        createGameObjects();
        drawScene();
    }
    private void drawScene(){
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                setCellColor(i,j,Color.BLUE);
            }
        }
        landscape.draw(this);
        rocket.draw(this);
    }
    private void createGameObjects(){
        rocket = new Rocket(WIDTH/2, 0);
        landscape = new GameObject(0, 25, ShapeMatrix.LANDSCAPE);
    }
}
