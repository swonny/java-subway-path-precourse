package view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readStartStation() {
        OutputView.printReadingStartStation();
        return read();
    }

    public String readMainMenu() {
        OutputView.printMainMenu();
        OutputView.printReadingMenu();
        return read();
    }

    private String read() {
        return scanner.nextLine();
    }

    public String readPathMenu() {
        OutputView.printPathMenu();
        OutputView.printReadingMenu();
        return read();
    }


    public String readDestination() {
        OutputView.printReadingDestination();
        return read();
    }
}
