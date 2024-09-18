package project;

import java.util.Scanner;

public class UserInput {

    public String inputText (String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        String userInput = scanner.nextLine();
        return userInput;

    }

    public int inputInteger (String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        int userInput = scanner.nextInt();
        return userInput;

    }


}
