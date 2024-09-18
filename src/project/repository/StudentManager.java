package project.repository;

import project.entity.Course;
import project.entity.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentManager {

    private Map<Integer, Student> studentMap;
    private Integer idCounter = 1;
    List<Course> allCourses = new ArrayList<>();

    public StudentManager() {
        this.studentMap = new HashMap<>();
    }

    public Integer addStudent(Student student) {
        int studentId = idCounter++;
        student.setStudentId(studentId);
        studentMap.put(studentId, student);
        return studentId;
    }

    public void printAllStudents() {
        System.out.println("Все студенты: " + studentMap);
    }

    public boolean deleteStudent(Integer studentId) {
        studentMap.remove(studentId);
        return true;
    }

    public Student findStudentById(Integer studentId) {
        Student studentSearch = studentMap.get(studentId);
        System.out.println(studentSearch);
        return studentSearch;
    }

    public Course addCourse(String courseName) {
        Course newCourse = new Course(courseName);
        allCourses.add(newCourse);
        return newCourse;
    }

    public boolean addCourseToStudent(Integer studentId, String courseName) {
        if (courseValidation(courseName)) {
            Course newCourse = addCourse(courseName);
            Student newStudent = studentMap.get(studentId);
            newCourse.getEnrolledStudents().add(newStudent);
            return true;
        } else {
            return false;
        }
    }

    public boolean printAllStudentsByCourse(String courseName) {
        for (Course course : allCourses) {
            if (course.getCourseName().equals(courseName))
                System.out.println("Студенты курса " + course.getCourseName() + " :" + course.getEnrolledStudents());
        }
        return true;
    }

    public boolean courseValidation(String courseName) {

        for (Course course : allCourses) {
            if (course.getCourseName().equals(courseName)) {
                return true;
            }
        }
        Course newCourse = addCourse(courseName);
        return newCourse != null;
    }
}
