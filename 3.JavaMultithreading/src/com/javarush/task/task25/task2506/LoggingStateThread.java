package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    Thread thread;

    @Override
    public void run() {
        super.run();
        Thread.State state1 = thread.getState();
        System.out.println(state1);
        while (true) {
            Thread.State state2 = thread.getState();
            if (state1 != state2) System.out.println(state2);
            state1 = state2;
            if (state2 == State.TERMINATED) return;
        }
    }

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
    }
}
