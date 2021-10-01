package baseball.util;

import baseball.exception.NotNumberException;

import java.util.Optional;
import java.util.regex.Pattern;

public class NumberUtils {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static int requireNumber(final String number) {
        return Optional.ofNullable(number)
                .filter(NumberUtils::isNumber)
                .map(Integer::parseInt)
                .orElseThrow(() -> new NotNumberException(number));
    }

    private static boolean isNumber(final String number) {
        return NUMBER_PATTERN.matcher(number).matches();
    }

}
