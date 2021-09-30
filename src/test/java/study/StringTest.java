package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("[문자열 분리] , 를 기준으로 분리")
    public void 문자열분리() {
        // given
        String one = "1";
        String two = "2";
        String delimiter = ",";
        String input = String.join(delimiter, one, two);
        String[] expected = {one, two};

        // when
        String[] split = input.split(delimiter);

        // then
        assertThat(split)
                .containsExactly(one, two)
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("[문자열 분리] , 가 없는 입력의 경우")
    public void 문자열분리_콤마가없는경우() {
        // given
        String one = "1";
        String delimiter = ",";
        String[] expected = {one};

        // when
        String[] split = one.split(delimiter);

        // then
        assertThat(split)
                .containsExactly(one)
                .isEqualTo(expected);
    }

}
