package baseball.domain;

import baseball.exception.InvalidBallNumbersException;
import baseball.util.NumberUtils;

import java.util.Objects;

public class Ball {

    private static final int MIN = 1;
    private static final int MAX = 9;

    private final int number;

    public Ball(final String number) {
        this(NumberUtils.requireNumber(number));
    }

    public Ball(final int number) {
        requireValidNumber(number);
        this.number = number;
    }

    private void requireValidNumber(final int number) {
        if (MAX < number || MIN > number) {
            throw new InvalidBallNumbersException(MIN, MAX);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Ball ball = (Ball) o;
        return number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
