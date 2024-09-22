package project.userManagement;

import project.UserInput;
import project.entity.Student;
import project.service.StudentService;

public class UserMenu {
UserInput userInput = new UserInput();
StudentService service = new StudentService();

public void start () {
while (true) {
           System.out.println();
          printMenu();
           int userChoice = enterUserChoice();

           switch (userChoice) {
               case 1:
                   boolean validInput = false;

                   while (!validInput) {
                       String studentName = userInput.inputText("Введите имя студента");
                       String studentSurname = userInput.inputText("Введите фамилию студента");

                       Integer newStudent = service.addNewStudent(studentName, studentSurname);
                       validInput = validationInputStudent(newStudent);
                   }

                   break;
               case 2:
                   boolean validInputDelete = false;

                   while (!validInputDelete) {
                       Integer studentId = userInput.inputInteger("Введите ID студента");

                       if (service.findStudentByID(studentId) != null) {
                           validInputDelete = validationStudentDelete(studentId);

                           if (validInputDelete) {
                               service.deleteStudent(studentId);
                           }
                       } else {
                           System.out.println("Ошибка: Студент с таким ID не существует. Повторите ввод.");
                       }
                   }
                   break;
               case 3:
                   service.printAllStudents();
                   break;
               case 4:
                   Integer studentIdForSearch = userInput.inputInteger("Введите ID студента");

                   Student student = service.findStudentByID(studentIdForSearch);

                   if (student != null) {
                       System.out.println("Студент с ID " + studentIdForSearch + ": " + student);
                   } else {
                       System.out.println("Студент с ID " + studentIdForSearch + " не найден");
                   }
                   break;
               case 5:
                   String courseName = userInput.inputText("Введите название курса");
                   if (service.addCourse(courseName) != null) {
                       System.out.println("Курс успешно добавлен");
                   } else {
                       System.out.println("Курс не был добавлен. Повторите ввод.");
                   }
                   break;
               case 6:
                   Integer studentIdForAdding = userInput.inputInteger("Введите ID студента");
                   String courseNameForAdding = userInput.inputText("Введите название курса");
                   if (service.addCourseToStudent(studentIdForAdding,courseNameForAdding)) {
                       System.out.println("Студент успешно записан на курс.");
                   } else {
                       System.out.println("Ошибка. Повторите ввод.");
                   }
                   break;
               case 7:
                   String courseNameForPrinting = userInput.inputText("Введите название курса");
                   service.printAllStudentsByCourse(courseNameForPrinting);
                   break;
               case 8:
                   System.out.println("Работа приложения завершена!");
                   return;
           }
       }
}

private void printMenu() {
    System.out.println("1. Добавить студента");
    System.out.println("2. Удалить студента");
    System.out.println("3. Список всех студентов");
    System.out.println("4. Найти студента по студенческому ID");
    System.out.println("5. Добавить курс");
    System.out.println("6. Записать студента на курс");
    System.out.println("7. Список студентов на курсе");
    System.out.println("8. Выход");
}

private int enterUserChoice() {
    return userInput.inputInteger("Выберете пункт меню: ");
}

    private boolean validationInputStudent(Integer newStudent) {
        if (newStudent == null) {
            System.out.println("Ошибка: Имя и фамилия не могут быть короче двух символов. Повторите ввод.");
            return false;
        }

        if (newStudent > 0) {
            System.out.println("Студент добавлен");
            return true;
        } else {
            System.out.println("Ошибка. Повторите ввод.");
            return false;
        }
    }

    private boolean validationStudentDelete (Integer studentIdForDelete) {
        if (studentIdForDelete > 0) {
            System.out.println("Студент удален");
            return true;
        } else {
            System.out.println("Ошибка. Повторите ввод.");
            return false;
        }
    }


}


