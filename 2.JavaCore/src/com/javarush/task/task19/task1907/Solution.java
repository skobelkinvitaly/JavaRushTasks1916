package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        FileReader fs = new FileReader(file);
//        String w = "world";
        String result = "";
        while (fs.ready()){
            int data = fs.read();
            result = result + (char) data;
        }
        fs.close();
//        System.out.println(result);
        result = result.toLowerCase();
        int frequency = 0;
        String[] numArray = result.split("\\W");
        for (int i = 0; i < numArray.length; i++) {
            if (numArray[i].equals("world")) frequency++;
        }

        System.out.println(frequency);
    }
}
