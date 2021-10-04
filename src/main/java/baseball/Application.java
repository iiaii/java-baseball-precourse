package baseball;

import baseball.domain.*;
import baseball.exception.*;
import baseball.view.BallNumbersConsoleInput;
import baseball.view.BallResultConsoleOutput;
import baseball.view.ErrorMessageConsoleOutput;
import baseball.view.GameMenuConsoleInput;

import java.util.function.Supplier;

public class Application {

    public static void main(String[] args) {
        do {
            Balls targetBalls = new Balls(Computer.createNumbers(Ball.minNumber(), Ball.maxNumber()));
            guessBalls(targetBalls);
            BallResultConsoleOutput.printGameEnd(Balls.maxSize());
        } while (isNewGame());
    }

    private static void guessBalls(final Balls targetBalls) {
        BallResult result;
        do {
            result = targetBalls.compare(newBalls());
            BallResultConsoleOutput.printResult(result.strikeCount(), result.ballCount());
        } while (!result.isAllStrike());
    }

    private static boolean isNewGame() {
        return repeatIfError(() -> {
            String menu = GameMenuConsoleInput.askMenu(GameMenu.indexes(), GameMenu.menus());
            return GameMenu.isNewGame(menu);
        });
    }

    private static Balls newBalls() {
        return repeatIfError(() -> {
            String numbers = BallNumbersConsoleInput.askNumbers();
            return new Balls(numbers);
        });
    }

    private static <T> T repeatIfError(final Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch(BaseBallException e) {
            ErrorMessageConsoleOutput.print(e.getMessage());
            return repeatIfError(supplier);
        }
    }

}
