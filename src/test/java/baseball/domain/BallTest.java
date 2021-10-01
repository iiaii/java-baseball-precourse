package baseball.domain;

import baseball.exception.InvalidBallNumbersException;
import baseball.exception.NotNumberException;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallTest {

    @Test
    @DisplayName("볼 생성 - 숫자가 아닌 경우")
    public void 볼생성_숫자가아닌경우() {
        // given
        String number = "!";

        // when
        ThrowingCallable throwingCallable = () -> new Ball(number);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(NotNumberException.class);
    }

    @ParameterizedTest(name = "볼 생성 - 1~9 의 수 : {arguments}")
    @ValueSource(ints = {1, 9})
    public void 볼생성_1부터9의수(final int number) {
        // given
        Ball expected = new Ball(number);

        // when
        Ball ball = new Ball(number);

        // then
        assertThat(ball).isEqualTo(expected);
    }

    @ParameterizedTest(name = "볼 생성 - 1~9 이외의 수 : {arguments}")
    @ValueSource(ints = {0, 10})
    public void 볼생성_1부터9이외의수(final int number) {
        // given

        // when
        ThrowingCallable throwingCallable = () -> new Ball(number);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(InvalidBallNumbersException.class);
    }

}