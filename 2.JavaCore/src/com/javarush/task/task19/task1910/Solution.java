package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        BufferedReader r1 = new BufferedReader(new FileReader(file1));
        String sFile1 = "";
        while (r1.ready()){
            String temp = r1.readLine();
            sFile1 = sFile1 + temp;
        }
        r1.close();
        sFile1 = sFile1.replaceAll("[^\\w\\s]", "");
//        System.out.println(sFile1);
//        String[] arr = sFile1.split("^\\W\\S");
//        String result = "";
//        for (int i = 0; i < arr.length; i++) {
////            System.out.println(arr[i]);
//            result = result + arr[i];
//        }
//
//        String[] arr2 = result.split("_");
//        String result2 = "";
//        for (int i = 0; i < arr2.length; i++) {
//            result2 = result2 + arr2[i];
//        }
//
//        String[] arr3 = result2.split("\\n");
//        String result3 = "";
//        for (int i = 0; i < arr3.length; i++) {
//            result3 = result3 + arr[i];
//        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
        writer.write(sFile1);
        writer.close();
    }
}
