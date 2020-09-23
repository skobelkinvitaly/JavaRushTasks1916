package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String filename = args[0];
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String name = "";
        String readline = "";
        double num = 0;
        double numNew = 0;
        Map<String, Double> map = new HashMap<String, Double>();
        while (true) {
            readline = reader.readLine();
            if (readline == null) break;
            else {
                name = readline.substring(0, readline.indexOf(" "));
                num = Double.parseDouble(readline.substring(readline.indexOf(" ") + 1, readline.length()));
                if (map.containsKey(name)) {
                    double numOld = map.get(name);
                    numNew = numOld + num;
                    map.put(name, numNew);
                } else {
                    map.put(name, num);
                }
            }
        }
        reader.close();

        Map<String, Double> sortedMap = new TreeMap<>(map);
        double max = 0;
        for (Map.Entry entry : sortedMap.entrySet()) {
            if ( (double) entry.getValue() > max) max = (double) entry.getValue();
        }

        for (Map.Entry entry2 : sortedMap.entrySet()) {
            if ( (double) entry2.getValue() == max) System.out.println(entry2.getKey());
        }
//        System.out.println(map.get(map.containsValue(max)));
    }
}
