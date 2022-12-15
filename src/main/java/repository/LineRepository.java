package repository;

import subway.domain.Line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteAll() {
        lines.clear();
    }

    public static Line getLineByName(String readLineName) {
        return lines.stream()
                .filter(line -> line.getName().equals(readLineName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("등록된 노선이 없습니다."));
    }

    public static boolean has(Line newLine) {
        return lines.stream()
                .anyMatch(line -> line.equals(newLine));
    }

    public static boolean isEmpty() {
        return lines.isEmpty();
    }
}
