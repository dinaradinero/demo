package project.userManagement;

import project.UserInput;
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
                   String studentName = userInput.inputText("Введите имя студента");
                   String studentSurname = userInput.inputText("Введите фамилию студента");
                   int studentYear = userInput.inputInteger("Введите год зачисления студента");

                   Integer newStudent =service.addNewStudent(studentName, studentSurname, studentYear);
                   break;
               case 2:
                   Integer studentId = userInput.inputInteger("Введите ID студента");
                   service.deleteStudent(studentId);
                   break;
               case 3:
                   service.printAllStudents();
                   break;
               case 4:
                   Integer studentIdForSearch = userInput.inputInteger("Введите ID студента");
                   service.findStudentByID(studentIdForSearch);
                   break;
               case 5:
                   String courseName = userInput.inputText("Введите название курса");
                   service.addCourse(courseName);
                   break;
               case 6:
                   Integer studentIdForAdding = userInput.inputInteger("Введите ID студента");
                   String courseNameForAdding = userInput.inputText("Введите название курса");
                   service.addCourseToStudent(studentIdForAdding,courseNameForAdding);
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
}
