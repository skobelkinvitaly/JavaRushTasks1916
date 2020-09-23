package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream =  System.out;
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(arrayOutputStream);
        System.setOut(stream);
//        TestString testString = new TestString();
        testString.printSomething();
        String result = arrayOutputStream.toString();
        System.setOut(consoleStream);
        result = result.toUpperCase();
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
