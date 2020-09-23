package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        String filename = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        filename = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(filename);
        String result = "";
        ArrayList<String> array = new ArrayList<>();
        while (fileReader.ready()) {
            int data = fileReader.read();
            result = result + (char) data;
        }
        fileReader.close();
        String tagFinish = "</" + args[0] + ">";
        String tagStart =  "<" + args[0] + " ";
        String tagStart2 =  "<" + args[0] + ">";
        int countStart = 0;
        int countFinish = 0;

        String[] sArray = result.split(tagFinish);
        ArrayList<String> tags = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < sArray.length; i++) {
            sArray[i] = sArray[i].trim();
            sArray[i] = sArray[i] + tagFinish;
            sArray[i] = sArray[i].substring(sArray[i].indexOf("<"), sArray[i].lastIndexOf(">")+1);
            System.out.println(sArray[i]);
            char[] tagStringChars = sArray[i].toCharArray();
            String s = "";
            for (int j = 0; j < tagStringChars.length; j++) {
                s = s + tagStringChars[i];
            }
        }



    }
}
