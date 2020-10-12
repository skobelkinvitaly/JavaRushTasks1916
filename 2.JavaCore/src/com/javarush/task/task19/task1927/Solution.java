package com.javarush.task.task19.task1927;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Контекстная реклама
*/

public class Solution {

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }

    public static TestString testString = new TestString();

    public static void main(String[] args) {
        String adv = "JavaRush - курсы Java онлайн";
        PrintStream consoleStream = System.out;// сохраняем ссылку на System.out в consoleStream класса PrintStream

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();// это расширяемый массив
        PrintStream printStream = new PrintStream(byteArrayOutputStream); // закидываем в поток наш массив
        System.setOut(printStream);// подменяем вывод на консоль загонянием в наш поток
        testString.printSomething();// выводим в наш массив 5 строк, предназначенных на консоль
        System.setOut(consoleStream);// возвращаем консольный вывод

        String st[] = byteArrayOutputStream.toString().split("\n");// режем вывод на консоль по строкам
        int i = 0;
        for (String sti : st) {// пока есть строки, что загнаны в наш массив
            System.out.println(sti);// выводим первую строку
            i++;// считаем счетчик второй строки
            if ((i % 2) == 0) {// если строка третья, то выводим в консоль рекламу
                System.out.println(adv);
            }
        }

    }
}

