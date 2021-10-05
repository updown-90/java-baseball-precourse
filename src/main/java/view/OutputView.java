package view;

import model.BaseBallGameResult;

public class OutputView {

	public static void printBaseBallGameResult(BaseBallGameResult baseBallGameResult) {
		if (baseBallGameResult.isNothing()) {
			System.out.println("낫싱");
			return;
		}

		System.out.printf("%d스트라이크 %d볼 %n", baseBallGameResult.getStrikeCount(), baseBallGameResult.getBallCount());
	}

}
