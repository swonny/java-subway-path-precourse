package view;

import constant.MainMenu;
import constant.PathMenu;
import subway.domain.Station;

import java.util.List;

import static constant.ViewMessage.*;

public class OutputView {
    private static void println(String value) {
        System.out.println(value);
    }

    private static void printNewLine() {
        System.out.println();
    }

    private static String integerToString(int numericValue) {
        return Integer.toString(numericValue);
    }

    private static void print(String value) {
        System.out.print(value);
    }

    private static void printFormat(String value, String formatValue) {
        System.out.printf(value, formatValue);
    }

    public static void printExceptionMessage(Exception exception) {
        println("[ERROR] " + exception.getMessage());
    }

    public static void printMainMenu() {
        println(MAIN_MENU_TITLE);
        println(MainMenu.getWholeMenu());
        printNewLine();
    }

    public static void printReadingMenu() {
        println(READ_MENU);
    }

    public static void printPathMenu() {
        println(PATH_MENU_TITLE);
        println(PathMenu.getWholeMenu());
        printNewLine();
    }

    public static void printReadingStartStation() {
        printNewLine();
        println(READ_START_STATION);
    }

    public static void printReadingDestination() {
        printNewLine();
        println(READ_DESTINATION);
    }

    public void printResult(List<Station> shortestPath, int distance, int time) {
        printNewLine();
        println(PATH_RESULT);
        printInfo(RESULT_DELIMITER);
        // TODO : 상수화하기
        printInfo("총 거리: " + distance + "km");
        printInfo("총 소요 시간: " + time + "분");
        printInfo(RESULT_DELIMITER);
        shortestPath.stream().forEach(station -> printInfo(station.getName()));
    }

    private void printInfo(String value) {
        println("[INFO] " + value);
    }
}
