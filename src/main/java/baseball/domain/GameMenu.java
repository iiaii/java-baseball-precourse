package baseball.domain;

import baseball.exception.InvalidGameMenuException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum GameMenu {
    NEW_GAME("1", "새로 시작"),
    GAME_END("2", "종료");

    private static final Map<String, GameMenu> gameMenuMap = gameMenuMap();

    private final String index;
    private final String menu;

    GameMenu(final String index, final String menu) {
        this.index = index;
        this.menu = menu;
    }

    private static Map<String, GameMenu> gameMenuMap() {
        Map<String, GameMenu> gameMenuMap = new HashMap<>();
        for (GameMenu gameMenu : GameMenu.values()) {
            gameMenuMap.put(gameMenu.index, gameMenu);
        }
        return gameMenuMap;
    }

    public static List<String> indexes() {
        return new ArrayList<>(gameMenuMap.keySet());
    }

    public static List<String> menus() {
        List<String> menus = new ArrayList<>();
        for (GameMenu gameMenu : gameMenuMap.values()) {
            menus.add(gameMenu.menu);
        }
        return menus;
    }

    public static boolean isNewGame(final String menu) {
        validateMenu(menu);
        return menu.equals(NEW_GAME.index);
    }

    private static void validateMenu(final String menu) {
        if (!isValidMenu(menu)) {
            throw new InvalidGameMenuException();
        }
    }

    private static boolean isValidMenu(final String menu) {
        return gameMenuMap.containsKey(menu);
    }
}
