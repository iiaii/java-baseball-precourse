package baseball.view;

public class BallResultConsoleOutput {

    private static final String STRIKE = "%d스트라이크 ";
    private static final String BALL = "%d볼 ";
    private static final String NOTHING = "낫싱";
    private static final String EMPTY = "";
    private static final String RESULT = "%d개의 숫자를 모두 맞히셨습니다! 게임 끝";

    public static void printGameEnd(final int ballSize) {
        System.out.println(String.format(RESULT, ballSize));
    }

    public static void print(final int strikeCount, final int ballCount) {
        System.out.println(convertToStringResult(strikeCount, ballCount));
    }

    private static String convertToStringResult(final int strikeCount, final int ballCount) {
        StringBuilder result = new StringBuilder();
        result.append(nothing(strikeCount, ballCount));
        result.append(strike(strikeCount));
        result.append(ball(ballCount));
        return result.toString()
                .trim();
    }

    private static String nothing(final int strikeCount, final int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            return NOTHING;
        }
        return EMPTY;
    }

    private static String ball(final int ballCount) {
        if (ballCount != 0) {
            return String.format(BALL, ballCount);
        }
        return EMPTY;
    }

    private static String strike(final int strikeCount) {
        if (strikeCount != 0) {
            return String.format(STRIKE, strikeCount);
        }
        return EMPTY;
    }

}
