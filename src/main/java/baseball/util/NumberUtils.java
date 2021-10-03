package baseball.util;

import baseball.exception.NotNumberException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class NumberUtils {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static List<Integer> convertToNumbers(final String numberString) {
        requireNumber(numberString);
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < numberString.length(); i++) {
            String number = numberString.substring(i, i + 1);
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    private static void requireNumber(final String number) {
        if (!isNumber(number)) {
            throw new NotNumberException(number);
        }
    }

    private static boolean isNumber(final String number) {
        return NUMBER_PATTERN.matcher(number).matches();
    }

}
