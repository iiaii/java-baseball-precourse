package baseball.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallResultSignTest {

    @Test
    @DisplayName("볼 결과 싸인 - 낫싱")
    public void 볼결과싸인_낫싱() {
        // given
        int strikeCount = 0;
        int ballCount = 0;
        String expected = "낫싱";

        // when
        String result = BallResultSign.convertToSign(strikeCount, ballCount);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("볼 결과 싸인 - 2스트라이크 1볼")
    public void 볼결과싸인_2스트라이크1볼() {
        // given
        int strikeCount = 2;
        int ballCount = 1;
        String expected = "2스트라이크 1볼";

        // when
        String result = BallResultSign.convertToSign(strikeCount, ballCount);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("볼 결과 싸인 - 1스트라이크")
    public void 볼결과싸인_1스트라이크() {
        // given
        int strikeCount = 1;
        int ballCount = 0;
        String expected = "1스트라이크";

        // when
        String result = BallResultSign.convertToSign(strikeCount, ballCount);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("볼 결과 싸인 - 1볼")
    public void 볼결과싸인_1볼() {
        // given
        int strikeCount = 0;
        int ballCount = 1;
        String expected = "1볼";

        // when
        String result = BallResultSign.convertToSign(strikeCount, ballCount);

        // then
        assertThat(result).isEqualTo(expected);
    }

}