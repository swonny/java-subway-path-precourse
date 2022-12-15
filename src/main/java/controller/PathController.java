package controller;

import constant.PathMenu;
import repository.SubwayRepository;
import subway.domain.Station;
import view.InputView;
import view.OutputView;

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
        String startStation = inputView.readStartStation();
        String destination = inputView.readDestination();
        List<Station> shortestPath = getShortestPath(startStation, destination, selectedMenu);
        // TODO : distance, time 하드코딩 변경
        int distance = 0;
        int time = 0;
        outputView.printResult(shortestPath, distance, time);
    }

    private List<Station> getShortestPath(String startStation, String destination, PathMenu selectedMenu) {
        if (PathMenu.FIRST.equals(selectedMenu)) {
            return getPathByDistance(startStation, destination);
        }
        // 거리 기준
        return getPathByTime(startStation, destination);
    }

    private List<Station> getPathByDistance(String startStation, String destination) {
        // TODO : 반환값 변경
        SubwayRepository.getShortestPathByDistance(startStation, destination);
        return null;
    }

    private List<Station> getPathByTime(String startStation, String destination) {
        // TODO : 반환값 변경
        return null;
    }

}
