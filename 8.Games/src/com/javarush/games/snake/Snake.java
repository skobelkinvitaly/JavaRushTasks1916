package com.javarush.games.snake;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    public Snake(int x, int y) {
        GameObject gameObject = new GameObject(x, y);//cоздаются сегменты змейки
        snakeParts.add(gameObject);                  //cоздаются сегменты змейки
        GameObject gameObject2 = new GameObject(x+1, y);//cоздаются сегменты змейки
        snakeParts.add(gameObject2);                 //cоздаются сегменты змейки
        GameObject gameObject3 = new GameObject(x+2, y);//cоздаются сегменты змейки
        snakeParts.add(gameObject3);                 //cоздаются сегменты змейки
    }

    private List<GameObject> snakeParts = new ArrayList<>();
}
