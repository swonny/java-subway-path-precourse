package controller;

import constant.PathMenu;
import subway.domain.Station;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PathController {
    private final OutputView outputView;
    private InputView inputView;

    public PathController(Scanner scanner) {
        this.inputView = new InputView(scanner);
        this.outputView = new OutputView();
    }

    public void run() {
        try {
            PathMenu selectedMenu = PathMenu.getMenuByName(inputView.readPathMenu());
            runMenu(selectedMenu);
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception);
            run();
        }
    }

    private void runMenu(PathMenu selectedMenu) {
        if (PathMenu.BACK.equals(selectedMenu)) {
            return;
        }
        // TODO : 메소드 분리해보기
        // TODO : shortestPath에서 getShortestPath(selectedMenu)하면 될듯
        String startStation = inputView.readStartStation();
        String destination = inputView.readDestination();
        List<Station> shortestPath = new ArrayList<>();
        if (PathMenu.FIRST.equals(selectedMenu)) {
            shortestPath = getPathByDistance(startStation, destination);
        }
        if (PathMenu.SECOND.equals(selectedMenu)) {
            shortestPath = getPathByTime(startStation, destination);
        }
        // TODO : distance, time 하드코딩 변경
        int distance = 0;
        int time = 0;
        outputView.printResult(shortestPath, distance, time);
    }

    private List<Station> getPathByTime(String startStation, String destination) {
        // TODO : 반환값 변경
        return null;
    }

    private List<Station> getPathByDistance(String startStation, String destination) {
        // TODO : 반환값 변경
        return null;
    }

}
