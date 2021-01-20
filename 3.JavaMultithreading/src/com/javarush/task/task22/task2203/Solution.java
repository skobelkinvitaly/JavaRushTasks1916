package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/

public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) throw new TooShortStringException();
        String resultString = "";
        String [] formattedString = string.split("\t");
        if (formattedString.length <3) throw new TooShortStringException();
        for (int i = 0; i < 2; i++) {
            if (i > 0) {
                resultString = resultString + formattedString[i];
            }
        }
        return resultString;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
