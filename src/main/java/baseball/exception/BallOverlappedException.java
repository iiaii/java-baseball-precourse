package baseball.exception;

public class BallOverlappedException extends BaseBallException {

    private static final long serialVersionUID = 1L;
    private static final String NOT_OVERLAPPED = "중복된 볼은 존재할 수 없습니다";

    public BallOverlappedException() {
        super(NOT_OVERLAPPED);
    }

}
