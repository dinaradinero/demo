package project.service;

import project.entity.Course;
import project.entity.Student;
import project.repository.StudentManager;

public class StudentService {
    StudentManager manager = new StudentManager();

    public Integer addNewStudent (String name, String surname) {

        if (!validationStudent(name,surname)) {
            return null;
        }
        Student newStudent = new Student(name, surname);

        return manager.addStudent(newStudent);
    }

    public boolean printAllStudents () {
        manager.printAllStudents();
        return true;
    }

    public boolean deleteStudent (Integer studentId) {

        if (!validationId(studentId)) {
            return false;
        }
        manager.deleteStudent(studentId);
        return true;
    }

    public Student findStudentByID (Integer studentId) {
        if (!validationId(studentId)) {
            return null;
        }
        return manager.findStudentById(studentId);
    }

    public Course addCourse (String courseName) {
        if (!validationCourse(courseName)) {
            return null;
        }
        return manager.addCourse(courseName);
    }


    public boolean addCourseToStudent (Integer studentId, String courseName) {
        if (!validationId(studentId)) {
            return false;
        }
        if (!validationCourse(courseName)) {
            return false;
        }
        manager.addCourseToStudent(studentId, courseName);
        return true;
    }

    public boolean printAllStudentsByCourse (String courseName) {
        if (!validationCourse(courseName)) {
            return false;
        }
        return manager.printAllStudentsByCourse(courseName);
    }

    private boolean validationStudent (String name, String surname) {
        if (name.isBlank()) return false;
        if (surname.isBlank()) return false;
        if (name.length() < 2) return false;
        if (surname.length() < 2) return false;

        return true;
    }

    private boolean validationId (Integer studentId) {
        return studentId != null && studentId > 0;
    }
    private boolean validationCourse (String courseName) {
        if (courseName.isBlank()) return false;
        if (courseName.length() < 3) return false;
        return true;
    }

}
