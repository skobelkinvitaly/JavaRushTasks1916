package com.javarush.task.task20.task2027;

import java.util.*;

/* 
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
//                {'f', 'd', 'e', 'r', 'l', 'k'},
//                {'u', 's', 'a', 'm', 'e', 'o'},
//                {'l', 'n', 'g', 'r', 'o', 'v'},
//                {'m', 'l', 'p', 'r', 'r', 'h'},
//                {'p', 'o', 'e', 'e', 'j', 'j'}
                {'a', 'b', 'c'},
                {'b', 'd', 'd'},
                {'c', 'd', 'd'}
        };
        List<Word> wordList = detectAllWords(crossword, "dd", "bb", "c");
        for (int i = 0; i < wordList.size(); i++) {
            System.out.println(wordList.get(i).toString());
        }

        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static char[] getChars(String word) {
        char[] charArray = new char[word.length()];
        charArray = word.toCharArray();
        return charArray;
    }

    public static char getStartChar(char[] chars) {
        char startChar = 0;
        startChar = chars[0];
        return startChar;
    }

    public static ArrayList getStartNum2(int[][] crossword, String s) {
        ArrayList<int[]> ArrayListOfCoordinates = new ArrayList<>();
        char ch = s.charAt(0);
        for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword[i].length; j++) {
                int[] coordinates = new int[2];
                if (crossword[i][j] == ch) {
                    coordinates[0] = j;
                    coordinates[1] = i;
                    ArrayListOfCoordinates.add(coordinates);
//                    System.out.println(String.valueOf(ch) + ": " + j + ", " + i);
                }
            }
        }
        return ArrayListOfCoordinates;
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        int numOfIterations = 0;
        List<Word> ArrayListOfWords = new ArrayList<>();
        HashSet<Word> setOfWords = new HashSet<>();
        for (int y = 0; y < words.length; y++) {
            ArrayList<int[]> startCoordinates = getStartNum2(crossword, words[y]);
            for (int qq = 0; qq < startCoordinates.size(); qq++) {
                int[] point = new int[2];
                point[0] = startCoordinates.get(qq)[0];
                point[1] = startCoordinates.get(qq)[1];
                String wordNew = "";
                int xTemp = 0;
                int yTemp = 0;
                for (int i = -1; i < 2; i++) {
                    if (wordNew.length() == words[y].length()) break;
                    for (int j = -1; j < 2; j++) {
                        if (wordNew.length() == words[y].length()) break;
                        for (int w = 0; w < words[y].length(); w++) {
                            xTemp = point[0] + w * j;
                            yTemp = point[1] + w * i;
                            if (xTemp < 0) {
                                wordNew = "";
                                break;
                            }
                            if (xTemp > crossword[0].length - 1) {
                                wordNew = "";
                                break;
                            }
                            if (yTemp < 0) {
                                wordNew = "";
                                break;
                            }
                            if (yTemp > crossword.length - 1) {
                                wordNew = "";
                                break;
                            }
                            if ((xTemp == point[0]) & (yTemp == point[1]) & (w != 0)) {
                                wordNew = "";
                                break;
                            }
                            char sTemp;
                            sTemp = (char) crossword[yTemp][xTemp];
                            wordNew = wordNew + sTemp;
                            if (wordNew.equals(words[y])) {
                                numOfIterations++;
                                Word word = new Word(words[y]);
                                word.startX = point[0];
                                word.endX = xTemp;
                                word.startY = point[1];
                                word.endY = yTemp;
                                setOfWords.add(word);
                                wordNew = "";
                                break;
                            }
                            if (wordNew.length() == words[y].length()) {
                                wordNew = "";
                                break;
                            }
                        }
                    }
                }
            }
        }
        ArrayListOfWords.clear();
        ArrayListOfWords.addAll(setOfWords);
        return ArrayListOfWords;
    }

    public static class Word {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Word word = (Word) o;
            return startX == word.startX &&
                    startY == word.startY &&
                    endX == word.endX &&
                    endY == word.endY &&
                    text.equals(word.text);
        }

        @Override
        public int hashCode() {
            return Objects.hash(text, startX, startY, endX, endY);
        }

        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
