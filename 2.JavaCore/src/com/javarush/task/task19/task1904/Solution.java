package com.javarush.task.task19.task1904;

/* 
И еще один адаптер
*/

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException, ParseException {
        PersonScannerAdapter PSA = new PersonScannerAdapter(new Scanner(System.in));
        PSA.read();
        PSA.close();
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner sc) {
            fileScanner = sc;
        }

        @Override
        public Person read() throws IOException, ParseException {
            String[] pers = fileScanner.nextLine().split(" ", 4);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d M y", Locale.ENGLISH);
            String d = pers[3];
            String first = pers[1];
            String middleName = pers[2];
            String lastName = pers[0];
            Date date = simpleDateFormat.parse(d);
            Person person = new Person(first, middleName, lastName, date);
            System.out.println(person);
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
