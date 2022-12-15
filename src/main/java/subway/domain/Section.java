package subway.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Section {
    private final int distance;
    private final int time;
    private List<Station> stations;

    public Section(List<Station> stations, int distance, int time) {
        // TODO : 필드 추가해서 대입하기
        this.stations = stations;
        this.distance = distance;
        this.time = time;
    }

    public List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public int getTime() {
        return time;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return distance == section.distance && time == section.time && Objects.equals(stations, section.stations);
    }

}
