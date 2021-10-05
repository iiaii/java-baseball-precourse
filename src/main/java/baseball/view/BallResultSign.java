package baseball.view;

import java.util.Optional;
import java.util.StringJoiner;

public enum BallResultSign {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private static final String BLANK = "";
    private static final String DELIMITER = " ";

    private final String sign;

    BallResultSign(final String sign) {
        this.sign = sign;
    }

    public static String convertToSign(final int strikeCount, final int ballCount) {
        StringJoiner result = new StringJoiner(DELIMITER);
        result.add(convertToSign(strikeCount, STRIKE));
        result.add(convertToSign(ballCount, BALL));
        return Optional.of(result.toString().trim())
                .filter(sign -> !sign.isEmpty())
                .orElse(NOTHING.sign);
    }

    private static String convertToSign(final int count, final BallResultSign sign) {
        if (count != 0) {
            return count + sign.sign;
        }
        return BLANK;
    }
    
}
