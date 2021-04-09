package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private Direction direction = Direction.LEFT;

    //Устанавливает направление
    public void setDirection(Direction direction) {
        this.direction = direction;
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
}
