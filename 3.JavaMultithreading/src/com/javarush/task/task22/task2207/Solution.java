package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        ArrayList<String> strings = new ArrayList<>();
        String file = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        file = reader.readLine();
        reader.close();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
//            System.out.println(line);
            String[] array = line.split(" ");
            for (int i = 0; i < array.length; i++) {
                strings.add(array[i]);
            }
        }
//        for (String s
//                : strings) {
//            System.out.println(s);
//
//        }
        for (int i = 0; i < strings.size(); i++) {
            for (int j = i + 1; j < strings.size(); j++) {
                StringBuilder tempSB = new StringBuilder(strings.get(j));
                String s = strings.get(i);
                String tempReversed = tempSB.reverse().toString();
                if (!s.equals("") && s.equals(tempReversed)){
                    Pair tempPair = new Pair();
                    tempPair.first = strings.get(i);
                    tempPair.second = strings.get(j);
                    result.add(tempPair);
                    System.out.println(tempPair);
                    strings.set(i, "");
                    strings.set(j, "");
                    break;
                }
            }
        }
    }

    public static class Pair {
        public Pair() {
        }

        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
