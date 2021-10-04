package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    private final List<Integer> numbers = Computer.createNumbers(Ball.minNumber(), Ball.maxNumber());

    @Test
    @DisplayName("볼 번호 생성 - 볼 사이즈와 같은지 확인")
    public void 볼번호생성_볼사이즈와같은지확인() {
        // given
        int expectedSize = Balls.maxSize();

        // when

        // then
        assertThat(numbers.size()).isEqualTo(expectedSize);
    }

    @Test
    @DisplayName("볼 번호 생성 - 중복되는 값이 없는지 확인")
    public void 볼번호생성_중복값없는지확인() {
        // given
        Set<Integer> numberSet = new HashSet<>(numbers);

        // when
        int expectedSize = numberSet.size();

        // then
        assertThat(numbers.size()).isEqualTo(expectedSize);
    }

    @Test
    @DisplayName("볼 번호 생성 - 볼 숫자 범위인지 확인")
    public void 볼번호생성_볼숫자범위인지확인() {
        // given
        int min = Ball.minNumber();
        int max = Ball.maxNumber();

        // when
        Predicate<Integer> isValidNumber = number -> min <= number && max >= number;

        // then
        assertThat(numbers).allMatch(isValidNumber);
    }

}