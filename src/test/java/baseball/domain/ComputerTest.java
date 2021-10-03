package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    private final List<Integer> numbers = Computer.createNumbers();
    private final Set<Integer> numberSet = new HashSet<>(numbers);

    @Test
    @DisplayName("볼 번호 생성 - 볼 사이즈와 같은지 확인")
    public void 볼번호생성_볼사이즈와같은지확인() {
        // given

        // when

        // then
        assertThat(numbers.size()).isEqualTo(Balls.SIZE);
    }

    @Test
    @DisplayName("볼 번호 생성 - 중복되는 값이 없는지 확인")
    public void 볼번호생성_중복값없는지확인() {
        // given

        // when

        // then
        assertThat(numbers.size()).isEqualTo(numberSet.size());
    }

    @Test
    @DisplayName("볼 번호 생성 - 볼 숫자 범위인지 확인")
    public void 볼번호생성_볼숫자범위인지확인() {
        // given
        int min = 1;
        int max = 9;

        // when

        // then
        assertThat(numbers).allMatch(number -> min <= number && max >= number);
    }

}