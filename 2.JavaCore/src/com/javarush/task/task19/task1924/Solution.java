package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static boolean isNumeric(String str) {
        try {
            int num = Integer.parseInt(str);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameRead = consoleReader.readLine();
        consoleReader.close();
        BufferedReader r = new BufferedReader(new FileReader(fileNameRead));
        while (true) {
            String temp = "";
            String newString = "";
            temp = r.readLine();
            if (temp == null) break;
            else {
                String[] stringSplitted = temp.split(" "); // разбили строку на слова и цифрры
                for (int i = 0; i < stringSplitted.length; i++) { // перебираем строку
                    String s = stringSplitted[i];
                    Integer num = 0;
                    if (isNumeric(s) == true) {             // проверка на число
                        num = Integer.parseInt(s);
                        for (Map.Entry entry : map.entrySet()
                        ) {
                            if (num == entry.getKey()) s = String.valueOf(entry.getValue());
                        }
                    }
                    if (i == 0 && i == stringSplitted.length) newString = newString + s;
                    else {
                        newString = newString + " " + s + " ";
                    }
//                    newString = newString + s;                    // формируем новую строку
                }
                System.out.println(newString);
            }
        }

        r.close();
    }
}
