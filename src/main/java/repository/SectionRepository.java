package repository;

import subway.domain.Section;

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
}
