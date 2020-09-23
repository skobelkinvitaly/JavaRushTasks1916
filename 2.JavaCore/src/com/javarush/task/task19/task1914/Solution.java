package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String string = outputStream.toString();
        System.setOut(consoleStream);
        String[] array = string.split(" ");
        String operationSign = array[1];
        int a = Integer.parseInt(array[0]);
        int b = Integer.parseInt(array[2]);
        int c = 0;
        if (operationSign.equals("+")) c = a + b;
        if (operationSign.equals("-")) c = a - b;
        if (operationSign.equals("*")) c = a * b;
        String res = string.substring(0,string.length());

        System.out.println(res + c);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

