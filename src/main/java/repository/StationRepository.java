package repository;

import subway.domain.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void deleteAll() {
        stations.clear();
    }

    public static Station getStationByName(String stationName) {
        return stations.stream()
                .filter(station -> station.getName().equals(stationName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("찾는 역이 없습니다."));
    }

    public static boolean has(Station addingStation) {
        return stations.stream()
                .anyMatch(station -> station.equals(addingStation));
    }
}
