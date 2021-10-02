package baseball.domain;

import baseball.exception.BallOverlappedException;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallsTest {

    @Test
    @DisplayName("볼 콜렉션 생성 - 같은 볼이 있는 경우")
    public void 볼콜렉션생성_같은볼이있는경우() {
        // given
        String numbers = "112";

        // when
        ThrowingCallable throwingCallable = () -> new Balls(numbers);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(BallOverlappedException.class);
    }

    @Test
    @DisplayName("다른 Balls 와 비교 - 3 스트라이크")
    public void 다른볼콜렉션비교_3스트라이크() {
        // given
        Balls targetBalls = new Balls("123");
        Balls balls = new Balls("123");
        BallResult expected = new BallResult(3, 0);

        // when
        BallResult ballResult = targetBalls.compare(balls);

        // then
        assertThat(ballResult).isEqualTo(expected);
    }

    @Test
    @DisplayName("다른 Balls 와 비교 - 1 스트라이크 1 볼")
    public void 다른볼콜렉션비교_1스트라이크1볼() {
        // given
        Balls targetBalls = new Balls("123");
        Balls balls = new Balls("137");
        BallResult expected = new BallResult(1, 1);

        // when
        BallResult ballResult = targetBalls.compare(balls);

        // then
        assertThat(ballResult).isEqualTo(expected);
    }

    @Test
    @DisplayName("다른 Balls 와 비교 - 낫싱")
    public void 다른볼콜렉션비교_낫싱() {
        // given
        Balls targetBalls = new Balls("123");
        Balls balls = new Balls("789");
        BallResult expected = new BallResult(0, 0);

        // when
        BallResult ballResult = targetBalls.compare(balls);

        // then
        assertThat(ballResult).isEqualTo(expected);
    }

}