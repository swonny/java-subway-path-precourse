package repository;

import subway.domain.Section;
import subway.domain.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SectionRepository {
    private static List<Section> sections = new ArrayList<>();

    public static void initializeSection(List<Section> newSections) {
        sections.addAll(newSections);
    }

    public static List<Section> sections() {
        return Collections.unmodifiableList(sections);
    }

    public static Section getSectionContains(Station station1, Station station2) {
        return sections.stream().filter(section -> section.stations().containsAll(List.of(station1, station2)))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("해당 구간은 존재하지 않습니다."));
    }
}
