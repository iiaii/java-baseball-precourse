package baseball.view;

import nextstep.utils.Console;

public class BallNumbersConsoleInput {

    private static final String NUMBERS_QUESTION = "숫자를 입력해주세요 : ";

    public static String askNumbers() {
        System.out.print(NUMBERS_QUESTION);
        return Console.readLine();
    }

}
