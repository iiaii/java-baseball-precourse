package baseball.view;

public class BallResultConsoleOutput {

    private static final String RESULT = "%d개의 숫자를 모두 맞히셨습니다! 게임 끝";

    public static void printGameEnd(final int ballSize) {
        System.out.println(String.format(RESULT, ballSize));
    }

    public static void printResult(final int strikeCount, final int ballCount) {
        System.out.println(BallResultSign.convertToSign(strikeCount, ballCount));
    }

}
