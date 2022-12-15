package controller;

import constant.MainMenu;
import subway.domain.Initializer;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class MainController {

    private final InputView inputView;
    private final PathController pathController;

    public MainController(Scanner scanner, Initializer initializer) {
        this.inputView = new InputView(scanner);
        this.pathController = new PathController(scanner);
        initializer.init();
    }

    public void run() {
        try {
            MainMenu selectedMenu = MainMenu.getMenuByName(inputView.readMainMenu());
            runMenu(selectedMenu);
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception);
            run();
        }
    }

    private void runMenu(MainMenu selectedMenu) {
        if (MainMenu.QUIT.equals(selectedMenu)) {
            return;
        }
        if (MainMenu.FIRST.equals(selectedMenu)) {
            pathController.run();
        }
        run();
    }
}
