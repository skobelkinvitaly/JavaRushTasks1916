package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public University(String name, int age) {
        super();
    }

    public Student getStudentWithAverageGrade(double someNum) {
        //TODO:
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() == someNum) return students.get(i);
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        double max = 0;
        int iMaxStud = 0;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() > max) {
                max = students.get(i).getAverageGrade();
                iMaxStud = i;
            }
        }
        //TODO:
        return students.get(iMaxStud);
    }

    //
//    public void getStudentWithMinAverageGradeAndExpel() {
//        //TODO:
//    }
    public Student getStudentWithMinAverageGrade() {
        double minGrade = Double.MAX_VALUE;
        int iMinNum = 0;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() < minGrade) {
                minGrade = students.get(i).getAverageGrade();
                iMinNum = i;
            }
        }
        return students.get(iMinNum);
    }
    public void expel(Student student){
        students.remove(student);
    }
}