package com.javarush.games.snake;
//Класс для хранения объектов игрового поля. Объект класса будет хранить координаты соотв. ячейки
public class GameObject {
    public int x, y;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
