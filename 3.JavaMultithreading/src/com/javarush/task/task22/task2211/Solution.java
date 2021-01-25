package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1 = args[0];
        String file2 = args[1];
        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);
        Charset utf8 = Charset.forName("UTF-8");
        Charset windows1251 = Charset.forName("Windows-1251");
        byte[] buffer = new byte[1000];
        fis.read(buffer);
        fis.close();
        String s = new String(buffer, windows1251);
        buffer = s.getBytes(utf8);
        fos.write(buffer);
        fos.close();
    }
}
