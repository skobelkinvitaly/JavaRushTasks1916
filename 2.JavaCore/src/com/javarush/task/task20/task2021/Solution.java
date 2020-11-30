package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
*/

public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        private void writeObject(ObjectOutputStream stream) throws NotSerializableException {
            throw new NotSerializableException();
        }
        private void readObject(ObjectInputStream stream) throws NotSerializableException {
            throw new NotSerializableException();
        }
    }

    public static void main(String[] args) throws IOException {
//        SubSolution sub = new SubSolution();
//
//        FileOutputStream fileOutputStream = new FileOutputStream("D:\\test1.txt");
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//
//        objectOutputStream.writeObject(sub);
    }
}
