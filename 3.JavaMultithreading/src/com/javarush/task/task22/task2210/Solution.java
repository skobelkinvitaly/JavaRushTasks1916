package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.StringTokenizer;

/* 
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {
//        String s = "level22.lesson13.task01";
//        String delimiter = ".";
//        String result[] = getTokens(s, delimiter);
//        for (int i = 0; i < result.length; i++) {
//            System.out.println(result[i]);
//        }
    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
        ArrayList<String> strings = new ArrayList<>();
//        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
//            i++;
            strings.add(token);
        }
        String[] resultArray = new String[strings.size()];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = strings.get(i);
        }
        return resultArray;
    }
}
