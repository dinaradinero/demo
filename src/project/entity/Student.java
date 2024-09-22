package project.entity;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private String surname;
    private int studentId;
    private List<Course> studentCourses;


    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.studentCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public List<Course> getStudentCourses() {
        return studentCourses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", studentId='" + studentId +
                ", studentCourses=" + studentCourses +
                '}';
    }
}
