package com.javarush.task.task23.task2305;

/* 
Inner
*/

public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {

        Solution solution1 = new Solution();
        solution1.innerClasses = new InnerClass[]{};
        Solution solution2 = new Solution();
        solution2.innerClasses = new InnerClass[]{};
        Solution[] solutions = new Solution[2];
        solutions[0] = solution1;
        solutions[1] = solution2;

        return solutions;
    }

    public static void main(String[] args) {

    }
}
