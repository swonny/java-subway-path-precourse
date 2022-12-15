package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private String name;
    private List<Station> stations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void initializeStations(List<Station> initStations) {
        this.stations.addAll(initStations);
    }

    public List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    // 추가 기능 구현
}
