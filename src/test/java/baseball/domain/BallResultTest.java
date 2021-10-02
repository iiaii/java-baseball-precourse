package baseball.domain;

import baseball.exception.BallOverlappedException;
import baseball.exception.InvalidCountException;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallResultTest {

    @ParameterizedTest(name = "볼 결과 생성 - 0이하의 값 | {arguments}")
    @CsvSource(value = {"-1:0", "0:-1"}, delimiter = ':')
    public void 볼결과생성_0이하의값(final int strikeCount, final int ballCount) {
        // given

        // when
        ThrowingCallable throwingCallable = () -> new BallResult(strikeCount, ballCount);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(InvalidCountException.class);
    }

    @Test
    @DisplayName("볼 결과 덧셈 - 1 스트라이크 + 1 볼")
    public void 볼결과덧셈_1스트라이크더하기1볼() {
        // given
        BallResult strike = BallResult.STRIKE;
        BallResult ball = BallResult.BALL;
        BallResult expected = new BallResult(1, 1);

        // when
        BallResult result = strike.add(ball);

        // then
        assertThat(result).isEqualTo(expected);
    }

}