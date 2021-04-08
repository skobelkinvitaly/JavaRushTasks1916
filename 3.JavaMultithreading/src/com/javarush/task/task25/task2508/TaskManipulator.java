package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    Thread thread;
    @Override
    public void run() {
        System.out.println(thread.getName());
        while (!thread.isInterrupted()) {
            try {
                thread.sleep(100);
                System.out.println(thread.getName());
            } catch (InterruptedException e) {
//                e.printStackTrace();
                break;
            }
        }
    }

    @Override
    public void start(String threadName) {
thread = new Thread(this);
thread.setName(threadName);
thread.start();
    }

    @Override
    public void stop() {
thread.interrupt();
    }
}
