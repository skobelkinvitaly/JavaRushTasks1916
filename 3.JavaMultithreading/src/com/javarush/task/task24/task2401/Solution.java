package com.javarush.task.task24.task2401;

/* 
Создание своего интерфейса-маркера
*/

public class Solution {
//    public interface SelfInterfaceMarker{}
//    public class SelfInterfaceMarkerImpl implements SelfInterfaceMarker{
//        public void move(){}
//        public void print(){}
//    }
    public static void main(String[] args) throws UnsupportedInterfaceMarkerException {
        SelfInterfaceMarkerImpl obj = new SelfInterfaceMarkerImpl();
        Util.testClass(obj);
    }

}
