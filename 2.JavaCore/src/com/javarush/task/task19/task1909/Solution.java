package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        BufferedReader r1 = new BufferedReader(new FileReader(file1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
        String s1 = "";
        while (r1.ready()){
//            s1 = s1 + String.valueOf(r1.read());
            int data = r1.read();
            if (data == 46) data = 33;
            writer.write(data);
        }
        r1.close();
//        System.out.println(s1);
//        r1.close();
//        String[]arr = s1.split(".");
//        String result = "";
//        for (int i = 0; i < arr.length; i++) {
//            result = result + "!";
//        }
//        System.out.println(result);

        writer.close();
    }
}
