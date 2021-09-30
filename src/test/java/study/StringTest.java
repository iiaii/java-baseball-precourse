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

    @Test
    @DisplayName("[괄호 제거] 괄호 제거 후 반환")
    public void 괄호제거() {
        // given
        String input = "(1,2)";
        String expected = "1,2";

        // when
        String peeled = peelBracket(input);

        // then
        assertThat(peeled).isEqualTo(expected);
    }

    @Test
    @DisplayName("[괄호 제거] 괄호가 없는 경우")
    public void 괄호제거_괄호가없는경우() {
        // given
        String input = "1,2";
        String expected = "1,2";

        // when
        String peeled = peelBracket(input);

        // then
        assertThat(peeled).isEqualTo(expected);
    }

    @Test
    @DisplayName("[괄호 제거] 괄호 내부가 비어있는 경우")
    public void 괄호제거_괄호내부가빈경우() {
        // given
        String input = "()";
        String expected = "";

        // when
        String peeled = peelBracket(input);

        // then
        assertThat(peeled).isEqualTo(expected);
    }

    private String peelBracket(String text) {
        return isWrappedInBracket(text)
                ? text.substring(1, text.length() - 1)
                : text;
    }

    private boolean isWrappedInBracket(String text) {
        return text.startsWith("(") && text.endsWith(")");
    }


}
