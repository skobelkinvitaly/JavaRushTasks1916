package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String filename1 = args[0];
        String filename2 = args[1];
        String resultString = "";
        BufferedReader r = new BufferedReader(new FileReader(filename1));
        BufferedWriter w = new BufferedWriter(new FileWriter(filename2));
        while (true) {
            String temp = "";
            temp = r.readLine();
            if (temp == null) break;
            else {
                String[] strings = temp.split(" ");
                for (int i = 0; i < strings.length; i++) {
                    if (resultString.length()>0) {
                        if (strings[i].length() > 6) resultString = resultString  + strings[i] + ",";
                    }
                    else if (strings[i].length() > 6) {
                        resultString = strings[i] + ",";
                    }
                }
            }
        }
        r.close();
        resultString = resultString.substring(0, resultString.length()-1);
//        System.out.println(resultString);
        w.write(resultString);
        w.close();
    }
}
