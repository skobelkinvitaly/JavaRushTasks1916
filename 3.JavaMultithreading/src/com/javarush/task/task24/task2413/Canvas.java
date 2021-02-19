package com.javarush.task.task24.task2413;

public class Canvas {
    void setPoint(double x, double y, char c) {
        int x1 = (int) Math.round(x);
        int y1 = (int) Math.round(y);
        if (x1 < 0 || y1 < 0 || y1 > matrix.length || x1 > matrix[0].length) {
        } else {
            matrix[y1][x1] = c;
        }
    }

    void drawMatrix(double x, double y, int[][] matrix, char c) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) setPoint(x+j,y+i,c);
            }
        }
    }

    private int width, height;

    public char[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }

    private char[][] matrix;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new char[height + 2][width + 2];
    }
}
