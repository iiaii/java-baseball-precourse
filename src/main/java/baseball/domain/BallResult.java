package baseball.domain;

import baseball.exception.InvalidCountException;

import java.util.Objects;

public class BallResult {

    public static final BallResult STRIKE = new BallResult(1, 0);
    public static final BallResult BALL = new BallResult(0, 1);
    public static final BallResult NOTHING = new BallResult(0, 0);

    private final int strikeCount;
    private final int ballCount;

    public BallResult(final int strikeCount, final int ballCount) {
        requireCount(strikeCount);
        requireCount(ballCount);
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    private void requireCount(final int count) {
        if (count < 0) {
            throw new InvalidCountException(count);
        }
    }

    public int strikeCount() {
        return strikeCount;
    }

    public int ballCount() {
        return ballCount;
    }

    public BallResult add(final BallResult ballResult) {
        return new BallResult(strikeCount + ballResult.strikeCount, ballCount + ballResult.ballCount);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final BallResult that = (BallResult) o;
        return strikeCount == that.strikeCount && ballCount == that.ballCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strikeCount, ballCount);
    }
}
