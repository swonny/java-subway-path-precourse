package controller;

import constant.PathMenu;
import repository.SectionRepository;
import repository.StationRepository;
import repository.SubwayRepository;
import subway.domain.Section;
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
        printResult(shortestPath);
    }

    private void printResult(List<Station> shortestPath) {
        int distance = 0;
        int time = 0;
        for (int stationIndex = 0; stationIndex < shortestPath.size() - 1; stationIndex++) {
            Section section = SectionRepository.getSectionContains(
                    shortestPath.get(stationIndex), shortestPath.get(stationIndex + 1)
            );
            distance += section.getDistance();
            time += section.getTime();
        }
        outputView.printResult(shortestPath, distance, time);
    }


    private List<Station> getShortestPath(String startStation, String destination, PathMenu selectedMenu) {
        validateDuplication(startStation, destination);
        if (PathMenu.FIRST.equals(selectedMenu)) {
            return getPathByDistance(startStation, destination);
        }
        // 거리 기준
        return getPathByTime(startStation, destination);
    }

    private List<Station> getPathByDistance(String startStation, String destination) {
        return SubwayRepository.getShortestPathByDistance(startStation, destination);
    }

    private static void validateDuplication(String startStation, String destination) {
        if (StationRepository.isSameStation(startStation, destination)) {
            throw new IllegalArgumentException("출발역과 도착역이 동일합니다.");
        }
    }

    private List<Station> getPathByTime(String startStation, String destination) {
        return SubwayRepository.getShortestPathByTime(startStation, destination);
    }

}
