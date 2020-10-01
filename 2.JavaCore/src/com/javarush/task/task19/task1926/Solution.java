package com.javarush.task.task19.task1926;

import java.io.*;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String filename = "";
        BufferedReader r1 = new BufferedReader(new InputStreamReader(System.in));
        filename = r1.readLine();
        r1.close();

        BufferedReader r = new BufferedReader(new FileReader(filename));
        while (true) {
            String temp = "";
            String reversed = "";
            temp = r.readLine();
            if (temp == null) break;
            else {
                char[] chars = temp.toCharArray();
                for (int i = chars.length-1; i >= 0 ; i--) {
                    reversed = reversed + chars[i];
                }
                System.out.println(reversed);
            }
        }
        r.close();

        r.close();

    }
}
