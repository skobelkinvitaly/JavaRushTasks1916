package com.javarush.games.snake;

import com.javarush.engine.cell.*;

public class SnakeGame extends Game {
    private   int turnDelay; //Переменная установки продолжительности хода
    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    private Snake snake;

    @Override
    public void initialize() {
        //устанавливаем размеры игрового поля
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }
    //метод выполняет действия для создания игры
    private void  createGame(){
        turnDelay = 300;
        setTurnTimer(turnDelay);
//        Apple apple = new Apple(7,7);//создаем яблоко
        Snake snakeT = new Snake(WIDTH/2, HEIGHT/2);
        snake = snakeT;
        drawScene();
//        apple.draw(this);//отрисовка яблока
    }
    //метод выполняет отрисовку экрана
    private void  drawScene(){
        //Окраска ячеек игрового поля
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
//                setCellColor(x, y, Color.DARKSEAGREEN);
                setCellValueEx(x,y,Color.DARKSEAGREEN, "");
            }
        }
        snake.draw(this); //отрисовка змеи
    }
//Всё, что должно происходить в игре на протяжении одного хода, описывается здесь.
// После передвижения змейки не забудь перерисовать игровое поле.
    @Override
    public void onTurn(int step) {
//        super.onTurn(step);
        snake.move();
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
//        super.onKeyPress(key);
        if (key == Key.LEFT) snake.setDirection(Direction.LEFT);
        if (key == Key.RIGHT) snake.setDirection(Direction.RIGHT);
        if (key == Key.UP) snake.setDirection(Direction.UP);
        if (key == Key.DOWN) snake.setDirection(Direction.DOWN);
    }
}
