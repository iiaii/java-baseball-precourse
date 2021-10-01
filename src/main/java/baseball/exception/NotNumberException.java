package baseball.exception;

public class NotNumberException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private static final String NOT_NUMBER = "입력값은 숫자 값이어야 합니다 -> %s";

    public NotNumberException(String number) {
        super(String.format(NOT_NUMBER, number));
    }

}
