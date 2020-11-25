package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/

public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        System.out.println(new Solution(4));

        //save to file
        Solution savedObject = new Solution(9);
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\test1.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(savedObject);
        fileOutputStream.close();
        objectOutputStream.close();

        //load from file
        FileInputStream fileInputStream = new FileInputStream("D:\\test1.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object object = objectInputStream.readObject();
        fileInputStream.close();
        objectInputStream.close();

        Solution loadedObject = (Solution) object;

        System.out.println(savedObject.string.equals(loadedObject.string));
    }

    private final transient String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
