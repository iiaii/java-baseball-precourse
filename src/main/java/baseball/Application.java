package baseball;

import baseball.domain.BallResult;
import baseball.domain.Balls;
import baseball.domain.Computer;
import baseball.domain.GameMenu;
import baseball.exception.*;
import baseball.view.BallNumbersConsoleInput;
import baseball.view.BallResultConsoleOutput;
import baseball.view.ErrorMessageConsoleOutput;
import baseball.view.GameMenuConsoleInput;


public class Application {

    public static void main(String[] args) {
        do {
            playGame();
        } while (isNewGame());
    }

    private static boolean isNewGame() {
        try {
            String menu = GameMenuConsoleInput.askMenu(GameMenu.indexes(), GameMenu.menus());
            return GameMenu.isNewGame(menu);
        } catch(BaseBallException e) {
            ErrorMessageConsoleOutput.print(e.getMessage());
            return isNewGame();
        }
    }

    private static void playGame() {
        Balls targetBalls = new Balls(Computer.createNumbers());
        BallResult ballResult;
        do {
            ballResult = targetBalls.compare(newBalls());
            BallResultConsoleOutput.print(ballResult.strikeCount(), ballResult.ballCount());
        } while (!ballResult.isAllStrike());
        BallResultConsoleOutput.printGameEnd(Balls.SIZE);
    }

    private static Balls newBalls() {
        try {
            return new Balls(BallNumbersConsoleInput.askNumbers());
        } catch(BaseBallException e) {
            ErrorMessageConsoleOutput.print(e.getMessage());
            return newBalls();
        }
    }

}
