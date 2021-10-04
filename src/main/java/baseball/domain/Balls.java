package baseball.domain;

import baseball.exception.BallOverlappedException;
import baseball.exception.InvalidBallsSizeException;
import baseball.util.NumberUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Balls {

    private static final int SIZE = 3;

    private final List<Ball> balls;

    public Balls(final String numbers) {
        this(NumberUtils.convertToNumbers(numbers));
    }

    public Balls(final List<Integer> numbers) {
        List<Ball> balls = createBalls(numbers);
        validateSize(numbers);
        validateNotOverlapped(balls);
        this.balls = balls;
    }

    private List<Ball> createBalls(final List<Integer> numbers) {
        List<Ball> balls = new ArrayList<>();
        for (int number : numbers) {
            balls.add(Ball.from(number));
        }
        return balls;
    }

    public BallResult compare(final Balls balls) {
        BallResult ballResult = BallResult.NOTHING;
        for (int i = 0; i < balls.size(); i++) {
            ballResult = ballResult.add(compare(balls, i));
        }
        return ballResult;
    }

    public static int maxSize() {
        return SIZE;
    }

    private BallResult compare(final Balls balls, final int i) {
        if (isStrike(balls, i)) {
            return BallResult.STRIKE;
        }
        if (isBall(balls, i)) {
            return BallResult.BALL;
        }
        return BallResult.NOTHING;
    }

    private boolean isBall(final Balls target, final int i) {
        return balls.contains(target.getBall(i));
    }

    private boolean isStrike(final Balls target, final int i) {
        return getBall(i).equals(target.getBall(i));
    }

    private Ball getBall(final int index) {
        return balls.get(index);
    }

    private int size() {
        return balls.size();
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new InvalidBallsSizeException(SIZE, numbers.size());
        }
    }

    private void validateNotOverlapped(final List<Ball> balls) {
        if (!isBallOverlapped(balls)) {
            throw new BallOverlappedException();
        }
    }

    private boolean isBallOverlapped(final List<Ball> balls) {
        return balls.size() == new HashSet<>(balls).size();
    }

}
