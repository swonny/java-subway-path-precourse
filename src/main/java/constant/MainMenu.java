package constant;

import java.util.Arrays;
import java.util.stream.Collectors;


public enum MainMenu {
    FIRST("1", "1. 경로 조회"),
    QUIT("Q", "Q. 종료");

    private final String menuCommand;
    private final String menuName;

    MainMenu(String menuCommand, String menuName) {
        this.menuCommand = menuCommand;
        this.menuName = menuName;
    }

    public static MainMenu getMenuByName(String input) {
        return Arrays.stream(MainMenu.values())
                .filter(command -> command.menuCommand.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("1 또는 Q 중 입력하세요."));
    }

    public static String getWholeMenu() {
        return Arrays.stream(MainMenu.values())
                .map(menu -> menu.menuName)
                .collect(Collectors.joining("\n"));
    }

    public String getMenuName() {
        return this.menuName;
    }
}
