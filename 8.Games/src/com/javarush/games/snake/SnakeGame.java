package com.javarush.games.snake;

import com.javarush.engine.cell.*;

public class SnakeGame extends Game {
    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;

    @Override
    public void initialize() {
        //устанавливаем размеры игрового поля
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }
    //метод выполняет действия для создания игры
    private void  createGame(){
//        Apple apple = new Apple(7,7);//создаем яблоко
        drawScene();
//        apple.draw(this);//отрисовка яблока
    }
    //метод выполняет отрисовку экрана
    private void  drawScene(){
        //Окраска ячеек игрового поля
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                setCellColor(x, y, Color.DARKSEAGREEN);
            }
        }
    }
}
