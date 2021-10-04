package baseball.domain;

import baseball.exception.InvalidBallNumbersException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Ball {

    private static final int MIN = 1;
    private static final int MAX = 9;
    private static final Map<Integer, Ball> ballMap = ballMap();

    private final int number;

    private Ball(final int number) {
        this.number = number;
    }

    private static Map<Integer, Ball> ballMap() {
        Map<Integer, Ball> ballMap = new HashMap<>();
        for (int i = MIN; i <= MAX; i++) {
            ballMap.put(i, new Ball(i));
        }
        return ballMap;
    }

    public static Ball from(final int number) {
        validateNumber(number);
        return ballMap.get(number);
    }
    
    public static int minNumber() {
        return MIN;
    }
    
    public static int maxNumber() {
        return MAX;
    }

    private static void validateNumber(final int number) {
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
