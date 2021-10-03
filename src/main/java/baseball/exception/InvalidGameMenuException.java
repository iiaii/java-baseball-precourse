package baseball.exception;

public class InvalidGameMenuException extends BaseBallException {

    private static final long serialVersionUID = 1L;
    private static final String INVALID_MENU = "없는 메뉴입니다. 제시된 메뉴를 선택해주세요.";

    public InvalidGameMenuException() {
        super(INVALID_MENU);
    }

}
