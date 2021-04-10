package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private Direction direction = Direction.LEFT;

    //Устанавливает направление
    public void setDirection(Direction direction) {
if (this.direction == Direction.RIGHT && direction != Direction.LEFT) this.direction = direction;
if (this.direction == Direction.LEFT && direction != Direction.RIGHT) this.direction = direction;
if (this.direction == Direction.UP && direction != Direction.DOWN) this.direction = direction;
if (this.direction == Direction.DOWN && direction != Direction.UP) this.direction = direction;
    }

    public boolean isAlive = true;
    private List<GameObject> snakeParts = new ArrayList<>();
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";

    public Snake(int x, int y) {
        GameObject gameObject = new GameObject(x, y);//cоздаются сегменты змейки
        snakeParts.add(gameObject);                  //cоздаются сегменты змейки
        GameObject gameObject2 = new GameObject(x + 1, y);//cоздаются сегменты змейки
        snakeParts.add(gameObject2);                 //cоздаются сегменты змейки
        GameObject gameObject3 = new GameObject(x + 2, y);//cоздаются сегменты змейки
        snakeParts.add(gameObject3);                 //cоздаются сегменты змейки
    }

    //отрисовка змейки на игровом поле
    public void draw(Game game) {
        if (isAlive) {
//            game.setCellValue(snakeParts.get(0).x, snakeParts.get(0).y, HEAD_SIGN);
            game.setCellValueEx(snakeParts.get(0).x, snakeParts.get(0).y, Color.NONE, HEAD_SIGN,
                    Color.BLACK, 75);
            for (int i = 1; i < snakeParts.size(); i++) {
//                game.setCellValue(snakeParts.get(i).x, snakeParts.get(1).y, BODY_SIGN);
                game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, BODY_SIGN,
                        Color.BLACK, 75);
            }
        } else {
            //            game.setCellValue(snakeParts.get(0).x, snakeParts.get(0).y, HEAD_SIGN);
            game.setCellValueEx(snakeParts.get(0).x, snakeParts.get(0).y, Color.NONE, HEAD_SIGN,
                    Color.RED, 75);
            for (int i = 1; i < snakeParts.size(); i++) {
//                game.setCellValue(snakeParts.get(i).x, snakeParts.get(1).y, BODY_SIGN);
                game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, BODY_SIGN,
                        Color.RED, 75);
            }
        }
    }

    //Логика передвижения змейки
    public void move() {
        GameObject newHead = createNewHead();
        if (newHead.x < 0 || newHead.x >= SnakeGame.WIDTH || newHead.y < 0 ||
                newHead.y >= SnakeGame.HEIGHT) isAlive = false;
        else {
            snakeParts.add(0, newHead);
            removeTail();
        }
    }

    //Создаётся новая голова
    public GameObject createNewHead() {
        int headX = snakeParts.get(0).x;
        int headY = snakeParts.get(0).y;
        if (direction == Direction.LEFT) return new GameObject(headX - 1, headY);
        if (direction == Direction.RIGHT) return new GameObject(headX + 1, headY);
        if (direction == Direction.DOWN) return new GameObject(headX, headY + 1);
        return new GameObject(headX, headY - 1);
    }

    //Удаление хвоста при создании головы
    public void removeTail() {
        snakeParts.remove(snakeParts.size() - 1);
    }
}
