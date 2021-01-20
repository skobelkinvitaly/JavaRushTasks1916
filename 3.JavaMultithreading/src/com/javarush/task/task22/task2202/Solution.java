package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null) throw new TooShortStringException();
        String formattedString = "";
        String[] array = string.split(" ");
        try {
            for (int i = 0; i < 5; i++) {
                if (i != 0) {
                    if (i == 1) {
                        formattedString = formattedString + array[i];
                    } else formattedString = formattedString + " " + array[i];
                }
            }
        } catch (Exception e) {
            throw new TooShortStringException();
        }
        return formattedString;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
