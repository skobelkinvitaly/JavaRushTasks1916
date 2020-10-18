package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static boolean isNumeric(String s) {
        try {
            int num = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        String filename = args[0];
        BufferedReader r = new BufferedReader(new FileReader(filename));
        while (true) {
            String temp = r.readLine();
            Date date = new Date();
            if (temp == null) break;
            else {
                int d = 0, m = 0, y = 0;
                String name = "";
                String[] tempArray = temp.split(" ");//разбиваем строку
                for (int i = 0; i < tempArray.length; i++) {
                    if (isNumeric(tempArray[i]) == true) {
                        if (d == 0 & m == 0 & y == 0) d = Integer.parseInt(tempArray[i]);
                        else {
                            if (d != 0 & m == 0 & y == 0) m = Integer.parseInt(tempArray[i]);
                            else {
                                if (d != 0 & m != 0 & y == 0) y = Integer.parseInt(tempArray[i]);
                            }
                        }
                    } else {
                        if (name.length() > 0) name = name + " " + tempArray[i];
                        else {
                            if (name.length() == 0) name = tempArray[i];
                        }
                    }
                }
                System.out.println(name);
                System.out.println(d + " " + m + " " + y);
                date.setDate(d);
                date.setMonth(m-1);
                date.setYear(y-1900);
                PEOPLE.add(new Person(name,date));
            }

        }
        r.close();
    }
}
