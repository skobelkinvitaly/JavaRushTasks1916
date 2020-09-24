package com.javarush.task.task19.task1923;

import java.io.*;
import java.util.ArrayList;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1 = args[0];
        String file2 = args[1];
        BufferedReader r = new BufferedReader(new FileReader(file1));
        BufferedWriter w = new BufferedWriter(new FileWriter(file2));
        while (true) {
            int count = 0;
            String temp = r.readLine();
            if (temp == null) break;
            else {
                String [] array = temp.split(" ");
//                ArrayList<String> stringArrayList = new ArrayList<>();
//                stringArrayList = temp.split(" ");
                for (int i = 0; i < array.length; i++) {
                    char[ ] chars = array[i].toCharArray();
                    for (int j = 0; j < chars.length; j++) {
                        if (Character.isDigit(chars[j])) {
                            count = 1;
                            break;
                        }
                    }
                    if (count ==1) {
                        w.write(array[i] + " ");
                        count = 0;
                    }
                }
            }
        }
        r.close();
        w.close();
    }
}
