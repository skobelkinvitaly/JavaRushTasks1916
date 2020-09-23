package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String filename = args[0];
        String name;
        double num = 0, numNew = 0;
        String readline = "";
        Map<String, Double> map = new HashMap<String, Double>();
        BufferedReader b = new BufferedReader(new FileReader(filename));
        while (true){
            readline = b.readLine();
            if (readline == null) break;
            else {
//                System.out.println(readline);
                name = readline.substring(0,readline.indexOf(" "));
                num = Double.parseDouble(readline.substring(readline.indexOf(" ") + 1, readline.length()));
                if (map.containsKey(name)){ //Проверка: есть ли уже такой ключ в Мапе
                    double numOld  = map.get(name);
                    numNew = numOld + num; // Обновляем value
                    map.put(name, numNew); // Записываем новое значение value
                } else map.put(name, num);
//                System.out.println(name);
//                System.out.println(num);
            }
        }
        b.close();
        double min = Double.MAX_VALUE;
//        for (double value :
//                map.values()) {
//            if (value<min) min = value;
//        }
//        System.out.println(min);
Map<String, Double> sortedMap = new TreeMap<>(map);
for (Map.Entry entry: sortedMap.entrySet()) {
    System.out.println(entry.getKey() + " " + entry.getValue());
}
    }
}
