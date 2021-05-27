package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends UniversityPerson {
    //    private List<Human> children = new ArrayList<>();
    private double averageGrade;
    //    private String university;
    private Date beginningOfSession;
    private Date endOfSession;
    private int course;

    @Override
    public String getPosition() {
//        return super.getPosition();
        return "Студент";
    }

    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
    }

    public int getCourse() {
        return course;
    }

//    public List<Human> getChildren() {
//        return children;
//    }

//    public void setChildren(List<Human> children) {
//        this.children = children;
//    }

    public void live() {
        learn();
    }

    public void learn() {
    }

//    public String getUniversity() {
//        return university;
//    }

//    public void setUniversity(String university) {
//        this.university = university;
//    }
//
//    public void printData() {
//        System.out.println("Студент: " + name);
//    }
//
//    public void incAverageGradeBy01() {
//        averageGrade += 0.1;
//    }
//
//    public void incAverageGradeBy02() {
//        averageGrade += 0.2;
//    }
    public  void incAverageGrade(double delta){
//        averageGrade += delta;
        setAverageGrade(getAverageGrade() + delta);
    }

    //    public void setValue(String name, double value) {
//        if (name.equals("averageGrade")) {
//            averageGrade = value;
//            return;
//        }
//        if (name.equals("course")) {
//            course = (int) value;
//            return;
//        }
//    }
    public void setCourse(int num) {
        this.course = num;
    }

    public void setAverageGrade(double grade) {
        this.averageGrade = grade;
    }

//    public void setBeginningOfSession(int day, int month, int year) {
    public void setBeginningOfSession(Date date) {
//        beginningOfSession = new Date(year, month, day);
        beginningOfSession = date;
    }

//    public void setEndOfSession(int day, int month, int year) {
    public void setEndOfSession(Date dateEnd) {
//        endOfSession = new Date(year, month, day);
        endOfSession = dateEnd;
    }

    public double getAverageGrade() {
        return averageGrade;
    }
}