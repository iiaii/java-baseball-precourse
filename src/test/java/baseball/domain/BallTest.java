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

    @ParameterizedTest(name = "볼 생성 - 1~9 의 수 : {arguments}")
    @ValueSource(ints = {1, 9})
    public void 볼생성_1부터9의수(final int number) {
        // given
        Ball expected = Ball.from(number);

        // when
        Ball ball = Ball.from(number);

        // then
        assertThat(ball).isEqualTo(expected);
    }

    @ParameterizedTest(name = "볼 생성 - 1~9 이외의 수 : {arguments}")
    @ValueSource(ints = {0, 10})
    public void 볼생성_1부터9이외의수(final int number) {
        // given

        // when
        ThrowingCallable throwingCallable = () -> Ball.from(number);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(InvalidBallNumbersException.class);
    }

}