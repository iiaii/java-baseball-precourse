package baseball.view;

import nextstep.utils.Console;

import java.util.List;
import java.util.StringJoiner;

public class GameMenuConsoleInput {

    private static final String MENU_PREFIX = "게임을 ";
    private static final String MENU = "%s하려면 %s";
    private static final String DELIMITER = ", ";
    private static final String MENU_POSTFIX = "를 입력하세요";

    public static String askMenu(final List<String> indexes, final List<String> menus) {
        System.out.println(menuExplanation(indexes, menus));
        return Console.readLine();
    }

    private static String menuExplanation(final List<String> indexes, final List<String> menus) {
        StringJoiner joiner = new StringJoiner(DELIMITER);
        for (int i = 0; i < indexes.size(); i++) {
            joiner.add(String.format(MENU, menus.get(i), indexes.get(i)));
        }
        return MENU_PREFIX + joiner + MENU_POSTFIX;
    }

}
