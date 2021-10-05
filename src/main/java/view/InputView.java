package view;

import nextstep.utils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

	public static List<Integer> scannerUserInputNumber() {
		System.out.print("숫자를 입력해 주세요 : ");
		String userInputNumber = Console.readLine();

		return stringToListConvert(userInputNumber);
	}

	public static String scannerRestartOrEndNumber() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		return Console.readLine();
	}

	public static List<Integer> stringToListConvert(String userInputNumber) {
		List<Integer> userInputList = new ArrayList<>();

		for (int i = 0; i < userInputNumber.length(); i++) {
			userInputList.add(Character.getNumericValue(userInputNumber.charAt(i)));
		}

		return userInputList;
	}
}
