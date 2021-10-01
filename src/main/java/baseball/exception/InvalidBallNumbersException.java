package baseball.exception;

public class InvalidBallNumbersException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private static final String INVALID_NUMBER = "볼의 숫자는 %d ~ %d 의 숫자여야 합니다";

    public InvalidBallNumbersException(final int min, final int max) {
        super(String.format(INVALID_NUMBER, min, max));
    }

}
