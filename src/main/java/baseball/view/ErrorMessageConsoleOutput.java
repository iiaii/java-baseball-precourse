package baseball.view;

public class ErrorMessageConsoleOutput {

    private static final String ERROR_PREFIX = "[ERROR] ";

    public static void print(final String message) {
        System.out.println(ERROR_PREFIX + message);
    }
}
