package baseball.exception;

public class InvalidCountException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private static final String INVALID_COUNT = "카운트 값은 0보다 커야 합니다 -> %d";

    public InvalidCountException(final int count) {
        super(String.format(INVALID_COUNT, count));
    }

}
