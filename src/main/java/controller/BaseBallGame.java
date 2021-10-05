package controller;

import model.Balls;
import model.BaseBallGameResult;
import model.RandomBallNumberGenerator;
import view.InputView;
import view.OutputView;

public class BaseBallGame {

	private static final String RESTART_NUMBER_FLAG = "1";
	private static boolean isRestart = true;

	public void gameStart() {
		try {
			RandomBallNumberGenerator randomBallNumberGenerator = new RandomBallNumberGenerator();

			while (isRestart) {
				BaseBallGameResult baseBallGameResult = new BaseBallGameResult(
					new Balls(randomBallNumberGenerator.getRandomBallNumbers()),
					new Balls(InputView.scannerUserInputNumber()));

				answerCheck(baseBallGameResult);
			}
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			gameStart();
		}
	}

	private void answerCheck(BaseBallGameResult baseBallGameResult) {
		OutputView.printBaseBallGameResult(baseBallGameResult);

		if (baseBallGameResult.isAnswer()) {
			restartOrEnd();
		}
	}

	private void restartOrEnd() {
		if (RESTART_NUMBER_FLAG.equals(InputView.scannerRestartOrEndNumber())) {
			gameStart();
		}

		isRestart = false;
	}
}
