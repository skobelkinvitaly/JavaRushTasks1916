package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("file");
        words.add("fillet");
        words.add("Bee");
    }

    public static void main(String[] args) throws IOException {
        String filename;
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        filename = r.readLine();
        r.close();
        BufferedReader r2 = new BufferedReader(new FileReader(filename));
        while (true) {
            String readlineString = r2.readLine();
            int count = 0;
            if (readlineString == null) break;
            else {
                String[] wordsArray = readlineString.split(" ");
                for (int i = 0; i < wordsArray.length; i++) {
                    for (int j = 0; j < words.size(); j++) {
                        if (wordsArray[i].equals(words.get(j))) {
                            count++;
                        }
                    }
                }
                if (count == 2) System.out.println(readlineString);
            }
        }
        r2.close();
    }
}
