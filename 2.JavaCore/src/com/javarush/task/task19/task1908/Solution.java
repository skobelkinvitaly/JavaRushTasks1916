package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        BufferedReader reader1 = new BufferedReader(new FileReader(file1));
        ArrayList<String> text = new ArrayList<>();
        String s = "";
        while (reader1.ready()) {
            s = s + reader1.readLine();
            text.add(s);
        }
        System.out.println(s);
        reader1.close();
        String[] arr = s.split(" ");
        String res = "";
        Solution solution = new Solution();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
            if (solution.isDigit(arr[i])) res = res + arr[i] + " ";
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
//        String newString = "";
//        for (int i = 0; i < arr.length; i++) {
//            if (!arr[i].equals(""))
//                newString = arr[i] + " ";
//        }
//        writer.write(newString);
//        System.out.println(newString);
        writer.write(res);
        System.out.println(res);
        writer.close();
    }
}
