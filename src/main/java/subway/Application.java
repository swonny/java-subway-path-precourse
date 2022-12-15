package subway;

import controller.MainController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        MainController mainController = new MainController(scanner);
        mainController.run();
    }
}
