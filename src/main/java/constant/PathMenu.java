package constant;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum PathMenu {
    FIRST("1", "1. 최단 거리"),
    SECOND("2", "2. 최소 시간"),
    BACK("B", "B. 돌아가기");

    private final String menuCommand;
    private final String menuName;

    PathMenu(String menuCommand, String menuName) {
        this.menuCommand = menuCommand;
        this.menuName = menuName;
    }

    public static PathMenu getMenuByName(String input) {
        return Arrays.stream(PathMenu.values())
                .filter(command -> command.menuCommand.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("1, 2 또는 Q 중 입력하세요."));
    }

    public static String getWholeMenu() {
        return Arrays.stream(PathMenu.values())
                .map(menu -> menu.menuName)
                .collect(Collectors.joining("\n"));
    }

    public String getMenuName() {
        return this.menuName;
    }
}
