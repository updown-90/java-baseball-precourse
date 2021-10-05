package model;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomBallNumberGenerator {

	public static final int RANDOM_MIN_NUMBER = 1;
	public static final int RANDOM_MAX_NUMBER = 9;
	public static final int RANDOM_BALL_NUMBER_SIZE = 3;

	private List<Integer> randomBallNumbers = new ArrayList<>();

	public RandomBallNumberGenerator() {
		while (randomBallNumbers.size() < RANDOM_BALL_NUMBER_SIZE) {
			createRandomNumber();
		}
		validateLength();
	}

	private void validateLength() {
		if (randomBallNumbers.size() != RANDOM_BALL_NUMBER_SIZE) {
			throw new IllegalArgumentException("[ERROR] 중복된 숫자가 생성되었습니다");
		}
	}

	private void createRandomNumber() {
		int createRandomNumber = Randoms.pickNumberInRange(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER);
		createRandomNumbers(createRandomNumber);
	}

	private void createRandomNumbers(int createRandomNumber) {
		if (!isDuplicate(createRandomNumber) && isInRange(createRandomNumber)) {
			randomBallNumbers.add(createRandomNumber);
		}
	}

	private boolean isDuplicate(int createRandomNumber) {
		return randomBallNumbers.contains(createRandomNumber);
	}

	protected boolean isInRange(int randomBallNumber) {
		if (randomBallNumber < RANDOM_MIN_NUMBER || randomBallNumber > RANDOM_MAX_NUMBER) {
			throw new IllegalArgumentException("[ERROR] 생성된 수가 1부터 9까지 정수가 아닙니다");
		}

		return true;
	}

	// 테스트 코드에서 사용하는 코드
	protected RandomBallNumberGenerator(List<Integer> inputRandomBallNumbers) {
		for (Integer inputRandomBallNumber : inputRandomBallNumbers) {
			createRandomNumbers(inputRandomBallNumber);
		}

		validateLength();
	}

	public List<Integer> getRandomBallNumbers() {
		return randomBallNumbers;
	}
}
