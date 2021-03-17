package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/

public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        for (int i = 0; i < threads.length; i++) {
            Thread threadTemp = threads[i];
            switch (threadTemp.getState()){
                case NEW: threadTemp.start();
                break;
                case TIMED_WAITING:
                case BLOCKED:
                case WAITING: threadTemp.interrupt();
                break;
                case RUNNABLE: threadTemp.isInterrupted();
                break;
                case TERMINATED:
                    System.out.println(threadTemp.getPriority());
                    break;
            }
        }
    }

    public static void main(String[] args) {
    }
}
