package baseball.exception;

public class InvalidBallsSizeException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private static final String INVALID_SIZE = "Balls 사이즈는 %d 이어야 합니다 (현재 사이즈: %d)";

    public InvalidBallsSizeException(final int limitSize, final int currentSize) {
        super(String.format(INVALID_SIZE, limitSize, currentSize));
    }

}
