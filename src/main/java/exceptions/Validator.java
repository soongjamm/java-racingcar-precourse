package exceptions;

import exceptions.customExceptions.NotValidInputException;
import racingcar.Car;

import java.util.List;

public class Validator {

    private static final int MINIMUM_CARS_SIZE = 1;
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;
    private static final String EMPTY_CAR_NAME_ERROR_MESSAGE = "자동차 이름이 입력되어야 한다.";
    private static final String EXCEED_MAXIMUM_CAR_NAME_ERROR_MESSAGE = "자동차의 이름은 " + MAXIMUM_CAR_NAME_LENGTH + "자 이하여야 한다.";
    private static final String MUST_BE_INTEGER_ERROR_MESSAGE = "시도 횟수는 숫자여야 한다.";
    private static final String EXCEED_INTEGER_ERROR_MESSAGE = "시도 횟수는 integer 범위에 포함되어야 한다.";
    private static final String MUST_BE_POSITIVE_NUMBER_ERROR_MESSAGE = "시도 횟수는 양수여야 한다.";

    public static void validateCarsSize(List<Car> cars) {
        if (cars.size() < MINIMUM_CARS_SIZE) {
            throw new NotValidInputException(EMPTY_CAR_NAME_ERROR_MESSAGE);
        }
    }

    public static void validateCarNameLength(List<Car> cars) {
        for (Car car : cars) {
            if (car.getName().length() > MAXIMUM_CAR_NAME_LENGTH) {
                throw new NotValidInputException(EXCEED_MAXIMUM_CAR_NAME_ERROR_MESSAGE);
            }
        }
    }

    public static void validateNumberOfProgress(String numberOfProgress) {
        for (int i = 0; i < numberOfProgress.length(); i++) {
            if (!Character.isDigit(numberOfProgress.charAt(i))) {
                throw new NotValidInputException(MUST_BE_INTEGER_ERROR_MESSAGE);
            }
        }
        checkIntegerRange(numberOfProgress);

        if (Integer.parseInt(numberOfProgress) <= 0) {
            throw new NotValidInputException(MUST_BE_POSITIVE_NUMBER_ERROR_MESSAGE);
        }
    }

    private static void checkIntegerRange(String numberOfProgress) {
        try {
            Integer.parseInt(numberOfProgress);
        } catch (NumberFormatException e) {
            throw new NotValidInputException(EXCEED_INTEGER_ERROR_MESSAGE);
        }
    }

}
